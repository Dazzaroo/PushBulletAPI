# PushBulletAPI
PushBullet simple API to add users and send notifications

# Development
The API is written in Java and developed using the following:
(1) Spring Boot on Eclipse IDE
(2) Apache Tomcat
(3) Tested with Postman

# Usage (assuming localhost web server)

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
  
# To Run Web Server (Apache Tomcat)

(1) Run PushBulletApplication.java as an application from Eclipse to start.
(2) Run the Maven Build for PushBulletBBC. A jar should be created as ~/target/PushBulletBBC-1.0-SNAPSHOT.jar which can be run standalone.
  
  
  
  
  
  
