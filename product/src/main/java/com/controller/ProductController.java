package com.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payload.ApiResponse;
import com.payload.ProductDto;
import com.repository.ProductRepo;
import com.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepo productRepo;
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@PostMapping("/")
	public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
		try {
			ProductDto createProductDto = this.productService.createProduct(productDto);
			logger.info("Product add: {}", productDto);
			return new ResponseEntity<>(createProductDto, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error occurred while creating product: {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getAllProduct() {
	    try {
	        List<ProductDto> allProduct = this.productService.allProduct();
	        logger.info("Product getAllProduct");
	        return ResponseEntity.ok(allProduct);
	    } catch (Exception e) {
	        logger.error("Error occurred while fetching all products: {}", e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	@GetMapping("/{productId}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable int productId) {
	    try {
	        logger.info("get Single User Handler : UserController ");
	        ProductDto product = productService.getProductById(productId);
	        return ResponseEntity.ok(product);
	    } catch (NoSuchElementException e) {
	        logger.error("Product with ID {} not found", productId);
	        return ResponseEntity.notFound().build();
	    } catch (Exception e) {
	        logger.error("Error occurred while fetching product with ID {}: {}", productId, e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable int productId) {
	    try {
	        this.productService.deleteProduct(productId);
	        logger.info("Product find: productId={}", productId);
	        return new ResponseEntity<>(new ApiResponse("Product Deleted Successfully", true), HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        logger.error("Product with ID {} not found", productId);
	        return ResponseEntity.notFound().build();
	    } catch (Exception e) {
	        logger.error("Error occurred while deleting product with ID {}: {}", productId, e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	@PutMapping("/{productId}")
	public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto,
	        @PathVariable("productId") int productId) {
	    try {
	        ProductDto updateUser = this.productService.updateProduct(productDto, productId);
	        logger.info("Product update: {}", productDto);
	        return ResponseEntity.ok(updateUser);
	    } catch (NoSuchElementException e) {
	        logger.error("Product with ID {} not found", productId);
	        return ResponseEntity.notFound().build();
	    } catch (Exception e) {
	        logger.error("Error occurred while updating product with ID {}: {}", productId, e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
}











