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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.music.album.domain.Album;

/**
 * @author harip
 *
 */
public class AlbumFieldMapperTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.apple.album.mapper.AlbumFieldMapper#parseAlbum(java.lang.String, java.lang.String, com.music.album.domain.Album)}.
	 */
	@Test
	public void testParseAlbum() {
		final String  input= "XTC / Drums and Wires / 1979";
		String separator= "/";
		Album album = new Album();
		album = AlbumFieldMapper.parseAlbum(input, separator, album);
	    assertThat("XTC", is(album.getArtistName().trim()));
	    assertThat("Drums and Wires", is(album.getAlbumName().trim()));
	    assertThat(1979L, is(album.getYear()));
	}
	
	/**
	 * Test method for {@link com.apple.album.mapper.AlbumFieldMapper#parseAlbum(java.lang.String, java.lang.String, com.music.album.domain.Album)}.
	 */
	@Test
	public void testParseSongInfo() {
		final String  input= "When You're Near Me I Have Difficulty - 3:22";
		String separator= "-";
		Album album = new Album();
		album = AlbumFieldMapper.parseAlbum(input, separator, album);
	    assertThat("When You're Near Me I Have Difficulty", is(album.getSongs().get(0).getSongName().trim()));
	    assertThat("3:22", is(album.getSongs().get(0).getSongLength().trim()));
	}
}
