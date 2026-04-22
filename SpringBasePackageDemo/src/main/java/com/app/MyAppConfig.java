package com.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration = ye class Spring ka configuration file hai
@Configuration

// Directly tum ek single package name likh sakte ho
// ya basePackages use kar sakte ho

// In curly bracket multiple packages pass kar sakte ho
// Jo bhi class ka package tum likhoge, Spring waha se beans uthayega

// Example:
// @ComponentScan(basePackages = {"com.app","my.one"})

// Single package:
// @ComponentScan("com.app")

// Multiple packages:
// @ComponentScan(basePackages = {"com.app","my.one.format"})

//---- also write like this ::  @ComponentScan({ "com.app", "my.one.format" })

// FINAL
@ComponentScan(basePackages = { "com.app", "my.one.format" })


public class MyAppConfig {

	// is class me kuch likhna zaroori nahi
	// bas Spring ko batana hai kaha scan karna hai
}