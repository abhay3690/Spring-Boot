package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entities.User;

public interface Abhay extends CrudRepository<User, Integer> {
	public List<User> findByName(String name);
	public List<User> findByNameAndCity(String name,String city);
	public List<User> findByNameStartingWith(String name);
	public List<User> findByNameEndingWith(String name);
	public List<User> findByNameContaining(String name);
	
	
//	  @Query("SELECT u FROM user u WHERE u.name = ?")
//	    User findByUsername(String name);
	
}
