package com.pushbullet.service;

import com.pushbullet.domain.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/* API to calls to the external PushBullet API and provide the BBC service functionality */

public class PushBulletBBCService implements IPushBulletBBCService {

	private IPushBulletRepository pushBulletRepository;
	
	/* Attempt to send a notification via a given username/note details and attempt to send via its key, if found in our repository.
	 * If successful then increases users notification count */
	
	@Override
	public ResponseEntity<String> SendNotification(PushBulletNotificationRequest pushBulletNotificationRequest) throws IllegalArgumentException {
		ResponseEntity<String> responseEntity;
		try {
			String username = pushBulletNotificationRequest.getUsername();
			String key = pushBulletRepository.getUserKey(username);
			PushBulletAPI pushBulletAPI = new PushBulletAPI(key);
			PushBulletNoteBuilder pushBulletNoteBuilder = new PushBulletNoteBuilder(pushBulletNotificationRequest);
			responseEntity = pushBulletAPI.createPush(pushBulletNoteBuilder.getPushBulletNote());
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				pushBulletRepository.addUserNotification(username);
			}
		} catch(IllegalArgumentException ex ) {
			throw ex;
		}
		return responseEntity;
	}

	
	public PushBulletBBCService(IPushBulletRepository pushBulletRepository) {
		this.pushBulletRepository = pushBulletRepository;
	}
}
