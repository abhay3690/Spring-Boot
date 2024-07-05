package com.quiz.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.entity.Quiz;
import com.quiz.exception.QuizException;
import com.quiz.repositories.QuizRepository;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;



@Service
public class QuizServiceImpl implements QuizService{

	private final QuizRepository quizRepository;
	
	private final QuestionClient questionClient;
	
	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		super();
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		Quiz save = this.quizRepository.save(quiz);
		return save;
	}

	@Override
	public List<Quiz> get() {
		List<Quiz> quizzes = this.quizRepository.findAll();
		List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		
		return newQuizList;
	}

	@Override
	public Quiz get(Long id) {
		Quiz quiz = this.quizRepository.findById(id)
				.orElseThrow(()-> new QuizException("Quiz not found with id : "+id));
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}

}
