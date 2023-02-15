package com.example.list.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.list.domain.Student;



@Controller
public class StudentController {
	
	
	@RequestMapping("/hello")
	public String showList(@ModelAttribute Student firstName, Student lastName, Model model) {
		List<Student> students = new ArrayList<Student>();
		
		Student message1 = new Student();
		message1.setFirstName("Kalevi");
		message1.setLastName("Kääpä");

		students.add(message1);

		Student message2 = new Student();		
		message2.setFirstName("Keijo");
		message2.setLastName("Koominen");

		students.add(message2);

		Student message3 = new Student();
		message3.setFirstName("Jouko");
		message3.setLastName("Joutilas");

		students.add(message3);

		model.addAttribute("studentlist", students);

		
		return "list";
	}
	
	
	
}
