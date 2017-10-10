package org.group17.Map;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import org.group17.Units.GameObject;
import org.group17.Units.GameObjectFactory;

/**
 * This class makes it possible to read a game map.
 * 
 * @author Cas
 *
 */
public class MapReader {

	/**
	 * This method creates a map.
	 * 
	 * @param sFileName
	 *            - The file name of the level to be played.
	 * @return cMap - A double array of chars to read a map.
	 * @throws Exception
	 *             - Throws an exception when the scanner can't find the file.
	 */
	public static char[][] createMap(String sFileName) throws Exception {
		ArrayList<String> alData = gameMapReader(sFileName);
		char[][] cMap = getCharBoard(alData);
		return cMap;
	}

	/**
	 * This method changes the char[][] with all the information of the data
	 * map. It changes it into an GameObject[][] with all the information using
	 * Objects, instead of chars.
	 * 
	 * @param sFileName
	 *            - The name of the file to be used.
	 * @return gmReturnMap - GameObject[][] with all the game data.
	 * @throws Exception
	 *             - Throws an exception when the scanner can't find the file.
	 */
	public GameMap getMap(String sFileName) throws Exception {
		char[][] cData = createMap(sFileName);
		int iHeight = cData.length;
		int iWidth = cData[0].length;
		GameMap gmReturnMap = new GameMap();
		for (int i = 0; i < iHeight; i++) {
			for (int i2 = 0; i2 < iWidth; i2++) {
				GameObject gameObject = GameObjectFactory.create(cData[i][i2], i2, i,
						gmReturnMap, iHeight);
				if (gameObject != null) {
					gmReturnMap.add(gameObject);
				}
			}
		}
		return gmReturnMap;
	}

	/**
	 * This method greats a double array of char characters which contains the
	 * map data.
	 * 
	 * @param alMapData
	 *            - An ArrayList with all the data from the map.
	 * @return cMapInformation - A double array of chars with all the map data.
	 */

	public static char[][] getCharBoard(ArrayList<String> alMapData) {
		char[][] cMapInformation = new char[Integer.parseInt(alMapData.get(0))][Integer
				.parseInt(alMapData.get(1))];

		for (int i = 0; i < Integer.parseInt(alMapData.get(0)); i++) {
			String sDataLine = alMapData.get(2 + i);

			for (int j = 0; j < Integer.parseInt(alMapData.get(1)); j++) {
				cMapInformation[i][j] = sDataLine.charAt(j);
			}
		}
		return cMapInformation;
	}

	/**
	 * This method gives back the amount of lines existing in the file.
	 * 
	 * @param sFileName
	 *            - The name of the file of the level.
	 * @throws Exception
	 *             - Throws an exception when the scanner can't find the file.
	 * @return iAmountOfLinesOfMap - Integer of the amount of lines of the map.
	 */
	public static int amountOfLinesReader(String sFileName) throws Exception {
		int iAmountOfLinesOfMap = 0;

		File fLevelFile = new File(sFileName);
		Scanner sScan = null;

		try {
			sScan = new Scanner(fLevelFile, "UTF-8");

			while (sScan.hasNextLine()) {
				sScan.nextLine();
				iAmountOfLinesOfMap++;
			}
			sScan.close();
		} finally {
			if (sScan != null) {
				sScan.close();
			}
		}
		return iAmountOfLinesOfMap;
	}

	/**
	 * This method gives back the length of the lines in the levels map.
	 * 
	 * @param sFileName
	 *            - The name of the file.
	 * @throws Exception
	 *             - Throws an exception when the scanner can't find the file.
	 * @return iLengthOfLinesOfMap - Integer which represents the length of the
	 *         lines.
	 */
	public static int lengthOfLinesReader(String sFileName) throws Exception {
		int iLenghtOfLinesOfMap = 0;

		File fLevelFile = new File(sFileName);
		Scanner sScan = null;

		try {
			sScan = new Scanner(fLevelFile, "UTF-8");
			String sFirstLine = sScan.nextLine();
			iLenghtOfLinesOfMap = sFirstLine.length();
			sScan.close();
		} finally {
			if (sScan != null) {
				sScan.close();
			}
		}
		return iLenghtOfLinesOfMap;
	}

	/**
	 * This method reads a map and returns an arraylist with all the map
	 * information.
	 * 
	 * @param sFileName
	 *            - The name of the file.
	 * @throws Exception
	 *             - Throws an exception when the scanner can't find the file.
	 * @return alMapInformation - All the information of the map. The first 2
	 *         parameters are the amount of lines in the map and the length of
	 *         the lines and all the other information is about the content on
	 *         the map itself.
	 */
	public static ArrayList<String> gameMapReader(String sFileName)
			throws Exception {
		ArrayList<String> alMapInformation = new ArrayList<String>();
		alMapInformation.add(String.valueOf(amountOfLinesReader(sFileName)));
		alMapInformation.add(String.valueOf(lengthOfLinesReader(sFileName)));
		File sLevelFile = new File(sFileName);
		Scanner sScan = null;

		try {
			sScan = new Scanner(sLevelFile, "UTF-8");

			for (int i = 0; i < Integer.parseInt(alMapInformation.get(0)); i++) {
				alMapInformation.add(sScan.nextLine());
			}
			sScan.close();
		} finally {
			if (sScan != null) {
				sScan.close();
			}
		}
		return alMapInformation;
	}
}