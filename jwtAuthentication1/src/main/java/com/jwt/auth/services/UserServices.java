package com.jwt.auth.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.jwt.auth.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
	private List<User> store = new ArrayList<>();

	public UserServices() {
		store.add(new User(UUID.randomUUID().toString(), "AbhaySuthar", "abhaysuthar@3690.com"));
		store.add(new User(UUID.randomUUID().toString(), "Gauri dale", "abhaysuthar@3690.com"));
		store.add(new User(UUID.randomUUID().toString(), "gurang Dalawadi", "abhaysuthar@3690.com"));
	}
	public List<User> getUsers(){
		return this.store;
	}
}
