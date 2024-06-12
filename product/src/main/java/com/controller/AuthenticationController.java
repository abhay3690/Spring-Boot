package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payload.SellerDto;
import com.security.AuthenticationRequest;
import com.service.SellerService;
import com.service.impl.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final SellerService sellerService;

    // Login user
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<SellerDto> registerNewSeller(@RequestBody SellerDto sellerDto) {
        SellerDto registeredSeller = sellerService.registerNewSeller(sellerDto);
        return new ResponseEntity<>(registeredSeller, HttpStatus.CREATED);
    }
}




















//package com.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.payload.SellerDto;
//import com.security.AuthenticationRequest;
//import com.service.SellerService;
//import com.service.impl.AuthenticationService;
//
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//@RequiredArgsConstructor
//public class AuthenticationController {
//
//	@Autowired
//	private final AuthenticationService service;
//
//	@Autowired
//	private SellerService sellerService;
//
//	// login user
//	@PostMapping("/login")
//	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
//		return ResponseEntity.ok(service.authenticate(request));
//	}
//
//	// register new user
//
//	@PostMapping("/register")
//	public ResponseEntity<SellerDto> registerNewSeller(@RequestBody SellerDto sellerDto) {
//		SellerDto registerUser = this.sellerService.registerNewSeller(sellerDto);
//		return new ResponseEntity<SellerDto>(registerUser, HttpStatus.CREATED);
//	}
//}