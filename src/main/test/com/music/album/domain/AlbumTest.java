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


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.music.album.domain.Album;
import com.music.album.domain.Song;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author harip
 *
 */
public class AlbumTest {

	
	@InjectMocks
	Album album;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		album = new Album();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.music.album.domain.Album#getArtistName()}.
	 */
	@Test
	public void testGetArtistName() {
		String expected = "TestArtistName";
		album.setArtistName(expected);
		String actual = album.getArtistName();
		assertThat(actual,is(expected));
		
	}

	/**
	 * Test method for {@link com.music.album.domain.Album#setArtistName(java.lang.String)}.
	 */
	@Test
	public void testSetArtistName() {
		String expected = "TestArtistName";
		album.setArtistName(expected);
		String actual = album.getArtistName();
		assertThat(actual,is(expected));
	}

	/**
	 * Test method for {@link com.music.album.domain.Album#getAlbumName()}.
	 */
	@Test
	public void testGetAlbumName() {
		String expected = "TestAlbumName";
		album.setAlbumName(expected);
		String actual = album.getAlbumName();
		assertThat(actual,is(expected));
	}

	/**
	 * Test method for {@link com.music.album.domain.Album#setAlbumName(java.lang.String)}.
	 */
	@Test
	public void testSetAlbumName() {
		String expected = "TestAlbumName";
		album.setAlbumName(expected);
		String actual = album.getAlbumName();
		assertThat(actual,is(expected));
	}

	/**
	 * Test method for {@link com.music.album.domain.Album#getYear()}.
	 */
	@Test
	public void testGetYear() {
		long expected = 2018;
		album.setYear(expected);
		long actual = album.getYear();
		assertThat(actual,is(expected));
	}

	/**
	 * Test method for {@link com.music.album.domain.Album#setYear(long)}.
	 */
	@Test
	public void testSetYear() {
		long expected = 2018;
		album.setYear(expected);
		long actual = album.getYear();
		assertThat(actual,is(expected));
	}

	/**
	 * Test method for {@link com.music.album.domain.Album#getSongs()}.
	 */
	@Test
	public void testGetSongs() {
		List<Song> actual = album.getSongs();
		assertThat(actual.size(), is(0));	
	}

	/**
	 * Test method for {@link com.music.album.domain.Album#setSongs(java.util.List)}.
	 */
	@Test
	public void testSetSongs() {
		List<Song> expected = new ArrayList<>();
		album.setSongs(expected);
		List<Song> actual = album.getSongs();
		assertThat(actual,is(expected));
	}
}
