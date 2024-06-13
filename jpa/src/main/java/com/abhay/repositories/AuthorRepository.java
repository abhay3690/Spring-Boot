package com.abhay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhay.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
