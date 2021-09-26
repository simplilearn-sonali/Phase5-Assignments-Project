package com.pkochuru.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class WebController {
	
	@GetMapping("/sayhi")
	public String sayhi(@RequestParam(value = "name", defaultValue="World") String name) {
		return "Welcome to the Spring Boot Web Application, " + name + "! This is running on AWS EC2.";
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
