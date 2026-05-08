package com.app.jatin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class TestObjRunner implements CommandLineRunner {
	
	@Autowired
	private DatabaseCon con;
	
	@Override
	public void run(String... args) throws Exception {
      // i am  just checking the obj is created aur not  
		System.out.println(con);		
	}

}
