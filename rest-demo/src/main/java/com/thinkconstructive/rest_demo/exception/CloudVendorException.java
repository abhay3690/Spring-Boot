package com.thinkconstructive.rest_demo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@RequiredArgsConstructor
@Getter
@Setter
public class CloudVendorException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
}
