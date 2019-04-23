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
package com.music.album.sort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.music.album.response.AlbumResponse;

/**
 * @author harip
 *
 */
public class AlbumSorterTest {
	
	
	List<AlbumResponse> finalAlbumList;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		finalAlbumList = new ArrayList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.apple.album.sort.AlbumSorter#sortAlbumBySongLengthInAscOrder(java.util.List)}.
	 */
	@Test
	public void testSortAlbumBySongLengthInAscOrder() {

		AlbumResponse albumResponse = new AlbumResponse();
		albumResponse.setAlbumName("unsortedAlbumName");
		albumResponse.setArtistName("unsortedArtistName");
		albumResponse.setSongLengthInSeconds(200);
		finalAlbumList.add(albumResponse);
		albumResponse.setAlbumName("sortedAlbumName");
		albumResponse.setArtistName("sortedArtistName");
		albumResponse.setSongLengthInSeconds(100);
		finalAlbumList.add(albumResponse);
		AlbumSorter.sortAlbumBySongLengthInAscOrder(finalAlbumList);
		//This returns the sorted list based on the song length
	    assertThat("sortedAlbumName", is(finalAlbumList.get(0).getAlbumName()));
	}

}
