package com.pushbullet.service;

import com.pushbullet.domain.*;

import org.springframework.http.ResponseEntity;

public interface IPushBulletBBCService {
	ResponseEntity<String> SendNotification(PushBulletNotificationRequest pushBulletNotificationRequest) throws IllegalArgumentException;
}
