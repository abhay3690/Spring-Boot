package com.example.payload.converter;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.modal.Teacher;
import com.example.payload.TeacherDto;

@Component
public class TeacherDtoConverter {
    private final TeacherClassroomDtoConverter teacherClassroomDtoConverter;

    public TeacherDtoConverter(TeacherClassroomDtoConverter teacherClassroomDtoConverter) {
        this.teacherClassroomDtoConverter = teacherClassroomDtoConverter;
    }

    public TeacherDto convert(Teacher from) {
        return new TeacherDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getNationalId(),
                from.getPhone(),
                teacherClassroomDtoConverter.convert(from.getClassroomList())
        );
    }

    public List<TeacherDto> convert(List<Teacher> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
