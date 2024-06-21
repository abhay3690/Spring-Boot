package com.otp.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.otp.modal.Users;
import com.otp.repository.UserRepository;
import com.otp.request.RegisterRequest;
import com.otp.response.RegisterResponse;
import com.otp.service.UserService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class USerServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final EmailService emailService;

	@Override
	public RegisterResponse register(RegisterRequest registerRequest) throws MessagingException {
		Users existingUser = userRepository.findByEmail(registerRequest.getEmail());
		if (existingUser != null && existingUser.isVerified()) {
			throw new RuntimeException("USer already registered");
		}
		Users users = Users.builder().userName(registerRequest.getUserName()).email(registerRequest.getEmail())
				.password(registerRequest.getPassword()).build();
		String otp = genetrateOtp();
		users.setOtp(otp);
		Users savedUser = userRepository.save(users);

		sendVerificationEmail(savedUser.getEmail(), otp);
		RegisterResponse response = RegisterResponse.builder().userName(users.getUserName()).email(users.getEmail())
				.build();

		return response;
	}

	private String genetrateOtp() {
		Random random = new Random();
		int otpValue = 1000000 + random.nextInt(9000000);
		return String.valueOf(otpValue);

	}

	private void sendVerificationEmail(String email, String otp) throws MessagingException {
		String subject = "Email verification";
		String body = "Yor verification otp is : " + otp;
		emailService.sendEmail(email, subject, body);
	}

	@Override
	public void verify(String email, String otp) {
		Users users = userRepository.findByEmail(email);
		if (users == null) {
			throw new RuntimeException("User not found");
		} else if (users.isVerified()) {
			throw new RuntimeException("User is already verified");
		} else if (otp.equals(users.getOtp())) {
			users.setVerified(true);
			userRepository.save(users);
		} else {
			throw new RuntimeException("Internal Server error");
		}
	}

	@Override
	public Users login(String email, String password) {
		Users byEmail = userRepository.findByEmail(email);
		if (byEmail != null && byEmail.isVerified() && byEmail.getPassword().equals(password)) {
			return byEmail;
		}else {
			throw new RuntimeException("Internal server Error");
		}
	}
}
