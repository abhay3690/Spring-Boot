package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payload.SellerDto;
import com.payload.SellerResponse;
import com.payload.ServiceResponse;


@Service
public interface SellerService {

	SellerDto createSeller(SellerDto sellerDto,int productId);
	
	// update
	SellerDto updateSeller(SellerDto sellerDto,int sellerId);
	
	// delete
	void deleteSeller(int sellerId);
	
	// get single Seller
	SellerDto getSellerById(int sellerId);
	
	//get all
	SellerResponse getAllSeller(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	// get All posts By User
	List<SellerDto> getSellersByProduct(int productId);
	
	// search posts
	List<SellerDto> searchSellers(String keyword);	

}
