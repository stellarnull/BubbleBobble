package org.group17.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

/**
 * This class runs all kind of tests to see if the MapReader works as it should.
 * 
 * @author Cas
 *
 */
public class TestMapReader {

	/**
	 * The amount of lines that are used in the level test file.
	 */
	public static final int AMOUNT_OF_LINES_TEST_FILE = 3;

	/**
	 * The length of lines that are used in the level test file.
	 */
	public static final int LENGTH_OF_LINES_TEST_FILE = 3;

	/**
	 * This method checks if the return value is not null.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test
	public void testAmountOfLinesReaderIsNotNull() throws Exception {
		assertNotNull(MapReader.amountOfLinesReader("src/main/resources/levels/testLevel.txt"));
	}

	/**
	 * This method checks if the lines reader gives back the right amount of
	 * lines.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test
	public void testAmountOfLinesReaderGivesCorrectResult() throws Exception {
		assertEquals(AMOUNT_OF_LINES_TEST_FILE, 
				MapReader.amountOfLinesReader("src/main/resources/levels/testLevel.txt"));
	}

	/**
	 * This method checks if the linesreader doesn't give back random numbers.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test
	public void testAmountOfLinesReaderGivesFalseResult() throws Exception {
		assertFalse(MapReader.amountOfLinesReader("src/main/resources/levels/testLevel.txt") == 2);
	}

	/**
	 * This method checks if an exception will be thrown.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test(expected = Exception.class)
	public void testAmountOfLinesReaderThrowsException() throws Exception {
		MapReader.lengthOfLinesReader("wrongfilename.txt");
	}

	/**
	 * This method checks if the lengthreader doesn't return a null.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test
	public void testLengthOfLinesReaderIsNotNull() throws Exception {
		assertNotNull(MapReader.lengthOfLinesReader("src/main/resources/levels/testLevel.txt"));
	}

	/**
	 * This method checks if the lengthreader gives back the right lenght of the
	 * lines.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test
	public void testLengthOfLinesReaderGivesCorrectResult() throws Exception {
		assertEquals(AMOUNT_OF_LINES_TEST_FILE, 
				MapReader.lengthOfLinesReader("src/main/resources/levels/testLevel.txt"));
	}

	/**
	 * This method checks if the lengthreader doesn't give back random numbers.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test
	public void testLengthOfLinesReaderGivesFalseResult() throws Exception {
		assertFalse(MapReader.lengthOfLinesReader("src/main/resources/levels/testLevel.txt") == 2);
	}

	/**
	 * This method checks if the length reader throws an exception when
	 * occurred.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test(expected = Exception.class)
	public void testLengthOfLinesReaderThrowsException() throws Exception {
		MapReader.lengthOfLinesReader("wrongfilename.txt");
	}

	/**
	 * THis method checks if the gameMapReader doesn't return a null.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test
	public void testGameMapReaderIsNotNull() throws Exception {
		assertNotNull(MapReader.gameMapReader("src/main/resources/levels/testLevel.txt"));
	}

	/**
	 * This method checks if the gameMapReader returns a correct result.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test
	public void testGameMapReaderGivesCorrectResult() throws Exception {
		ArrayList<String> alInformation = new ArrayList<String>();
		alInformation.add("3");
		alInformation.add("3");
		alInformation.add("XXX");
		alInformation.add("X X");
		alInformation.add("XXX");
		assertEquals(alInformation, 
				MapReader.gameMapReader("src/main/resources/levels/testLevel.txt"));
	}

	/**
	 * This method checks if the gameMapReader doesn't return random values.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test
	public void testGameMapReaderGivesFalseResult() throws Exception {
		ArrayList<String> alInformation = new ArrayList<String>();
		alInformation.add("3");
		alInformation.add("3");
		alInformation.add("XXX");
		alInformation.add("XX");
		alInformation.add("XXX");
		assertFalse(alInformation 
				== MapReader.gameMapReader("src/main/resources/levels/testLevel.txt"));
	}

	/**
	 * This method checks if an exception is thrown when occurred.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test(expected = Exception.class)
	public void testGameMapReaderThrowsException() throws Exception {
		MapReader.gameMapReader("wrongfilename.txt");
	}

	/**
	 * This method tests if the method doesn't return a null value.
	 */
	@Test
	public void testGetCharBoardGivesSomething() {
		ArrayList<String> alList = new ArrayList<String>();
		alList.add("0");
		alList.add("0");
		assertNotNull(MapReader.getCharBoard(alList));
	}

