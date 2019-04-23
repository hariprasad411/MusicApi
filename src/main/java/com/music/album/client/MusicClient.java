/*
 * Copyright 2018 Hari Prasad Ghanta
 * 
 * Created on : 20-04-19
 * Author     : Hari Prasad Ghanta
 *
 *-----------------------------------------------------------------------------
 * Revision History (Release 1.0.0.0)
 *-----------------------------------------------------------------------------
 * VERSION     AUTHOR/      DESCRIPTION OF CHANGE
 * OLD/NEW     DATE                RFC NO
 *-----------------------------------------------------------------------------
 * --/1.0  | author        | Initial Create.
 *         | 20-04-19      |
 *---------|---------------|---------------------------------------------------
 *         | author        | Defect ID 1/Description
 *         | dd-mm-yy      | 
 *---------|---------------|---------------------------------------------------
 */
package com.music.album.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.music.album.entity.Album;

/**
 * 
 * @author harip
 *
 */
public class MusicClient {
	
	final static Logger logger = Logger.getLogger(MusicClient.class);
	
	public static final String REST_SERVICE_URL="http://locahost:8080/itunes/music";
	
	/**
	 * Add Http Authorization Headers, using Basic-Authentication to send user Credentials
	 * 
	 */
	private static HttpHeaders getHeader(){
		String plainCredentials = "admin:password";
		String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic "+base64Credentials);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}
	
	/**
	 * GET request to get all albums
	 * @throws IOException
	 */
	private static void listAndUpdateAlbums() {
		logger.info("---------------Updating the database and retrieving album list from Database.----------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String>  request = new HttpEntity<>(getHeader());
		ResponseEntity<String> response = restTemplate.exchange(REST_SERVICE_URL+"/albums/updateDataBase/",HttpMethod.GET,request,String.class);
		logger.info(response.getBody());
	}
	
	/**
	 * GET album list from the File.
	 * @throws IOException
	 */
	private static void fetchAlbumListFromFile() {
		logger.info("-------------------------retrieving album list from File.-------------------------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String>  request = new HttpEntity<>(getHeader());
		ResponseEntity<String> response = restTemplate.exchange(REST_SERVICE_URL+"/albums/playlists/",HttpMethod.GET,request,String.class);
		logger.info(response.getBody());
	}
	
	/**
	 * Fetch all the  albums.
	 * @throws IOException
	 */
	private static void fetchAllAlbums() {
		logger.info("-------------------------retrieving albums.-------------------------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String>  request = new HttpEntity<>(getHeader());
		ResponseEntity<String> response = restTemplate.exchange(REST_SERVICE_URL+"/albums/",HttpMethod.GET,request,String.class);
		logger.info(response.getBody());
	}
	
	/**
	 * Fetch albumsById.
	 * @throws IOException
	 */
	private static void fetchAlbumById() {
		logger.info("-------------------------retrieving album By Id.-------------------------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String>  request = new HttpEntity<>(getHeader());
		ResponseEntity<String> response = restTemplate.exchange(REST_SERVICE_URL+"/albums/1",HttpMethod.GET,request,String.class);
		logger.info(response.getBody());
	}
	
	/**
	 * Create a new Album.
	 * @throws IOException
	 */
	private static void createAlbum() {
		logger.info("------------------------Creating a new Album.-------------------------");
		Album album = new Album();
		album.setAlbumName("testAlbumName");
		album.setArtistName("testArtistName");
		album.setYear(2019);
		List<com.music.album.entity.Song>  songList = new ArrayList<>();
		com.music.album.entity.Song song = new com.music.album.entity.Song();
		song.setSongLength("2:27");
		song.setSongName("TestSongName");
		song.setAlbum(album);
		album.setSongs(songList);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object>  request = new HttpEntity<>(album,getHeader());
		restTemplate.postForLocation(REST_SERVICE_URL+"/albums",request,String.class);

	}
	
	/**
	 * update Album.
	 * @throws IOException
	 */
	private static void updateAlbum() {
		logger.info("------------------------ Update an Album.-------------------------");
		Album album = new Album();
		album.setAlbumName("testAlbumNameUpdated");
		album.setArtistName("testArtistNameUpdated");
		album.setYear(2018);
		List<com.music.album.entity.Song>  songList = new ArrayList<>();
		com.music.album.entity.Song song = new com.music.album.entity.Song();
		song.setSongLength("2:27");
		song.setSongName("TestSongNameUpdated");
		song.setAlbum(album);
		album.setSongs(songList);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object>  request = new HttpEntity<>(album,getHeader());
		ResponseEntity<String> response = restTemplate.exchange(REST_SERVICE_URL+"/albums/61",HttpMethod.PUT,request,String.class);
		logger.info(response.getBody());
	}
	
	/**
	 * Delete the  albums.
	 * @throws IOException
	 */
	private static void deleteAlbum() {
		logger.info("-------------------------Deleting the album.-------------------------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String>  request = new HttpEntity<>(getHeader());
		restTemplate.exchange(REST_SERVICE_URL+"/albums/19",HttpMethod.DELETE,request,Album.class);
	}
	
    /**
     *  Test the different EndPoints
     * @param args
     */
	public static void main(String args[]){
		listAndUpdateAlbums();
		fetchAlbumListFromFile();
		fetchAllAlbums();
		fetchAlbumById();
		createAlbum();
		 updateAlbum();
		 deleteAlbum();
	}

}
