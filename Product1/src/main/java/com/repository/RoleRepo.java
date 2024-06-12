package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}