package com.mia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mia.reporting.HtmlToPdfConverter;
import com.mia.reporting.VelocityTemplateParser;

@Controller
public class HomeController {
	
	@Autowired
	private VelocityTemplateParser velocityTemplateParser;
	
	@Autowired
	private HtmlToPdfConverter htmlToPdfConverter;

	@GetMapping("/")
	public String homePage() {
		String html = velocityTemplateParser.generateHTML(null, null);
		System.out.println(html);
		htmlToPdfConverter.generatePdf(html);
		return "index.html";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "/html/login.html";
	}
}
