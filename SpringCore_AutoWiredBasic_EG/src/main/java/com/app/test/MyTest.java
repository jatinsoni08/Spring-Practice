package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.config.MyAppConfig;
import com.app.service.MyService;

public class MyTest {

	public static void main(String[] args) {

		// Spring container start kar rahe hai
		ApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);

		// Bean get kar rahe hai (Spring khud object banayega)
		Object obj = context.getBean("myService");

		// Type casting
		MyService service = (MyService) obj;

		// Output print
		System.out.println(service);
	}
}