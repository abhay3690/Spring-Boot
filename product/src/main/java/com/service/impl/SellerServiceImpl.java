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
import com.payload.SellerResponse;
import com.repository.ProductRepo;
import com.repository.SellerRepo;
import com.service.SellerService;
import org.springframework.data.domain.Sort;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;


@Service
public class SellerServiceImpl implements SellerService{
	@Autowired
	private SellerRepo sellerRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ProductRepo productRepo;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	@Override
	public SellerDto createSeller(SellerDto sellerDto, int productId) {
		Product product = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product ", "Product id", productId));

		
		Seller seller = this.modelMapper.map(sellerDto, Seller.class);
		seller.setId(sellerDto.getId());
		seller.setName(sellerDto.getName());
		seller.setPhonenumber(sellerDto.getPhonenumber());
		seller.setAddress(sellerDto.getAddress());
		seller.setPassword(sellerDto.getPassword());
		seller.setProduct(product);
		
		Seller newSeller = this.sellerRepo.save(seller);

		return this.modelMapper.map(newSeller, SellerDto.class);
	}
	@Override
	public SellerDto updateSeller(SellerDto sellerDto, int sellerId) {
		Seller seller = this.sellerRepo.findById(sellerId)
				.orElseThrow(() -> new ResourceNotFoundException("seller", "seller id", sellerId));
		seller.setId(sellerDto.getId());
		seller.setName(sellerDto.getName());
		seller.setPhonenumber(sellerDto.getPhonenumber());
		seller.setAddress(sellerDto.getAddress());
		seller.setPassword(sellerDto.getPassword());
		Seller updatedSeller = this.sellerRepo.save(seller);
		
		return this.modelMapper.map(updatedSeller, SellerDto.class);
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
	public SellerResponse getAllSeller(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
//		Sort sort =null;
		Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		/*
		  if(sortDir.equalsIgnoreCase("asc")) { sort = Sort.by(sortBy).ascending();
		  }else { sort = Sort.by(sortBy).descending(); }
		 */
		Pageable p = PageRequest.of(pageNumber, pageSize, sort /* Sort.by(sortBy).descending() */);
		Page<Seller> pageSeller = this.sellerRepo.findAll(p);
		List<Seller> allSellers = pageSeller.getContent();
		List<SellerDto> sellerDtos = allSellers.stream().map((seller) -> this.modelMapper.map(seller, SellerDto.class))
				.collect(Collectors.toList());
		SellerResponse sellerResponse = new SellerResponse();
		sellerResponse.setContent(sellerDtos);
		sellerResponse.setPageNumber(pageSeller.getNumber());
		sellerResponse.setPageSize(pageSeller.getSize());
		sellerResponse.setTotalElements(pageSeller.getTotalElements());
		sellerResponse.setTotalPages(pageSeller.getTotalPages());
		sellerResponse.setLastPage(pageSeller.isLast());

		return sellerResponse;
	}
	@Override
	public List<SellerDto> getSellersByProduct(int productId) {
		Product product = this.productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "product Id", productId));

		List<Seller> sellers = this.sellerRepo.findByProduct(product);
		List<SellerDto> sellerDtos = sellers.stream().map(seller -> this.modelMapper.map(seller, SellerDto.class))
				.collect(Collectors.toList());

		return sellerDtos;
	}
	@Override
	public List<SellerDto> searchSellers(String keyword) {
		List<Seller> sellers = this.sellerRepo.searchByTitle("%" + keyword + "%");
		List<SellerDto> sellerDtos = sellers.stream().map((seller) -> this.modelMapper.map(seller, SellerDto.class))
				.collect(Collectors.toList());
		return sellerDtos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//	private SellerRepo sellerRepo;
//	@Autowired
//	private ModelMapper modelMapper;
//	@Autowired
//	private ProductRepo productRepo;
//	@Override
//	public SellerDto createSeller(SellerDto sellerDto, int productId) {
//			this.productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product","Product id", productId));
//			Seller seller = this.modelMapper.map(sellerDto,Seller.class);
//			seller.setId(sellerDto.getId());
//			seller.setName(sellerDto.getName());
//			seller.setPhonenumber(seller.getPhonenumber());
//			seller.setAddress(sellerDto.getAddress());
//			seller.setProducts(seller.getProducts());
//			
//			Seller newseller = this.sellerRepo.save(seller);
//			return this.modelMapper.map(newseller, SellerDto.class);
//	}
//	@Override
//	public SellerDto updateSeller(SellerDto sellerDto, int sellerId) {
//		Seller seller = this.sellerRepo.findById(sellerId)
//				.orElseThrow(() -> new ResourceNotFoundException("seller", "seller id", sellerId));
//		seller.setId(sellerDto.getId());
//		seller.setName(sellerDto.getName());
//		seller.setPhonenumber(seller.getPhonenumber());
//		seller.setAddress(sellerDto.getAddress());
//		seller.setProducts(seller.getProducts());
//		Seller updatedPost = this.sellerRepo.save(seller);
//		return this.modelMapper.map(updatedPost, SellerDto.class);
//	}
//	@Override
//	public void deleteSeller(int sellerId) {
//		Seller seller = this.sellerRepo.findById(sellerId)
//				.orElseThrow(() -> new ResourceNotFoundException("seller", "seller id", sellerId));
//		this.sellerRepo.delete(seller);
//	}
//	@Override
//	public SellerDto getSellerById(int sellerId) {
//		Seller seller = this.sellerRepo.findById(sellerId)
//				.orElseThrow(() -> new ResourceNotFoundException("Seller", "seller id", sellerId));
//		return this.modelMapper.map(seller, SellerDto.class);
//	}
//	@Override
//	public List<SellerDto> getSellersByProduct(int productId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public List<SellerDto> searchProducts(String keyword) {
////		List<Seller> sellers = this.sellerRepo.searchByTitle("%" + keyword + "%");
////		List<SellerDto> sellerDtos = sellers.stream().map((seller) -> this.modelMapper.map(seller, SellerDto.class))
////				.collect(Collectors.toList());
////		return sellerDtos;
//		return null;
//	}

}