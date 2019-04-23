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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.music.album.domain.Song;

/**
 * @author harip
 *
 */
public class SongTest {

	
	@InjectMocks
	Song song;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		song = new Song();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.music.album.domain.Song#getSongName()}.
	 */
	@Test
	public void testGetSongName() {
		String expected = "TestSongName";
		song.setSongName(expected);
		String actual = song.getSongName();
		assertThat(actual,is(expected));
	}

	/**
	 * Test method for {@link com.music.album.domain.Song#setSongName(java.lang.String)}.
	 */
	@Test
	public void testSetSongName() {
		String expected = "TestSongName";
		song.setSongName(expected);
		String actual = song.getSongName();
		assertThat(actual,is(expected));
	}

	/**
	 * Test method for {@link com.music.album.domain.Song#getSongLength()}.
	 */
	@Test
	public void testGetSongLength() {
		String expected = "TestSongName";
		song.setSongLength(expected);
		String actual = song.getSongLength();
		assertThat(actual,is(expected));
	}

	/**
	 * Test method for {@link com.music.album.domain.Song#setSongLength(java.lang.String)}.
	 */
	@Test
	public void testSetSongLength() {
		String expected = "TestSongLength";
		song.setSongLength(expected);
		String actual = song.getSongLength();
		assertThat(actual,is(expected));
	}

}
