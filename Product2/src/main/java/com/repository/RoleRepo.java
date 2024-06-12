package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modal.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}