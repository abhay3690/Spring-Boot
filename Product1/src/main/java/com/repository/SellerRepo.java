package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Seller;


@Repository
public interface SellerRepo extends JpaRepository<Seller, Long>{

	Optional<Seller> findByEmail(String email);
}
