package com.load;

import com.entity.Seller;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	private Long sId;

	private Long pId;

	@NotEmpty
	@Size(min = 3, message = "name must be 3 character")
	private String pName;

	private String pImage;

	private Long pPrice;

	@NotEmpty
	@Size(min = 3, message = "category must be 3 character")
	private String pCategory;

	private String pDescription;
	
	@JsonIgnore
	private Seller seller;

	

}