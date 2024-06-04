package com.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.modal.Product;
import com.modal.Seller;
import com.payload.SellerDto;
import com.repository.ProductRepo;
import com.repository.SellerRepo;
import com.service.SellerService;

import net.abhay.entities.Post;
import net.abhay.payloads.PostDto;


@Service
public class SellerServiceImpl implements SellerService{
	@Autowired
	private SellerRepo sellerRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ProductRepo productRepo;
	@Override
	public SellerDto createSeller(SellerDto sellerDto, int productId) {
			this.productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product","Product id", productId));
			Seller seller = this.modelMapper.map(sellerDto,Seller.class);
			seller.setId(sellerDto.getId());
			seller.setName(sellerDto.getName());
			seller.setPhonenumber(seller.getPhonenumber());
			seller.setAddress(sellerDto.getAddress());
			seller.setProduct(seller.getProduct());
			
			Seller newseller = this.sellerRepo.save(seller);
			return this.modelMapper.map(newseller, SellerDto.class);
	}
	@Override
	public SellerDto updateSeller(SellerDto sellerDto, int sellerId) {
		Seller seller = this.sellerRepo.findById(sellerId)
				.orElseThrow(() -> new ResourceNotFoundException("seller", "seller id", sellerId));
		seller.setId(sellerDto.getId());
		seller.setName(sellerDto.getName());
		seller.setPhonenumber(seller.getPhonenumber());
		seller.setAddress(sellerDto.getAddress());
		seller.setProduct(seller.getProduct());
		Seller updatedPost = this.sellerRepo.save(seller);
		return this.modelMapper.map(updatedPost, SellerDto.class);
	}
	@Override
	public void deleteSeller(int sellerId) {
		Seller seller = this.sellerRepo.findById(sellerId)
				.orElseThrow(() -> new ResourceNotFoundException("seller", "seller id", sellerId));
		this.sellerRepo.delete(seller);
	}
	@Override
	public SellerDto getSellerById(int sellerId) {
		Seller seller = this.sellerRepo.findById(sellerId)
				.orElseThrow(() -> new ResourceNotFoundException("Seller", "seller id", sellerId));
		return this.modelMapper.map(seller, SellerDto.class);
	}
	@Override
	public List<SellerDto> getSellersByProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SellerDto> searchProducts(String keyword) {
		List<Seller> sellers = this.sellerRepo.searchByTitle("%" + keyword + "%");
		List<SellerDto> sellerDtos = sellers.stream().map((seller) -> this.modelMapper.map(seller, SellerDto.class))
				.collect(Collectors.toList());
		return sellerDtos;
	}

}
