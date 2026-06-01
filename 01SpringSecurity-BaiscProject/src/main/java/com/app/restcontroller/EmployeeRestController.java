package com.app.restcontroller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
@RestController
public class EmployeeRestController {

	List<Employee> list = new ArrayList<>(List.of(new Employee(1, "Jatin", "Jaipur"),
			new Employee(2, "Sumit", "Indore"), new Employee(1, "BePositive", "Kota")

	));

	@GetMapping("/get-employee")
	public List<Employee> getAllEmployee() {
		return list;
	}

	@PostMapping("/add-employee")
	public void addEmployee(@RequestBody Employee employee) {
		list.add(employee);
		System.out.println(list);
	}

	@GetMapping("/get-info")
	public String getCourseInfo(HttpServletRequest request) {
		return "Jatin Soni JAVA Course"+request.getSession().getId();

	}
	
	
	@GetMapping("/get-moreinfo")
	public String getCourseMoreInfo(HttpServletRequest request) {
		return "Its a 10 month course"+request.getSession().getId();

	}
	
	@GetMapping("/get-csrf")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken)request.getAttribute("_csrf");

	}
}
