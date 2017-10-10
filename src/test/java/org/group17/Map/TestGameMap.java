package org.group17.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import java.util.ArrayList;

import org.group17.Units.Entity;
import org.group17.Units.Wall;
import org.group17.Units.Player;
import org.group17.Math.Vector;

import org.junit.Test;

/**
 * This test class is used to test the GameMap class.
 * 
 * @author Cas
 *
 */
public class TestGameMap {

	private GameMap gmMap;

	/**
	 * This method prepares everything for the tests.
	 */
	@Before
	public void setup() {
		this.gmMap = new GameMap();
	}

	/**
	 * This test checks if the getImage() returns something else than null.
	 * 
	 * @throws Exception
	 *             - Exception is thrown when the image can not be made.
	 */
	@Test
	public void testGetImageReturnsSomething() throws Exception {
		assertNotNull(new GameMap().getImage());
	}

	/**
	 * This test checks if the getEntityList method returns the entity list.
	 */
	@Test
	public void testReturnEntityList() {
		assertEquals(new ArrayList<Entity>(), this.gmMap.getEntityList());
	}

	/**
	 * This test checks if the getWallList method returns the wall list.
	 */
	@Test
	public void testReturnWallList() {
		assertEquals(new ArrayList<Wall>(), this.gmMap.getWallList());
	}

	/**
	 * This test checks if the add method can really add a player.
	 */
	@Test
	public void testAddPlayer() {
		Player pPlayer = new Player(new Vector(0.0, 0.0), this.gmMap);
		ArrayList<Entity> alE = new ArrayList<Entity>();
		this.gmMap.add(pPlayer);
		alE.add(pPlayer);
		assertEquals(alE, this.gmMap.getEntityList());
	}

	/**
	 * This test checks if the add method can really add a wall.
	 */
	@Test
	public void testAddWall() {
		Wall wWall = new Wall(new Vector(0.0, 0.0), this.gmMap);
		ArrayList<Wall> alW = new ArrayList<Wall>();
		this.gmMap.add(wWall);
		alW.add(wWall);
		assertEquals(alW, this.gmMap.getWallList());
	}

	/**
	 * This test checks if the remove method can really remove a player from the
	 * entity list.
	 */
	@Test
	public void testRemove() {
		Player pPlayer = new Player(new Vector(0.0, 0.0), this.gmMap);
		this.gmMap.add(pPlayer);
		this.gmMap.remove(pPlayer);
		assertEquals(true, this.gmMap.getEntityList().isEmpty());
	}

	/**
	 * This test checks if the getPlayer method returns the value of
	 * this.pPlayer.
	 */
	@Test
	public void testGetPlayer() {
		assertEquals(null, this.gmMap.getPlayer());
	}
}