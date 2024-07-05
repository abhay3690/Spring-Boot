package com.gaphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaphql.entities.Order;
import com.gaphql.entities.User;
import com.gaphql.helper.ExceptionHelper;
import com.gaphql.repositories.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	@Autowired
	private UserRepo userRepo;
	public User createUser(User user) {
		return userRepo.save(user);
	}
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	public User getUser(int userId) {
        return userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
	}
	public boolean deleteUser(int userId) {
		User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		userRepo.delete(user);
		return true;
	}
	public User updateUser(int userId,User user) {
		User user2 = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setPhone(user.getPhone());
		user2.setPassword(user.getPassword());
//		user2.setOrders(user.getOrders());
		return user2;
	}
}
