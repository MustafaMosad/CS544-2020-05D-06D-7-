package com.cs544.group7.crudService.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cs544.group7.crudService.security.model.JwtUserDetails;
import com.cs544.group7.crudService.security.resp.TokenValidationResponse;
import com.cs544.group7.crudService.security.util.AuthenticationServiceCaller;

@Component
@Configuration
public class JwtTokenAuthorizationOncePerRequestFilter extends OncePerRequestFilter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${jwt.http.request.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationServiceCaller authenticationServiceCaller;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("Authentication Request For '{}'", request.getRequestURL());
		final String requestTokenHeader = request.getHeader(this.tokenHeader);

		if (SecurityContextHolder.getContext().getAuthentication() == null) {

			TokenValidationResponse tokenValidationResponse = authenticationServiceCaller
					.authenticateUser(requestTokenHeader);

			if (tokenValidationResponse.isValid()) {
				UserDetails userDetails = new JwtUserDetails(tokenValidationResponse.getUsername(),
						tokenValidationResponse.getAuthorites().get(0));
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}

		}
		chain.doFilter(request, response);
	}

}
