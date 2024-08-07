package com.example.exception.classroom;

public class ClassroomAlreadyExistException extends RuntimeException {
    public ClassroomAlreadyExistException(String message) {
        super(message);
    }
}