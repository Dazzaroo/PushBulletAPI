# PushBulletAPI
PushBullet simple API to add users and send notifications

# Development
The API is written in Java and developed using the following:
(1) Spring Boot on Eclipse IDE
(2) Tomcat
(3) Tested with Postman

# Usage

(1) Create a User 

  http://localhost:8080/api/pushbullet/user via POST method
  
  POST json data e.g:
  
  {
  "username":"daz",
  "accessToken":"o.XXXXXXXXXXXXXXX"
  }
  
 (2) Retrieve all Users
 
  http://localhost:8080/api/pushbullet/user via GET method
  
 (3) Send a Note
  
  http://localhost:8080/api/pushbullet/note via POST method
  
  POST json data e.g:
  
  {
  "username":"daz",
  "title":"title test",
  "body":"body test"
  }
  
  The Response from the PushBullet's own API will be returned if a valid user can be found otherwise a BAD REQUEST will be returned
  
  
  
  
  
  
