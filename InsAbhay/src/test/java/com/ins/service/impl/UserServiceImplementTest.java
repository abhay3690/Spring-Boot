package com.ins.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ins.modal.User;
import com.ins.service.UserServices;



public class UserServiceImplementTest {
	@Mock
	private UserServices userRepository;

	@InjectMocks
	private UserServiceImplement userService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveUser() {
		User user = new User();
		user.setId("1");
		user.setName("Abhay");
		user.setAddress("Ganesh gold");

		// Mocking userRepository.save() method
		when(userRepository.saveUser(any(User.class))).thenReturn(user);

		// Call the method to be tested
		User savedUser = userService.saveUser(user);

		// Verify that userRepository.save() was called once
		verify(userRepository, times(1)).saveUser(savedUser);

		// Assert that the returned user is not null
		assertNotNull(savedUser);
		// Assert that the returned user has an ID generated
		assertNotNull(savedUser.getId());
		// Assert that the returned user's name and email match the input
		assertEquals("1", savedUser.getId());
		assertEquals("Abhay", savedUser.getName());
	}

	@Test
	public void testGetAllUser() {
		List<User> userList = new ArrayList<>();
		userList.add(new User());
		userList.add(new User());
		userList.add(new User());

		// Mocking userRepository.findAll() method
		when(userRepository.getAllUser()).thenReturn(userList);

		// Call the method to be tested
		List<User> retrievedUsers = userService.getAllUser();

		// Verify that userRepository.findAll() was called once
		verify(userRepository, times(1)).getAllUser();

		// Assert that the list of retrieved users is not null
		assertNotNull(retrievedUsers);
		// Assert that the size of the retrieved users list matches the size of the
		// original list
		assertEquals(userList.size(), retrievedUsers.size());
	}

	@Test
	public void testGetUser() {
		
		User user = new User();
		user.setId("1");
		user.setName("Abhay");
		user.setAddress("Ganesh gold");



		// Call the method to be tested
		User retrievedUser = userService.getUser("1");

		// Verify that userRepository.findById() was called once with the specified ID
		verify(userRepository, times(1)).getUser("1");

		// Assert that the retrieved user is not null
		assertNotNull(retrievedUser);
		// Assert that the retrieved user's ID, name, and email match the input user
		assertEquals("1", retrievedUser.getId());
		assertEquals("Abhay", retrievedUser.getName());
		assertEquals("Ganesh gold", retrievedUser.getAddress());
	}
	
}
