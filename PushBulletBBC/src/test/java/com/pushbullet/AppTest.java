package com.pushbullet;

import com.pushbullet.domain.*;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



/**
 * Unit test for PushBulletAPI - simple unit tests. Not complete
 */

public class AppTest 

{

	  @Rule
	    public ExpectedException thrown = ExpectedException.none();
	  
   /* public void testSend() {
    	PushBulletAPI api = new PushBulletAPI("o.ZgqvZvrEgIfZ8MuDoUccENMGMqU0tQVd");
    	PushBulletNote pushBulletNote = new PushBulletNote("title1", "body");
    	ResponseEntity<String> responseEntity = api.createPush(pushBulletNote);
    	assertTrue(true);
    }*/
    
    @Test
    public void testCreateUser() {
    	PushBulletLocalRepository pushBulletLocalRepository = new PushBulletLocalRepository();
    	PushBulletUser pushBulletUser = pushBulletLocalRepository.addUser("usertest", "token1");
    	assertNotNull(pushBulletUser);
     	
    }
    
    @Test
    public void testNullUser() {
    	thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Username must be set");
    	PushBulletLocalRepository pushBulletLocalRepository = new PushBulletLocalRepository();
       	PushBulletUser pushBulletUser = pushBulletLocalRepository.addUser("", "token1");
   	
    }
    
    @Test
    public void testNullAccessToken() {
    	thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Access token must be set");
    	PushBulletLocalRepository pushBulletLocalRepository = new PushBulletLocalRepository();
       	PushBulletUser pushBulletUser = pushBulletLocalRepository.addUser("user1", "");
   	
    }
    
    @Test
    public void testDuplicateUser() {
    	thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Username user1 already exists");
    	PushBulletLocalRepository pushBulletLocalRepository = new PushBulletLocalRepository();
       	PushBulletUser pushBulletUser = pushBulletLocalRepository.addUser("user1", "token1");
    	pushBulletUser = pushBulletLocalRepository.addUser("user1", "token1");
   	
    }
    
    @Test
    public void testSendNotification() {
    	PushBulletLocalRepository pushBulletLocalRepository = new PushBulletLocalRepository();
    	PushBulletUser pushBulletUser = pushBulletLocalRepository.addUser("usertest", "token1");
    }
    
}