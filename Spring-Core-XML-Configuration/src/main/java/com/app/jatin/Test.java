package com.app.jatin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		// Spring Container
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");

		Learn l1 = (Learn) ac.getBean("aa");
		System.out.println(l1);
	}
}