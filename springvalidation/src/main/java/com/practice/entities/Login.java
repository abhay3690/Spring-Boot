package com.practice.entities;

public class Login {
	private String userName;
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", email=" + email + "]";
	}

	public Login(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
	}
}
