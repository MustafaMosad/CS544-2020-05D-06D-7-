package com.cs544.group7.userManagementService.service;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cs544.group7.userManagementService.enums.RoleType;
import com.cs544.group7.userManagementService.exception.custom.EmailAlreadyExistException;
import com.cs544.group7.userManagementService.repo.RoleRepository;
import com.cs544.group7.userManagementService.repo.UserRepository;
import com.cs544.group7.userManagementService.req.RegistrationForm;
import com.cs544.group7.userManagementService.security.model.Address;
import com.cs544.group7.userManagementService.security.model.Admin;
import com.cs544.group7.userManagementService.security.model.Agent;
import com.cs544.group7.userManagementService.security.model.Passenger;
import com.cs544.group7.userManagementService.security.model.Role;
import com.cs544.group7.userManagementService.security.model.User;

@Service
public class RegistrationService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/**
	 * This method to add new user to the system by specific email and encoded
	 * password
	 * 
	 * @param email
	 * @param password
	 * @param roleType
	 * @throws EmailAlreadyExistException
	 */

	@Transactional // doit as a one transaction to rollback in case failure
	public void saveUser(RegistrationForm registrationForm, RoleType roleType) throws EmailAlreadyExistException {
		logger.info("Start of saveUser");

		isEmailExist(registrationForm.getEmail());

		User user = null;
		switch (roleType) {
		case ROLE_PASSENGER:
			Address address = new Address(registrationForm.getStreet(), registrationForm.getCity(),
					registrationForm.getZipCode());
			user = new Passenger(registrationForm.getEmail(), encodePassword(registrationForm.getPassword()),
					registrationForm.getFirstName(), registrationForm.getLastName(), registrationForm.getBirthDate(),
					address);
			break;
		case ROLE_AGENT:
			user = new Agent(registrationForm.getEmail(), encodePassword(registrationForm.getPassword()),
					registrationForm.getFirstName(), registrationForm.getLastName(), registrationForm.getBirthDate());
			break;

		case ROLE_ADMIN:
			user = new Admin(registrationForm.getEmail(), encodePassword(registrationForm.getPassword()),
					registrationForm.getFirstName(), registrationForm.getLastName(), registrationForm.getBirthDate());
			break;

		}
		HashSet<Role> roles = new HashSet<>();

		roles.add(roleRepo.findByName(roleType.name()));
		user.setRoles(roles);

		userRepo.save(user);

		user.setEnabled(true);
		userRepo.save(user);

		logger.info("End of saveUser");

	}

	/**
	 * 
	 * @param password
	 * @return
	 */
	private String encodePassword(String password) {
		return passwordEncoder.encode(password);

	}

	/**
	 * check if email is already registered before
	 * 
	 * @param email
	 * @return
	 * @throws EmailAlreadyExistException
	 */
	private void isEmailExist(String email) throws EmailAlreadyExistException {
		logger.info("Start of isEmailExist ");

		if (userRepo.findByEmail(email) != null)
			throw new EmailAlreadyExistException("Provided Email Already Regestired !");

		logger.info("End of isEmailExist");
	}

}