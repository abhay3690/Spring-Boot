package com.otp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otp.modal.Users;
import com.otp.request.RegisterRequest;
import com.otp.response.RegisterResponse;
import com.otp.service.UserService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
	private final UserService userService;
	@PostMapping("register")
	public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) throws MessagingException{
		RegisterResponse register = userService.register(registerRequest);
		return new ResponseEntity<>(register,HttpStatus.CREATED);
	}
	 @PostMapping("/verify")
	    public ResponseEntity<?> verify(@RequestParam String email, @RequestParam String otp){
	        try {
	            userService.verify(email, otp);
	            return new ResponseEntity<>("User verified successfully",HttpStatus.OK);
	        }catch (RuntimeException e){
	            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	        }
	    }
	 @PostMapping("/login")
	 public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password){
		 Users users = userService.login(email, password);
		 return new ResponseEntity<>(users, HttpStatus.OK);
	 }

}
