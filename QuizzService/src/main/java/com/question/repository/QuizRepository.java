package com.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.question.entity.Quiz;
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
