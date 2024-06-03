package com.payload;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProductDto {
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "name" ,length = 20)
	private String title;
	@Column(name = "price" ,length = 20)
	private String price;
	@Column(name = "image" ,length = 20)
	private String image;
	@Column(name = "discription" ,length = 100)
	private String discription;
}
