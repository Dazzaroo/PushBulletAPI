package com.pushbullet.service;

import com.pushbullet.domain.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/* A low level API to the external Pushbullet API. We want to hide low level details to our BBC Service */

public class PushBulletAPI  {
	
	  /* Hardcode the PushBullet API URL but may want to consider environment variable/from config file etc. to avoid
	   * recompile of card if location changed
	   */
	  private static final String PUSHBULLET_API_URL = "https://api.pushbullet.com/v2";
	  
	  HttpHeaders headers;
	  
	  /* mapping to the createPush PushBullet external API */
	  public  ResponseEntity<String> createPush(PushBulletNote pushBulletNote) throws IllegalArgumentException {
		  String jsonString;
		  jsonString = getJsonObject(pushBulletNote);
		  RestTemplate rest = new RestTemplate();
		  HttpEntity<String> requestEntity = new HttpEntity<String>(jsonString, headers);
		  ResponseEntity<String> responseEntity = 
			        rest.exchange(PUSHBULLET_API_URL+"/pushes", HttpMethod.POST, requestEntity, String.class);
		  return responseEntity;
	  }
	  
	  public <T> String getJsonObject(T jsonObject) throws IllegalArgumentException {
		  ObjectMapper mapper = new ObjectMapper();  
		  String jsonString = "";
		  try {
		  	jsonString = mapper.writeValueAsString(jsonObject);
		  } catch (JsonProcessingException ex) {
			throw new IllegalArgumentException("Invalid object details " +ex.getMessage());
		  } 
		  return jsonString;
	  }
	  
	  public PushBulletAPI(String key) {
		  headers = new HttpHeaders();
		  headers.add("Content-Type", "application/json");
		  headers.add("Authorization", String.format("Bearer %s", key));
	  }
}
