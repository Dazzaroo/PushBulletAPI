package com.pushbullet.controllers;

import com.pushbullet.domain.*;
import com.pushbullet.service.*;

import java.util.Collection;

import javax.tools.JavaFileObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@ComponentScan("com.pushbullet.*") 

/* Our Spring API Controller to handle (1) Adding a new user (2) List of all users and (3) Creating a Note */

public class PushBulletController {
    
	@Autowired
    private IPushBulletRepository pushBulletRepository;
    
    @RequestMapping(value = "/api/pushbullet/user", method = RequestMethod.POST,    headers = {"content-type=application/json"})
    public ResponseEntity<?> addUser(@RequestBody PushBulletUserRequest pushBulletUserRequest) {
    	PushBulletUser pushBulletUser;
    	
    	String username = pushBulletUserRequest.getUsername();

    	try {
	    	pushBulletUser = pushBulletRepository.addUser(username,
	    			                     pushBulletUserRequest.getAccessToken());
	        return new ResponseEntity<>((PushBulletUser)pushBulletUser, HttpStatus.CREATED);
    	} catch(IllegalArgumentException ex) {
    		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    	}
    }
    
    @RequestMapping(value = "/api/pushbullet/user", method = RequestMethod.GET)
    public ResponseEntity<Collection<PushBulletUser>> getAllUsers(){
        return new ResponseEntity<>((Collection<PushBulletUser>) pushBulletRepository.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "api/pushbullet/note", method = RequestMethod.POST,    headers = {"content-type=application/json"})
    public ResponseEntity<?> sendNotification(@RequestBody PushBulletNotificationRequest pushBulletNotificationRequest) {
    	ResponseEntity<String> responseEntity;
    	try {
    	  PushBulletBBCService pushBulletService = new PushBulletBBCService(pushBulletRepository); /* TODO put in constructor of controller */
     	  responseEntity = pushBulletService.SendNotification(pushBulletNotificationRequest);
    	} catch(IllegalArgumentException ex) {
    		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    	}
    	return responseEntity;
    }

}

