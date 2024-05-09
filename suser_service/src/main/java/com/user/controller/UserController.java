package com.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entities.Number;
import com.user.entities.User;

@RestController
public class UserController {

	List<User> user = new ArrayList<User>(
			List.of(new User(1, "ghjkg", new Number(1, "hgkjg"))));

	@GetMapping("/path")
	public List<User> getUser() {
		System.out.println("HII");
		return user;
	}
}
