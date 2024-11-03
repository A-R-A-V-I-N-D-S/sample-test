package com.example.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.thymeleafdemo.model.Student;

@Controller
public class StudentController {
	
	@Value("${countries}")
	private List<String> countries;
	
	@Value("${programming-languages}")
	private List<String> languages;
	
	@Value("${operating-systems}")
	private List<String> favOS;

	@GetMapping("/showStudentForm")
	public String showForm(Model model) {
		Student theStudent = new Student();

		model.addAttribute("student", theStudent);
		
		model.addAttribute("countries", countries);
		
		model.addAttribute("favLanguages", languages);
		
		model.addAttribute("favOS", favOS);

		return "student-form";
	}

	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		System.out.println("theStudent - "+ theStudent.getFirstName()+theStudent.getLastName());
		
		return "student-confirmation";
	}

}
