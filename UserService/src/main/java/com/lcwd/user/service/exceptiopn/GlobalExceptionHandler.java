 package com.lcwd.user.service.exceptiopn;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class )
 public ResponseEntity<ApiResponse> handlertResourceNotFoundException(ResourceNotFoundException ex){
	String message = ex.getMessage();
	ApiResponse response  = ApiResponse.builder().success(true).status(HttpStatus.NOT_FOUND).build();
	return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	
	 
 }
}
