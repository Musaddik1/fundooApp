package com.bridgelabz.fundooApp.model;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
	private String userId;
	@Indexed(unique=true)
	@Email(message = "Email should not be null")
	private String emailId;

	private String name;
	
	private String password;
	private String phoneNumber;
	private String address;
	private boolean isVerified;
	private LocalDateTime creationTime;
	private LocalDateTime updateTime;
	
	public User()
	{
		
	}
	
	
	/**
	 * @param userId
	 * @param emailId
	 * @param name
	 * @param password
	 * @param phoneNumber
	 * @param address
	 * @param isVerified
	 * @param creationTime
	 * @param updateTime
	 */
	public User(String userId, @Email(message = "Email should not be null") String emailId, String name,
			String password, String phoneNumber, String address, boolean isVerified, LocalDateTime creationTime,
			LocalDateTime updateTime) {
		
		this.userId = userId;
		this.emailId = emailId;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.isVerified = isVerified;
		this.creationTime = creationTime;
		this.updateTime = updateTime;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the isVerified
	 */
	public boolean isVerified() {
		return isVerified;
	}

	/**
	 * @param isVerified the isVerified to set
	 */
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userId;
	}



	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userId = userid;
	}



	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public LocalDateTime getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}


	public LocalDateTime getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", emailId=" + emailId + ", name=" + name + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", isVerified=" + isVerified
				+ ", creationTime=" + creationTime + ", updateTime=" + updateTime + "]";
	}
	
	
	


}
