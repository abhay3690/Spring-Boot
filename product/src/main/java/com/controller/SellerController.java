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

import com.config.AppConstatns;
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
    public ResponseEntity<SellerDto> createPost(@RequestBody SellerDto sellerDto, @PathVariable int productId) {
        try {
            logger.info("Creating seller for product with ID: {}", productId);
            SellerDto createSeller = this.sellerService.createSeller(sellerDto, productId);
            logger.info("Seller created successfully with ID: {}", createSeller.getId());
            return new ResponseEntity<>(createSeller, HttpStatus.CREATED);
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
	public ResponseEntity<SellerResponse> getAllSeller(
			@RequestParam(value = "pageNumber",defaultValue = AppConstatns.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = AppConstatns.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = AppConstatns.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir",defaultValue = AppConstatns.SORT_DIR, required = false) String sortDir) {
		SellerResponse sellerResponse = this.sellerService.getAllSeller(pageNumber, pageSize, sortBy, sortDir);
//		SellerResponse sellerResponse = this.sellerService.getAllSeller(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<SellerResponse>(sellerResponse, HttpStatus.OK);
	}

    @GetMapping("/sellers/{sellerId}")
    public ResponseEntity<SellerDto> SellerById(@PathVariable Integer sellerId) {
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
            SellerDto updateSeller = this.sellerService.updateSeller(sellerDto, sellerId);
            logger.info("Updated seller with ID: {}", sellerId);
            return new ResponseEntity<>(updateSeller, HttpStatus.OK);
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
    public ResponseEntity<List<SellerDto>> searchSellerByTitle(@PathVariable("keywords") String keywords) {
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
































//@RestController
//
//@RequestMapping("/api/")
//
//public class SellerController {
//
//	@Autowired
//	private SellerService sellerService;
//	@Autowired
//	private String path;
//	private static final Logger logger = LoggerFactory.getLogger(SellerController.class);
//
//	// create
//	@PostMapping("/products/{productId}/sellers")
//	public ResponseEntity<SellerDto> createPost(@RequestBody SellerDto sellerDto, @PathVariable int productId) {
//		SellerDto createSeller = this.sellerService.createSeller(sellerDto, productId);
//		return new ResponseEntity<SellerDto>(createSeller, HttpStatus.CREATED);
//
//	}
//
//	// get by product
//	@GetMapping("/product/{productId}/sellers")
//	public ResponseEntity<List<SellerDto>> getSellersByProduct(@PathVariable Integer productId) {
//		List<SellerDto> sellers = this.sellerService.getSellersByProduct(productId);
//		return new ResponseEntity<List<SellerDto>>(sellers, HttpStatus.OK);
//	}
//
//	// get all sellers
//
//	@GetMapping("/sellers")
//	public ResponseEntity<SellerResponse> getAllSeller(
//			@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
//			@RequestParam(value = "pageSize", required = false) Integer pageSize,
//			@RequestParam(value = "sortBy", required = false) String sortBy,
//			@RequestParam(value = "sortDir", required = false) String sortDir) {
//		SellerResponse sellerResponse = this.sellerService.getAllSeller(pageNumber, pageSize, sortBy, sortDir);
////		SellerResponse sellerResponse = this.sellerService.getAllSeller(pageNumber, pageSize, sortBy, sortDir);
//		return new ResponseEntity<SellerResponse>(sellerResponse, HttpStatus.OK);
//	}
//
//	// get seller by id
//	@GetMapping("/sellers/{sellerId}")
//
//	public ResponseEntity<SellerDto> SellerById(@PathVariable Integer sellerId) {
//		SellerDto sellerDto = this.sellerService.getSellerById(sellerId);
//		return new ResponseEntity<SellerDto>(sellerDto, HttpStatus.OK);
//	}
//
//	// update
//	@PutMapping("/sellers/{sellerId}")
//	public ResponseEntity<SellerDto> updateSeller(@RequestBody SellerDto sellerDto, @PathVariable Integer sellerId) {
//		SellerDto updateSeller = this.sellerService.updateSeller(sellerDto, sellerId);
//		return new ResponseEntity<SellerDto>(updateSeller, HttpStatus.OK);
//	}
//
//	// delete
//	@DeleteMapping("/sellers/{sellerId}")
//	public ApiResponse deleteSeller(@PathVariable Integer sellerId) {
//		this.sellerService.deleteSeller(sellerId);
//		return new ApiResponse("Post is sucessfully Deleted", true);
//	}
//
//	// search
//	@GetMapping("/sellers/search/{keywords}")
//	public ResponseEntity<List<SellerDto>> searchSellerByTitle(@PathVariable("keywords") String keywords) {
//		List<SellerDto> result = this.sellerService.searchSellers(keywords);
//		return new ResponseEntity<List<SellerDto>>(result, HttpStatus.OK);
//
//	}
//}

//
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
//import com.payload.SellerDto;
//import com.service.SellerService;
//
//
//@RestController
//@RequestMapping("/seller")
//public class SellerController {
//	@Autowired
//	private SellerService sellerService;
//	@PostMapping("/product/{productId}/sellers")
//	public ResponseEntity<SellerDto> createSeller(@RequestBody SellerDto sellerDto, @PathVariable int productId) {
//		SellerDto createSeller = this.sellerService.createSeller(sellerDto, productId);
//		return new ResponseEntity<SellerDto>(createSeller, HttpStatus.CREATED);
//
//	}
//	@PutMapping("/sellers/{sellerId}")
//	public ResponseEntity<SellerDto> updateSeller(@RequestBody SellerDto sellerDto,@PathVariable Integer sellerId){
//		SellerDto update = this.sellerService.updateSeller(sellerDto, sellerId);
//		return new ResponseEntity<SellerDto>(update,HttpStatus.OK);
//	}
//	@DeleteMapping("/sellers/{sellerId}")
//	public ApiResponse deleteSeller(@PathVariable Integer sellerId) {
//		this.sellerService.deleteSeller(sellerId);
//		return new ApiResponse("Post is sucessfully Deleted", true);
//	}
//	@GetMapping("/{sellerId}")
//	public ResponseEntity<SellerDto> getSellerById(@PathVariable int sellerId){
//		SellerDto sellerid = sellerService.getSellerById(sellerId);
//		return ResponseEntity.ok(sellerid);
//	}
//	
//}