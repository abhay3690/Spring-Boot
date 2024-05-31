package com.ins.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id){
		User user = userServices.getUser(id);
		return ResponseEntity.ok(user);
	}
}
