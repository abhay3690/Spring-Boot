package com.example.payload.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.modal.Classroom;
import com.example.payload.ClassroomDto;

@Component
public class ClassroomDtoConverter {
    private final ClassroomStudentDtoConverter classroomStudentDtoConverter;

    public ClassroomDtoConverter(ClassroomStudentDtoConverter classroomStudentDtoConverter) {
        this.classroomStudentDtoConverter = classroomStudentDtoConverter;
    }

    public ClassroomDto convert(Classroom from) {
        return new ClassroomDto(
                from.getId(),
                from.getName(),
                from.getDescription(),
                from.getTeacher().getId(),
                classroomStudentDtoConverter.convert(from.getStudentList())
        );
    }

    public List<ClassroomDto> convert(List<Classroom> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}