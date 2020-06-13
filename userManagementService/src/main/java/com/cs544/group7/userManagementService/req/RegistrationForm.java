package com.cs544.group7.userManagementService.req;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about user to register him ")
public class RegistrationForm {
	@NotEmpty(message = "email can not be empty")
	@Email(message = " Please provide valid Email")
	@ApiModelProperty(notes = " User Email ")
	private String email;
	@NotEmpty(message = "password can not be empty")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!^*-_]).{8,30})", message = " password must be at least 8 characters, at most 30 , contains 1 uppercase character"
			+ ", contains 1 lowercase character , contains 1 special character from @#$%!^*-_" + "and 1 number")
	@ApiModelProperty(notes = " password must be at least 8 characters, at most 30 , contains 1 uppercase character"
			+ ", contains 1 lowercase character , contains 1 special character from @#$%!^*-_" + "and 1 number")
	private String password;
	@NotEmpty(message = "confirm password cannot be empty")
	@ApiModelProperty(notes = "Must Match Password")
	private String confirmPassword;

	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String street;
	private String city;
	private String zipCode;

	@AssertTrue(message = "confirm password field should be equal to password field")
	@JsonIgnore
	public boolean isValid() {
		return this.password.equals(this.confirmPassword);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}