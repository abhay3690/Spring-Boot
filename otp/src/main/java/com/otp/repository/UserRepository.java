package com.otp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otp.modal.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	Users findByEmail(String email); 
	

}
