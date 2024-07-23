package net.abhay.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.abhay.blog.services.AuthenticationService;
import net.abhay.blog.services.UserService;

import net.abhay.payloads.UserDto;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;

	private final UserService userService ;

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(service.authenticate(request));
	}
	// register new user
		@PostMapping("/register")
		public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
			UserDto registerUser = this.userService.registerNewUser(userDto);
			return new ResponseEntity<>(registerUser,HttpStatus.CREATED);
		}

}