package com.service.impl;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modal.Product;
import com.payload.ProductDto;
import com.repository.ProductRepo;
import com.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public ProductDto createProduct(ProductDto productDto) {
		Product product = this.modelMapper.map(productDto, Product.class);
		Product save = this.productRepo.save(product);
		return this.modelMapper.map(save, ProductDto.class);
	}
	

	@Override
	public ProductDto updateProduct(ProductDto product, Integer productId) {
		
		return null;
	}

	@Override
	public ProductDto getProductById(Integer productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> allProduct() {
		
		return null;
	}

	@Override
	public void deleteProduct(Integer productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProductDto registerNewProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
