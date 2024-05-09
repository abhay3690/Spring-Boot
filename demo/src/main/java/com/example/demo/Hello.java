package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class Hello {

	@RequestMapping("/Gaurang")
	public String name() {
		return "abhay is me";
	}

}
