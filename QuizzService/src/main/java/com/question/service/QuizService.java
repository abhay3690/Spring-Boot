package com.question.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.entity.Quiz;

@Service
public interface QuizService {
	Quiz add(Quiz quiz);

	List<Quiz> get();

	Quiz get(Long id);
}
