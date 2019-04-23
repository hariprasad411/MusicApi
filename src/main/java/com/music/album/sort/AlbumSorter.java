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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.music.album.response.AlbumResponse;

/**
 * This class sorts the album
 * @author harip
 *
 */
public class AlbumSorter {

	/**
	 * Sorts the album based on the song duration in ascending order
	 * @param finalAlbumList - sorted Album list based on the song duration.
	 */
	public static void sortAlbumBySongLengthInAscOrder(List<AlbumResponse> finalAlbumList) {
		Collections.sort(finalAlbumList, new Comparator<AlbumResponse>() {
			public int compare(AlbumResponse previousVal, AlbumResponse nextVal) {
				return previousVal.getSongLengthInSeconds().compareTo(nextVal.getSongLengthInSeconds());
			}
		});
	}
}