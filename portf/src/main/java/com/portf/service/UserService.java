package com.portf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portf.payload.UserDto;

@Service
public interface UserService {
	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> allUser();

	void deleteUser(Integer userId);
}
