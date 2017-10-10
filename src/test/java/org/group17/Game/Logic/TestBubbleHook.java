package org.group17.Game.Logic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.group17.Map.GameMap;
import org.group17.Math.Vector;
import org.group17.Units.Enemy;
import org.group17.Units.Bubble;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the collision hook class.
 * 
 * @author Rob
 *
 */
public class TestBubbleHook {

	private BubbleHook bh;
	private GameMap gmMap;
	private Enemy enEnemy;

	/**
	 * Preparing setup.
	 * 
	 * @throws Exception
	 *             - When the level can't be read.
	 */
	@Before
	public void setUp() throws Exception {
		this.bh = new BubbleHook();
		this.gmMap = new GameMap();
		this.enEnemy = new Enemy(new Vector(0, 0), this.gmMap);
		this.gmMap.add(this.enEnemy);
	}
	
	/**
	 * Tests if the checkreleasement is false when the time is not right.
	 */
	@Test
	public void testCheckReleasementFalseNotRighTime() {
		this.enEnemy.onCollisionWith(
				new Bubble(new Vector(0, 0), this.gmMap, new Vector(0, 0)));
		this.bh.onEachIteration(gmMap, 100);
		assertTrue(this.enEnemy.getInBubble());
	}
	
	/**
	 * Tests if checkreleasement is false when the enemy is not inside a bubble.
	 */
	@Test
	public void testCheckReleasementFalseNotInBubble() {
		this.enEnemy.onCollisionWith(
				new Bubble(new Vector(0, 0), this.gmMap, new Vector(0, 0)));
		
		try {
			Thread.sleep(8000);
		}
		catch (Exception e) {
			System.out.println("Something went wrong with a test");
		}
		
		this.bh.onEachIteration(gmMap, 100);
		this.enEnemy.getOutOfBubble();
		assertFalse(this.enEnemy.getInBubble());
	}
	
	/**
	 * Tests if checkreleasement is false when all conditions are false.
	 */
	@Test
	public void testCheckReleasementFalseOnBothConditions() {
		this.enEnemy.onCollisionWith(
				new Bubble(new Vector(0, 0), this.gmMap, new Vector(0, 0)));
		this.enEnemy.getOutOfBubble();
		this.bh.onEachIteration(gmMap, 100);
		assertFalse(0.05 == this.enEnemy.getSpeed().getX());
	}
	
	/**
	 * Tests if checkreleasement can be executed.
	 */
	@Test
	public void testCheckReleasementTrue() {
		this.enEnemy.onCollisionWith(
				new Bubble(new Vector(0, 0), this.gmMap, new Vector(0, 0)));
		
		try {
			Thread.sleep(8000);
		}
		catch (Exception e) {
			System.out.println("Something went wrong with a test");
		}
		
		this.bh.onEachIteration(gmMap, 100);
		assertFalse(this.enEnemy.getInBubble());
		assertTrue(0.05 == this.enEnemy.getSpeed().getX());
	}
}