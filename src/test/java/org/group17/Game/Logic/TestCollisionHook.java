package org.group17.Game.Logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.group17.Map.GameMap;
import org.group17.Math.Vector;
import org.group17.Units.Player;
import org.group17.Units.Wall;
import org.group17.Units.Enemy;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the collision hook class.
 * 
 * @author Rob
 *
 */
public class TestCollisionHook {

	private CollisionHook ch;
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
		this.ch = new CollisionHook();
		this.gmMap = new GameMap();
		this.pPlayer = new Player(new Vector(0, 0), this.gmMap);
	}
	
	/**
	 * This is a test method test.
	 */
	@Test
	public void testNotCollisionWallTrue() {
		Wall wall = new Wall(new Vector(0, 0), this.gmMap);
		this.gmMap.add(this.pPlayer);
		this.gmMap.add(wall);
		this.ch.onEachIteration(this.gmMap, 1);
		assertEquals(true, this.pPlayer.collidesWith(wall));
	}

	/**
	 * Tests if the collision with wall gives false.
	 */
	@Test
	public void testNotCollisionWallFalse() {
		Wall wall = new Wall(new Vector(0.75, 0), this.gmMap);
		this.gmMap.add(this.pPlayer);
		this.gmMap.add(wall);
		this.ch.onEachIteration(this.gmMap, 1);
		assertFalse(this.pPlayer.collidesWith(wall));
		assertEquals(wall.getLocation(), new Vector(0.75, 0));
	}

	/**
	 * Tests if a collision can be seen with an entity.
	 */
	@Test
	public void testCollisionEntity() {
		Enemy enemy = new Enemy(new Vector(0, 0), this.gmMap);
		this.gmMap.add(this.pPlayer);
		this.gmMap.add(enemy);
		this.ch.onEachIteration(this.gmMap, 1);
		assertEquals(true, this.pPlayer.collidesWith(enemy));
	}

	/**
	 * Tests if the collision with entity can be false.
	 */
	@Test
	public void testCollisionEntityFalse() {
		Enemy enemy = new Enemy(new Vector(0.75, 0), this.gmMap);
		this.gmMap.add(this.pPlayer);
		this.gmMap.add(enemy);
		this.ch.onEachIteration(this.gmMap, 1);
		assertFalse(this.pPlayer.collidesWith(enemy));
		assertEquals(enemy.getLocation(), new Vector(0.75, 0));
	}
}