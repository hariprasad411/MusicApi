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

/**This class contains the song information.
 * @author harip
 *
 */
public class Song {
	
	/**
	 * Name of the song 
	 */
	private String songName;
	
	/**
	 * Duration of the song.
	 */
	private String songLength;
	
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
}
