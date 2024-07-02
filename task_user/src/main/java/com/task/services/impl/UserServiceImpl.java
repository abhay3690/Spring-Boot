package com.task.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.exception.ResourceNotFoundException;
import com.task.modal.User;
import com.task.repositories.UserRepo;
import com.task.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Autowired
//	private RoleRepo roleRepo;

	@Override
	public User createUser(User user) {
		User user1 = this.dtoToUser(user);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public User updateUser(User user, Integer userId) {
		User user1 = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

		user.setName(user.getName());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		user.setAbout(user.getAbout());
		User updateUser = this.userRepo.save(user);
		User userToDto = this.userToDto(updateUser);
		return user1;
	}

	@Override
	public User getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

		return this.userToDto(user);
	}

	@Override
	public List<User> allUser() {
		List<User> users = this.userRepo.findAll();
		List<User> list = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return list;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
		this.userRepo.delete(user);

	}

	public User dtoToUser(User user) {
		User map = this.modelMapper.map(user, User.class);

//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return map;
	}

	public User userToDto(User user) {
		User userDto = this.modelMapper.map(user, User.class);

//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return userDto;
	}

	@Override
	public User registerNewUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public UserDto registerNewUser(UserDto userDto) {
//		User user = this.modelMapper.map(userDto, User.class);
//		// encode password
//		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
//
//		// roles
//		Role role = this.roleRepo.findById(AppConstatns.NORMAL_USER).get();
//
//		user.getRoles().add(role);
//
//		User newUser = this.userRepo.save(user);
//
//		return this.modelMapper.map(newUser, UserDto.class);
//	}

}
