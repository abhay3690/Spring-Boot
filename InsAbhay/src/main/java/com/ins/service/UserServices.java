package com.ins.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ins.modal.User;
@Service 
public interface UserServices {
	User saveUser(User user);
	List<User> getAllUser();
	User getUser(Integer id);

}
