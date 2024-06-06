package com.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Seller {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name" ,length = 20)
	private String name;
	
	@Column(name = "phonenumber" ,length = 10)
	private Long phonenumber;
	
	@Column(name = "address" ,length = 100)
	private String address;
	
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
}