package com.example.friendList.web;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.friendList.domain.Friend;


@Controller
public class FriendController {
	
	@GetMapping("/index")
	public String friendAdd(Model model) {
		
		model.addAttribute("friend", new Friend());
		return "list";
	}
	@PostMapping("/index")
		public String friendSubmit(@ModelAttribute Friend friend, Model model) {
		
		
		model.addAttribute("friend", friend);
		return "list";
	}
	
	
	
	
}
