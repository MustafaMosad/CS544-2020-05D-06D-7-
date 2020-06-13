package com.cs544.group7.userManagementService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs544.group7.userManagementService.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

	User findByEmailAndEnabled(String email, boolean isEnabled);
}
