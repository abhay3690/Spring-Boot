package com.ins.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ins.modal.User;

public interface UserRepository extends JpaRepository<User, String>{
	
}
