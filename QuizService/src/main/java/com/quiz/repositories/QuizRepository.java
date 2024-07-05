package com.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.entity.Quiz;

@Repository
public interface QuizRepository  extends JpaRepository<Quiz, Long>{

}
