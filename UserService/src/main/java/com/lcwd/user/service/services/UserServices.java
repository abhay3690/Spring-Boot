package com.lcwd.user.service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lcwd.user.service.entities.User;
@Service
public interface UserServices {

	User saveUser(User user);

	List<User> getAllUser();
	User getUser(String UserId);
}
