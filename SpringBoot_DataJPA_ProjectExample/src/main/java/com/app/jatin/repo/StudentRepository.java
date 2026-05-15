package com.app.jatin.repo;

import org.springframework.data.repository.CrudRepository;
import com.app.jatin.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}