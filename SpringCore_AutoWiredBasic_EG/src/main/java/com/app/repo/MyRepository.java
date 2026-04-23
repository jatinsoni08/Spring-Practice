package com.app.repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // Spring ko bol rahe hai ki ye ek bean hai (object banega container me)
public class MyRepository {

	// Hardcoded value inject kar rahe hai
	@Value("SAMPLE")
	private String entity;

	@Override
	public String toString() {
		return "MyRepository [entity=" + entity + "]";
	}
}