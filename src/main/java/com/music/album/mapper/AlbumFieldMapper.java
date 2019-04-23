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
package com.music.album.mapper;

import java.util.ArrayList;
import java.util.List;

import com.music.album.common.constant.CommonConstant;
import com.music.album.domain.Album;
import com.music.album.domain.Song;

/**
 * This class maps the contents of the file album.txt and maps it to Album object.
 * @author harip
 *
 */
public class AlbumFieldMapper {
	
	
	/**
	 * This class reads the data from the album .txt and maps that values to the Album object.
	 * 
	 * @param input - each line in the album.txt file
	 * @param separator - It could be SLASH separator or HYPHEN separator
	 * @param album - Album object which has the artistname, album name, year, songname , songLength fields.
	 * @return - return the album object with the values from the album.txt file
	 */
	public static Album parseAlbum(final String  input, String separator, Album album){
		
		final String[] data = input.split(separator);
	
		try{
			
			if(CommonConstant.SLASH_SEPARATOR.equalsIgnoreCase(separator))
			{
				
				//===================================================================================================//
				// Here we are setting the albumName,ArtistName and Year from the albumt.txt file into Album Object. //
				//===================================================================================================//
				
				album = setAlbumdetails(data);
				
			} else if (CommonConstant.HYPHEN_SEPARATOR.equalsIgnoreCase(separator)){
				
				//==================================================================================================//
				// Here were setting the song information into the Album details.                                   //
				//==================================================================================================//
				
				updateAlbumDetailsWithSongsInfo(album, data);
				
			}
			return album;
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		return album;
	}

	/**
	 * Set the Album Details with ArtistName, Album Name and Year information.
	 * @param data - array which contains the artistName,Album Name and Year information.
	 * @return - the ablbum object.
	 */
	private static Album setAlbumdetails(final String[] data) {
		Album album = new Album();
		album.setArtistName(data[0]);
		album.setAlbumName(data[1]);
		album.setYear(Long.valueOf(data[2].trim()));
		return album;
	}

	/**
	 * This method updates the album details with songs information.
	 * 
	 * @param album - Album object with year,artist and album information.
	 * @param data - contains the songs information which will be set to the  Album.
	 */
	private static void updateAlbumDetailsWithSongsInfo(Album album, final String[] data) {
		Song song = new Song();
		List<Song>  songsList = new ArrayList<>();
		song.setSongName(data[0]);
		song.setSongLength(data[1]);
		songsList.add(song);
		album.getSongs().add(song);
	}
}
