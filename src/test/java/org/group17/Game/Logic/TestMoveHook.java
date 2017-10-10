package org.group17.Game.Logic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.group17.Map.GameMap;
import org.group17.Math.Vector;
import org.group17.Units.Player;

/**
 * This class tests the MoveHook class.
 * @author Cas
 *
 */
public class TestMoveHook {

	private MoveHook mh;
	private GameMap gmMap;

	/**
	 * Preparing setup.
	 * 
	 * @throws Exception
	 *             - When the level can't be read.
	 */
	@Before
	public void setUp() throws Exception {
		this.mh = new MoveHook();
		this.gmMap = new GameMap();
	}
	
	/**
	 * Tests OnEachIteration when only player is moving.
	 */
	@Test
	public void testMovementPlayer() {
		Player pPlayer = new Player(new Vector(0.5, 0.9), this.gmMap);
		Player pPlayerTest = new Player(new Vector(0.5, 0.9), this.gmMap);
		this.gmMap.add(pPlayer);
		this.mh.onEachIteration(this.gmMap, 100);
		pPlayerTest.getLocation().addLocal(pPlayerTest.getSpeed().multiply(100));
		assertEquals(pPlayer.getSpeed(), pPlayerTest.getSpeed());
	}
	
	/**
	 * Tests OnEachIteration when only enemy in bubble is moving.
	 
	@Test
	public void testMovementEnemyInBubble() {
		Enemy eEnemy = new Enemy(new Vector(0.5, 0.9), this.gmMap);
		eEnemy.beBubbled();
		Enemy eEnemyTest = new Enemy(new Vector(0.5, 0.9), this.gmMap);
		this.gmMap.add(eEnemy);
		this.mh.onEachIteration(this.gmMap, 100);
		eEnemyTest.getSpeed().setX(0);
		assertEquals(eEnemy.getSpeed().getX(), eEnemyTest.getSpeed().getX(), 0.0000000001);
	}
	*/
	/**
	 * Tests OnEachIteration when only enemy is moving.
	 
	@Test
	public void testMovementEnemy() {
		Enemy eEnemy = new Enemy(new Vector(0.5, 0.9), this.gmMap);
		Enemy eEnemyTest = new Enemy(new Vector(0.5, 0.9), this.gmMap);
		eEnemy.getSpeed().setX(2);
		eEnemyTest.getSpeed().setX(2);
		this.gmMap.add(eEnemy);
		this.mh.onEachIteration(this.gmMap, 100);
		eEnemyTest.move(100);
		assertEquals(eEnemy.getSpeed().getX(), eEnemyTest.getSpeed().getX(), 0.0000000001);
	}
	*/
}