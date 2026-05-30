package com.app.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@JsonProperty("user-unq-id")
	private Integer userId;

	@JsonProperty("user-first-name")
	private String userName;

	private String userRole;

	@JsonIgnore
	private String password;

	private List<String> permissions;
	// private List<String> permissions;
	// private String[] permissions;

	private Map<String, String> models;
	// private Properties models;
}