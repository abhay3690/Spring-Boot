package com.example.payload.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.modal.Student;
import com.example.payload.StudentDto;


@Component
public class StudentDtoConverter {
    private final AddressDtoConverter addressDtoConverter;

    public StudentDtoConverter(AddressDtoConverter addressDtoConverter) {
        this.addressDtoConverter = addressDtoConverter;
    }

    public StudentDto convert(Student from) {
        return new StudentDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getNationalId(),
                from.getStudentNumber(),
                from.getFatherName(),
                from.getFatherPhone(),
                from.getMotherName(),
                from.getMotherPhone(),
                addressDtoConverter.convert(from.getAddressList()),
                from.getClassroom() != null ? from.getClassroom().getId() : null
        );
    }

    public List<StudentDto> convert(List<Student> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}