package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.config.AppConstants;
import com.payload.ApiResponse;
import com.payload.SellerDto;
import com.payload.SellerResponse;
import com.service.SellerService;

@RestController
@RequestMapping("/api/")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    private static final Logger logger = LoggerFactory.getLogger(SellerController.class);

    @PostMapping("/products/{productId}/sellers")
    public ResponseEntity<SellerDto> createSeller(@RequestBody SellerDto sellerDto, @PathVariable int productId) {
        try {
            logger.info("Creating seller for product with ID: {}", productId);
            SellerDto createdSeller = this.sellerService.createSeller(sellerDto, productId);
            logger.info("Seller created successfully with ID: {}", createdSeller.getId());
            return new ResponseEntity<>(createdSeller, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error occurred while creating seller for product with ID: {}", productId, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/sellers")
    public ResponseEntity<List<SellerDto>> getSellersByProduct(@PathVariable Integer productId) {
        try {
            logger.info("Fetching sellers for product with ID: {}", productId);
            List<SellerDto> sellers = this.sellerService.getSellersByProduct(productId);
            logger.info("Found {} sellers for product with ID: {}", sellers.size(), productId);
            return new ResponseEntity<>(sellers, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while fetching sellers for product with ID: {}", productId, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sellers")
    public ResponseEntity<SellerResponse> getAllSellers(
            @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
        try {
            logger.info("Fetching all sellers");
            SellerResponse sellerResponse = this.sellerService.getAllSellers(pageNumber, pageSize, sortBy, sortDir);
            logger.info("Fetched {} sellers", sellerResponse.getContent().size());
            return new ResponseEntity<>(sellerResponse, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while fetching all sellers", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sellers/{sellerId}")
    public ResponseEntity<SellerDto> getSellerById(@PathVariable Integer sellerId) {
        try {
            logger.info("Fetching seller with ID: {}", sellerId);
            SellerDto sellerDto = this.sellerService.getSellerById(sellerId);
            logger.info("Fetched seller with ID: {}", sellerId);
            return new ResponseEntity<>(sellerDto, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while fetching seller with ID: {}", sellerId, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/sellers/{sellerId}")
    public ResponseEntity<SellerDto> updateSeller(@RequestBody SellerDto sellerDto, @PathVariable Integer sellerId) {
        try {
            logger.info("Updating seller with ID: {}", sellerId);
            SellerDto updatedSeller = this.sellerService.updateSeller(sellerDto, sellerId);
            logger.info("Updated seller with ID: {}", sellerId);
            return new ResponseEntity<>(updatedSeller, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while updating seller with ID: {}", sellerId, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/sellers/{sellerId}")
    public ApiResponse deleteSeller(@PathVariable Integer sellerId) {
        try {
            logger.info("Deleting seller with ID: {}", sellerId);
            this.sellerService.deleteSeller(sellerId);
            logger.info("Deleted seller with ID: {}", sellerId);
            return new ApiResponse("Seller successfully deleted", true);
        } catch (Exception e) {
            logger.error("Error occurred while deleting seller with ID: {}", sellerId, e);
            return new ApiResponse("Failed to delete seller", false);
        }
    }

    @GetMapping("/sellers/search/{keywords}")
    public ResponseEntity<List<SellerDto>> searchSellersByTitle(@PathVariable("keywords") String keywords) {
        try {
            logger.info("Searching for sellers with keywords: {}", keywords);
            List<SellerDto> result = this.sellerService.searchSellers(keywords);
            logger.info("Found {} sellers matching the search criteria", result.size());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while searching sellers with keywords: {}", keywords, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
