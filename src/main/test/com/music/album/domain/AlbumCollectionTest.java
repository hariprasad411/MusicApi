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

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.music.album.domain.Album;
import com.music.album.domain.AlbumCollection;

/**
 * @author harip
 *
 */
public class AlbumCollectionTest {

	AlbumCollection albumCollection;

	Album album;

	List<Album> albumList;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		albumCollection = new AlbumCollection();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.music.album.domain.AlbumCollection#getAlbums()}.
	 */
	@Test
	public void testGetAlbums() {
		List<Album> actual = albumCollection.getAlbums();
		assertNull(actual);
	}

	/**
	 * Test method for
	 * {@link com.music.album.domain.AlbumCollection#setAlbums(java.util.List)}.
	 */
	@Test
	public void testSetAlbums() {;
		assertNull(albumCollection.getAlbums());
	}

}
