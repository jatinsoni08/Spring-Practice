package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	/**
	 * Configure Spring Security settings
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		// Disable CSRF protection
		// Useful for REST APIs that are accessed through Postman,
		// mobile apps, or frontend applications.
		http.csrf(csrf -> csrf.disable());

		// Enable HTTP Basic Authentication
		// Username and password will be sent in request headers.
		http.httpBasic(Customizer.withDefaults());

		// Make the application stateless
		// Spring Security will not create or use HTTP sessions.
		http.sessionManagement(session -> 
		session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		// Require authentication for every request
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

		return http.build();
	}

	/**
	 * In-Memory User Configuration Users are stored in application memory. Mainly
	 * used for testing and learning purposes.
	 */
	@Bean
	public UserDetailsService userDetailsService() {

		// Admin user
		UserDetails admin = User.withDefaultPasswordEncoder().
				username("jatin").password("hello").roles("ADMIN")
				.build();

		// Normal user
		UserDetails user = User.withDefaultPasswordEncoder().
				username("prasson").password("bidua").roles("USER")
				.build();

		return new InMemoryUserDetailsManager(admin, user);
	}
}