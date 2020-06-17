package com.cs544.group7.crudService.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cs544.group7.crudService.security.filter.JwtTokenAuthorizationOncePerRequestFilter;
import com.cs544.group7.crudService.security.filter.JwtUnAuthorizedResponseAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JWTWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtUnAuthorizedResponseAuthenticationEntryPoint jwtUnAuthorizedResponseAuthenticationEntryPoint;

	@Autowired
	private JwtTokenAuthorizationOncePerRequestFilter jwtAuthenticationTokenFilter;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().exceptionHandling()
				.authenticationEntryPoint(jwtUnAuthorizedResponseAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/v2/api-docs", "/configuration/ui", "/resources/**", "/swagger-resources/**",
						"/configuration/security", "/swagger-ui.html", "/webjars/**")
				.permitAll().anyRequest().authenticated().and()
				.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

	}

}
