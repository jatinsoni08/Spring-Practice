package com.app.jatin.controller;

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
    public Object getAllStudents() {
        return repo.findAll();
    }
}