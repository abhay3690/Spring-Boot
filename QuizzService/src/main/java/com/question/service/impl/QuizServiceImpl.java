package com.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entity.Quiz;
import com.question.repository.QuizRepository;
import com.question.service.QuizService;
@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizRepository quizRepository;
	@Override
	public Quiz add(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		return quizRepository.findAll();
	}

	@Override
	public Quiz get(Long id) {
		return quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
	}

}
