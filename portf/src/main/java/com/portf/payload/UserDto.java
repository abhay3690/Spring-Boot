package com.portf.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
	private Long id;

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
