package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payload.ProductDto;
import com.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ ")
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("/")
	public ResponseEntity<ProductDto> createUser(@Valid @RequestBody ProductDto productDto) {
		ProductDto createProductDto = this.productService.createProduct(productDto);
		return new ResponseEntity<>(createProductDto, HttpStatus.CREATED);
	}
	
}
