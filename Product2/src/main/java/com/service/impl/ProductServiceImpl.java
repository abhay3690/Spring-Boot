package com.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
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
    public ProductDto registerNewProduct(ProductDto productDto) {
        Product product = dtoToProduct(productDto);
        Product savedProduct = productRepo.save(product);
        return productToDto(savedProduct);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = dtoToProduct(productDto);
        Product savedProduct = productRepo.save(product);
        return productToDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));

        product.setPrice(productDto.getPtitle());
        product.setPimage(productDto.getPimage());
        product.setPrice(productDto.getPrice());
        product.setPdiscription(productDto.getPdescription());

        Product updatedProduct = productRepo.save(product);
        return productToDto(updatedProduct);
    }

    @Override
    public ProductDto getProductById(Integer productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));
        return productToDto(product);
    }

    @Override
    public List<ProductDto> allProduct() {
        List<Product> products = productRepo.findAll();
        return products.stream()
                .map(this::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Integer productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));
        productRepo.delete(product);
    }

    private Product dtoToProduct(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

    private ProductDto productToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
}
