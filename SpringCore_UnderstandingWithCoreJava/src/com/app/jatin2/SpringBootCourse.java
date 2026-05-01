package com.app.jatin2;

public class SpringBootCourse implements Course {
	@Override
	public Boolean getTheCourse(double amount) {
		System.out.println("enrolled :" + amount);
		return true;
	}
}