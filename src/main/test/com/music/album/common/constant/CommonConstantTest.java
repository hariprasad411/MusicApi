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
package com.music.album.common.constant;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.music.album.common.constant.CommonConstant;

/**
 * @author harip
 *
 */
public class CommonConstantTest {
	
	CommonConstant  constant;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		constant = new CommonConstant();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testHyphenSeparator() {
		String actual =CommonConstant.HYPHEN_SEPARATOR;
        String expected = "-";
        assertThat(actual, is(expected));
	}
	

	@Test
	public void testSlashSeparator() {
		String actual =CommonConstant.SLASH_SEPARATOR;
        String expected = "/";
        assertThat(actual, is(expected));
	}
	
	@Test
	public void testAlbumResourceText() {
		String actual =CommonConstant.RESOURCE_ALBUM_TXT;
        String expected =  "resource/album.txt";
        assertThat(actual, is(expected));
	}
	
	@Test
	public void testALo4jResourceText() {
		String actual = CommonConstant.LOG4J_RESOURCE_PATH;
        String expected =  "resource/log4j.properties";
        assertThat(actual, is(expected));
	}
	
}
