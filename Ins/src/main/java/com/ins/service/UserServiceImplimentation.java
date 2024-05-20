package com.ins.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import com.ins.dto.UserDto;
import com.ins.exception.UserException;
import com.ins.modal.User;
import com.ins.repository.UserRepository;

public class UserServiceImplimentation implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) throws UserException {
		Optional<User> isEmailExist = userRepository.findByEmail(user.getEmail());
		if (isEmailExist.isPresent()) {
			throw new UserException("Email is Already Exist !! ");
		}
		Optional<User> isUsernameExist = userRepository.findByUsername(user.getUsername());
		if (isUsernameExist.isPresent()) {
			throw new UserException("Username is Already Taken... !! ");
		}
		if (user.getEmail() == null|| user.getPassword() == null || user.getUsername() == null /*|| user.getName() == null*/) {
			throw new UserException("All Fields Are requires");
		}
		User newUser =new User();
		newUser.setPassword(user.getPassword());
		newUser.setUsername(user.getUsername());
//		newUser.setName(user.getName());
		return userRepository.save(newUser);
	}

	@Override
	public User findUserByIdUser(Integer userId) throws UserException {
		Optional<User> opt = userRepository.findById(userId);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new UserException("User not Exist with id" +userId);
	}

	@Override
	public User findUSerProfile(String token) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByName(String userName) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String followUser(Integer reqUserId, Integer followUserId) throws UserException {
		User reqUser = findUserByIdUser(reqUserId);
		User followUser = findUserByIdUser(followUserId);
		
		UserDto follower = new UserDto();
		follower.setEmail(reqUser.getEmail());
		follower.setId(reqUser.getId());
//		follower.setName(reqUser.getName());
		follower.setUserImage(reqUser.getUserImage());
		follower.setUsername(reqUser.getUsername());
		
		UserDto following = new UserDto();
		following.setEmail(reqUser.getEmail());
		following.setId(reqUser.getId());
//		following.setName(reqUser.getName());
		following.setUserImage(reqUser.getUserImage());
		following.setUsername(reqUser.getUsername());
		
		reqUser.getFollwing().add(following);
		followUser.getFollower().add(follower);
		
		userRepository.save(followUser);
		userRepository.save(reqUser	);
		
		
			
		
		return null;
	}

	@Override
	public String unFollowUser(Integer reqUserId, Integer followUsaerID) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByIds(List<Integer> userIds) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchUser(String query) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUserDeatails(User updatedUser, User existingUser) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
