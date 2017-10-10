package org.group17.Game.Logic;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.group17.Map.GameMap;
import org.group17.Math.Vector;
import org.group17.Units.Enemy;
import org.group17.Units.Bubble;
import org.group17.Units.Wall;

/**
 * This class tests the GravityHook class.
 * 
 * @author Cas
 *
 */
public class TestGravityHook {

	private GravityHook gh;
	private GameMap gmMap;

	/**
	 * Preparing setup.
	 * 
	 * @throws Exception
	 *             - When the level can't be read.
	 */
	@Before
	public void setUp() throws Exception {
		this.gh = new GravityHook();
		this.gmMap = new GameMap();
	}

	/**
	 * Test if speed of bubble is not influenced.
	 */
	@Test
	public void testCheckGravityFalseEntityIsBubbleSpeedY() {
		Bubble bBubble = new Bubble(new Vector(0.5, 0.9), this.gmMap, new Vector(0.6, -1));
		Bubble bBubbleTest = new Bubble(new Vector(0.5, 0.9), this.gmMap, new Vector(0.6, -1));
		this.gmMap.add(bBubble);
		bBubbleTest.getSpeed().addLocal(new Vector(0, -15).multiply(-100));
		this.gh.onEachIteration(this.gmMap, 100);
		assertEquals(bBubbleTest.getSpeed().getY(), bBubble.getSpeed().getY(), 0.000000001);
	}

	/**
	 * Test if speed of bubble is being influenced.
	 */
	@Test
	public void testCheckGravityFalseEntityIsBubbleSpeedX() {
		Bubble bBubble = new Bubble(new Vector(0.5, 0.9), this.gmMap, new Vector(0.6, -1));
		Bubble bBubbleTest = new Bubble(new Vector(0.5, 0.9), this.gmMap, new Vector(0.6, -1));
		this.gmMap.add(bBubble);
		bBubbleTest.getSpeed().addLocal(new Vector(0, -15).multiply(-100));
		this.gh.onEachIteration(this.gmMap, 100);
		assertEquals(bBubbleTest.getSpeed().getX(), bBubble.getSpeed().getX(), 0.000000001);
	}

	/**
	 * Tests if speed of enemy is not influenced.
	 
	@Test
	public void testCheckGravityTrueEntityIsEnemyInWallTresholdSpeedYHigherThanZero() {
		Enemy eEnemy = new Enemy(new Vector(0.5, 0.9), this.gmMap);
		Wall wWall = new Wall(new Vector(0, 0), this.gmMap);
		eEnemy.setSpeed(new Vector(0.1, 0.2));
		gmMap.add(eEnemy);
		gmMap.add(wWall);
		this.gh.onEachIteration(this.gmMap, 100);
		assertEquals(0, eEnemy.getSpeed().getY(), 0.00000001);
	}
	*/

	/**
	 * Tests if speed of enemy is influenced.
	 */
	@Test
	public void testCheckGravityFalseEntityIsEnemyInWallTresholdSpeedYLowerThanZero() {
		Enemy eEnemy = new Enemy(new Vector(0.5, 0.9), this.gmMap);
		Wall wWall = new Wall(new Vector(0, 0), this.gmMap);
		eEnemy.setSpeed(new Vector(0.1, -0.2));
		gmMap.add(eEnemy);
		gmMap.add(wWall);
		this.gh.onEachIteration(gmMap, 100);
		assertTrue(0 == eEnemy.getSpeed().getY());
	}

	/**
	 * Tests if gravity is applied.
	 */
	@Test
	public void testCheckGravityTrue() {
		Enemy eEnemy = new Enemy(new Vector(0.5, 0.9), this.gmMap);
		Enemy eEnemyTest = new Enemy(new Vector(0.5, 0.9), this.gmMap);
		Wall wWall = new Wall(new Vector(10, 10), this.gmMap);
		eEnemy.setSpeed(new Vector(0.1, 0.2));
		eEnemyTest.setSpeed(new Vector(0.1, 0.2));
		this.gmMap.add(eEnemy);
		this.gmMap.add(wWall);
		this.gh.onEachIteration(this.gmMap, 100);
		eEnemyTest.getSpeed().add(new Vector(0, -8).multiply(100));
		assertTrue(eEnemyTest.getSpeed().equals(eEnemy.getSpeed()));
	}
}