package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.load.ApiResponse;
import com.load.SellerDto;
import com.service.SellerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

	@Autowired
	private SellerService sellerService;

	private static final Logger logger = LoggerFactory.getLogger(SellerController.class);

	@PostMapping
	public ResponseEntity<?> createSeller(@Valid @RequestBody SellerDto sellerDTO) {
		logger.info("Creating a new seller");
		SellerDto createdSeller = sellerService.createSeller(sellerDTO);
		logger.info("Seller created successfully with ID: {}", createdSeller.getId());
		return new ResponseEntity<>(createdSeller, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<SellerDto>> getAllSellers() {
		logger.info("Fetching all sellers");
		List<SellerDto> sellers = sellerService.getAllSellers();
		logger.info("Fetched all sellers successfully");
		return new ResponseEntity<>(sellers, HttpStatus.OK);
	}

	@GetMapping("/{sellerid}")
	public ResponseEntity<SellerDto> getSellerById(@PathVariable Long sellerid) {
		logger.info("Fetching seller with ID: {}", sellerid);
		SellerDto seller = sellerService.getSellerById(sellerid);
		if (seller != null) {
			logger.info("Seller with ID: {} fetched successfully", sellerid);
			return ResponseEntity.ok(seller);
		} else {
			logger.warn("Seller with ID: {} not found", sellerid);
			return ResponseEntity.notFound().build();
		}
//        return seller != null ? ResponseEntity.ok(seller) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ApiResponse deleteSeller(@PathVariable Long id) {
		logger.info("Deleting seller with ID: {}", id);
		sellerService.deleteSeller(id);
		logger.info("Seller with ID: {} deleted successfully", id);
		return new ApiResponse("Seller Deleted Successfully!!!", true);
	}
}