package com.app.jatin.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.jatin.bean.User;

@Controller
public class UserController {

	// USING MODEL

	@GetMapping("/info")
	public String showHomePage(Model model) {

		model.addAttribute("userName", "Jatin");

		model.addAttribute("courseName", "Spring Boot MVC");

		return "userHome";
	}

	// USING MAP

	@GetMapping("/map")
	public String mapData(Map<String, Object> map) {

		map.put("trainer", "Jatin");

		map.put("technology", "Spring MVC");

		return "userHome";
	}

	// USING MODELMAP

	@GetMapping("/modelmap")
	public String modelMapData(ModelMap map) {

		map.addAttribute("framework", "Spring Boot");

		map.addAttribute("version", "3.x");

		return "userHome";
	}

	// SINGLE OBJECT

	@GetMapping("/single")
	public String singleUser(Model model) {

		User user = new User(1, "Ram", "Developer");

		model.addAttribute("obj", user);

		return "userData";
	}

	// MULTIPLE OBJECTS

	@GetMapping("/all")
	public String allUsers(Model model) {

		List<User> list = Arrays.asList(

				new User(1, "Ram", "Developer"),

				new User(2, "Ramesh", "Tester"),

				new User(3, "Shyam", "QA"),

				new User(4, "Ashutosh", "Team Lead"));

		model.addAttribute("userData", list);

		return "userData";
	}
}