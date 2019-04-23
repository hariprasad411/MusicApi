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

import java.util.List;

/**
 * This class consists collection of the all the Album objects.
 * @author harip
 *
 */
public class AlbumCollection {
	
	/**
	 * This contains the list of all the album objects
	 */
	private List<Album> albums;
	
	/**
	 * Get the list of the albums.
	 * @return the list of albums.
	 */
	public List<Album> getAlbums() {
		return albums;
	}
	
	/**
	 * Set the album to the albums list.
	 * @param albums - set the album to the list.
	 */
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
}
