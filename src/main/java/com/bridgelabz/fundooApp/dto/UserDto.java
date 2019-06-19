 package com.bridgelabz.fundooApp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
	
	@NotNull
	@Size(min = 2,max = 30)
	private String name;
	@NotNull
	//@Email(regexp ="^[_A-Za-z\\+]+(\\.[_A-Za-z0-9-]+)*@"
	//	+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" )
	private String emailId;
	
	@Pattern(regexp = "^[6-9]?[0-9]{9}+$")
	private String phoneNumber;
	@NotNull
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
