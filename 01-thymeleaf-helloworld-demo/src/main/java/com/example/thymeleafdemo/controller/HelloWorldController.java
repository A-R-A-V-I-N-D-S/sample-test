package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

	@GetMapping("/showForm")
	public String showForm() {
		return "helloWorldForm";
	}
	
	@GetMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}
	
	@GetMapping("/processForm-v2")
	public String letsShoutDude(HttpServletRequest servletRequest, Model model) {
		String theNameString = servletRequest.getParameter("studentName");
		String resultString = "Yo! "+ theNameString.toUpperCase();
		model.addAttribute("phrase",resultString);
		return "helloWorld";
	}
	
	@PostMapping("/processForm-v3")
	public String letsShoutDude(@RequestParam("studentName")String name, Model model) {
		String resultString = "Hey! My friend "+ name.toUpperCase();
		model.addAttribute("phrase",resultString);
		return "helloWorld";
	}
}
