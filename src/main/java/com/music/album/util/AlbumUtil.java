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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.music.album.mapper.AlbumFieldMapper;
import com.music.album.response.AlbumResponse;
import com.music.album.common.constant.CommonConstant;
import com.music.album.domain.Album;

/**
 * This Album Util class contains the specific methods which deals with the album.
 * @author harip
 *
 */
public class AlbumUtil {

	private static final Logger logger = Logger.getLogger(AlbumUtil.class);
	
	/**
	 * Fill the Album object with the data from the album.txt
	 * @param album - Album  object.
	 * @param albumList - This list contains the list of Album information created from the album.txt
	 * @param allLines - line content list from the album.txt.
	 * @param scanner - contains the line information
	 * @return
	 */
	public static Album prepareAlbumData(Album album, List<Album> albumList, List<String> allLines, Scanner scanner) {
		for (String line : allLines) {
			String lineText = scanner.nextLine();

			if (lineText.contains(CommonConstant.SLASH_SEPARATOR)) {
				album = AlbumFieldMapper.parseAlbum(line, CommonConstant.SLASH_SEPARATOR, album);
			} else if (lineText.contains(CommonConstant.HYPHEN_SEPARATOR)) {
				album = AlbumFieldMapper.parseAlbum(line, CommonConstant.HYPHEN_SEPARATOR, album);
			} else {
				albumList.add(album);
				album = new Album();
			}
		}
		return album;
	}
	
	/**
	 * This method displays the Album information and the total time duration.
	 * @param count
	 * @param finalAlbumList - newly created album list
	 * @return - returns the list of songs duration
	 */
	public static List<Integer> processAndDislayAlbumDetails(AtomicInteger count, List<AlbumResponse> finalAlbumList) {
		List<Integer> durationInSecondsList = new ArrayList<>();

		for (AlbumResponse albumFinal : finalAlbumList) {

			AlbumUtil.displayAlbumDetails(count, albumFinal);

			DurationUtil.updateListWithSongsDurationInfo(durationInSecondsList, albumFinal);

		}
		return durationInSecondsList;
	}
	
	/**
	 * Display the Album details
	 * @param count - to Identity the number of albums in the album list.
	 * @param albumFinal :- Album whose details are being diplayed.
	 */
	public static void displayAlbumDetails(AtomicInteger count, AlbumResponse albumFinal) {
		logger.info(
				count.incrementAndGet() + ". " + albumFinal.getArtistName() + " - " + albumFinal.getAlbumName() + " - "
						+ albumFinal.getYear() + " - " + albumFinal.getSongName() + " - " + albumFinal.getSongLength());
	}
}