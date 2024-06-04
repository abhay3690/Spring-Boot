package com.payload;

public class SellerDto {
	private int id;
	private String name;
	private Long phonenumber;
	private String address;
	private ProductDto seller;

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

	public ProductDto getSeller() {
		return seller;
	}

	public void setSeller(ProductDto seller) {
		this.seller = seller;
	}
}
