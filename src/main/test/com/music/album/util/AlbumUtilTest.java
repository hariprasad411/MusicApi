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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.music.album.response.AlbumResponse;
import com.music.album.common.constant.CommonConstant;
import com.music.album.domain.Album;
import com.music.album.domain.Song;

/**
 * @author harip
 *
 */
public class AlbumUtilTest {
	
	@InjectMocks
	AlbumUtil albumUtil;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		albumUtil = new AlbumUtil();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.apple.album.util.AlbumUtil#prepareAlbumData(com.music.album.domain.Album, java.util.List, java.util.List, java.util.Scanner)}.
	 * @throws IOException 
	 */
	@Test
	public void testPrepareAlbumData() throws IOException {
		PropertyConfigurator.configure(CommonConstant.LOG4J_RESOURCE_PATH);

		Album album = new Album();
		List<Album> albumList = new ArrayList<>();
    	String fileName = FileUtil.getResourceFilePath(CommonConstant.RESOURCE_ALBUM_TXT);
		List<String> allLines = FileUtil.readFileContent(fileName);
		try (Scanner scanner = new Scanner(new File(fileName))) {
			AlbumUtil.prepareAlbumData(album, albumList, allLines, scanner);
			
		}
		   assertNotNull(album);
	}

	/**
	 * Test method for {@link com.apple.album.util.AlbumUtil#processAndDislayAlbumDetails(java.util.concurrent.atomic.AtomicInteger, java.util.List)}.
	 */
	@Test
	public void testProcessAndDislayAlbumDetails() {
		AtomicInteger count = new AtomicInteger(1);
		 List<AlbumResponse> finalAlbumList = new ArrayList<>();
		 
		AlbumResponse albumResponse = new AlbumResponse();
		albumResponse.setAlbumName("unsortedAlbumName");
		albumResponse.setArtistName("unsortedArtistName");
		albumResponse.setSongLengthInSeconds(200);
		albumResponse.setSongLength("3:20");
		finalAlbumList.add(albumResponse);
		
		albumResponse = new AlbumResponse();
		albumResponse.setAlbumName("sortedAlbumName");
		albumResponse.setArtistName("sortedArtistName");
		albumResponse.setSongLengthInSeconds(100);
		albumResponse.setSongLength("1:40");
		finalAlbumList.add(albumResponse);
			
		 List<Integer> durationInSecondsList =  AlbumUtil.processAndDislayAlbumDetails(count, finalAlbumList);
		 assertThat(200, is(durationInSecondsList.get(0)));
	}

	/**
	 * Test method for {@link com.apple.album.util.AlbumUtil#displayAlbumDetails(java.util.concurrent.atomic.AtomicInteger, com.apple.album.response.AlbumResponse)}.
	 */
	@Test
	public void testDisplayAlbumDetails() {
		AtomicInteger count = new AtomicInteger(1);
		AlbumResponse albumFinal = new AlbumResponse();
		albumFinal.setAlbumName("testAlbumName");
		AlbumUtil.displayAlbumDetails(count, albumFinal);
	    assertThat("testAlbumName", is(albumFinal.getAlbumName()));
	}
}
