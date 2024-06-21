package com.otp.service;

import com.otp.modal.Users;
import com.otp.request.RegisterRequest;
import com.otp.response.RegisterResponse;

import jakarta.mail.MessagingException;

public interface UserService {
	RegisterResponse register(RegisterRequest registerRequest) throws MessagingException;
	void verify(String email, String otp);
	Users login(String email,String password);

}
