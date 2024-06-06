package com.controller;

import java.util.List;

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
import com.service.ProductService;

import jakarta.validation.Valid;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            ProductDto createProductDto = this.productService.createProduct(productDto);
            logger.info("Product created successfully with ID: {}", createProductDto.getPid());
            System.out.println("This is checking : jhsdfokhsfhahfoshtio");
            return new ResponseEntity<>(createProductDto, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error occurred while creating product", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable("productId") int productId) {
        try {
            logger.info("Updating product with ID: {}", productId);
            ProductDto updateProduct = this.productService.updateProduct(productDto, productId);
            System.out.println("This is checking : jhsdfokhsfhahfoshtio");
            logger.info("Product updated successfully with ID: {}", productId);
            return ResponseEntity.ok(updateProduct);
        } catch (Exception e) {
            logger.error("Error occurred while updating product with ID: {}", productId, e);
            System.out.println("This is checking : jhsdfokhsfhahfoshtio");
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
            ProductDto productById = this.productService.getProductById(productId);
            logger.info("Fetched product with ID: {}", productId);
            return ResponseEntity.ok(productById);
        } catch (Exception e) {
            logger.error("Error occurred while fetching product with ID: {}", productId, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        try {
            logger.info("Fetching all products");
            List<ProductDto> allProduct = this.productService.allProduct();
            logger.info("Fetched {} products", allProduct.size());
            return ResponseEntity.ok(allProduct);
        } catch (Exception e) {
            logger.error("Error occurred while fetching all products", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
































//
//@RestController
//@RequestMapping("/api/products")
////@CrossOrigin(origins = "http://localhost:3000")
//public class ProductController {
//
//	@Autowired
//	private ProductService productService;
//
//	// Post- create product
//	@PostMapping("/")
//	public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
//		ProductDto createProductDto = this.productService.createProduct(productDto);
//		return new ResponseEntity<>(createProductDto, HttpStatus.CREATED);
//	}
//
//	// Put- Update Product
//	@PutMapping("/productId}")
//	public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable("productId") int productId) {
//		ProductDto updateProduct = this.productService.updateProduct(productDto, productId);
//		return ResponseEntity.ok(updateProduct);
//	}
//	//Admin
//	// Delete Product
////	@PreAuthorize("hasRole('ADMIN')")
//	@DeleteMapping("{productId}")
//	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable int productId) {
//		this.productService.deleteProduct(productId);
//		return new ResponseEntity<>(new ApiResponse("Product Deleted Successfully", true), HttpStatus.OK);
//	}
//
//	// Get User
//	@GetMapping("{productId}")
//	public ResponseEntity<ProductDto> getSingleProduct(@PathVariable int productId) {
//		ProductDto productById = this.productService.getProductById(productId);
//		return ResponseEntity.ok(productById);
//	}
//
//	@GetMapping("/")
//	public ResponseEntity<List<ProductDto>> getAllProduct() {
//		List<ProductDto> allProduct = this.productService.allProduct();
//		return ResponseEntity.ok(allProduct);
//	}
//}
































//import java.util.List;
//import java.util.NoSuchElementException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.payload.ApiResponse;
//import com.payload.ProductDto;
//import com.repository.ProductRepo;
//import com.service.ProductService;
//
//import jakarta.validation.Valid;

//@RestController
//@RequestMapping("/product")
//public class ProductController {
//	@Autowired
//	private ProductService productService;
//	@Autowired
//	private ProductRepo productRepo;
//	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
//
//	@PostMapping("/")
//	public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
//		try {
//			ProductDto createProductDto = this.productService.createProduct(productDto);
//			logger.info("Product add: {}", productDto);
//			return new ResponseEntity<>(createProductDto, HttpStatus.CREATED);
//		} catch (Exception e) {
//			logger.error("Error occurred while creating product: {}", e.getMessage());
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@GetMapping("/")
//	public ResponseEntity<List<ProductDto>> getAllProduct() {
//	    try {
//	        List<ProductDto> allProduct = this.productService.allProduct();
//	        logger.info("Product getAllProduct");
//	        return ResponseEntity.ok(allProduct);
//	    } catch (Exception e) {
//	        logger.error("Error occurred while fetching all products: {}", e.getMessage());
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	    }
//	}
//
//	@GetMapping("/{productId}")
//	public ResponseEntity<ProductDto> getProductById(@PathVariable int productId) {
//	    try {
//	        logger.info("get Single User Handler : UserController ");
//	        ProductDto product = productService.getProductById(productId);
//	        return ResponseEntity.ok(product);
//	    } catch (NoSuchElementException e) {
//	        logger.error("Product with ID {} not found", productId);
//	        return ResponseEntity.notFound().build();
//	    } catch (Exception e) {
//	        logger.error("Error occurred while fetching product with ID {}: {}", productId, e.getMessage());
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	    }
//	}
//
//	@DeleteMapping("/{productId}")
//	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable int productId) {
//	    try {
//	        this.productService.deleteProduct(productId);
//	        logger.info("Product find: productId={}", productId);
//	        return new ResponseEntity<>(new ApiResponse("Product Deleted Successfully", true), HttpStatus.OK);
//	    } catch (NoSuchElementException e) {
//	        logger.error("Product with ID {} not found", productId);
//	        return ResponseEntity.notFound().build();
//	    } catch (Exception e) {
//	        logger.error("Error occurred while deleting product with ID {}: {}", productId, e.getMessage());
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	    }
//	}
//
//	@PutMapping("/{productId}")
//	public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto,
//	        @PathVariable("productId") int productId) {
//	    try {
//	        ProductDto updateUser = this.productService.updateProduct(productDto, productId);
//	        logger.info("Product update: {}", productDto);
//	        return ResponseEntity.ok(updateUser);
//	    } catch (NoSuchElementException e) {
//	        logger.error("Product with ID {} not found", productId);
//	        return ResponseEntity.notFound().build();
//	    } catch (Exception e) {
//	        logger.error("Error occurred while updating product with ID {}: {}", productId, e.getMessage());
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//	    }
//	}
//}











