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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class contains the file related operations.
 * @author harip
 *
 */
public class FileUtil {

	/**
	 * Reads the contents of the file.
	 * @param fileName - name of the file
	 * @return - Returns the list of line content in the file
	 * @throws IOException
	 */
	public static List<String> readFileContent(String fileName) throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get(fileName));
		return allLines;
	}
	
	/**
	 * This method returns the absolute path of the file
	 * @param resourcePath - fileNName relative path
	 * @return - the absolute path of the file.
	 */
	public static String getResourceFilePath(String resourcePath) {
		File resourceFile = new File(resourcePath);
		String fileName = resourceFile.getAbsolutePath();
		return fileName;
	}
}