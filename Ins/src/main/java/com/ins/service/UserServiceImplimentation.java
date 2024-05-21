 package com.ins.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ins.dto.UserDto;
import com.ins.exception.ErrorDetails;
import com.ins.exception.UserException;
import com.ins.modal.User;
import com.ins.repository.UserRepository;

@Service
public class UserServiceImplimentation implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto registerUser(UserDto user) throws UserException {

		Optional<User> isEmailExist = userRepository.findByEmail(user.getEmail());
		if (isEmailExist.isPresent()) {
			throw new UserException("Email is Already Exist !! ");
		}
		Optional<User> isUsernameExist = userRepository.findByUsername(user.getUsername());
		if (isUsernameExist.isPresent()) {
			throw new UserException("Username is Already Taken... !! ");
		}
		if (user.getEmail() == null || user.getUsername() == null || user.getName() == null) {
			throw new UserException("All Fields Are required");
		}

		// Convert UserDto to User
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setEmail(user.getEmail());
		// Set other properties as needed

		// Save the User object
		User savedUser = userRepository.save(newUser);

		// Convert the saved User back to UserDto if needed
		UserDto savedUserDto = new UserDto();
		savedUserDto.setUsername(savedUser.getUsername());
		// Map other properties from savedUser to savedUserDto as needed

		return savedUserDto;

//		Optional<User> isEmailExist = userRepository.findByEmail(user.getEmail());
//		if (isEmailExist.isPresent()) {
//			throw new UserException("Email is Already Exist !! ");
//		}
//		Optional<User> isUsernameExist = userRepository.findByUsername(user.getUsername());
//		if (isUsernameExist.isPresent()) {
//			throw new UserException("Username is Already Taken... !! ");
//		}
//		if (user.getEmail() == null||  user.getUsername() == null || user.getName() == null) {
//			throw new UserException("All Fields Are requires");
//		}
//		UserDto userDto =new UserDto();
//		
//		userDto.setUsername(user.getUsername());
////		newUser.setName(user.getName());
//		return userRepository.save(userDto);
	}

	@Override
	public UserDto findUserByIdUser(Integer userId) throws UserException {
//		Optional<UserDto> opt = userRepository.findById(userId);
//		if (opt.isPresent()) {
//			User user = opt.get();
//			// Convert User to UserDto
//			UserDto userDto = convertToDto(user);
//			return userDto;
//		}
//		throw new UserException("User not Exist with id" + userId);
		return null;
	}

	private UserDto convertToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUsername(user.getUsername());
		userDto.setEmail(user.getEmail());
		// Map other properties from user to userDto as needed
		return userDto;
	}

	@Override
	public UserDto findUSerProfile(String token) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto findUserByName(String userName) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String followUser(Integer reqUserId, Integer followUserID) throws UserException {

		// Find the users
		UserDto reqUser = findUserByIdUser(reqUserId); // Assuming this method returns User, not UserDto
		UserDto followUser = findUserByIdUser(followUserID); // Assuming this method returns User, not UserDto

		// Create follower and following objects
		User follower = new User();
		follower.setEmail(reqUser.getEmail());
		follower.setId(reqUser.getId());
		follower.setUsername(reqUser.getUsername());

		User following = new User();
		following.setEmail(followUser.getEmail());
		following.setId(followUser.getId());
		following.setUsername(followUser.getUsername());

		// Add follower and following
//		followUser.getFollowers().add(follower); // Assuming there's a followers list in User class
//		reqUser.getFollowing().add(following); // Assuming there's a following list in User class

		// Save users
		userRepository.save(followUser);
		userRepository.save(reqUser);

		return "You are now following " + followUser.getUsername();
	}

	@Override
	public String unFollowUser(Integer reqUserId, Integer followUserID) throws UserException {
		UserDto reqUser = findUserByIdUser(reqUserId);
		UserDto followUser = findUserByIdUser(followUserID);

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

//		reqUser.getFollwing().remove(following);
//		followUser.getFollower().remove(follower);

		userRepository.save(followUser);
		userRepository.save(reqUser);

		return "You have Unfollowed " + followUser.getUsername();
	
	}
	@Override
	public List<UserDto> findUserByIds(List<Integer> userIds) throws UserException {
	    // Retrieve users from the repository based on the provided user IDs
	    List<User> users = userRepository.findAllUsersByUserIds(userIds);
	    
	    // Create a list to store UserDto objects
	    List<UserDto> userDtos = new ArrayList<>();
	    
	    // Iterate through each User object and convert it to UserDto
	    for (User user : users) {
	        UserDto userDto = new UserDto();
	        userDto.setId(user.getId());
	        userDto.setUsername(user.getUsername());
	        userDto.setEmail(user.getEmail());
//	        userDto.setName(user.getName());
	        userDto.setUserImage(user.getUserImage());
	        
	        // Add the converted UserDto to the list
	        userDtos.add(userDto);
	    }
	    
	    // Return the list of UserDto objects
	    return userDtos;
	}

