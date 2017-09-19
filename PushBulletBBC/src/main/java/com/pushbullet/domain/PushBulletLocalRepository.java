package com.pushbullet.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


import java.util.Map;

import org.springframework.stereotype.Repository;

/* Example of a repository that uses local storage and storage forgotten between web server startups */

@Repository
public class PushBulletLocalRepository implements IPushBulletRepository {

    private Map<String,PushBulletUser> userHashMap = new HashMap<String,PushBulletUser>();

    /* Add a user to our local repository. Duplicate users not allowed. We could modify an existing user,
     * to refresh a token, but
     * have not allowed duplicates in this case for simplicity. 
     */
	@Override
	public PushBulletUser addUser(String username, String accessToken) throws IllegalArgumentException {
		if (username == "")
			throw new IllegalArgumentException("Username must be set");
		if (accessToken == "")
			throw new IllegalArgumentException("Access token must be set");
		if (userHashMap.containsKey(username))
			throw new IllegalArgumentException("Username "+ username +" already exists");
		PushBulletUser pushBulletUser = new PushBulletUser(username, accessToken);
	
		userHashMap.put(username, pushBulletUser); 
		return pushBulletUser;
	}

	@Override
	public Collection<PushBulletUser> getAllUsers() {
		List<PushBulletUser> userList = new ArrayList<PushBulletUser>(userHashMap.values());
		return userList;
	}

	/* Add a count to users notification sent number.
	 * Being very careful to avoid concurrency race issues on this count
	 */
	
	@Override
	public void addUserNotification(String username) {
		PushBulletUser pushBulletUser = userHashMap.get(username);
		if (pushBulletUser != null) { 
			synchronized(userHashMap) {
				int currentNumOfNotificationsPushed = pushBulletUser.getNumOfNotificationsPushed();
				pushBulletUser.setNumOfNotificationsPushed(currentNumOfNotificationsPushed + 1);
			}
		}
		
	}

	@Override
	public String getUserKey(String username) throws IllegalArgumentException {
		String key;
		PushBulletUser pushBulletUser = userHashMap.get(username);
		if (username != null && pushBulletUser !=null)
			key = pushBulletUser.getAccessToken();
		else
			throw(new IllegalArgumentException("user " + username + " does not exist"));
		return key;
	}
	
	public PushBulletLocalRepository() {
		userHashMap = Collections.synchronizedMap(userHashMap);
	}

}
