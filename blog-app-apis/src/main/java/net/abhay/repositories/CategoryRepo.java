package net.abhay.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import net.abhay.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
