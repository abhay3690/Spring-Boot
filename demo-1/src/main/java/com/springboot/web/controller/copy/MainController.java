package com.springboot.web.controller.copy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/abhaya")
	public String name() {
		System.out.println("This is Homepage");
		return "fname";
	}
	
	@RequestMapping("/suthar")
	public String lname() {
		System.out.println("This is Homepage");
		return "lname";
	}
}
