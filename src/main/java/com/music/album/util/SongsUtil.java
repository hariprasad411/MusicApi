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

import java.util.HashSet;
import java.util.Set;

import com.music.album.domain.Album;

/**
 * This Songs Util class contains the specific methods which deals with  songs in the album.
 * @author harip
 *
 */
public class SongsUtil {

	/**
	 * returns a set with the median of songs in each album.
	 * @param album1
	 * @return
	 */
	public static Set<Double> getSongsDurationMedianSet(Album album1) {
		return calculateMedianOfSongsDuration(album1);
	}

	/**
	 * This method calculates the median of the songs in each album.
	 * @param album1
	 * @return
	 */
	private static Set<Double> calculateMedianOfSongsDuration(Album album1) {
		Set<Double> finalAverageSetVal = new HashSet<>();
		album1.getSongs().stream().mapToInt(song -> (Integer.valueOf(song.getSongLength().split(":")[0].trim()) * 60)
				+ Integer.valueOf(song.getSongLength().split(":")[1].trim())).average().ifPresent(avg -> {
					finalAverageSetVal.add(avg);
				});
		return finalAverageSetVal;
	}
}