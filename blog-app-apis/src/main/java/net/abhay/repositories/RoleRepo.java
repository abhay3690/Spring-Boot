package net.abhay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.abhay.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}