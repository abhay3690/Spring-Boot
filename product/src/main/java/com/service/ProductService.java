package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payload.ProductDto;

@Service
public interface ProductService {
	ProductDto registerNewProduct(ProductDto productDto);
	ProductDto createProduct(ProductDto productDto);
	ProductDto updateProduct(ProductDto productDto,Integer productId);
	ProductDto getProductById(Integer productId);
	List<ProductDto> allProduct();
	void deleteProduct(Integer productId);
}
