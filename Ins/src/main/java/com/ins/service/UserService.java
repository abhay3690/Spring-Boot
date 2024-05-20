package com.ins.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ins.exception.UserException;
import com.ins.modal.User;
@Service
public interface UserService  {
	public User registerUser(User user) throws UserException;
	public User findUserByIdUser(Integer userId) throws UserException;
	public User findUSerProfile(String token) throws UserException;
	public User findUserByName(String userName) throws UserException;
	public String followUser(Integer reqUserId, Integer followUsaerID) throws UserException;
	public String unFollowUser(Integer reqUserId, Integer followUsaerID) throws UserException;
	public List<User> findUserByIds(List<Integer> userIds)  throws UserException;
	public List<User> searchUser(String query) throws UserException;
	public User updateUserDeatails(User updatedUser,User existingUser) throws UserException;
	
	}