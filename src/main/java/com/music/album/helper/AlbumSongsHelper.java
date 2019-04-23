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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.music.album.response.AlbumResponse;
import com.music.album.sort.AlbumSorter;
import com.music.album.util.SongsUtil;
import com.music.album.domain.Album;

/**
 * This Album Util class contains the specific methods which deals with the album.
 * @author harip
 *
 */
public class AlbumSongsHelper {

    /**
     * 
     * @param finalAlbumList
     * @param album1
     * @param finalAverageListVal
     */
	public static List<AlbumResponse> addSongsToAlbumWithDurtionLessThanOrEqualToMedian(List<AlbumResponse> finalAlbumList,
			Album album1, List<Double> finalAverageListVal) {
		album1.getSongs().forEach(song -> {

			AlbumResponse albumToBeAdded = new AlbumResponse();

			Integer songValInSec = Integer.valueOf(song.getSongLength().split(":")[0].trim()) * 60
					+ Integer.valueOf(song.getSongLength().split(":")[1].trim());

			albumToBeAdded.setAlbumName(album1.getAlbumName());
			albumToBeAdded.setArtistName(album1.getArtistName());
			albumToBeAdded.setYear(album1.getYear());

			if (songValInSec <= finalAverageListVal.get(0)) {
				albumToBeAdded.setSongName(song.getSongName());
				albumToBeAdded.setSongLength(song.getSongLength());
				albumToBeAdded.setSongLengthInSeconds(Integer.valueOf(songValInSec));

				finalAlbumList.add(albumToBeAdded);

				AlbumSorter.sortAlbumBySongLengthInAscOrder(finalAlbumList);
			}
		});
		return finalAlbumList;
	}
	
	/**
	 * prepare a new album with list of songs which are less than or equal to median of songs Length in each album.
	 * @param albumList - Album with details from the album.txt
	 * @param finalAlbumList - newly created album.
	 */
	public static List<AlbumResponse> prepareNewAlbum(List<Album> albumList, List<AlbumResponse> finalAlbumList) {
		Set<Double> averageSetVal;
		 List<AlbumResponse> albumResponse = new ArrayList<>();
		
		for (Album album1 : albumList) {

			averageSetVal = new HashSet<>();
			Set<Double> finalAverageSetVal = averageSetVal;

			finalAverageSetVal = SongsUtil.getSongsDurationMedianSet(album1);

			List<Double> finalAverageListVal = new ArrayList<>(finalAverageSetVal);

			albumResponse = AlbumSongsHelper.addSongsToAlbumWithDurtionLessThanOrEqualToMedian(finalAlbumList, album1, finalAverageListVal);
		}
		return albumResponse;
	}

	public static List<Album> getAlbumEntityList(List<AlbumResponse> albumResponseList) {
		// TODO Auto-generated method stub
		return null;
	}
}