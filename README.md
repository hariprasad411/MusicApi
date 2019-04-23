# MusicApi
This API exposes and Consumes Crud Operation with SpringSecurity Implementation on InMemoryDataBase

=====================================================================================================================
# MusicApi
=====================================================================================================================

This API exposes and Consumes Crud Operation with SpringSecurity Implementation on InMemoryDataBase

Problem statement

Here MusicApi/resource/album.txt file has the 3 Album sets, and each Album has some Songs and the duration of songs.

Calculate the median of songs  in each album and display the songs whose duration are less than the median 
in Ascending order.

=====================================================================================================================
Key Functionality
=====================================================================================================================

a) This is a Spring Restful project which performs the CRUD operations on Music Api
b) Hibernate is used to provide the one to many mapping functionality
c) SpringSecurity with Basic Authentication is provide for securing the webservices
d)  Inbuilt h2 database is used for retrieving the credentails for SpringSeurity
e) A Restful webservice is reads data from file and is exposed as webservice
f) A restful webservice call reads the file and updates the database.
g) All CRUD operations are exposed as webservice and the data is retrievd from hql database
h) The code deals with two typs of tables ( namely Album and Song)
i) RESTFUL CLient program has been written to read the data from the exposed webservice. THis is called MusicClient.
j)LOG4j has been used and proper documentation with comments is provide for each method.
k) JUnts have been roubustly written for all the code that has been developed.

Steps to follow
a) Run mvn clean install
b) Upon succesfull build, then run the MusicApplication.java. This starts the spring boot server on 8080 port

=====================================================================================================================
Explanation of Each Webservice EndPOint
=====================================================================================================================

1st URL :- GET method  :- http://localhost:8080/itunes/music/albums/updateDataBase

This will read the data from the album.txt and update the Album and Song table in H2 Db. And after updating the 
data is returned back to the client.

Note : Here only Admins are authorized to invoke this service.

----------------------------------------------------------------------------------------------------------------
2nd Url :- GET method :-http://localhost:8080/itunes/music/albums/playlists

This service can be invoked by clients having the USER or ADMIN role
This will retrieve the data from text file and return it to the client.

----------------------------------------------------------------------------------------------------------------
3rd Url :- GET method :-http://localhost:8080/itunes/music/albums

This service can be invoked by clients having the ADMIN role
This will retrieve the data from database and retuns to client.

----------------------------------------------------------------------------------------------------------------
4th Url :- GET method :-http://localhost:8080/itunes/music/albums/19

This service can be invoked by clients having the USER OR ADMIN role
This will retrieve the data from database with album id 19 and retuns to client.

----------------------------------------------------------------------------------------------------------------
5th Url :- DELETE method :-http://localhost:8080/itunes/music/albums/19

This service can be invoked by clients having the ADMIN role
This will delete the data from database with album id 19.

---------------------------------------------------------------------------------------------------------------- 
6th Url :- POST method :-http://localhost:8080/itunes/music/albums

BODY :- PASS THE ALBUM OBJECT
       example :- 

{  
   "artistName":"Vampire Weekend ",
   "albumName":" Contra ",
   "year":2010,
   "songName":"Holiday ",
   "songLength":" 2:18"
}

This service can be invoked by clients having the ADMIN role
This will create a new ALBUM in the database

---------------------------------------------------------------------------------------------------------------- 

7th Url : PUT METHOD  :- http://localhost:8080/itunes/music/albums/19

BODY :- PASS THE ALBUM OBJECT that needs to be modifed

{  
   "artistName":"Vampire Weekend Updated",
   "albumName":" Contra Updated",
   "year":2010,
   "songName":"Holiday Updated",
   "songLength":" 2:18"
}

This service can be invoked by clients having the ADMIN role
This will update the existing  ALBUM records in the database

---------------------------------------------------------------------------------------------------------------- 


MusicClient ( REST CLIENT )

SAMPLE RESPONSE OBTAINED AFTER RUNNING THE MusicClient.java. This client consumes the webservices  that are exposed as part of MusicAPi implementation

