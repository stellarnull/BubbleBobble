package org.group17.Units;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class to test the GameObjectFactory.
 * @author Cas
 *
 */
public class TestGameObjectFactory {

	/**
	 * Tests if the enemy is created.
	 */
	@Test
	public void testEnemy() {
		GameObject goGameObject = GameObjectFactory.create('E', 0, 0, null, 1);
		assertEquals(goGameObject.getClass(), Enemy.class);
	}

	/**
	 * Tests if the player is created.
	 */
	@Test
	public void testPlayer() {
		GameObject goGameObject = GameObjectFactory.create('P', 0, 0, null, 1);
		assertEquals(goGameObject.getClass(), Player.class);
	}

	/**
	 * Tests if the wall is created.
	 */
	@Test
	public void testWall() {
		GameObject goGameObject = GameObjectFactory.create('X', 0, 0, null, 1);
		assertEquals(goGameObject.getClass(), Wall.class);
	}

	/**
	 * Tests if the floor is created.
	 */
	@Test
	public void testFloor() {
		GameObject goGameObject = GameObjectFactory.create('F', 0, 0, null, 1);
		assertEquals(goGameObject.getClass(), Floor.class);
	}
	
	/**
	 * Tests if the empty is gotten.
	 */
	@Test
	public void testEmpty() {
		GameObject goGameObject = GameObjectFactory.create(' ', 0, 0, null, 1);
		assertEquals(goGameObject, null);		
	}
}
