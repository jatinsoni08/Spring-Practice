package com.app.jatin;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {

	private String name;

	private List<String> mobileno;

	private Set<String> address;

	private Map<String, String> courses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMobileno() {
		return mobileno;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", mobileno=" + mobileno + ", address=" + address + ", courses=" + courses
				+ "]";
	}

	public void setMobileno(List<String> mobileno) {
		this.mobileno = mobileno;
	}

	public Set<String> getAddress() {
		return address;
	}

	public void setAddress(Set<String> address) {
		this.address = address;
	}

	public Map<String, String> getCourses() {
		return courses;
	}

	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}

	public Student() {
		super();
	}

}
