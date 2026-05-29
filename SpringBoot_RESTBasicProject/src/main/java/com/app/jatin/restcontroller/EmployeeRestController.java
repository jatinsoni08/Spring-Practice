package com.app.jatin.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.jatin.model.Employee;

/*
@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @GetMapping("/show")
    public List<Employee> showEmployeeDetails() {

        List<Employee> listOfEmployee = List.of(
                new Employee(1, "A", "Jaipur"),
                new Employee(2, "B", "Udaipur"),
                new Employee(3, "C", "Indore")
        );

        return listOfEmployee;
    }
}
*/

/*
@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @PostMapping("/show")
    public List<Employee> showEmployeeDetails(
    @RequestBody Employee employee) {

        List<Employee> listOfEmployee = List.of(
                new Employee(1, "A", "Jaipur"),
                new Employee(2, "B", "Udaipur"),
                new Employee(3, "C", "Indore")
        );

        return listOfEmployee;
    }
}
*/

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    List<Employee> listOfEmployee = new ArrayList<>(
            List.of(
                    new Employee(1, "A", "Jaipur"),
                    new Employee(2, "B", "Udaipur"),
                    new Employee(3, "C", "Indore")
            )
    );

    // GET API
    @GetMapping("/show")
    public List<Employee> showEmployeeDetails() {

        return listOfEmployee;
    }

    // POST API
    @PostMapping("/add")
    public List<Employee> addEmployee(@RequestBody Employee employee) {

        listOfEmployee.add(employee);

        return listOfEmployee;
    }
}