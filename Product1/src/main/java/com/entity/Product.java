package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

	private Long sId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long pId;

	@Column(name = "product_name")
	private String pName;

	@Column(name = "product_image")
	private String pImage;

	@Column(name = "product_price")
	private Long pPrice;

	@Column(name = "product_category")
	private String pCategory;

	@Column(name = "product_description")
	private String pDescription;

	@ManyToOne
	@JoinColumn(name = "products")
	private Seller seller;
}