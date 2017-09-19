package com.pushbullet.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PushBulletUser {
	private String username;
	private String accessToken;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date creationTime;
	private int numOfNotificationsPushed;
	

	public PushBulletUser(String username, String accessToken) {
		this.setUsername(username);
		this.setAccessToken(accessToken);
		this.setCreationTime(new Date());
		this.setNumOfNotificationsPushed(0);
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public Date getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}


	public int getNumOfNotificationsPushed() {
		return numOfNotificationsPushed;
	}


	public void setNumOfNotificationsPushed(int numOfNotificationsPushed) {
		this.numOfNotificationsPushed = numOfNotificationsPushed;
	}


}
