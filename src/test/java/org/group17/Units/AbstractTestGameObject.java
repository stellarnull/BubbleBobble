package org.group17.Units;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import org.group17.Map.GameMap;
import org.group17.Math.Vector;

/**
 * This test class is used to test all GameObjects.
 * 
 * @author Cas
 *
 */
public abstract class AbstractTestGameObject {

	/**
	 * For testing purposes, this field has to be set to the gameobject to be
	 * tested. gameObject.x and gameObject.y should be 0.
	 */
	private GameObject gameObject;

	/**
	 * The related map for this object.
	 */
	private GameMap testMap = new GameMap();

	/**
	 * TestClass om te beslissen welke klasse deze tests aanroept.
	 * 
	 * @author Cas
	 *
	 */
	public enum TestClass {
		WALL, FLOOR, PLAYER, ENEMY, BUBBLE
	}

	/**
	 * Returns the gameobject for tests.
	 * @return this.gameObject - The game object.
	 */
	public GameObject getGameObjectTest() {
		return this.gameObject;
	}

	/**
	 * Returns the testMap for tests of game objects.
	 * @return this.testMap - The test game map.
	 */
	public GameMap getGameMapTest() {
		return this.testMap;
	}

	/**
	 * Class to check which of the subclasses has to be tested.
	 * 
	 * @param testClass
	 *            - The type of the subclass
	 */
	public AbstractTestGameObject(TestClass testClass) {
		if (testClass == TestClass.WALL) {
			this.gameObject = new Wall(new Vector(0, 0), this.testMap);
		} else if (testClass == TestClass.PLAYER) {
			this.gameObject = new Player(new Vector(0, 0), this.testMap);
		} else if (testClass == TestClass.FLOOR) {
			this.gameObject = new Floor(new Vector(0, 0), this.testMap);
		}  else {
			this.gameObject = new Enemy(new Vector(0, 0), this.testMap);
		}
	}

	/**
	 * Tests if the testmap is set right.
	 */
	@Test
	public void testGetMap() {
		assertTrue(this.testMap == this.gameObject.getMap());
	}

	/**
	 * Tests if the map can be set correctly.
	 */
	@Test
	public void testSetMap() {
		GameMap gmMap = new GameMap();
		this.gameObject.setMap(gmMap);
		assertTrue(gmMap == this.gameObject.getMap());
	}

	/**
	 * Tests if the collisions give the right return.
	 */
	@Test
	public void testCollidesTrue() {
		assertTrue(this.gameObject.collidesWith(new Wall(new Vector(0, 0.8), this.testMap)));
		assertTrue(new Wall(new Vector(0, 0.8), this.testMap).collidesWith(this.gameObject));
	}

	/**
	 * Tests if the collision can fail on the X coord.
	 */
	@Test
	public void testCollidesFalseX() {
		assertTrue(this.gameObject.collidesWith(new Wall(new Vector(0, 0.8), this.testMap)));
		assertTrue(new Wall(new Vector(0, 0.8), this.testMap).collidesWith(this.gameObject));
	}

	/**
	 * Tests if the collision can fail on the Y coord.
	 */
	@Test
	public void testCollidesFalseY() {
		assertFalse(this.gameObject.collidesWith(new Wall(new Vector(1.2, 0), this.testMap)));
		assertFalse(new Wall(new Vector(1.2, 0), this.testMap).collidesWith(this.gameObject));
	}

	/**
	 * Tests if a new location can be set.
	 */
	@Test
	public void testSetLocation() {
		this.gameObject.setLocation(new Vector(10, 10));
		assertTrue(this.gameObject.getLocation().getX() == 10
				&& this.gameObject.getLocation().getY() == 10);
	}

	/**
	 * Tests collision with the floor.
	 */
	@Test
	public void testCollidesWithFloor() {
		assertFalse(this.gameObject.collidesWith(new Floor(new Vector(0, 0), this.testMap)));
	}
}