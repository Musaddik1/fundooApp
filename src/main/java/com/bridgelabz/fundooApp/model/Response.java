package com.bridgelabz.fundooApp.model;

public class Response {

	private int statuscode;
	private String token;
	private String statusMessage;
	
	public Response()
	{
		
	}

	public Response(int statuscode, String token, String statusMessage) {
		super();
		this.statuscode = statuscode;
		this.token = token;
		this.statusMessage = statusMessage;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
}
