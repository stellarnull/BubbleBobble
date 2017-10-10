package org.group17.Game.Logic;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Before;
import org.group17.Map.GameMap;
import org.group17.Math.Vector;
import org.group17.Units.Player;
import org.group17.Units.Entity;
import org.group17.Units.Bubble;
import org.group17.Units.Wall;

/**
 * This class tests the ControlHook class.
 * 
 * @author Cas
 *
 */
public class TestControlHook {

	private ControlHook ch;
	private GameMap gmMap;
	private Player pPlayer;

	/**
	 * Preparing setup.
	 * 
	 * @throws Exception
	 *             - When the level can't be read.
	 */
	@Before
	public void setUp() throws Exception {
		this.ch = new ControlHook();
		this.gmMap = new GameMap();
		this.pPlayer = new Player(new Vector(0.5, 0.9), this.gmMap);
	}

	/**
	 * Tests if the jump can be set.
	 */
	@Test
	public void testSetJump() {
		this.ch.setJump(true);
		assertTrue(this.ch.getJump());
	}

	/**
	 * Tests if the left can be set.
	 */
	@Test
	public void testSetLeft() {
		this.ch.setLeft(true);
		assertTrue(this.ch.getLeft());
	}

	/**
	 * Tests if the right can be set.
	 */
	@Test
	public void testSetRight() {
		this.ch.setRight(true);
		assertTrue(this.ch.getRight());
	}

	/**
	 * Tests if the bubble can be set.
	 */
	@Test
	public void testSetBubble() {
		this.ch.setBubble(true);
		assertTrue(this.ch.getBubble());
	}

	/**
	 * Tests if a player can jump.
	 */
	@Test
	public void testOnEachIterationJump() {
		this.ch.setJump(true);
		Wall wall = new Wall(new Vector(0, 0), this.gmMap);
		this.gmMap.add(this.pPlayer);
		this.gmMap.add(wall);
		this.ch.onEachIteration(this.gmMap, 100);
		assertFalse(0 == this.pPlayer.getSpeed().getY());
	}
	
	/**
	 * Tests if a player can jump.
	 */
	@Test
	public void testOnEachIterationJumpWallNotInTreshold() {
		this.ch.setJump(true);
		Wall wall = new Wall(new Vector(10, 10), this.gmMap);
		this.gmMap.add(this.pPlayer);
		this.gmMap.add(wall);
		this.ch.onEachIteration(this.gmMap, 100);
		assertTrue(0 == this.pPlayer.getSpeed().getY());
	}
	
	/**
	 * Tests if a player can jump.
	 */
	@Test
	public void testOnEachIterationJumpIsFalse() {
		this.ch.setJump(false);
		Wall wall = new Wall(new Vector(0, 0), this.gmMap);
		this.gmMap.add(this.pPlayer);
		this.gmMap.add(wall);
		this.ch.onEachIteration(this.gmMap, 100);
		assertTrue(0 == this.pPlayer.getSpeed().getY());
	}
	
	/**
	 * Tests if a player can jump.
	 */
	@Test
	public void testOnEachIterationJumpSpeedYNotNull() {
		this.ch.setJump(true);
		Wall wall = new Wall(new Vector(0, 0), this.gmMap);
		this.gmMap.add(this.pPlayer);
		this.gmMap.add(wall);
		this.pPlayer.getSpeed().setY(10);
		this.ch.onEachIteration(this.gmMap, 100);
		assertTrue(10 == this.pPlayer.getSpeed().getY());
	}
	
	/**
	 * Tests if the player can accelerate.
	 */
	@Test
	public void testAccelerateHorizontalLeft() {
		this.ch.setJump(true);
		this.gmMap.add(this.pPlayer);
		this.ch.setLeft(true);
		this.ch.setRight(false);
		this.ch.onEachIteration(this.gmMap, 100);
		assertTrue(0 != this.pPlayer.getSpeed().getX());
	}
	
	/**
	 * Tests if the player can accelerate.
	 */
	@Test
	public void testAccelerateHorizontalRight() {
		this.ch.setJump(true);
		this.gmMap.add(this.pPlayer);
		this.ch.setLeft(false);
		this.ch.setRight(true);
		this.ch.onEachIteration(this.gmMap, 100);
		assertTrue(0 != this.pPlayer.getSpeed().getX());
	}
	
	/**
	 * Tests if the player can accelerate.
	 */
	@Test
	public void testAccelerateHorizontalNoneAllTrue() {
		this.ch.setJump(true);
		this.gmMap.add(this.pPlayer);
		this.ch.setLeft(true);
		this.ch.setRight(true);
		this.ch.onEachIteration(this.gmMap, 100);
		assertTrue(0 == this.pPlayer.getSpeed().getX());
	}
	
	/**
	 * Tests if the player can accelerate.
	 */
	@Test
	public void testAccelerateHorizontalNoneAllFalse() {
		this.ch.setJump(true);
		this.gmMap.add(this.pPlayer);
		this.ch.setLeft(false);
		this.ch.setRight(false);
		this.ch.onEachIteration(this.gmMap, 100);
		assertTrue(0 == this.pPlayer.getSpeed().getX());
	}
	
	/**
	 * Test shooting bubble.
	 */
	@Test
	public void testBubblePlayerSpeedXHigherThanZero() {
		this.ch.setJump(true);
		this.gmMap.add(this.pPlayer);
		this.ch.setBubble(true);
		this.pPlayer.getSpeed().setX(1);
		this.ch.onEachIteration(this.gmMap, 100);
		Bubble bBubble = null;
		for (Entity eE : this.gmMap.getEntityList()) {
			if (eE.getClass().equals(Bubble.class)) {
				bBubble = (Bubble) eE;
			}
		}	
		assertTrue(bBubble.getSpeed().getX() > 0);
	}
	
	/**
	 * Test shooting bubble.
	 */
	@Test
	public void testBubblePlayerSpeedXLowerThanZero() {
		this.ch.setJump(true);
		this.gmMap.add(this.pPlayer);
		this.ch.setBubble(true);
		this.pPlayer.getSpeed().setX(-1);
		this.ch.onEachIteration(this.gmMap, 100);
		Bubble bBubble = null;
		for (Entity eE : this.gmMap.getEntityList()) {
			if (eE.getClass().equals(Bubble.class)) {
				bBubble = (Bubble) eE;
			}
		}
		assertTrue(bBubble.getSpeed().getX() < 0);
	}
	
	/**
	 * Test shooting bubble is false.
	 */
	@Test
	public void testBubbleFalse() {
		this.ch.setJump(true);
		this.gmMap.add(this.pPlayer);
		this.ch.setBubble(false);
		this.pPlayer.getSpeed().setX(-1);
		this.ch.onEachIteration(this.gmMap, 100);
		assertTrue(1 == this.gmMap.getEntityList().size());
	}
}