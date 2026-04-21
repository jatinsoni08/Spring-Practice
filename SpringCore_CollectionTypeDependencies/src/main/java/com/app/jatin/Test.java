package com.app.jatin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		Student s = (Student) ac.getBean("st");
		System.out.println(s.getName());
		System.out.println(s.getAddress());
		System.out.println(s.getMobileno());
		System.out.println(s.getCourses());
	}

}
