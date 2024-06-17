package com.portf.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Name cannot be empty")
	@Size(min = 2, message = "Name must be requires 2 charecter")
	private String name;

	@NotEmpty(message = "Email cannot be empty")
	@Email
	private String email;

	@NotEmpty(message = "Message cannot be empty")
	@Size(max = 1000, message = "Message must be less than 1000 characters")
	private String message;
}
