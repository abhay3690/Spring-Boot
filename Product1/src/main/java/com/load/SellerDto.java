package com.load;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SellerDto {

	private Long id;

	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message = "Password is required")
	@Size(min = 3, max = 50, message = "Password must be between 3 and 50 characters")
	private String password;

	private List<ProductDto> products;

	public SellerDto(Long id, String name, String email, String password, List<ProductDto> products) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.products = products;
	}

//	public SellerDto(Long id,String name,String email,List<ProductDto> products) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.products = products;
//	}

}
