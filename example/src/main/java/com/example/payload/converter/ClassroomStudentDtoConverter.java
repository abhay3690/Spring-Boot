package com.example.payload.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.modal.Student;
import com.example.payload.ClassroomStudentDto;

@Component
public class ClassroomStudentDtoConverter {
    public ClassroomStudentDto convert(Student from){
        return new ClassroomStudentDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getNationalId(),
                from.getStudentNumber()
        );
    }

    public List<ClassroomStudentDto> convert(List<Student> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}