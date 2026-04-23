package com.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Ye class Spring configuration ke liye hai

@ComponentScan(basePackages = "com.app")
// Spring ko bol rahe hai ki is package me sab beans dhundo
public class MyAppConfig {

}