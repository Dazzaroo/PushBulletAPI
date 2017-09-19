package com.pushbullet.domain;

public class PushBulletNote {
	private String title;
	private String body;
	private String type;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public PushBulletNote(String title, String body) {
		this.title = title;
		this.body = body;
		this.setType("note");
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
