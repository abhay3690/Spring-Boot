package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exception.classroom.ClassroomNotFoundException;
import com.example.helper.BusinessMessage;
import com.example.helper.GenerateClassroomName;
import com.example.helper.LogMessage;
import com.example.modal.Classroom;
import com.example.payload.ClassroomDto;
import com.example.payload.converter.ClassroomDtoConverter;
import com.example.payload.request.classroom.CreateClassroomRequest;
import com.example.payload.request.classroom.UpdateClassroomRequest;
import com.example.repository.ClassroomRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final TeacherService teacherService;
    private final ClassroomDtoConverter converter;
    
    public void createClassroom(CreateClassroomRequest request) {
        Classroom classroom = new Classroom();
        classroom.setName(GenerateClassroomName.generate());
        classroom.setDescription(request.getDescription());
        classroom.setTeacher(teacherService.findTeacherByTeacherId(request.getTeacherId()));

        classroomRepository.save(classroom);
        log.info(LogMessage.Classroom.ClassroomCreated());
    }

    public void updateClassroom(String id, UpdateClassroomRequest request) {
        Classroom classroom = findClassroomByClassroomId(id);

        classroom.setDescription(request.getDescription());
        classroom.setTeacher(teacherService.findTeacherByTeacherId(request.getTeacherId()));

        classroomRepository.save(classroom);
        log.info(LogMessage.Classroom.ClassroomUpdated(id));
    }

    public void deleteClassroom(String id) {
        Classroom classroom = findClassroomByClassroomId(id);

        classroomRepository.delete(classroom);
        log.info(LogMessage.Classroom.ClassroomDeleted(id));
    }

    public ClassroomDto findClassroomById(String id) {
        Classroom classroom = findClassroomByClassroomId(id);

        log.info(LogMessage.Classroom.ClassroomFound(id));
        return converter.convert(classroom);
    }

    public List<ClassroomDto> findAllClassrooms() {
        List<Classroom> classroomList = classroomRepository.findAll();

        if (classroomList.isEmpty()) {
            log.error(LogMessage.Classroom.ClassroomListEmpty());
            throw new ClassroomNotFoundException(BusinessMessage.Classroom.CLASSROOM_LIST_EMPTY);
        }

        log.info(LogMessage.Classroom.ClassroomListed());
        return converter.convert(classroomList);
    }

    protected Classroom findClassroomByClassroomId(String id) {
        return classroomRepository.findById(id).orElseThrow(() -> {
            log.error(LogMessage.Classroom.ClassroomNotFound(id));
            throw new ClassroomNotFoundException(BusinessMessage.Classroom.CLASSROOM_NOT_FOUND);
        });
    }
}