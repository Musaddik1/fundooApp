package com.bridgelabz.fundooApp.model;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;

public class Label {

	@Id
	private String labelId;
	private String labelName;
	private LocalTime creationTime;
	private LocalTime updateTime;
	private String userId;
	
	public Label() {}


	/**
	 * @param labelId
	 * @param labelName
	 * @param creationTime
	 * @param updateTime
	 * @param userId
	 */
	public Label(String labelId, String labelName, LocalTime creationTime, LocalTime updateTime, String userId) {
		super();
		this.labelId = labelId;
		this.labelName = labelName;
		this.creationTime = creationTime;
		this.updateTime = updateTime;
		this.userId = userId;
	}


	public String getLabelId() {
		return labelId;
	}

	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	

	public LocalTime getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(LocalTime creationTime) {
		this.creationTime = creationTime;
	}


	public LocalTime getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(LocalTime updateTime) {
		this.updateTime = updateTime;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Label [labelId=" + labelId + ", labelName=" + labelName + ", creationTime=" + creationTime
				+ ", updateTime=" + updateTime + ", userId=" + userId + "]";
	}

	
	
}
