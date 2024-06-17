package com.portf.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.portf.payload.ApiResponse;
import com.portf.payload.UserDto;
import com.portf.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/add")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		logger.info("Request received to create user with data: {}", userDto);
		try {
			UserDto dto = this.userService.createUser(userDto);
			logger.info("User created successfully with ID: {}", dto.getId());
			return new ResponseEntity<>(dto, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Failed to create user", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") int userId) {
		logger.info("Request received to update user with ID: {}", userId);
		try {
			UserDto updateUser = this.userService.updateUser(userDto, userId);
			logger.info("User updated successfully with ID: {}", updateUser.getId());
			return ResponseEntity.ok(updateUser);
		} catch (Exception e) {
			logger.error("Failed to update user with ID: {}", userId, e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable int userId) {
		logger.info("Request received to fetch user with ID: {}", userId);
		try {
			UserDto userById = this.userService.getUserById(userId);
			logger.info("User fetched successfully with ID: {}", userById.getId());
			return ResponseEntity.ok(userById);
		} catch (Exception e) {
			logger.error("Failed to fetch user with ID: {}", userId, e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser() {
		logger.info("Request received to fetch all users");
		try {
			List<UserDto> allUser = this.userService.allUser();
			logger.info("Fetched {} users", allUser.size());
			return ResponseEntity.ok(allUser);
		} catch (Exception e) {
			logger.error("Failed to fetch all users", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int userId) {
		logger.info("Request received to delete user with ID: {}", userId);
		try {
			this.userService.deleteUser(userId);
			logger.info("User deleted successfully with ID: {}", userId);
			return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Failed to delete user with ID: {}", userId, e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
