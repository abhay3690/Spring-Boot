package com.Jauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Jauth.model.User;
import com.Jauth.service.JwtService;
import com.Jauth.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@PostMapping("register")
	public User register(@RequestBody User user) {
		return service.saveUser(user);
	}

	@PostMapping("login")
	public String login(@RequestBody User user) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		} else {
			return "Login Failed";
		}
	}
}
