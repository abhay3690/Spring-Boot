package com.task.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.modal.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
