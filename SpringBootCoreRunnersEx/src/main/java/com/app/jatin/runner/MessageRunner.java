package com.app.jatin.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(10)
@Component
public class MessageRunner implements CommandLineRunner{
	
	 @Override
	public void run(String... args) throws Exception {
		System.out.println("Message Runner.....");
	}
	

}
