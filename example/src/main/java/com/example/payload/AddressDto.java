package com.example.payload;

public record AddressDto(
	    String id,
	    String street,
	    String city,
	    String state,
	    String zipCode
	) {
	}