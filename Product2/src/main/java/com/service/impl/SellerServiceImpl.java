package com.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.AppConstants;
import com.exception.ResourceNotFoundException;
import com.modal.Product;
import com.modal.Role;
import com.modal.Seller;
import com.payload.SellerDto;
import com.payload.SellerResponse;
import com.repository.ProductRepo;
import com.repository.RoleRepo;
import com.repository.SellerRepo;
import com.service.SellerService;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerRepo sellerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public SellerDto createSeller(SellerDto sellerDto, int productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Product id", productId));

        Seller seller = modelMapper.map(sellerDto, Seller.class);
        seller.setProduct(product);

        Seller newSeller = sellerRepo.save(seller);

        return modelMapper.map(newSeller, SellerDto.class);
    }

    @Override
    public SellerDto updateSeller(SellerDto sellerDto, int sellerId) {
        Seller seller = sellerRepo.findById(sellerId)
                .orElseThrow(() -> new ResourceNotFoundException("Seller", "Seller id", sellerId));

        seller.setName(sellerDto.getName());
        seller.setEmail(sellerDto.getEmail());
        seller.setPhonenumber(sellerDto.getPhonenumber());
        seller.setAddress(sellerDto.getAddress());
        seller.setPassword(sellerDto.getPassword());

        Seller updatedSeller = sellerRepo.save(seller);

        return modelMapper.map(updatedSeller, SellerDto.class);
    }

    @Override
    public void deleteSeller(int sellerId) {
        Seller seller = sellerRepo.findById(sellerId)
                .orElseThrow(() -> new ResourceNotFoundException("Seller", "Seller id", sellerId));
        sellerRepo.delete(seller);
    }

    @Override
    public SellerDto getSellerById(int sellerId) {
        Seller seller = sellerRepo.findById(sellerId)
                .orElseThrow(() -> new ResourceNotFoundException("Seller", "Seller id", sellerId));
        return modelMapper.map(seller, SellerDto.class);
    }

    @Override
    public SellerResponse getAllSellers(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Seller> pageSeller = sellerRepo.findAll(pageable);

        List<SellerDto> sellerDtos = pageSeller.getContent().stream()
                .map(seller -> modelMapper.map(seller, SellerDto.class))
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
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Product id", productId));

        List<Seller> sellers = sellerRepo.findByProduct(product);

        return sellers.stream()
                .map(seller -> modelMapper.map(seller, SellerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SellerDto> searchSellers(String keyword) {
        List<Seller> sellers = sellerRepo.searchByTitle(keyword);
        return sellers.stream()
                .map(seller -> modelMapper.map(seller, SellerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SellerDto registerNewSeller(SellerDto sellerDto) {
        if (sellerDto.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        Seller seller = modelMapper.map(sellerDto, Seller.class);
        seller.setPassword(passwordEncoder.encode(seller.getPassword()));
        Role role = roleRepo.findById(AppConstants.NORMAL_USER)
                .orElseThrow(() -> new ResourceNotFoundException("Role", "Role id", AppConstants.NORMAL_USER));

        seller.getRoles().add(role);

        Seller newSeller = sellerRepo.save(seller);
        return modelMapper.map(newSeller, SellerDto.class);
    }
}
