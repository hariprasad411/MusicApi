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

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.music.album.common.constant.CommonConstant;

/**
 * @author harip
 *
 */
public class FileUtilTest {

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
	 * Test method for {@link com.apple.album.util.FileUtil#readFileContent(java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	public void testReadFileContent() throws IOException {
		 List<String>  fileDataList = FileUtil.readFileContent("./resource/album.txt");
		 assertNotNull(fileDataList);
	}

	/**
	 * Test method for {@link com.apple.album.util.FileUtil#getResourceFilePath(java.lang.String)}.
	 */
	@Test
	public void testGetResourceFilePath() {
		String  path = FileUtil.getResourceFilePath(CommonConstant.RESOURCE_ALBUM_TXT);
		assertNotNull(path);
	}

}
