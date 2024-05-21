package net.abhay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.abhay.blog.services.AuthenticationService;
import net.abhay.blog.services.UserService;
import net.abhay.exceptions.ApiException;
import net.abhay.payloads.PostDto;
import net.abhay.payloads.UserDto;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	@Autowired
	private final AuthenticationService service;
	@Autowired
	private UserService userService ;

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {

		return ResponseEntity.status(HttpStatus.OK).body(service.authenticate(request));

	}
	// register new user
	
		@PostMapping("/register")
		public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
			UserDto registerUser = this.userService.registerNewUser(userDto);
			return new ResponseEntity<UserDto>(registerUser,HttpStatus.CREATED);
		}

}