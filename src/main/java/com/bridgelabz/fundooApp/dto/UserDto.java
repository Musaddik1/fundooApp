 package com.bridgelabz.fundooApp.dto;

public class UserDto {
	
	private String name;
	private String emailId;
	private String phoneNumber;
	private String password;
	
	
	public UserDto()
	{
		
	}


	public UserDto(String name, String emailId, String phoneNumber, String password) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	


}
