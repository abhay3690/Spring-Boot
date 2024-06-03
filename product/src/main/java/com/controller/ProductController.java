package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payload.ProductDto;
import com.service.ProductService;

import jakarta.validation.Valid;
import net.abhay.payloads.UserDto;

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
	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getAllUser() {
		List<ProductDto> allUser = this.productService.allProduct();
		return ResponseEntity.ok(allProduct);
	}
}
