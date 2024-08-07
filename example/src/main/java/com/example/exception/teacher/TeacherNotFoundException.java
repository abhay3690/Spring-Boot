package com.example.exception.teacher;


public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(String message) {
        super(message);
    }
}