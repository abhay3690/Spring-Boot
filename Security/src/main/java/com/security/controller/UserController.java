package com.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.security.entity.AuthRequest;
import com.security.entity.UserInfo;
import com.security.logout.BlackList;
import com.security.service.JwtService;
import com.security.service.UserInfoService;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtService jwtService;

	@Autowired
	private BlackList blackList;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Spring Security tutorials !!";
	}

	@PostMapping("/addUser")
	public String addUser(@RequestBody UserInfo userInfo) {
		return userInfoService.addUser(userInfo, null);
	}

	@PostMapping("/login")
	public String addUser(@RequestBody AuthRequest authRequest) {
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		if (authenticate.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUserName());
		} else {
			throw new UsernameNotFoundException("Invalid user request");
		}
	}

	@PostMapping("/logout")
	@PreAuthorize("hasAuthority('USER_ROLES') or hasAuthority('ADMIN_ROLES')")
	public String logoutUser(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		String token = null;
		if (authHeader != null && authHeader.startsWith("Bearer")) {
			token = authHeader.substring(7);
		}
		blackList.blacKListToken(token);
		return "You have successfully logged out !!";
	}

	@GetMapping("/getUsers")
	@PreAuthorize("hasAuthority('ADMIN_ROLES') or hasAuthority('USER_ROLES')")
	public List<UserInfo> getAllUsers() {
		return userInfoService.getAllUser();
	}

	@GetMapping("/getUsers/{id}")
	@PreAuthorize("hasAuthority('USER_ROLES')")
	public UserInfo getAllUsers(@PathVariable Integer id) {
		return userInfoService.getUser(id);
	}


}
