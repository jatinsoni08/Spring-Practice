package com.app.jatin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.jatin.entity.Student;
import com.app.jatin.repo.StudentRepository;

@Component
public class TestOprRunner implements CommandLineRunner {

    @Autowired
    private StudentRepository repo;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(repo.getClass().getName());

        Student sob = new Student();
        sob.setStdId(101);
        sob.setStdName("Jatin Soni");
        sob.setStdFee(1000.00);

        repo.save(sob);
    }
}