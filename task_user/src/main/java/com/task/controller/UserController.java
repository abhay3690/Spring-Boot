package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.modal.User;
import com.task.payload.ApiResponse;
import com.task.services.UserService;

@RestController
@RequestMapping("/api/users")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;

	// Post- create User
	@PostMapping("/")
	public ResponseEntity<User> createUser( @RequestBody User user) {
		User createUser = this.userService.createUser(user);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}

	// Put- Update User
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") int userId) {
		User updateUser = this.userService.updateUser(user, userId);
		return ResponseEntity.ok(updateUser);
	}
	//Admin
	// Delete User
//	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}

	// Get User
	@GetMapping("{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable int userId) {
		User userById = this.userService.getUserById(userId);
		return ResponseEntity.ok(userById);
	}

	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = this.userService.allUser();
		return ResponseEntity.ok(allUser);
	}
}
