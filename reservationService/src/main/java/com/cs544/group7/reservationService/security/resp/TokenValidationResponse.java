package com.cs544.group7.reservationService.security.resp;

import java.util.List;

public class TokenValidationResponse {

	private String username;
	private List<String> authorites;
	private boolean isValid;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getAuthorites() {
		return authorites;
	}

	public void setAuthorites(List<String> authorites) {
		this.authorites = authorites;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "TokenValidationResponse [username=" + username + ", authorites=" + authorites + ", isValid=" + isValid
				+ "]";
	}

}
