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
package com.music.album.executor;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.music.album.helper.AlbumSongsHelper;
import com.music.album.response.AlbumResponse;
import com.music.album.util.AlbumUtil;
import com.music.album.util.DurationUtil;
import com.music.album.util.FileUtil;
import com.music.album.common.constant.CommonConstant;
import com.music.album.domain.Album;

public class AlbumExecutor {


	final static Logger logger = Logger.getLogger(AlbumExecutor.class);
	
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException, URISyntaxException {
		
		PropertyConfigurator.configure(CommonConstant.LOG4J_RESOURCE_PATH);

		Album album = new Album();
		List<Album> albumList = new ArrayList<>();
		AtomicInteger count = new AtomicInteger(0);
		List<AlbumResponse> finalAlbumList = new ArrayList<>();

	    //***********************************************************************************************************//
		//  Step 1. Get the Resource Absolute path                                                                   //
		//***********************************************************************************************************//
		String fileName = FileUtil.getResourceFilePath(CommonConstant.RESOURCE_ALBUM_TXT);
		

		//***********************************************************************************************************//
		//  Step 2. Read the content from the album.txt                                                              //
		//***********************************************************************************************************//
		List<String> allLines = FileUtil.readFileContent(fileName);

		
		//***********************************************************************************************************//
		//  Step 3. Iterate through each line in album.txt                                                           //
		//***********************************************************************************************************//
		try (Scanner scanner = new Scanner(new File(fileName))) {

			
			//******************************************************************************************************//
			//  Step 4. Populate Album object with the contents of album.txt                                        //
			//******************************************************************************************************//
			AlbumUtil.prepareAlbumData(album, albumList, allLines, scanner);

			//******************************************************************************************************//
			//  Step 5. Prepare new Album object based on the below conditions                                      //
			//  In each album calculate median of songs length and collect all songs whose length is less than or   //
			//  equal to the median of songs length in the album                                                    //
			//******************************************************************************************************//
			AlbumSongsHelper.prepareNewAlbum(albumList, finalAlbumList);

			
			//******************************************************************************************************//
			//  Step 6. Display  the album details in the below format                                              //
			//        1. Artist - Album - Year - Song - Song Length                                                 //
			//		  2. Artist - Album - Year - Song - Song Length                                                 //
			//         ...                                                                                          //
			//        <N>. Artist - Album - Year - Song - Song Length                                               //
			//******************************************************************************************************//
			List<Integer> durationInSecondsList = AlbumUtil.processAndDislayAlbumDetails(count, finalAlbumList);

			
			//******************************************************************************************************//
			//  Step 7. Display the total duration in the below format                                              //
			//                    Total Time: <mm:ss>                                                               //
			//******************************************************************************************************//
			DurationUtil.displayTotalDurationOfNewAlbum(durationInSecondsList);

		} catch (IOException ex) {
			logger.error("Exception occurred :: ", ex);
		}
	}
}