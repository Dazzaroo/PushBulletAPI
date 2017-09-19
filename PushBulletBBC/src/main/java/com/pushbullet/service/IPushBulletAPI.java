package com.pushbullet.service;

import org.springframework.http.ResponseEntity;
import com.pushbullet.domain.PushBulletNote;

public interface IPushBulletAPI { 
	public  ResponseEntity<String> createPush(PushBulletNote pushBulletNote);
}
