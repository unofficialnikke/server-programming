package com.example.endpoints.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class EndpointsController {

	@RequestMapping("/index")
	public String index() {
		return "This is the main page";
	}
	@RequestMapping("/contact")
	public String conctact() {
		return "This is the contact page";
	}

}
