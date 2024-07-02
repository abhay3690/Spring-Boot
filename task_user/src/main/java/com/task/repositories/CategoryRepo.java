package com.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.modal.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
