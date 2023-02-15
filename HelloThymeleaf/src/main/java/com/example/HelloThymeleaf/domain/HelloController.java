package com.example.HelloThymeleaf.domain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(@RequestParam(value="name") String name, Model model, @RequestParam(value="age")int age, Model model2) {
		model.addAttribute("name", name);
		model2.addAttribute("age", age);
		return "hello";
		
	}
	
}
