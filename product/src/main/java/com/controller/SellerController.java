package com.controller;

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
import com.payload.SellerDto;
import com.service.SellerService;


@RestController
@RequestMapping("/seller")
public class SellerController {
	@Autowired
	private SellerService sellerService;
	@PostMapping("/product/{productId}/sellers")
	public ResponseEntity<SellerDto> createSeller(@RequestBody SellerDto sellerDto, @PathVariable int productId) {
		SellerDto createSeller = this.sellerService.createSeller(sellerDto, productId);
		return new ResponseEntity<SellerDto>(createSeller, HttpStatus.CREATED);

	}
	@PutMapping("/sellers/{sellerId}")
	public ResponseEntity<SellerDto> updateSeller(@RequestBody SellerDto sellerDto,@PathVariable Integer sellerId){
		SellerDto update = this.sellerService.updateSeller(sellerDto, sellerId);
		return new ResponseEntity<SellerDto>(update,HttpStatus.OK);
	}
	@DeleteMapping("/sellers/{sellerId}")
	public ApiResponse deleteSeller(@PathVariable Integer sellerId) {
		this.sellerService.deleteSeller(sellerId);
		return new ApiResponse("Post is sucessfully Deleted", true);
	}
	@GetMapping("/{sellerId}")
	public ResponseEntity<SellerDto> getSellerById(@PathVariable int sellerId){
		SellerDto sellerid = sellerService.getSellerById(sellerId);
		return ResponseEntity.ok(sellerid);
	}
	
}
