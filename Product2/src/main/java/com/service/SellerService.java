package com.service;

import java.util.List;

import com.payload.SellerDto;
import com.payload.SellerResponse;

public interface SellerService {
    // Create a new seller associated with a product
    SellerDto createSeller(SellerDto sellerDto, int productId);

    // Update an existing seller
    SellerDto updateSeller(SellerDto sellerDto, int sellerId);

    // Delete a seller by ID
    void deleteSeller(int sellerId);

    // Get a single seller by ID
    SellerDto getSellerById(int sellerId);

    // Get all sellers with pagination and sorting
    SellerResponse getAllSellers(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    // Get all sellers associated with a product
    List<SellerDto> getSellersByProduct(int productId);

    // Search for sellers by keyword
    List<SellerDto> searchSellers(String keyword);

    // Register a new seller
    SellerDto registerNewSeller(SellerDto sellerDto);
}
