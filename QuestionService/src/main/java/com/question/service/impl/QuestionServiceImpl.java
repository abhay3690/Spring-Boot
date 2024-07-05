package com.question.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.entity.Question;
import com.question.exception.QuestionNotFoundException;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	private final QuestionRepository questionRepository;
	
	
	public QuestionServiceImpl(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}

	@Override
	public Question create(Question question) {
		Question save = this.questionRepository.save(question);
		return save;
	}

	@Override
	public List<Question> get() {
		List<Question> list = this.questionRepository.findAll();
		return list;
	}

	@Override
	public Question getOne(Long id) {
		Question question = this.questionRepository.findById(id).orElseThrow(()-> new QuestionNotFoundException("Question Not Found With id : "+id));
		return question;
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Long quizId) {
		List<Question> list = this.questionRepository.findByQuizId(quizId);
		return list;
	}

}
