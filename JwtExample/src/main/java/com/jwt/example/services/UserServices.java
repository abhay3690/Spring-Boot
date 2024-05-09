package com.jwt.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.example.models.User;

@Service
public class UserServices {
	private List<User> store = new ArrayList<>();

	public UserServices() {
		store.add(new User(UUID.randomUUID().toString(),"Abhay","aabc@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Gaurang","gabc@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Parth","pabc@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Namam","nabc@gmail.com"));
	}	
	public List<User> getUsers(){
		return this.store;
	}
}
