package com.thinkconstructive.rest_demo.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CloudVendorNotFoundException extends RuntimeException{
    public CloudVendorNotFoundException(String message) {
        super(message);
    }
    public CloudVendorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
