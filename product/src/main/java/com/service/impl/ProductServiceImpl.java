package com.service.impl;


import java.util.List;
import java.util.stream.Collectors;

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
        product.setPid(productDto.getPid());
        product.setPtitle(productDto.getPtitle());
        product.setPimage(productDto.getPimage());
        product.setPdiscription(productDto.getPdiscription());
        product.setPrice(productDto.getPrice());
        product.setSeller(productDto.getSeller());
        Product savedProduct = productRepo.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer productId) {
        Product product = this.productRepo.findById(productId)
                                             .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));

        // Update existing product with new data
        product.setPtitle(productDto.getPtitle());
        product.setPdiscription(productDto.getPdiscription());
        // You can update other fields similarly

        // Save the updated product
        Product updatedProduct = productRepo.save(product);
        return modelMapper.map(updatedProduct, ProductDto.class);
    }

    @Override
    public ProductDto getProductById(Integer productId) {
        Product product = productRepo.findById(productId)
                                    .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public List<ProductDto> allProduct() {
        List<Product> products = productRepo.findAll();
        return products.stream()
                       .map(product -> modelMapper.map(product, ProductDto.class))
                       .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public ProductDto registerNewProduct(ProductDto productDto) {
        // Implement registration logic here, if needed
        return createProduct(productDto);
    }
}

