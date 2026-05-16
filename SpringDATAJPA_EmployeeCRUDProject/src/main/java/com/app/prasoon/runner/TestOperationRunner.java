package com.app.prasoon.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.prasoon.entity.Employee;
import com.app.prasoon.repo.EmployeeRepository;

@Component
public class TestOperationRunner implements CommandLineRunner {

	// Repository object inject hoga
	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {

		// ================= INSERT =================

		Employee e1 = new Employee(101, "Rahul", 45000.0, "DEV");

		Employee e2 = new Employee(102, "Aman", 55000.0, "TESTING");

		Employee e3 = new Employee(103, "Neha", 65000.0, "HR");

		// save multiple objects
		repo.saveAll(Arrays.asList(e1, e2, e3));

		System.out.println("EMPLOYEE DATA INSERTED");

		System.out.println("--------------------------------");

		// ================= FETCH ALL =================

		Iterable<Employee> list = repo.findAll();

		// print all records
		list.forEach(System.out::println);

		System.out.println("--------------------------------");

		// ================= FETCH BY ID =================

		Optional<Employee> opt = repo.findById(102);

		if (opt.isPresent()) {

			Employee emp = opt.get();

			System.out.println("EMPLOYEE FOUND");
			System.out.println(emp);

		} else {

			System.out.println("EMPLOYEE NOT FOUND");
		}

		System.out.println("--------------------------------");

		// ================= UPDATE =================

		Optional<Employee> updateData = repo.findById(103);

		if (updateData.isPresent()) {

			Employee emp = updateData.get();

			// salary update
			emp.setEmpSal(90000.0);

			// updated object save
			repo.save(emp);

			System.out.println("EMPLOYEE UPDATED");
		}

		System.out.println("--------------------------------");

		// ================= DELETE =================

		repo.deleteById(101);

		System.out.println("EMPLOYEE DELETED");

		System.out.println("--------------------------------");

		// ================= FINAL DATA =================

		Iterable<Employee> finalData = repo.findAll();

		finalData.forEach(System.out::println);
	}
}