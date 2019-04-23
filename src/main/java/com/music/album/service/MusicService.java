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
package com.music.album.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.album.common.constant.CommonConstant;
import com.music.album.domain.Album;
import com.music.album.entity.Song;
import com.music.album.helper.AlbumSongsHelper;
import com.music.album.repository.MusicRepository;
import com.music.album.response.AlbumResponse;
import com.music.album.util.AlbumUtil;
import com.music.album.util.FileUtil;

@Service
public class MusicService {
	
	@Autowired
	MusicRepository musicRepositry;

	final static Logger logger = Logger.getLogger(MusicService.class);
	public List<AlbumResponse> getAlbumsSortedByDurationAsc() throws IOException {
		PropertyConfigurator.configure(CommonConstant.LOG4J_RESOURCE_PATH);

		Album album = new Album();
		List<Album> albumList = new ArrayList<>();
		AtomicInteger count = new AtomicInteger(0);
		List<AlbumResponse> finalAlbumList = new ArrayList<>();
		 List<AlbumResponse> albumResponse = new ArrayList();

	    //***********************************************************************************************************//
		//  Step 1. Get the Resource Absolute path                                                                   //
		//***********************************************************************************************************//
		String fileName = FileUtil.getResourceFilePath(CommonConstant.RESOURCE_ALBUM_TXT);
		

		//***********************************************************************************************************//
		//  Step 2. Read the content from the album.txt                                                              //
		//***********************************************************************************************************//
		List<String> allLines = FileUtil.readFileContent(fileName);

		
		//***********************************************************************************************************//
		//  Step 3. Iterate through each line in album.txt                                                           //
		//***********************************************************************************************************//
		try (Scanner scanner = new Scanner(new File(fileName))) {

			
			//******************************************************************************************************//
			//  Step 4. Populate Album object with the contents of album.txt                                        //
			//******************************************************************************************************//
			AlbumUtil.prepareAlbumData(album, albumList, allLines, scanner);

			//******************************************************************************************************//
			//  Step 5. Prepare new Album object based on the below conditions                                      //
			//  In each album calculate median of songs length and collect all songs whose length is less than or   //
			//  equal to the median of songs length in the album                                                    //
			//******************************************************************************************************//
			albumResponse = AlbumSongsHelper.prepareNewAlbum(albumList, finalAlbumList);

			
		
		} catch (IOException ex) {
			logger.error("Exception occurred :: ", ex);
		}
		return albumResponse;
	}

	/**
	 * Creates an Album list.
	 * @param albumEntityList
	 */
	public void createAlbumList(List<Album> albumEntityList) {
		musicRepositry.saveAll(albumEntityList);
		
	}

	/**
	 * GETs all the album List information
	 * @return
	 */
	public List<com.music.album.entity.Album> getAllAlbums() {
		List<com.music.album.entity.Album> albums = new ArrayList<>();
		musicRepositry.findAll().forEach(album -> albums.add(album));
		return albums;
	}

	/**
	 * Gets the album information by ID
	 * @param id
	 * @return
	 */
	public com.music.album.entity.Album getAlbumById(int id) {
		return musicRepositry.findById(id).get();
	}

	/**
	 * Delete Album by Id.
	 * @param id
	 */
	public void deleteAlbum(int id) {
		musicRepositry.deleteById(id);
	}

	/**
	 * create an Album
	 * @param album
	 */
	public void createOrUpdateAlbum(com.music.album.entity.Album album) {
		musicRepositry.save(album);
		
	}

	/**
	 * 
	 * @param album
	 * @param id
	 * @return
	 */
	public com.music.album.entity.Album updateAlbums(com.music.album.entity.Album album, int id) {
		List<Song>  songList = new ArrayList<>();
		return musicRepositry.findById(Integer.parseInt(String.valueOf(id)))
				.map(updatedAlbum -> {
					updatedAlbum.setAlbumName(album.getAlbumName());
					updatedAlbum.setArtistName(album.getArtistName());
					updatedAlbum.setYear(album.getYear());
					album.getSongs().forEach( song -> {
						Song songUpdated = new Song();
						songUpdated.setSongId(song.getSongId());
						songUpdated.setSongLength(song.getSongLength());
						songUpdated.setSongName(song.getSongName());
						songList.add(songUpdated);
					});
					updatedAlbum.setSongs(songList);
					return musicRepositry.save(updatedAlbum);
					})
				.orElseGet(() -> {
						album.setAlbumId(Integer.parseInt(String.valueOf(id)));
		        return musicRepositry.save(album);
					
				});
	}
}
