package com.mia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String homePage() {
		return "index.html";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "/html/login.html";
	}
}