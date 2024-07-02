package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Product;
import com.entity.Seller;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE p.sId = :sId")
	List<Product> findAllBySId(@Param("sId") Long sId);

}