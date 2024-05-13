package net.abhay.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor@Getter@Setter
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min = 3,message = "Username must be min of 3 characters")
	private String name;
	@Email(message = "Please Enter Valid Email !!")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	private String email;
	@NotEmpty
	@Size(min=3,max = 10,message = "Password must be min 3 chars and max 10 chars !!")
	@Pattern(regexp = "^[a-zA-Z0-9@#$%^&+=]{8,}$")
	private String password;
	private String about;
}
