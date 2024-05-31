package com.ins.service.impl;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.UUID;

import com.ins.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ins.Repository.UserRepository;
import com.ins.modal.User;
import com.ins.service.UserServices;

@Service
public class UserServiceImplement implements UserServices  {
	@Autowired
	private UserRepository userRepository;
	@Override
	public User saveUser(User user) {
		String randomUserId =UUID.randomUUID().toString();
		user.setId(randomUserId);
		return userRepository.save(user);
	}
	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public User getUser(String id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User is not found With id : " + id));
		return user;
	}


}
