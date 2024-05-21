package com.ins.service;

import java.util.List;

import com.ins.dto.UserDto;
import com.ins.exception.UserException;

public interface UserService  {
	 UserDto registerUser(UserDto user) throws UserException;
	 UserDto findUserByIdUser(Integer userId) throws UserException;
	 UserDto findUSerProfile(String token) throws UserException;
	 UserDto findUserByName(String userName) throws UserException;
	 String followUser(Integer reqUserId, Integer followUserID) throws UserException;
	 String unFollowUser(Integer reqUserId, Integer followUserID) throws UserException;
	 List<UserDto> findUserByIds(List<Integer> userIds)  throws UserException;
	 List<UserDto> searchUser(String query) throws UserException;
	 UserDto updateUserDeatails(UserDto updatedUser,UserDto existingUser) throws UserException;
	
	}