package com.payload;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
	
	private int pid;
	
	private String ptitle;

	private String price;

	private String pimage;

	private String pdiscription;
	@JsonIgnore
	private SellerDto seller;
	
}

