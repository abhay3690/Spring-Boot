package com.user.service;

import java.util.ArrayList;
import java.util.List;

import com.user.entity.User;



public class UserServiceImpl implements UserService {
	List<User> list = new ArrayList<>(
			List.of(new User(1, "ysadjh", 52)));

	@Override
	public User getUser(int id) {
		
		return null;
	}

	

 

	

	

}