//	@Override
//	public List<UserDto> searchUser(String query) throws UserException {
//		List<User> users = userRepository.findByQuery(query);
//		if (users.size() == 0) {
//			throw new UserException("USer not Found");
//		}
//		return users;
//	}
	
	
	@Override
	public List<UserDto> searchUser(String query) throws UserException {
	    // Retrieve users from the repository based on the provided query
	    List<User> users = userRepository.findByQuery(query);
	    
	    // Check if users are found
	    if (users.isEmpty()) {
	        throw new UserException("User not Found");
	    }
	    
	    // Create a list to store UserDto objects
	    List<UserDto> userDtos = new ArrayList<>();
	    
	    // Convert each User object to UserDto
	    for (User user : users) {
	        UserDto userDto = new UserDto();
	        userDto.setId(user.getId());
	        userDto.setUsername(user.getUsername());
	        userDto.setEmail(user.getEmail());
//	        userDto.setName(user.getName());
	        userDto.setUserImage(user.getUserImage());
	        
	        // Add the converted UserDto to the list
	        userDtos.add(userDto);
	    }
	    
	    // Return the list of UserDto objects
	    return userDtos;
	}


	@Override
	public UserDto updateUserDeatails(UserDto updatedUser, UserDto existingUser) throws UserException {
		if (updatedUser.getEmail() != null) {
			existingUser.setEmail(updatedUser.getEmail());
		}
		return null;
	}

	
	
	
	
	
	
	
	
	
	
//	@Override
//	public User registerUser(User user) throws UserException {
//		Optional<User> isEmailExist = userRepository.findByEmail(user.getEmail());
//		if (isEmailExist.isPresent()) {
//			throw new UserException("Email is Already Exist !! ");
//		}
//		Optional<User> isUsernameExist = userRepository.findByUsername(user.getUsername());
//		if (isUsernameExist.isPresent()) {
//			throw new UserException("Username is Already Taken... !! ");
//		}
//		if (user.getEmail() == null|| user.getPassword() == null || user.getUsername() == null /*|| user.getName() == null*/) {
//			throw new UserException("All Fields Are requires");
//		}
//		User newUser =new User();
//		newUser.setPassword(user.getPassword());
//		newUser.setUsername(user.getUsername());
////		newUser.setName(user.getName());
//		return userRepository.save(newUser);
//	}
//
//	@Override
//	public User findUserByIdUser(Integer userId) throws UserException {
//		Optional<User> opt = userRepository.findById(userId);
//		if (opt.isPresent()) {
//			return opt.get();
//		}
//		throw new UserException("User not Exist with id" +userId);
//	}
//
//	@Override
//	public User findUSerProfile(String token) throws UserException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public User findUserByName(String userName) throws UserException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String followUser(Integer reqUserId, Integer followUserId) throws UserException {
//		User reqUser = findUserByIdUser(reqUserId);
//		User followUser = findUserByIdUser(followUserId);
//		
//		UserDto follower = new UserDto();
//		follower.setEmail(reqUser.getEmail());
//		follower.setId(reqUser.getId());
////		follower.setName(reqUser.getName());
//		follower.setUserImage(reqUser.getUserImage());
//		follower.setUsername(reqUser.getUsername());
//		
//		UserDto following = new UserDto();
//		following.setEmail(reqUser.getEmail());
//		following.setId(reqUser.getId());
////		following.setName(reqUser.getName());
//		following.setUserImage(reqUser.getUserImage());
//		following.setUsername(reqUser.getUsername());
//		
//		reqUser.getFollwing().add(following);
//		followUser.getFollower().add(follower);
//		
//		userRepository.save(followUser);
//		userRepository.save(reqUser);
//		
//		return "yOU ARE FOLLOwing "+followUser.getUsername();
//	}
//
//	@Override
//	public String unFollowUser(Integer reqUserId, Integer followUserId) throws UserException {
//		User reqUser = findUserByIdUser(reqUserId);
//		User followUser = findUserByIdUser(followUserId);
//		
//		UserDto follower = new UserDto();
//		follower.setEmail(reqUser.getEmail());
//		follower.setId(reqUser.getId());
////		follower.setName(reqUser.getName());
//		follower.setUserImage(reqUser.getUserImage());
//		follower.setUsername(reqUser.getUsername());
//		
//		UserDto following = new UserDto();
//		following.setEmail(reqUser.getEmail());
//		following.setId(reqUser.getId());
////		following.setName(reqUser.getName());
//		following.setUserImage(reqUser.getUserImage());
//		following.setUsername(reqUser.getUsername());
//		
//		reqUser.getFollwing().remove(following);
//		followUser.getFollower().remove(follower);
//		
//		userRepository.save(followUser);
//		userRepository.save(reqUser);
//		
//		return "You have Unfollowed " +followUser.getUsername();
//	}
//
//	@Override
//	public List<User> findUserByIds(List<Integer> userIds) throws UserException {
//		
//		List<User> users = userRepository.findAllUsersByUserIds(userIds);
//		
//		return users;
//	}
//
//	@Override
//	public List<User> searchUser(String query) throws UserException {
//		
//		List<User> users = userRepository.findByQuery(query);
//		if (users.size() == 0) {
//			throw new UserException("USer not Found");
//		}
//		return users;
//	}
//
//	@Override
//	public User updateUserDeatails(User updatedUser, User existingUser) throws UserException {
//		if (updatedUser.getEmail() != null) {
//			existingUser.setEmail(updatedUser.getEmail());
//		}
//	
//		return null;
//	}

}
