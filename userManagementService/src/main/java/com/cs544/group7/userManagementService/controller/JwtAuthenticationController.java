package com.cs544.group7.userManagementService.controller;

import java.util.Objects;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs544.group7.userManagementService.exception.custom.AuthenticationException;
import com.cs544.group7.userManagementService.res.TokenValidationResponse;
import com.cs544.group7.userManagementService.res.UserDto;
import com.cs544.group7.userManagementService.security.dto.req.JwtTokenRequest;
import com.cs544.group7.userManagementService.security.dto.req.ValidateTokenRequest;
import com.cs544.group7.userManagementService.security.dto.res.JwtTokenResponse;
import com.cs544.group7.userManagementService.security.util.JwtTokenUtil;
import com.cs544.group7.userManagementService.service.AuthenticationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Login Controller", description = "This Controller contains APIs for Authnticate User and generate token.")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private AuthenticationService authService;

	@RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
	@ApiOperation(value = "Login to the system as admin , agent or passenger ", response = JwtTokenResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully logged in and token generated"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest)
			throws AuthenticationException {

		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtTokenResponse(token));
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	@ApiOperation(value = "validate Token", response = TokenValidationResponse.class)
	public TokenValidationResponse validateToken(@RequestBody ValidateTokenRequest validateTokenRequest) {
		return authService.validateToken(validateTokenRequest);
	}

	@RequestMapping(value = "/getById/{userId}", method = RequestMethod.GET)
	public UserDto validateToken(@PathVariable Long userId) {
		return authService.getById(userId);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	private void authenticate(String username, String password) {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new AuthenticationException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new AuthenticationException("INVALID_CREDENTIALS", e);
		}
	}
}
