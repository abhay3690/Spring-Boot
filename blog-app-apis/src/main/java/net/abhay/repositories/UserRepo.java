package net.abhay.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.abhay.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	
}