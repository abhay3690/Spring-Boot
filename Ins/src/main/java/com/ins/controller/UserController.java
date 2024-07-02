package com.ins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ins.dto.UserDto;
import com.ins.exception.UserException;
import com.ins.modal.User;
import com.ins.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	// Post- create User
//	@PostMapping("/")
//	public ResponseEntity<User> registerUser(@RequestBody User user) {
//	    try {
//	        if (user == null) {
//	            throw new IllegalArgumentException("User object cannot be null");
//	        }
//	        
//	        User registeredUser = this.userService.registerUser(user);
//	        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
//	    } catch (UserException e) {
//	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	    } catch (IllegalArgumentException e) {
//	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	    }
//	}

	@PostMapping("/")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto user) throws UserException {
		UserDto registerUser = this.userService.registerUser(user);
		return new ResponseEntity<UserDto>(registerUser, HttpStatus.CREATED);
	}

	// Get User findUserByIdUser
	@GetMapping("{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable int userId) throws UserException {
		UserDto userByIdUser = this.userService.findUserByIdUser(userId);
		return ResponseEntity.ok(userByIdUser);
	}
}