	/**
	 * This test checks if the GetCharBoard method can read a character.
	 */
	@Test
	public void testGetCharBoardReadsACharacter() {
		ArrayList<String> alList = new ArrayList<String>();
		alList.add("1");
		alList.add("1");
		alList.add("a");
		char[][] cMap = MapReader.getCharBoard(alList);
		assertEquals('a', cMap[0][0]);
	}

	/**
	 * This test checks if the GetCharBoard method can read multiple lines.
	 */
	@Test
	public void testGetCharBoardReadsMultipleLines() {
		ArrayList<String> alList = new ArrayList<String>();
		alList.add("2");
		alList.add("1");
		alList.add("a");
		alList.add("b");
		char[][] cMap = MapReader.getCharBoard(alList);
		char[][] cTest = new char[2][1];
		cTest[0][0] = 'a';
		cTest[1][0] = 'b';
		assertEquals(cTest[0][0], cMap[0][0]);
		assertEquals(cTest[1][0], cMap[1][0]);
	}

	/**
	 * This test checks if the GetCharBoard method can read multiple lines and
	 * characters.
	 */
	@Test
	public void testGetCharBoardReadsMultipleLinesAndMultipleCharacters() {
		ArrayList<String> alList = new ArrayList<String>();
		alList.add("2");
		alList.add("3");
		alList.add("aaa");
		alList.add("bcc");
		char[][] cMap = MapReader.getCharBoard(alList);
		char[][] cTest = new char[AMOUNT_OF_LINES_TEST_FILE + 1][LENGTH_OF_LINES_TEST_FILE];
		cTest[0][0] = 'a';
		cTest[0][1] = 'a';
		cTest[0][2] = 'a';
		cTest[1][0] = 'b';
		cTest[1][1] = 'c';
		cTest[1][2] = 'c';
		assertEquals(cTest[0][0], cMap[0][0]);
		assertEquals(cTest[0][1], cMap[0][1]);
		assertEquals(cTest[0][2], cMap[0][2]);
		assertEquals(cTest[1][0], cMap[1][0]);
		assertEquals(cTest[1][1], cMap[1][1]);
		assertEquals(cTest[1][2], cMap[1][2]);
	}

	/**
	 * This method checks if an exception is thrown when handling the wrong
	 * filename.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test(expected = Exception.class)
	public void testCreateMapThrowsException() throws Exception {
		MapReader.createMap("wrongfilename.txt");
	}

	/**
	 * This test checks if the CreateMap method returns a correct board.
	 * 
	 * @throws Exception
	 *             - Throws an Exception if the filename is wrong.
	 */
	@Test
	public void testCreateMapReturnsCorrectCharBoard() throws Exception {
		char[][] cMap = MapReader.createMap("src/main/resources/levels/testLevel.txt");
		char[][] cTest = new char[AMOUNT_OF_LINES_TEST_FILE][LENGTH_OF_LINES_TEST_FILE];
		cTest[0][0] = 'X';
		cTest[0][1] = 'X';
		cTest[0][2] = 'X';
		cTest[1][0] = 'X';
		cTest[1][1] = ' ';
		cTest[1][2] = 'X';
		cTest[2][0] = 'X';
		cTest[2][1] = 'X';
		cTest[2][2] = 'X';
		assertEquals(cTest[0][0], cMap[0][0]);
		assertEquals(cTest[0][1], cMap[0][1]);
		assertEquals(cTest[0][2], cMap[0][2]);
		assertEquals(cTest[1][0], cMap[1][0]);
		assertEquals(cTest[1][1], cMap[1][1]);
		assertEquals(cTest[1][2], cMap[1][2]);
		assertEquals(cTest[2][0], cMap[2][0]);
		assertEquals(cTest[2][1], cMap[2][1]);
		assertEquals(cTest[2][2], cMap[2][2]);
	}
}