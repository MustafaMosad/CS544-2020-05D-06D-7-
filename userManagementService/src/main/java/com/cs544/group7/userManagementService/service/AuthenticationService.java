package com.cs544.group7.userManagementService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cs544.group7.userManagementService.res.TokenValidationResponse;
import com.cs544.group7.userManagementService.security.dto.req.ValidateTokenRequest;
import com.cs544.group7.userManagementService.security.util.JwtTokenUtil;

@Service
public class AuthenticationService {

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public TokenValidationResponse validateToken(ValidateTokenRequest validateTokenRequest) {

		String username = null;
		TokenValidationResponse tokenValidationResponse = new TokenValidationResponse();

		try {
			System.out.println("heeeeey // " + validateTokenRequest.getToken());
			username = jwtTokenUtil.getUsernameFromToken(validateTokenRequest.getToken());

			if (username != null) {

				UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

				if (jwtTokenUtil.validateToken(validateTokenRequest.getToken(), userDetails)) {
					return constructTokenResponse(userDetails, tokenValidationResponse);
				}
			}
		} catch (Exception e) {
			tokenValidationResponse.setValid(false);

		}
		return tokenValidationResponse;
	}

	private TokenValidationResponse constructTokenResponse(UserDetails userDetails,
			TokenValidationResponse tokenValidationResponse) {

		tokenValidationResponse.setValid(true);
		tokenValidationResponse.setUsername(userDetails.getUsername());
		List<String> authorities = new ArrayList<String>();

		for (GrantedAuthority authority : userDetails.getAuthorities()) {
			authorities.add(authority.getAuthority());
		}

		tokenValidationResponse.setAuthorites(authorities);
		return tokenValidationResponse;
	}
}
