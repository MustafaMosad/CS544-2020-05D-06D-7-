package com.cs544.group7.reservationService.security.resp;

public class UserDto {

	private String firstName;
	private String listName;
	private boolean isExist;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

}
