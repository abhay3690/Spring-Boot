package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.payload.ApiResponse;
import com.payload.ProductDto;
import com.service.ProductService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping("/")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        try {
            logger.info("Creating product...");
            ProductDto createdProductDto = this.productService.createProduct(productDto);
            logger.info("Product created successfully with ID: {}", createdProductDto.getPid());
            return new ResponseEntity<>(createdProductDto, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error occurred while creating product", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable("productId") int productId) {
        try {
            logger.info("Updating product with ID: {}", productId);
            ProductDto updatedProduct = this.productService.updateProduct(productDto, productId);
            logger.info("Product updated successfully with ID: {}", productId);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            logger.error("Error occurred while updating product with ID: {}", productId, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable int productId) {
        try {
            logger.info("Deleting product with ID: {}", productId);
            this.productService.deleteProduct(productId);
            logger.info("Product deleted successfully with ID: {}", productId);
            return new ResponseEntity<>(new ApiResponse("Product Deleted Successfully", true), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while deleting product with ID: {}", productId, e);
            return new ResponseEntity<>(new ApiResponse("Failed to delete product", false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getSingleProduct(@PathVariable int productId) {
        try {
            logger.info("Fetching product with ID: {}", productId);
            ProductDto productDto = this.productService.getProductById(productId);
            logger.info("Fetched product with ID: {}", productId);
            return ResponseEntity.ok(productDto);
        } catch (Exception e) {
            logger.error("Error occurred while fetching product with ID: {}", productId, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        try {
            logger.info("Fetching all products");
            List<ProductDto> allProducts = this.productService.allProduct();
            logger.info("Fetched {} products", allProducts.size());
            return ResponseEntity.ok(allProducts);
        } catch (Exception e) {
            logger.error("Error occurred while fetching all products", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
