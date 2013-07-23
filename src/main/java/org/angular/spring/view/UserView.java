package org.angular.spring.view;

import java.util.Map;

public class UserView {

	private final String name;

	private final Map<String, Boolean> roles;

	private final String token;


	public UserView(String userName, Map<String, Boolean> roles, String token) {
		this.name = userName;
		this.roles = roles;
		this.token = token;
	}


	public String getName() {
		return this.name;
	}


	public Map<String, Boolean> getRoles() {
		return this.roles;
	}


	public String getToken() {
		return this.token;
	}

}