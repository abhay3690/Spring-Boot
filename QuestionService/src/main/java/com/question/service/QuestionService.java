package com.question.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.entity.Question;

@Service
public interface QuestionService {

	Question create(Question question);
	
	List<Question> get();
	
	Question getOne(Long id);
	
	List<Question> getQuestionsOfQuiz(Long quizId);
	
}
