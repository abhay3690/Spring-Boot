package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.modal.Seller;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Integer>{
//	List<Seller> findByProduct(Seller seller);
//
//	List<Seller> findByTitleContaining(String title);
//	@Query("select p from Post p where p.title like :key")
//	List<Seller> searchByTitle (@Param("key") String title);
}
