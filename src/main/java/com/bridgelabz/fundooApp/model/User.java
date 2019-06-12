package com.bridgelabz.fundooApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class User {
	
	@Id
	private String userid;
	@Indexed(unique=true)
	private String emailId;
	

	private String name;
	private String password;
	private String phoneNumber;
	private String address;
	private boolean isVerified;
	private String token;
	
	public User()
	{
		
	}
	
	/**
	 * @param userid
	 * @param emailId
	 * @param name
	 * @param password
	 * @param phoneNumber
	 * @param address
	 * @param isVerified
	 * @param token
	 */
	public User(String userid, String emailId, String name, String password, String phoneNumber, String address,
			boolean isVerified, String token) {
		super();
		this.userid = userid;
		this.emailId = emailId;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.isVerified = isVerified;
		this.token = token;
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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}



	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
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
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", emailId=" + emailId + ", name=" + name + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", isVerified=" + isVerified + ", token="
				+ token + "]";
	}


}
