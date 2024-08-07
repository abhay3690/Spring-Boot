package com.example.payload.converter;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.modal.Classroom;
import com.example.payload.TeacherClassroomDto;

@Component
public class TeacherClassroomDtoConverter {
    public TeacherClassroomDto convert(Classroom from){
        return new TeacherClassroomDto(
                from.getId(),
                from.getName()
        );
    }

    public List<TeacherClassroomDto> convert(List<Classroom> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
