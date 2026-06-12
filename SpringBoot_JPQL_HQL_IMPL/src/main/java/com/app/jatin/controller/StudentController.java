package com.app.jatin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.jatin.entity.Student;
import com.app.jatin.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository repo;

	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return repo.save(student);
	}

	@GetMapping("/all")
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	// JPQL
	@GetMapping("/jpql")
	public List<Student> getJPQLData() {
		return repo.getAllStudentsJPQL();
	}

	// JPQL with condition
	@GetMapping("/course/{course}")
	public List<Student> getByCourse(@PathVariable String course) {
		return repo.getStudentByCourse(course);
	}

	// HQL
	@GetMapping("/hql")
	public List<Student> getHQLData() {
		return repo.getAllStudentsHQL();
	}
}