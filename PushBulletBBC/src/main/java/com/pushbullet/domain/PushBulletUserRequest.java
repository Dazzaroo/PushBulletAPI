package com.pushbullet.domain;

public class PushBulletUserRequest {  
		private String username;
		private String accessToken;

		public String getUsername() {
			return username;
		}
		
		public String getAccessToken() {
			return accessToken;
		}
		
		public void getUsername(String username) {
			this.username = username;
		}
		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}
		public PushBulletUserRequest() {

		}
		
		public PushBulletUserRequest(String username, String accessToken) {
			this.username = username;
			this.accessToken = accessToken;
		}

		
}
