package com.cs544.group7.userManagementService.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cs544.group7.userManagementService.repo.UserRepository;
import com.cs544.group7.userManagementService.res.TokenValidationResponse;
import com.cs544.group7.userManagementService.res.UserDto;
import com.cs544.group7.userManagementService.security.dto.req.ValidateTokenRequest;
import com.cs544.group7.userManagementService.security.model.JwtUserDetails;
import com.cs544.group7.userManagementService.security.model.User;
import com.cs544.group7.userManagementService.security.util.JwtTokenUtil;

@Service
public class AuthenticationService {

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserRepository userRepository;

	public TokenValidationResponse validateToken(ValidateTokenRequest validateTokenRequest) {

		String username = null;
		TokenValidationResponse tokenValidationResponse = new TokenValidationResponse();

		try {
			username = jwtTokenUtil.getUsernameFromToken(validateTokenRequest.getToken());

			if (username != null) {

				UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

				if (jwtTokenUtil.validateToken(validateTokenRequest.getToken(), userDetails)) {
					return constructTokenResponse((JwtUserDetails) userDetails, tokenValidationResponse);
				}
			}
		} catch (Exception e) {
			tokenValidationResponse.setValid(false);

		}
		return tokenValidationResponse;
	}

	private TokenValidationResponse constructTokenResponse(JwtUserDetails userDetails,
			TokenValidationResponse tokenValidationResponse) {

		tokenValidationResponse.setValid(true);
		tokenValidationResponse.setId(userDetails.getId());
		tokenValidationResponse.setUsername(userDetails.getUsername());
		tokenValidationResponse.setFirstName(userDetails.getFirstName());
		tokenValidationResponse.setLastName(userDetails.getLastName());
		tokenValidationResponse.setUserType(userDetails.getUserType());
		List<String> authorities = new ArrayList<String>();

		for (GrantedAuthority authority : userDetails.getAuthorities()) {
			authorities.add(authority.getAuthority());
		}

		tokenValidationResponse.setAuthorites(authorities);
		return tokenValidationResponse;
	}

	public UserDto getById(Long id) {

		UserDto userDto = new UserDto();

		User user = null;

		user = userRepository.getOne(id);

		try {
			user.isEnabled();
		} catch (Exception e) {
			userDto.setExist(false);
			return userDto;
		}
		userDto.setExist(true);

		userDto.setFirstName(user.getFirstName());

		userDto.setListName(user.getLastName());

		return userDto;
	}
}
