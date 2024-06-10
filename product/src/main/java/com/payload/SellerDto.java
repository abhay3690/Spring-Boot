package com.payload;


import lombok.Data;

import lombok.NoArgsConstructor;


//@Getter
//@Setter
//@NoArgsConstructor
@Data
@NoArgsConstructor
public class SellerDto {
	
	private int id;

	private String name;


	private String email;


	private Long phonenumber;


	private String address;

	private String password;

	private ProductDto product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public SellerDto(int id, String name, String email, Long phonenumber, String address, String password,
			ProductDto product) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.password = password;
		this.product = product;
	}

	


	
	
}
