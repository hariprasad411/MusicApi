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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class AlbumResponseTest {

	@InjectMocks
	AlbumResponse album ;
	
	@Before
	public void setUp() throws Exception {
		album = new AlbumResponse();
	}

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
	 * Test method for {@link com.music.album.domain.Song#getSongName()}.
	 */
	@Test
	public void testGetSongName() {
		String expected = "TestSongName";
		album.setSongName(expected);
		String actual = album.getSongName();
		assertThat(actual,is(expected));
	}

	/**
	 * Test method for {@link com.music.album.domain.Song#setSongName(java.lang.String)}.
	 */
	@Test
	public void testSetSongName() {
		String expected = "TestSongName";
		album.setSongName(expected);
		String actual = album.getSongName();
		assertThat(actual,is(expected));
	}

	/**
	 * Test method for {@link com.music.album.domain.Song#getSongLength()}.
	 */
	@Test
	public void testGetSongLength() {
		String expected = "TestSongName";
		album.setSongLength(expected);
		String actual = album.getSongLength();
		assertThat(actual,is(expected));
	}

	/**
	 * Test method for {@link com.music.album.domain.Song#setSongLength(java.lang.String)}.
	 */
	@Test
	public void testSetSongLength() {
		String expected = "TestSongLength";
		album.setSongLength(expected);
		String actual = album.getSongLength();
		assertThat(actual,is(expected));
	}


	@Test
	public void testGetSongLengthInSeconds() {
		Integer expected = 10;
		album.setSongLengthInSeconds(expected);
		Integer actual = album.getSongLengthInSeconds();
		assertThat(actual,is(expected));
	}

	@Test
	public void testSetSongLengthInSeconds() {
		Integer expected = 10;
		album.setSongLengthInSeconds(expected);
		Integer actual = album.getSongLengthInSeconds();
		assertThat(actual,is(expected));
	}

}
