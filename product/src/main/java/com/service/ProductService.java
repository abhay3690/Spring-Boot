package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payload.ProductDto;

@Service
public interface ProductService {
	// register
	ProductDto registerNewProduct(ProductDto productDto);

	// create
	ProductDto createProduct(ProductDto productDto);

	// update
	ProductDto updateProduct(ProductDto productDto, Integer productId);

	// get product by Id
	ProductDto getProductById(Integer productId);

	// All product
	List<ProductDto> allProduct();

	// Dellete Product
	void deleteProduct(Integer productId);
}
