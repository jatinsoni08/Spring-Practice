package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.repo.MyRepository;

@Component // Ye bhi Spring bean hai
public class MyService{

	// HAS-A relation (Service ke paas Repository hai)

	@Autowired
	// Spring automatically object inject karega (Dependency Injection)
	private MyRepository repo;

	@Override
	public String toString() {
		return "MyService [repo=" + repo + "]";
	}

}