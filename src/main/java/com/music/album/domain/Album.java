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
package com.music.album.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the album information.
 * @author harip
 *
 */
public class Album {

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
	 * List of songs in each album.
	 */
	private List<Song> songs;

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
	 * Get the list of the songs in each album.
	 * @return - The list of songs in each album.
	 */
	public List<Song> getSongs() {
		if (null == songs) {
			songs = new ArrayList<>();
		}
		return songs;
	}

	/**
	 * Set the list of songs in each album.
	 * @param songs - List of the songs to be set.
	 *           
	 */
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

}
