package com.example.payload;

public record ClassroomStudentDto(
        String id,
        String firstName,
        String lastName,
        String nationalId,
        String studentNumber
) {
}