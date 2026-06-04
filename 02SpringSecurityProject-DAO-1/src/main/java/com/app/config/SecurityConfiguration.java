package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	// OLD CODE
	// @Autowired
	// private Object UserDetailsService;

	// CORRECT CODE
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Configure Spring Security settings
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		// Disable CSRF for REST APIs
		http.csrf(csrf -> csrf.disable());

		// Enable Basic Authentication
		http.httpBasic(Customizer.withDefaults());

		// Stateless Session
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		// Authenticate all requests
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

		return http.build();
	}

	/*
	 * ========================================================== OLD IN-MEMORY USER
	 * CONFIGURATION COMMENTED BECAUSE DATABASE AUTHENTICATION IS USED NOW
	 * ==========================================================
	 */

	// @Bean
	// public UserDetailsService userDetailsService() {
	//
	// UserDetails admin = User.withDefaultPasswordEncoder()
	// .username("jatin")
	// .password("hello")
	// .roles("ADMIN")
	// .build();
	//
	// UserDetails user = User.withDefaultPasswordEncoder()
	// .username("prasson")
	// .password("bidua")
	// .roles("USER")
	// .build();
	//
	// return new InMemoryUserDetailsManager(admin, user);
	// }

	/**
	 * Password Encoder
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Authentication Provider
	 */
	@Bean
	public AuthenticationProvider authProvider() {

		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();

		daoProvider.setUserDetailsService(userDetailsService);

		daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

		return daoProvider;
	}
}