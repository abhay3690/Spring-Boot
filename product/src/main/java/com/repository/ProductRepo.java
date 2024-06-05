package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.modal.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{
}
