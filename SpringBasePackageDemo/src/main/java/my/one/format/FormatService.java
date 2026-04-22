package my.one.format;

import org.springframework.stereotype.Component;

// Ye alag package me hai, isliye ComponentScan me include karna padega
@Component
public class FormatService {

	public String format() {
		return "FormatService Working...";
	}
}