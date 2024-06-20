package com.aas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aas.entity.OurUsers;

public interface UsersRepo extends JpaRepository<OurUsers, Integer> {
	Optional<OurUsers> findByEmail(String email);

	Optional<OurUsers> findByName(String name);
}
