package com.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.Quiz;
import com.question.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	private QuizService quizService;

	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}

	// create
	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return quizService.add(quiz);
	}
	//get all
	@GetMapping
	public List<Quiz> get(){
		return quizService.get();
	}

	@GetMapping("/{id}")
	public Quiz getOne(@PathVariable Long id){
		return quizService.get(id);
	}
}
