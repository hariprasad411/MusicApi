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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**This class contains the song information.
 * @author harip
 *
 */
@Entity
@Table(name="Song")
public class Song implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * Get The SongId.
	 */
	public Integer songId;
	
	/**
	 * Name of the song 
	 */
	private String songName;
	
	/**
	 * Duration of the song.
	 */
	private String songLength;
	
	/**
	 * Get the Album
	 */
	private Album album;
	
	/**
	 * @return the album
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALBUM_ID", nullable = false)
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}

	/**
	 * @return the songId
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SONG_ID", unique = true, nullable = false)
	public Integer getSongId() {
		return songId;
	}

	/**
	 * @param songId the songId to set
	 */
	public void setSongId(Integer songId) {
		this.songId = songId;
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
}
