package com.portf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portf.modal.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
