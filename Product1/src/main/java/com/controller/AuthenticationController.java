package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.load.SellerDto;
import com.security.AuthenticationRequest;
import com.security.AuthenticationResponse;
import com.service.SellerService;
import com.service.impliment.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	@Autowired
	private final AuthenticationService service;

	@Autowired
	private SellerService sellerService;

	// login user
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(service.authenticate(request));
	}

	// register new user

	@PostMapping("/register")
	public ResponseEntity<SellerDto> registerUser(@RequestBody SellerDto sellerDto) {
		SellerDto registerUser = this.sellerService.registerNewSeller(sellerDto);
		return new ResponseEntity<SellerDto>(registerUser, HttpStatus.CREATED);
	}
}
