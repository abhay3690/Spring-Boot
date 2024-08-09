package com.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Ensure transactions are managed

import com.example.helper.BusinessMessage;
import com.example.helper.DateHelper;
import com.example.helper.GenerateStudentNumber;
import com.example.helper.LogMessage;
import com.example.modal.Student;
import com.example.payload.StudentDto;
import com.example.payload.converter.StudentDtoConverter;
import com.example.payload.request.student.CreateStudentRequest;
import com.example.payload.request.student.UpdateStudentRequest;
import com.example.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassroomService classroomService;
    private final StudentDtoConverter converter;

    @Transactional // Ensure that the operations are managed within a transaction
    public void createStudent(CreateStudentRequest request) {
        checkIfStudentExists(request.getNationalId());
        checkIfStudentFatherPhoneExists(request.getFatherPhone());
        checkIfStudentMotherPhoneExists(request.getMotherPhone());

        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setNationalId(request.getNationalId());
        student.setStudentNumber(GenerateStudentNumber.generate());
        student.setFatherName(request.getFatherName());
        student.setFatherPhone(request.getFatherPhone());
        student.setMotherName(request.getMotherName());
        student.setMotherPhone(request.getMotherPhone());
        student.setCreatedDate(DateHelper.getCurrentDate());
        student.setUpdatedDate(DateHelper.getCurrentDate());

        studentRepository.save(student);
        log.info(LogMessage.Student.StudentCreated());
    }

    @Transactional // Ensure that the operations are managed within a transaction
    public void updateStudent(String id, UpdateStudentRequest request) {
        Student student = findStudentByStudentId(id);

        if (!student.getFatherPhone().equals(request.getFatherPhone())) {
            checkIfStudentFatherPhoneExists(request.getFatherPhone());
        }
        if (!student.getMotherPhone().equals(request.getMotherPhone())) {
            checkIfStudentMotherPhoneExists(request.getMotherPhone());
        }

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setFatherName(request.getFatherName());
        student.setFatherPhone(request.getFatherPhone());
        student.setMotherName(request.getMotherName());
        student.setMotherPhone(request.getMotherPhone());
        student.setClassroom(classroomService.findClassroomByClassroomId(request.getClassroomId()));
        student.setUpdatedDate(DateHelper.getCurrentDate());

        studentRepository.save(student);
        log.info(LogMessage.Student.StudentUpdated(id));
    }

    @Transactional // Ensure that the operations are managed within a transaction
    public void addStudentToClassroom(String id, String classroomId) {
        Student student = findStudentByStudentId(id);
        student.setClassroom(classroomService.findClassroomByClassroomId(classroomId));
        student.setUpdatedDate(DateHelper.getCurrentDate());

        studentRepository.save(student);
        log.info(LogMessage.Student.StudentAddedToClassroom(id, classroomId));
    }

    @Transactional // Ensure that the operations are managed within a transaction
    public void removeStudentFromClassroom(String id) {
        Student student = findStudentByStudentId(id);
        student.setClassroom(null);
        student.setUpdatedDate(DateHelper.getCurrentDate());

        studentRepository.save(student);
        log.info(LogMessage.Student.StudentRemovedFromClassroom(id));
    }

    @Transactional // Ensure that the operations are managed within a transaction
    public void deleteStudent(String id) {
        Student student = findStudentByStudentId(id);

        studentRepository.delete(student);
        log.info(LogMessage.Student.StudentDeleted(id));
    }

    public StudentDto findStudentById(String id) {
        Student student = findStudentByStudentId(id);

        log.info(LogMessage.Student.StudentFound(id));
        return converter.convert(student);
    }

    public List<StudentDto> findAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        if (studentList.isEmpty()) {
            log.error(LogMessage.Student.StudentListEmpty());
            throw new RuntimeException(BusinessMessage.Student.STUDENT_LIST_EMPTY);
        }

        log.info(LogMessage.Student.StudentListed());
        return converter.convert(studentList);
    }

    private void checkIfStudentExists(String nationalId) {
        if (studentRepository.existsByNationalId(nationalId)) {
            log.error(LogMessage.Student.StudentAlreadyExists(nationalId));
            throw new RuntimeException(BusinessMessage.Student.STUDENT_ALREADY_EXISTS);
        }
    }

    protected Student findStudentByStudentId(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(LogMessage.Student.StudentNotFound(id));
                    throw new RuntimeException(BusinessMessage.Student.STUDENT_NOT_FOUND);
                });
    }

    private void checkIfStudentFatherPhoneExists(String fatherPhone) {
        if (studentRepository.existsByFatherPhone(fatherPhone)) {
            log.error(LogMessage.Student.FatherPhoneAlreadyExists(fatherPhone));
            throw new RuntimeException(BusinessMessage.Student.STUDENT_FATHER_PHONE_ALREADY_EXISTS);
        }
    }

    private void checkIfStudentMotherPhoneExists(String motherPhone) {
        if (studentRepository.existsByMotherPhone(motherPhone)) {
            log.error(LogMessage.Student.MotherPhoneAlreadyExists(motherPhone));
            throw new RuntimeException(BusinessMessage.Student.STUDENT_MOTHER_PHONE_ALREADY_EXISTS);
        }
    }
}
