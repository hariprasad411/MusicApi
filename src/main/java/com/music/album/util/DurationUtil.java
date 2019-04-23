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

import java.util.List;

import org.apache.log4j.Logger;

import com.music.album.response.AlbumResponse;

/**
 * This Duration Util class deals with duration of songs in the album.
 * @author harip
 *
 */
public class DurationUtil {

	private static final Logger logger = Logger.getLogger(DurationUtil.class);
	
	/**
	 * This displays the total duration of the newly created album.
	 * @param durationInSeconds - total duration of the newly created album
	 */
	public static void displayTotalDurationOfNewAlbum(List<Integer> durationInSeconds) {

		String totalRunTime = calculateTotalDurationOfNewAlbum(durationInSeconds);
		logger.info("Total Time: " + totalRunTime);
	}
	
	/**
	 * This method calculates the total duration of the new album.
	 * @param durationInSeconds - List containing duration of each song on the newly created album.
	 * @return - Returns the total duration in String format.
	 */
	private static String calculateTotalDurationOfNewAlbum(List<Integer> durationInSeconds) {
		int totalDuration = durationInSeconds.stream().mapToInt(Integer::intValue).sum();
		String totalRunTime = secondsToString(totalDuration);
		return totalRunTime;
	}
	
	/**
	 * This method converts the seconds to mm:ss time format
	 * @param pTime - total seconds in int format.
	 * @return - returns the total time in mm:ss format.
	 */
	private static String secondsToString(int pTime) {
		return String.format("%02d:%02d", pTime / 60, pTime % 60);
	}
	
    /**
     * This method updates the durationInSecond list  with the song length duration in seconds.
     * @param durationInSeconds
     * @param albumFinal
     */
	public static void updateListWithSongsDurationInfo(List<Integer> durationInSeconds, AlbumResponse albumFinal) {
		durationInSeconds.add(albumFinal.getSongLengthInSeconds());
	}
}