package com.bridgelabz.fundooApp.dto;

public class ForgetPasswordDto {

	private String emailId;

	public ForgetPasswordDto() {

	}

	public ForgetPasswordDto(String emailId) {

		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
