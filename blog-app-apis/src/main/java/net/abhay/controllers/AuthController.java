package net.abhay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.abhay.payloads.JwtAuthRequest;
import net.abhay.payloads.JwtAuthResponse;
import net.abhay.security.JwtTokenHelper;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {
		System.out.println("This is check purpose comtroller");
		this.authenticate(request.getUsername(), request.getPassword());
		System.out.println("This is check purpose comtroller1");
		UserDetails userDetail = this.userDetailsService.loadUserByUsername(request.getUsername());
		System.out.println("This is check purpose comtroller2");
		String token = this.jwtTokenHelper.generateToken(userDetail);
		System.out.println("This is check purpose comtroller3");
		JwtAuthResponse response = new JwtAuthResponse();
		System.out.println("This is check purpose comtroller4");
		response.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	}

	public void authenticate(String username, String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);
		try {
			System.out.println("This is check purpose comtroller5");
			this.authenticationManager.authenticate(authenticationToken);
		} catch (BadCredentialsException e) {
			System.out.println("Invalid UserDetails !! ");
			throw new Exception("Invalid Username & Password !!");
		}
	}
}