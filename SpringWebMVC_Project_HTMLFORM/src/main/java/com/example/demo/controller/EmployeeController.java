package com.example.demo.controller;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @GetMapping("/form")
    public String showForm() {

        return "empReg";
    }

    @PostMapping("/register")
    public String saveEmployee(
            @ModelAttribute Employee emp,
            Model model) {

        model.addAttribute("empData", emp);

        return "success";
    }
}