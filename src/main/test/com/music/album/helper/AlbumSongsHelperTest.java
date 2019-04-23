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
package com.music.album.helper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.music.album.response.AlbumResponse;
import com.music.album.domain.Album;
import com.music.album.domain.Song;

/**
 * @author harip
 *
 */
public class AlbumSongsHelperTest {

	
	List<Album> albumList; 
	
	List<AlbumResponse> finalAlbumList;
	
	 List<Double> finalAverageListVal;
	
	Album album;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	    albumList = new ArrayList<>() ;
		finalAlbumList = new ArrayList<>();
		album = new Album();
		finalAverageListVal = new ArrayList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.apple.album.helper.AlbumSongsHelper#addSongsToAlbumWithDurtionLessThanOrEqualToMedian(java.util.List, com.music.album.domain.Album, java.util.List)}.
	 */
	@Test
	public void testAddSongsToAlbumWithDurtionGreaterThanMedian() {
		
		AlbumResponse albumResponse = new AlbumResponse();
		albumResponse.setAlbumName("unsortedAlbumName");
		albumResponse.setArtistName("unsortedArtistName");
		albumResponse.setSongLengthInSeconds(200);
		finalAlbumList.add(albumResponse);
		albumResponse.setAlbumName("sortedAlbumName");
		albumResponse.setArtistName("sortedArtistName");
		albumResponse.setSongLengthInSeconds(100);
		finalAlbumList.add(albumResponse);
		AlbumSongsHelper.addSongsToAlbumWithDurtionLessThanOrEqualToMedian(finalAlbumList, album, finalAverageListVal);
		
		//This returns the sorted list based on the song length
	    assertThat("sortedAlbumName", is(finalAlbumList.get(0).getAlbumName()));
		
		
	}

	/**
	 * Test method for {@link com.apple.album.helper.AlbumSongsHelper#prepareNewAlbum(java.util.List, java.util.List)}.
	 */
	@Test
	public void testPrepareNewAlbum() {
		
		List<Song>  songList = new ArrayList<>();
		
		Song song = new Song();
		song.setSongName("testSongA");
		song.setSongLength("1:00");
		songList.add(song);
		
		song = new Song();
		song.setSongName("testSongB");
		song.setSongLength("2:00");
		songList.add(song);
		
		song = new Song();
		song.setSongName("testSongc");
		song.setSongLength("3:00");
		songList.add(song);
		
		Album album = new Album();
		album.setAlbumName("unsortedAlbumName");
		album.setArtistName("unsortedArtistName");
		album.setYear(2018);
		album.setSongs(songList);
		
		
		albumList.add(album);
		
		AlbumSongsHelper.prepareNewAlbum(albumList, finalAlbumList);
		
		//Here the media is 3 so  final list should contain Albums with song duration  less than 3
		
		assertThat(finalAlbumList.size(), is(2));
		
		assertThat(finalAlbumList.get(0).getSongLength(), is("1:00"));
		
		assertThat(finalAlbumList.get(1).getSongLength(), is("2:00"));
		
	}

}
