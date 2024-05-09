package com.practice.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {

	@NotBlank(message = "Name is required")
	@Size(min =3,max=12,message ="USer in 3 to 12 charecter")
	private String name;

	@Email(message = "Email should be valid")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}

	public User(@NotBlank(message = "Name is required") String name,
			@Email(message = "Email should be valid") String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
