package com.batch.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.modal.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Serializable>{

}