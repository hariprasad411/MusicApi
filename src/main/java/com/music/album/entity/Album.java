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
package com.music.album.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.music.album.common.constant.CommonConstant;

/**
 * This class contains the album information.
 * @author harip
 *
 */
@Entity
@Table(name="Album")
public class Album implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * primary key for the Album table
	 */
	private int albumId;

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
	 * @return the albumId
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ALBUM_ID", unique = true, nullable = false)
	public int getAlbumId() {
		return albumId;
	}

	/**
	 * @param albumId the albumId to set
	 */
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	
	/**
	 * Gets the artist name from the album.
	 * @return the name of the artist.
	 */
	@Column(name="ARTIST_NAME", unique = false, nullable = false, length=1024)
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
	@Column(name="ALBUM_NAME", unique = false, nullable = false, length=1024)
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
	@Column(name="YEAR", unique = false, nullable = false, length=1024)
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
	@OneToMany(fetch= FetchType.LAZY, mappedBy=CommonConstant.ALBUM)
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
