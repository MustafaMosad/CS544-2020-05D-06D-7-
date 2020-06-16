package com.cs544.group7.userManagementService.security.dto.req;

import java.io.Serializable;

public class ValidateTokenRequest implements Serializable {

	private static final long serialVersionUID = 8317676219297719109L;

	private String token;

	public ValidateTokenRequest() {

	}

	public ValidateTokenRequest(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