02:32:07.981 [main] DEBUG org.springframework.web.client.RestTemplate - HTTP GET http://localhost:8080/itunes/music/albums/updateDataBase/
02:32:07.997 [main] DEBUG org.springframework.web.client.RestTemplate - Accept=[text/plain, application/json, application/*+json, */*]
02:32:09.569 [main] DEBUG org.springframework.web.client.RestTemplate - Response 200 OK
02:32:09.575 [main] DEBUG org.springframework.web.client.RestTemplate - Reading to [java.lang.String] as "application/json;charset=UTF-8"
02:32:09.609 [main] DEBUG org.springframework.web.client.RestTemplate - HTTP GET http://localhost:8080/itunes/music/albums/playlists/
02:32:09.609 [main] DEBUG org.springframework.web.client.RestTemplate - Accept=[text/plain, application/json, application/*+json, */*]
02:32:09.798 [main] DEBUG org.springframework.web.client.RestTemplate - Response 200 OK
02:32:09.798 [main] DEBUG org.springframework.web.client.RestTemplate - Reading to [java.lang.String] as "application/json;charset=UTF-8"
02:32:09.804 [main] DEBUG org.springframework.web.client.RestTemplate - HTTP GET http://localhost:8080/itunes/music/albums/
02:32:09.804 [main] DEBUG org.springframework.web.client.RestTemplate - Accept=[text/plain, application/json, application/*+json, */*]
02:32:10.227 [main] DEBUG org.springframework.web.client.RestTemplate - Response 200 OK
02:32:10.227 [main] DEBUG org.springframework.web.client.RestTemplate - Reading to [java.lang.String] as "application/json;charset=UTF-8"
02:32:10.242 [main] DEBUG org.springframework.web.client.RestTemplate - HTTP GET http://localhost:8080/itunes/music/albums/1
02:32:10.242 [main] DEBUG org.springframework.web.client.RestTemplate - Accept=[text/plain, application/json, application/*+json, */*]
02:32:10.377 [main] DEBUG org.springframework.web.client.RestTemplate - Response 200 OK
02:32:10.378 [main] DEBUG org.springframework.web.client.RestTemplate - Reading to [java.lang.String] as "application/json;charset=UTF-8"
02:32:10.385 [main] DEBUG org.springframework.web.client.RestTemplate - HTTP POST http://localhost:8080/itunes/music/albums
02:32:10.467 [main] DEBUG org.springframework.web.client.RestTemplate - Writing [com.music.album.entity.Album@2145b572] with org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
02:32:10.698 [main] DEBUG org.springframework.web.client.RestTemplate - Response 200 OK
02:32:10.703 [main] DEBUG org.springframework.web.client.RestTemplate - HTTP PUT http://localhost:8080/itunes/music/albums/61
02:32:10.705 [main] DEBUG org.springframework.web.client.RestTemplate - Accept=[text/plain, application/json, application/*+json, */*]
02:32:10.707 [main] DEBUG org.springframework.web.client.RestTemplate - Writing [com.music.album.entity.Album@72057ecf] with org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
02:32:10.831 [main] DEBUG org.springframework.web.client.RestTemplate - Response 200 OK
02:32:10.831 [main] DEBUG org.springframework.web.client.RestTemplate - Reading to [java.lang.String] as "application/json;charset=UTF-8"
02:32:10.849 [main] DEBUG org.springframework.web.client.RestTemplate - HTTP DELETE http://localhost:8080/itunes/music/albums/19
02:32:10.899 [main] DEBUG org.springframework.web.client.RestTemplate - Accept=[application/json, application/*+json]
02:32:11.076 [main] DEBUG org.springframework.web.client.RestTemplate - Response 200 OK
02:32:11.079 [main] DEBUG org.springframework.web.client.RestTemplate - Reading to [com.music.album.entity.Album]


---------------------------------------------------------------------------------------------------------------- 
Note

All the responses that are displayed as part of the webservice response are in the Ascending order of the Duration.


---------------------------------------------------------------------------------------------------------------- 




