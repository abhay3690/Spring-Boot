package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.user.User;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}

	@RequestMapping("/sucess")
//	@GetMapping("/sucess")
	public String processForm(@Valid @ModelAttribute("loginData") User loginData, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		System.out.println(loginData);

		return "sucess";
	}
}
