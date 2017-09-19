package com.pushbullet.domain;

import java.util.Collection;

/* Interface for methods to hold storage for user/access token */
public interface IPushBulletRepository {
	PushBulletUser addUser(String username, String accessToken ) throws IllegalArgumentException;
	Collection<PushBulletUser> getAllUsers();
	void addUserNotification(String username);
	String getUserKey(String username) throws IllegalArgumentException;
}
