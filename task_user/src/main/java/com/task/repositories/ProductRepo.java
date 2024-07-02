package com.task.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.task.modal.Category;
import com.task.modal.Product;
import com.task.modal.User;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	List<Product> findByUser(User user);

	List<Product> findByCategory(Category category);

	List<Product> findByTitleContaining(String title);

	@Query("select p from Post p where p.title like :key")
	List<Product> searchByTitle(@Param("key") String title);

}
