package com.user.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int userId;
	private String name;
	private Long phone;
	List<Contact> contacts = new ArrayList<>();

	
	

	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Long getPhone() {
		return phone;
	}




	public void setPhone(Long phone) {
		this.phone = phone;
	}




	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	




	public User(int userId, String name, Long phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
	}




	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phone=" + phone + "]";
	}

	

	
	

}
