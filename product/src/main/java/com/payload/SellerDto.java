package com.payload;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SellerDto {
	
	private int id;

	private String name;

	private Long phonenumber;

	private String address;
	
	private List<ProductDto> products= new ArrayList<ProductDto>();
}
