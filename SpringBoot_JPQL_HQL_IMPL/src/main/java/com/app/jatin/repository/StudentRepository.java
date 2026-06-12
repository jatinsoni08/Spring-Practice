package com.app.jatin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.jatin.entity.Student;

public interface StudentRepository extends 
JpaRepository<Student, Integer> {

	// JPQL Query
	@Query("SELECT s FROM Student s")
	List<Student> getAllStudentsJPQL();

	// JPQL with condition
	@Query("SELECT s FROM Student s WHERE s.course=?1")
	List<Student> getStudentByCourse(String course);

	// HQL Query
	@Query(value = "FROM Student")
	List<Student> getAllStudentsHQL();
}