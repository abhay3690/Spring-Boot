package com.gaphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaphql.entities.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
//custom query method
//custom find methods
}
