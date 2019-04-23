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
package com.music.album.util;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.music.album.response.AlbumResponse;

/**
 * @author harip
 *
 */
public class DurationUtilTest {

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
	 * Test method for {@link com.apple.album.util.DurationUtil#displayTotalDurationOfNewAlbum(java.util.List)}.
	 */
	@Test
	public void testDisplayTotalDurationOfNewAlbum() {
		List<Integer> durationInSeconds = new ArrayList<>();
		durationInSeconds.add(1);
		durationInSeconds.add(2);
		DurationUtil.displayTotalDurationOfNewAlbum(durationInSeconds);
		assertNotNull(durationInSeconds);
	}

	/**
	 * Test method for {@link com.apple.album.util.DurationUtil#updateListWithSongsDurationInfo(java.util.List, com.apple.album.response.AlbumResponse)}.
	 */
	@Test
	public void testUpdateListWithSongsDurationInfo() {
		List<Integer> durationInSeconds = new ArrayList<>();
		AlbumResponse albumResponse = new AlbumResponse();
		albumResponse.setAlbumName("unsortedAlbumName");
		albumResponse.setArtistName("unsortedArtistName");
		albumResponse.setSongLengthInSeconds(200);
		DurationUtil.updateListWithSongsDurationInfo(durationInSeconds, albumResponse);
		assertThat(durationInSeconds.size(), is(1));
	}

}
