package com.payload;

import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SellerDto {
	
	private int id;

	private String name;

	private String email;

	private Long phonenumber;

	private String address;
	
	
	@NotEmpty
	private String password;
	
	private ProductDto product;
	
}
