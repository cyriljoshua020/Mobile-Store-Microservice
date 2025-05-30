package com.abc.security_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResourceController {
	
	@GetMapping("/home")
	public String home() {
		
		return "Home Page";
	}
	
	@GetMapping("/user/dashboard")
	public String userDashboard() {
		
		return "User DashBoard";
	}
	
	@GetMapping("/admin/dashboard")
	public String adminDashboard() {
		
		return "Admin DashBoard";
	}
}
