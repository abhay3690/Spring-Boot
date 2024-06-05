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
		Product product = this.dtoToProduct(productDto);
		Product savedProduct = this.productRepo.save(product);
		return this.productToDto(savedProduct);
	}

	@Override
	public ProductDto createProduct(ProductDto productDto) {

		Product product = this.dtoToProduct(productDto);
		Product savedUser = this.productRepo.save(product);
		return this.productToDto(savedUser);
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, Integer productId) {
		Product product = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", " Id ", productId));
		product.setPid(productDto.getPid());
		product.setPtitle(productDto.getPtitle());
		product.setPimage(productDto.getPimage());
		product.setPrice(productDto.getPrice());
		product.setPdiscription(productDto.getPdiscription());
		Product updateProduct = this.productRepo.save(product);
		ProductDto producttoDto = this.productToDto(updateProduct);
		return producttoDto;
	}

	@Override
	public ProductDto getProductById(Integer productId) {
		Product product = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", " Id ", productId));

		return this.productToDto(product);
	}

	@Override
	public List<ProductDto> allProduct() {
		List<Product> products = this.productRepo.findAll();
		List<ProductDto> list = products.stream().map(user -> this.productToDto(user)).collect(Collectors.toList());
		return list;
	}

	@Override
	public void deleteProduct(Integer productId) {
		Product product = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", " Id ", productId));
		this.productRepo.delete(product);
		
	}

	public Product dtoToProduct(ProductDto productDto) {
		Product product = this.modelMapper.map(productDto, Product.class);

//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return product;
	}
	public ProductDto productToDto(Product product) {
		ProductDto productDto = this.modelMapper.map(product, ProductDto.class);

//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return productDto;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//    @Autowired
//    private ProductRepo productRepo;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Override
//    public ProductDto createProduct(ProductDto productDto) {
//        
//    	Product product = this.modelMapper.map(productDto, Product.class);
//        product.setPid(productDto.getPid());
//        product.setPtitle(productDto.getPtitle());
//        product.setPimage(productDto.getPimage());
//        product.setPdiscription(productDto.getPdiscription());
//        product.setPrice(productDto.getPrice());
////        product.setSeller(productDto.getSeller());
//        Product savedProduct = productRepo.save(product);
//        return modelMapper.map(savedProduct, ProductDto.class);
//    }
//
//    @Override
//    public ProductDto updateProduct(ProductDto productDto, Integer productId) {
//        Product product = this.productRepo.findById(productId)
//                                             .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));
//
//        // Update existing product with new data
//        product.setPtitle(productDto.getPtitle());
//        product.setPdiscription(productDto.getPdiscription());
//        // You can update other fields similarly
//
//        // Save the updated product
//        Product updatedProduct = productRepo.save(product);
//        return modelMapper.map(updatedProduct, ProductDto.class);
//    }
//
//    @Override
//    public ProductDto getProductById(Integer productId) {
//        Product product = productRepo.findById(productId)
//                                    .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));
//        return modelMapper.map(product, ProductDto.class);
//    }
//
//    @Override
//    public List<ProductDto> allProduct() {
//        List<Product> products = productRepo.findAll();
//        return products.stream()
//                       .map(product -> modelMapper.map(product, ProductDto.class))
//                       .collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteProduct(Integer productId) {
//        productRepo.deleteById(productId);
//    }
//
//    @Override
//    public ProductDto registerNewProduct(ProductDto productDto) {
//        // Implement registration logic here, if needed
//        return createProduct(productDto);
//    }
}
