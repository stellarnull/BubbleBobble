package org.group17.Units;


import static org.junit.Assert.assertTrue;

import org.group17.Map.GameMap;
import org.group17.Math.Vector;
import org.junit.Test;

/**
 * This class tests the PowerUpMovement interface.
 * 
 * @author Ludwig
 *
 */
public class TestPowerUpMovement {
	
	private GameMap testMap = new GameMap();
	private Player testPlayer = new Player(new Vector(0, 0), this.testMap);
	
	/**
	 * Tests if using the PowerUpMovement interface multiplies with 1.5 indeed.
	 */
	@Test
	public void testMove() {
		this.testPlayer.setInvulnerableTime(System.currentTimeMillis() + 12000);
		this.testPlayer.getSpeed().setX(1);
		this.testPlayer.setMoveBehaviour(new PowerUpMovement());
		this.testPlayer.move(1);
		double place = this.testPlayer.getLocation().getX();
		assertTrue(1.5 == place);
	}
}
