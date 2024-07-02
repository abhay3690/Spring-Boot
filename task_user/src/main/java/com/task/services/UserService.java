package com.task.services;

import java.util.List;

import com.task.modal.User;

public interface UserService {
	User registerNewUser(User userDto);

	User createUser(User user);

	User updateUser(User user, Integer userId);

	User getUserById(Integer userId);

	List<User> allUser();

	void deleteUser(Integer userId);
}