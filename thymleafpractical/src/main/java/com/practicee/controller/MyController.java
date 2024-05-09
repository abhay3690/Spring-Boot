package com.practicee.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {

		System.out.println("Inside about handler ... ");

		model.addAttribute("name", "Abhay suthar");
		model.addAttribute("currentDate", new Date().toLocaleString());

		return "about";
		// about.html
	}
	
	//handling iteration
	@GetMapping("example-loop")
	public String iterateHandler(Model m) {
		List<String> names= List.of("Ankit","Abhay","rahul");
		m.addAttribute("name",names);
		
		return "iterate";
	}
}
