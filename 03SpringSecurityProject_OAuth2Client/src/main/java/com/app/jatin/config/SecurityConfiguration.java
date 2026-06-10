package com.app.jatin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Marks this class as a Spring Configuration class
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
				// Any request coming to the application must be authenticated
				.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())

				// Enable OAuth2 Login (Google/GitHub)
				.oauth2Login(Customizer.withDefaults());

		return http.build();
	}
}