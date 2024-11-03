package com.example.thymeleafdemo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		theModel.addAttribute("theDate", java.time.LocalDateTime.now());
		return "helloWorld";
	}
	
}
