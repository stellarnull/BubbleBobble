package org.group17.Units;

import static org.junit.Assert.assertFalse;

import org.group17.Map.GameMap;
import org.group17.Math.Vector;
import org.junit.Test;

/**
 * This class tests the StarPowerUp class.
 * 
 * @author Ludwig
 *
 */
public class TestStarPowerUp {

	private GameMap testMap = new GameMap();
	private StarPowerUp testStar = new StarPowerUp(new Vector(0, 0), this.testMap);
	private Player testPlayer = new Player(new Vector(0, 0), this.testMap);
	
	/**
	 * Tests if collision with player makes start disappear.
	 */
	@Test
	public void testOnCollisionWithPlayer() {
		this.testStar.onCollisionWith(testPlayer);
		assertFalse(this.testMap.getEntityList().contains(this.testStar)); 
	}
}
