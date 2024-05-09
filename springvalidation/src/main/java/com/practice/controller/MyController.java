package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.practice.entities.Login;

@Controller
public class MyController {
	
	@GetMapping("/form")
	public String openForm(Model model) {
		System.out.println("Hfello World");
		model.addAttribute("login", new Login());
		return "form";
	}

//handler for processing form
//	
//	@PostMapping("/process")
//	public String processForm(@ModelAttribute("loginData") Login loginData) {
//		System.out.println(loginData);
//		return "sucess";
//	}
}