package org.group17.Game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.group17.Units.Player;
import org.junit.Before;
import org.junit.Test;

/**
 * This test class tests the Game class.
 * 
 * @author Cas
 *
 */
public class TestGame {

	private Game gGame;

	/**
	 * Prepare the tests.
	 * 
	 * @throws Exception
	 *             - In case of the lvel can't be read.
	 */
	@Before
	public void setUp() throws Exception {
		this.gGame = new Game();
	}

	/**
	 * This test checks if the constructor sets the right values.
	 * 
	 * @throws Exception
	 *             - Throws an exception if the level can't be read.
	 */
	@Test
	public void testConstructor() throws Exception {
		assertEquals(false, this.gGame.getRunning());
		assertNotNull(this.gGame.getMap());
	}

	/**
	 * This test checks if the right score has been set.
	 */
	@Test
	public void testGetScore() {
		assertEquals(0, this.gGame.getScore());
	}

	/**
	 * Tests if the player can be retrieved.
	 */
	@Test
	public void testGetPlayer() {
		assertEquals(Player.class, this.gGame.getPlayer().getClass());
	}

	/**
	 * This test checks if the game starts.
	 */
	@Test
	public void testStart() {
		this.gGame.start();
		assertEquals(true, this.gGame.getRunning());
		this.gGame.stop();
		assertEquals(true, this.gGame.getThread().isAlive());
	}

	/**
	 * This test checks if the game stops.
	 */
	@Test
	public void testStop() {
		this.gGame.stop();
		assertEquals(false, this.gGame.getRunning());
	}

	/**
	 * Tests if an image can be retrieved.
	 * 
	 * @throws Exception
	 *             - Exception when image location can't be found.
	 */
	@Test
	public void testGetImage() throws Exception {
		assertNotNull(this.gGame.getImage());
	}
}