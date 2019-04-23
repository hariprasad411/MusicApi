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
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.music.album.domain.Album;
import com.music.album.domain.Song;

/**
 * @author harip
 *
 */
public class SongsUtilTest {

	List<Album> albumList; 
	
	@InjectMocks
	SongsUtil songsutil;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		albumList = new ArrayList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.apple.album.util.SongsUtil#getSongsDurationMedianSet(com.music.album.domain.Album)}.
	 */
	@Test
	public void testGetSongsDurationMedianSet() {
		
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
		Set<Double>   durationSet = SongsUtil.getSongsDurationMedianSet(album);
		assertNotNull(durationSet);
		
		durationSet.forEach(val ->{
			assertThat(val, is(120.0));
		});
		
	}

}
