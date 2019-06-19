package com.bridgelabz.fundooApp.model;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;

public class Note {

	@Id
	private String noteId;
	private String title;
	private String description;
	private LocalTime creationtTime;
	private LocalTime updateTime;
	private String userId;
	private boolean isTrash;
	private boolean isArchive;

	public Note() {

	}

	/**
	 * @param noteId
	 * @param title
	 * @param description
	 * @param creationtTime
	 * @param updateTime
	 * @param userId
	 * @param isTrash
	 * @param isArchive
	 */
	public Note(String noteId, String title, String description, LocalTime creationtTime, LocalTime updateTime,
			String userId, boolean isTrash, boolean isArchive) {
		super();
		this.noteId = noteId;
		this.title = title;
		this.description = description;
		this.creationtTime = creationtTime;
		this.updateTime = updateTime;
		this.userId = userId;
		this.isTrash = isTrash;
		this.isArchive = isArchive;
	}

	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalTime getCreationtTime() {
		return creationtTime;
	}

	public void setCreationtTime(LocalTime creationtTime) {
		this.creationtTime = creationtTime;
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

	public boolean isTrash() {
		return isTrash;
	}

	public void setTrash(boolean isTrash) {
		this.isTrash = isTrash;
	}

	public boolean isArchive() {
		return isArchive;
	}

	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", title=" + title + ", description=" + description + ", creationtTime="
				+ creationtTime + ", updateTime=" + updateTime + ", userId=" + userId + ", isTrash=" + isTrash + "]";
	}

}
