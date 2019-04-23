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
package com.music.album.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.music.album.common.constant.CommonConstant;
import com.music.album.domain.Album;
import com.music.album.helper.AlbumSongsHelper;
import com.music.album.response.AlbumResponse;
import com.music.album.service.MusicService;


/**
 * This has the End points for performing the crud operation on music Api
 * @author harip
 *
 */
@Controller
@RestController
@RequestMapping("/itunes/music")
public class MusicController {

	@Autowired
	MusicService musicService;
	
	/**
	 * This method displays the data form the text file in JSON format
	 */
	@RequestMapping(value="/albums/updateDataBase", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody  Response readFromFileAndUpdateDB(){
			List<AlbumResponse>  albumResponseList = null;
			JSONObject jsonObj = new JSONObject();
			try{
				albumResponseList = musicService.getAlbumsSortedByDurationAsc();
				List<Album> albumEntityList = AlbumSongsHelper.getAlbumEntityList(albumResponseList);
				musicService.createAlbumList(albumEntityList);
				jsonObj.put(CommonConstant.ALBUM_CONSTANT, albumEntityList);
				
				return Response.status(Status.OK).entity(jsonObj).type(String.valueOf(MediaType.APPLICATION_JSON)).build();
			}catch(Exception e){
				return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).type(String.valueOf(MediaType.APPLICATION_JSON)).build();
			}
			
		}
	
	/**
	 * @throws IOException 
	 * @throws JSONException 
	 * This displays the data from the text file in jso format.
	 * @throws  
	 */
	@RequestMapping(value="/albums/playlists", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getMusicDetailsFromFile() throws  IOException{
		JSONObject obj = new JSONObject();
		List<AlbumResponse> albumResponses = musicService.getAlbumsSortedByDurationAsc();
		obj.put(CommonConstant.ALBUM_CONSTANT, albumResponses);
		return Response.status(Status.OK).entity(obj).type(String.valueOf(MediaType.APPLICATION_JSON)).build();
	}
	
	/**
	 *  Fetches the album records from Album table.
	 * @return
	 * @throws JSONException 
	 */
	@GetMapping(value="/albums", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllAlbums() {
		JSONObject obj = new JSONObject();
		List<com.music.album.entity.Album> albums = musicService.getAllAlbums();
		obj.put(CommonConstant.ALBUM_CONSTANT, albums);
		return Response.status(Status.OK).entity(obj).type(String.valueOf(MediaType.APPLICATION_JSON)).build();
	}
	
	/**
	 * Fetches the particular album from the Album table based on the ID.
	 * @throws JSONException 
	 */
	@GetMapping(value = "/albums/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	private Response getAlbum(@PathVariable("id") int id) {
		JSONObject obj = new JSONObject();
		com.music.album.entity.Album album = musicService.getAlbumById(id);
		obj.put(CommonConstant.ALBUM,album);
		return Response.status(Status.OK).entity(obj).type(String.valueOf(MediaType.APPLICATION_JSON)).build();
	}
	
	/**
	 * Deletes album based on the Id.
	 * @param id
	 * @return
	 * @throws JSONException
	 */
	@DeleteMapping(value = "/albums/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	private Response deleteAlbum(@PathVariable("id") int id) {
		JSONObject obj = new JSONObject();
		musicService.deleteAlbum(id);
		return Response.status(Status.OK).entity(obj).type(String.valueOf(MediaType.APPLICATION_JSON)).build();
	}
	
	@PostMapping(value="/albums", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response createAlbum(@RequestBody com.music.album.entity.Album album) {
		JSONObject obj = new JSONObject();
		 musicService.createOrUpdateAlbum(album);
		obj.put(CommonConstant.ALBUM_ID_CONSTANT, album);
		return Response.status(Status.OK).entity(obj).type(String.valueOf(MediaType.APPLICATION_JSON)).build();
	}
	
	@PutMapping(value="/albums/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response createOrUpdateAlbum(@RequestBody com.music.album.entity.Album album, @PathVariable("id") int id){
		JSONObject obj = new JSONObject();
		com.music.album.entity.Album albums = musicService.updateAlbums(album,id);
		obj.put(CommonConstant.ALBUM, albums);
		return Response.status(Status.OK).entity(obj).type(String.valueOf(MediaType.APPLICATION_JSON)).build();
	}

}