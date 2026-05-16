package com.app.prasoon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

// table name in database
@Table(name = "employee_tab")
public class Employee {
	// Primary Key
	@Id
	@Column(name = "eid")
	private Integer empId;
	// employee name
	@Column(name = "ename")
	private String empName;
	// employee salary
	@Column(name = "esal")
	private Double empSal;
	// employee department
	@Column(name = "edept")
	private String empDept;
}