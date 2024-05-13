package net.abhay.blog.services;

import java.util.List;

import net.abhay.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> allUser();

	void deleteUser(Integer userId);
}
