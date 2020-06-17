package com.cs544.group7.userManagementService.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cs544.group7.userManagementService.repo.UserRepository;
import com.cs544.group7.userManagementService.security.model.JwtUserDetails;
import com.cs544.group7.userManagementService.security.model.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.info("Start of loadUserByUsername");
		logger.debug("username is {} ", username);
		User user = userRepo.findByEmail(username);

		if (user == null) {
			logger.warn("user with username : {} not found ", username);
			logger.info("End of loadUserByUsername");

			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));

		}
		logger.info("End of loadUserByUsername {} ", user.getRoles().iterator().next().getName());

		JwtUserDetails userDetails = new JwtUserDetails(user.getId(), user.getEmail(), user.getPassword(),
					user.getRoles().iterator().next().getName());
		 userDetails.setFirstName(user.getFirstName());
		 userDetails.setLastName(user.getLastName());
		 userDetails.setUserType(user.getClass().getSimpleName());
		return userDetails;
	}

}
