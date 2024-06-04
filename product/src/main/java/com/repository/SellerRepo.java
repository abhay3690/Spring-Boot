package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.modal.Seller;

public interface SellerRepo extends JpaRepository<Seller, Integer>{
	List<Seller> findByProduct(Seller seller);

	List<Seller> findByTitleContaining(String title);
	@Query("select p from Post p where p.title like :key")
	List<Seller> searchByTitle (@Param("key") String title);
}
