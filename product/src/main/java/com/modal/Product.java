package com.modal;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@Column(name = "name" ,length = 20)
	private String ptitle;
	@Column(name = "price" ,length = 20)
	private String price;
	@Column(name = "image" ,length = 20)
	private String pimage;
	@Column(name = "discription" ,length = 100)
	private String pdiscription;
	
	@ManyToOne
	private Seller seller;
	
}
