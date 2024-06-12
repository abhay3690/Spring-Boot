package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.load.SellerDto;

@Service
public interface SellerService {

	SellerDto createSeller(SellerDto sellerDTO);

	List<SellerDto> getAllSellers();

	SellerDto getSellerById(Long id);

	void deleteSeller(Long id);
	
	SellerDto registerNewSeller(SellerDto sellerDto);

}
