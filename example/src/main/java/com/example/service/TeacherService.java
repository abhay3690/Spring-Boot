package com.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Ensure transactions are managed

import com.example.helper.BusinessMessage;
import com.example.helper.DateHelper;
import com.example.helper.LogMessage;
import com.example.modal.Teacher;
import com.example.payload.TeacherDto;
import com.example.payload.converter.TeacherDtoConverter;
import com.example.payload.request.teacher.CreateTeacherRequest;
import com.example.payload.request.teacher.UpdateTeacherRequest;
import com.example.repository.TeacherRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherDtoConverter converter;

    @Transactional // Ensure that the operations are managed within a transaction
    public void createTeacher(CreateTeacherRequest request) {
        checkIfTeacherExists(request.getNationalId());

        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setNationalId(request.getNationalId());
        teacher.setPhone(request.getPhone());
        teacher.setCreatedDate(DateHelper.getCurrentDate()); // Set creation date
        teacher.setUpdatedDate(DateHelper.getCurrentDate()); // Set update date initially

        teacherRepository.save(teacher);
        log.info(LogMessage.Teacher.TeacherCreated());
    }

    @Transactional // Ensure that the operations are managed within a transaction
    public void updateTeacher(String id, UpdateTeacherRequest request) {
        Teacher teacher = findTeacherByTeacherId(id);

        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setPhone(request.getPhone());
        teacher.setUpdatedDate(DateHelper.getCurrentDate()); // Update date

        teacherRepository.save(teacher);
        log.info(LogMessage.Teacher.TeacherUpdated(id));
    }

    @Transactional // Ensure that the operations are managed within a transaction
    public void deleteTeacher(String id) {
        Teacher teacher = findTeacherByTeacherId(id);

        teacherRepository.delete(teacher);
        log.info(LogMessage.Teacher.TeacherDeleted(id));
    }

    public TeacherDto findTeacherById(String id) {
        Teacher teacher = findTeacherByTeacherId(id);

        log.info(LogMessage.Teacher.TeacherFound(id));
        return converter.convert(teacher);
    }

    public List<TeacherDto> findAllTeachers() {
        List<Teacher> teacherList = teacherRepository.findAll();

        if (teacherList.isEmpty()) {
            log.error(LogMessage.Teacher.TeacherListEmpty());
            throw new RuntimeException(BusinessMessage.Teacher.TEACHER_LIST_EMPTY);
        }

        log.info(LogMessage.Teacher.TeacherListed());
        return converter.convert(teacherList);
    }

    private void checkIfTeacherExists(String nationalId) {
        if (teacherRepository.existsByNationalId(nationalId)) {
            log.error(LogMessage.Teacher.TeacherAlreadyExists(nationalId));
            throw new RuntimeException(BusinessMessage.Teacher.TEACHER_ALREADY_EXISTS);
        }
    }

    protected Teacher findTeacherByTeacherId(String id) {
        return teacherRepository.findById(id).orElseThrow(() -> {
            log.error(LogMessage.Teacher.TeacherNotFound(id));
            throw new RuntimeException(BusinessMessage.Teacher.TEACHER_NOT_FOUND);
        });
    }
}
