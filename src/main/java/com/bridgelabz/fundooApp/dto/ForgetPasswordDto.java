package com.bridgelabz.fundooApp.dto;

public class ForgetPasswordDto {

	private String password;
	
	public ForgetPasswordDto()
	{
		
	}

	public ForgetPasswordDto(String password) {
		
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
