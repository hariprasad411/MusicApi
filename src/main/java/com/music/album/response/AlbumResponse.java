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
package com.music.album.response;

/**
 * This class contains the response of the album information.
 * 
 * @author harip
 *
 */
public class AlbumResponse {

	/**
	 * The name of the artist.
	 */
	private String artistName;

	/**
	 * The name of the album.
	 */
	private String albumName;

	/**
	 * The year in which the album is created.
	 */
	private long year;

	/**
	 * Name of the song
	 */
	private String songName;

	/**
	 * Duration of the song.
	 */
	private String songLength;

	/**
	 * Duration of the song in seconds
	 */
	private Integer songLengthInSeconds;


	/**
	 * Gets the artist name from the album.
	 * @return the name of the artist.
	 */
	public String getArtistName() {
		return artistName;
	}

	/**
	 * Set the artist name in the album.
	 * @param artistName  - The name of the artist name to be set.
	 *           
	 */
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	/**
	 * Gets the album name from the album
	 * @return the name of the album
	 */
	public String getAlbumName() {
		return albumName;
	}

	/**
	 * Set the name of the album.
	 * @param albumName - The name of the album to be set.
	 *           
	 */
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	/**
	 * Get the year in which the album is created.
	 * @return the year in which the album is created.
	 */
	public long getYear() {
		return year;
	}

	/**
	 * set the year in which the album is created.
	 * @param year - Year in which the album is created.
	 *            
	 */
	public void setYear(long year) {
		this.year = year;
	}

	/**
	 * Get the song name
	 * @return - the song name.
	 */
	public String getSongName() {
		return songName;
	}

	/**
	 * Set the song name.
	 * @param songName
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}

	/**
	 * Set the song duration.
	 * @return - the song duration.
	 */
	public String getSongLength() {
		return songLength;
	}


	/**
	 * Set the song duration
	 * @param songLength : The duration of the song to be set.
	 */
	public void setSongLength(String songLength) {
		this.songLength = songLength;
	}

	/**
	 * Set the song duration in seconds.
	 * @return - the song duration in seconds.
	 */
	public Integer getSongLengthInSeconds() {
		return songLengthInSeconds;
	}

	/**
	 * Set the song duration in seconds.
	 * @param songLength : The duration of the song to be set in seconds.
	 */
	public void setSongLengthInSeconds(Integer songLengthInSeconds) {
		this.songLengthInSeconds = songLengthInSeconds;
	}

}