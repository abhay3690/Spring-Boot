package com.jpa.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
	
		int a=64;
		int b=53;
		int c =4233;
		float y =987f;
		return "This is justsum of /t a + b + c + y =  "+(a+b+c+y);
	}

}
