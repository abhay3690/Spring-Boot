package com.exception;


public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // Constructor that accepts a message
    public ApiException(String message) {
        super(message);
    }

    // Default constructor
    public ApiException() {
        super();
    }
}

