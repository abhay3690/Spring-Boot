package com.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.Question;
import com.question.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuetionController {
	@Autowired
	private QuestionService questionService;

//create
	@PostMapping
	public Question create(@RequestBody Question question) {
		System.out.println(" "+question.getQuestion());
		return questionService.create(question);
	}

	// get all
	@GetMapping
	public List<Question> getAll() {
		return questionService.get();
	}

	@GetMapping("/{questionId}")
	public Question getOne(@PathVariable Long questionId) {
		return questionService.getOne(questionId);
	}
	//get all question of all specific 	quiz
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionOfQuiz(@PathVariable Long quizId){
		return questionService.getQuestionOfQuiz(quizId);
	}
}
