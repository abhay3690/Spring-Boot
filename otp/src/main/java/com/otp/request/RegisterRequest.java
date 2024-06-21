package com.otp.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
	private String userName;
	private String email;
	private String password;
}
