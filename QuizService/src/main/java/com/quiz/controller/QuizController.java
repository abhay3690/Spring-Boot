package com.quiz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entity.Quiz;
import com.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	private final QuizService quizService;

	public QuizController(QuizService quizService) {
		super();
		this.quizService = quizService;
	}
	
	// post
	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return this.quizService.add(quiz);
	}
	
	// get all
	@GetMapping
	public List<Quiz> getAllQuiz() {
		return this.quizService.get();
	}
	
	// get By id
	@GetMapping("/{id}")
	public Quiz getById(@PathVariable Long id) {
		return this.quizService.get(id);
	}
}
