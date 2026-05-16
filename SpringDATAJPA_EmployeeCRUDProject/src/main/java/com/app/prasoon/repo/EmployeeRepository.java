package com.app.prasoon.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.prasoon.entity.Employee;

// CrudRepository<EntityClass , PrimaryKeyDatatype>
public interface EmployeeRepository 
extends CrudRepository<Employee, Integer> {

}