package com.jwt.auth.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.models.User;
import com.jwt.auth.services.UserServices;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserServices userServices;
	@GetMapping("/Users")
	public List<User> getUser() {
		System.out.println("Hii world");
		return userServices.getUsers();
	}
	@GetMapping("/currentUser")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
		
	}

}
