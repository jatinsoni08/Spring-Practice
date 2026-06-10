package com.app.jatin.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indicates that this class handles REST API requests
public class ARestController {

	// Home endpoint
	@GetMapping("/")
	public String home() {
		return "Welcome to Spring Security OAuth2 Project";
	}

	// Protected endpoint
	@GetMapping("/hi")
	public String showData() {

		return "OAuth2 Login Project is running successfully.";
	}
}