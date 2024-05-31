package com.ins.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ins.modal.User;
import com.ins.service.UserServices;

@RestController
@RequestMapping("/A")
public class UserController {
	@Autowired
	private UserServices userServices;

	@PostMapping("/")
	private ResponseEntity<User> createUser(@RequestBody User user) { 
		User user1 = userServices.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userServices.getAllUser();
		return ResponseEntity.ok(allUser);
	}
}
