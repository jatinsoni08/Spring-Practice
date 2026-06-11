package com.app.jatin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.jatin.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}