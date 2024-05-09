package com.jwt.example.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.models.User;
import com.jwt.example.services.UserServices;

@RestController
@RequestMapping("/home")
public class HomeControllers {
	@Autowired
	private UserServices userServices;
	
//		http://localhost:8081/home/users
	@GetMapping("/users")
	public List<User> getUser() {
		System.out.println("geting users");
		return this.userServices.getUsers();
	}
	
	@GetMapping("/curent-user")
	public String getLoggedInUSer(Principal principal) {
		return principal.getName();
		
	}
}
