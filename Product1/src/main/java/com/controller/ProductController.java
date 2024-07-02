package com.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.config.AppConstants;
import com.load.ApiResponse;
import com.load.ProductDto;
import com.repository.ProductResponse;
import com.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/Products")
public class ProductController {

	@Autowired
	private ProductService productService;

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@PostMapping("/{sId}")
	public ResponseEntity<ProductDto> registerProduct(@Valid @RequestBody ProductDto productDto,
			@PathVariable Long sId) {
		try {
			logger.info("Registering product with seller ID: {}", sId);
			ProductDto registerProduct = this.productService.registerProduct(productDto, sId);
			logger.info("Product registered successfully with ID: {}", registerProduct.getPId());
			return new ResponseEntity<>(registerProduct, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error occurred while registering product: {}", e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("/{sId}/product/{pId}")
	public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable Long sId,
			@PathVariable Long pId) {
		try {
			logger.info("Updating product with ID: {} for seller ID: {}", pId, sId);
			ProductDto updateProduct = this.productService.updateProduct(productDto, pId, sId);
			logger.info("Product updated successfully with ID: {}", updateProduct.getPId());
			return new ResponseEntity<>(updateProduct, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occurred while updating product: {}", e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<ProductResponse> getAllProduct(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
//		try {
		logger.info("Fetching all products with pageNumber: {}, pageSize: {}, sortBy: {}, sortDir: {}", pageNumber,
				pageSize, sortBy, sortDir);
		ProductResponse allProduct = this.productService.getAllProduct(pageNumber, pageSize, sortBy, sortDir);
		logger.info("Fetched all products successfully");
		return new ResponseEntity<ProductResponse>(allProduct, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.badRequest().build();
//		}
	}

	@GetMapping("/seller/{sellerId}")
	public ResponseEntity<List<ProductDto>> getAllProductBySellerId(@PathVariable Long sellerId) {
		logger.info("Fetching all products for seller ID: {}", sellerId);
		List<ProductDto> allProductBySId = this.productService.getAllProductBySId(sellerId);
		logger.info("Fetched all products for seller ID: {} successfully", sellerId);
		return new ResponseEntity<List<ProductDto>>(allProductBySId, HttpStatus.OK);
	}

	@GetMapping("/{pId}")
	public ResponseEntity<ProductDto> getProductByProductId(@PathVariable Long pId) {
		logger.info("Fetching product with ID: {}", pId);
		ProductDto productByPId = this.productService.getProductByPId(pId);
		logger.info("Fetched product with ID: {} successfully", pId);
//			return productByPId != null?ResponseEntity.ok(productByPId):ResponseEntity.notFound().build();
		return new ResponseEntity<ProductDto>(productByPId, HttpStatus.OK);
	}

	@DeleteMapping("/{pId}")
	public ApiResponse deleteProduct(@PathVariable Long pId) {
		logger.info("Deleting product with ID: {}", pId);
		this.productService.deleteProduct(pId);
		logger.info("Product with ID: {} deleted successfully", pId);
		return new ApiResponse("Product Deleted Successfully!!!", true);
	}
}