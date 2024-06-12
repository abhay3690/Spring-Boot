package com.service.impliment;

import java.util.List;

import org.springframework.stereotype.Service;

import com.config.AppConstants;
import com.defaultException.ResourceNotFoundException;
import com.entity.Role;
import com.entity.Seller;
import com.load.SellerDto;
import com.repository.RoleRepo;
import com.repository.SellerRepo;
import com.service.SellerService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepo sellerRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public SellerDto createSeller(SellerDto sellerDTO) {
		Seller seller = convertToEntity(sellerDTO);
		Seller savedSeller = sellerRepo.save(seller);
		return convertToDTO(savedSeller);
	}

	@Override
	public List<SellerDto> getAllSellers() {
		List<Seller> sellers = sellerRepo.findAll();
		return sellers.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public SellerDto getSellerById(Long id) {
		Seller seller = sellerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("seller", "id", id));
		return seller != null ? convertToDTO(seller) : null;
	}

	@Override
	public void deleteSeller(Long id) {
		this.sellerRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Seller ", "id ", id) );
		sellerRepo.deleteById(id);
	}

	private SellerDto convertToDTO(Seller seller) {
		return modelMapper.map(seller, SellerDto.class);
	}

	private Seller convertToEntity(SellerDto sellerDTO) {
		return modelMapper.map(sellerDTO, Seller.class);
	}

	@Override
	public SellerDto registerNewSeller(SellerDto sellerDto) {
		Seller seller = this.modelMapper.map(sellerDto, Seller.class);
		// encode password
		seller.setPassword(this.passwordEncoder.encode(seller.getPassword()));
		// roles
		Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		
		seller.getRoles().add(role);
		
		Seller newSeller = this.sellerRepo.save(seller);
		return this.modelMapper.map(newSeller, SellerDto.class);
	}
}
