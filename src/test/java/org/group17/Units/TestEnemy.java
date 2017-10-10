package org.group17.Units;

import java.awt.Image;

import javax.imageio.ImageIO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import org.group17.Math.Vector;
import org.group17.Map.GameMap;

/**
 * This class tests the Enemy Class.
 * 
 * @author Cas
 *
 */
public class TestEnemy extends AbstractTestGameObject {

	private Enemy testEnemy;
	private Player testPlayer;
	private GameMap testMap = getGameMapTest();

	/**
	 * Constructor to choose which class in the AbstractTestGameObject.
	 */
	public TestEnemy() {
		super(TestClass.ENEMY);
	}

	/**
	 * Preparing tests.
	 */
	@Before
	public void setUp() {
		this.testEnemy = new Enemy(new Vector(0, 0), this.testMap);
		this.testPlayer = new Player(new Vector(0, 0), this.testMap);
		this.testMap.add(getGameObjectTest());
		this.testMap.add(this.testEnemy);
		this.testMap.add(this.testPlayer);
	}
	
	/**
	 * Tests if the move changes the X coordinate correctly.
	 */
	@Test
	public void testMoveEnemyXCoord() {
		this.testEnemy.getSpeed().setX(1);
		this.testEnemy.move(1);
		assertTrue(1 == this.testEnemy.getSpeed().getX());
	}
	
	/**
	 * Tests if the move changes the Y coordinate correctly.
	 */
	@Test
	public void testMoveEnemyYCoord() {
		this.testEnemy.getSpeed().setY(13);
		this.testEnemy.move(1);
		assertEquals(13, this.testEnemy.getSpeed().getY(), 0.0000001);
	}
	
	
	/**
	 * Tests if checkjump can be false on jump valid.
	 */
	@Test
	public void testCheckJumpFalseOnJumpValid() {
		this.testEnemy.getLocation().setY(7);
		this.testEnemy.checkAbove();
		assertFalse(13 == this.testEnemy.getSpeed().getY());
	}
	
	/**
	 * Tests if check above can return false.
	 */
	@Test
	public void testCheckAboveNotSameX() {
		this.testPlayer.getLocation().setX(5);
		this.testEnemy.checkAbove();
		assertFalse(this.testEnemy.getSameX());
	}
	
	/**
	 * Tests if check above can return false.
	 */
	@Test
	public void testCheckAboveSameX() {
		this.testPlayer.getLocation().setX(0);
		this.testEnemy.getLocation().setX(0);
		this.testEnemy.checkAbove();
		assertEquals(true, this.testEnemy.getSameX());
	}
	
	/**
	 * Tests if jump in range can return false.
	 */
	@Test
	public void testCheckAboveNotInJumpRange() {
		this.testPlayer.getLocation().setY(10);
		this.testEnemy.getLocation().setY(5);
		this.testEnemy.checkAbove();
		assertEquals(false, this.testEnemy.getInJumpRange());
	}
	
	/**
	 * Tests if jump in range can return true on zero boundary.
	 */
	@Test
	public void testCheckAboveInJumpRangeBoundaryZero() {
		this.testPlayer.getLocation().setY(1);
		this.testEnemy.getLocation().setY(1);
		this.testEnemy.checkAbove();
		assertEquals(true, this.testEnemy.getInJumpRange());
	}
	
	/**
	 * Tests if jump in range can return true on two point one boundary.
	 */
	@Test
	public void testCheckAboveInJumpRangeBoundaryTwoPointOne() {
		this.testPlayer.getLocation().setY(3.1);
		this.testEnemy.getLocation().setY(1);
		this.testEnemy.checkAbove();
		assertEquals(true, this.testEnemy.getInJumpRange());
	}
	
	/**
	 * Tests if jump valid can be true.
	 */
	@Test
	public void testCheckAboveJumpValid() {
		this.testEnemy.getLocation().setY(6.99999);
		this.testEnemy.checkAbove();
		assertTrue(this.testEnemy.getJumpValid());
	}
	
	/**
	 * Tests the boundary of 7 to let jump valid be false.
	 */
	@Test
	public void testCheckAboveJumpNotValid() {
		this.testEnemy.getLocation().setY(7);
		this.testEnemy.checkAbove();
		assertFalse(this.testEnemy.getJumpValid());
	}
	
	/**
	 * Tests if the Y coordinate is changed in the jump.
	 */
	@Test
	public void testJumpYCoord() {
		this.testEnemy.jump();
		assertTrue(13 == this.testEnemy.getSpeed().getY());
	}
	
	/**
	 * Tests if the X coordinate is changed in the jump.
	 */
	@Test
	public void testJumpXCoord() {
		this.testEnemy.jump();
		assertTrue(1 == this.testEnemy.getSpeed().getX());
	}
	
	/**
	 * This test checks if the constructor assigns the right boolean value.
	 */
	@Test
	public void testEnemyConstructor() {
		assertEquals(false, this.testEnemy.getInBubble());
	}

	/**
	 * This test checks if actually something is returned when the enemy is not
	 * in a bubble.
	 * 
	 * @throws Exception
	 *             - If the picture can't be loaded (Won't happen), an
	 *             IOException is thrown.
	 */
	@Test
	public void testGetImageNotInBubble() throws Exception {
		assertNotNull(this.testEnemy.getImage());
	}

	/**
	 * This test checks if actually something is returned when the enemy is in a
	 * bubble.
	 * 
	 * @throws Exception
	 *             - If the picture can't be loaded (Won't happen), an
	 *             IOException is thrown.
	 */
	@Test
	public void testGetImageInBubble() throws Exception {
		Enemy e = new Enemy(new Vector(0, 0), this.testMap);
		e.beBubbled();
		Image im = ImageIO.read(Enemy.class.getResourceAsStream("/pic/Bubble.png"));
		assertTrue(im.getAccelerationPriority() == e.getImage().getAccelerationPriority());
	}

	/**
	 * This test checks if the right boolean values are assigned.
	 */
	@Test
	public void testBeBubbledAssignsRightBooleanValues() {
		this.testEnemy.beBubbled();
		assertEquals(true, this.testEnemy.getInBubble());
	}

	/**
	 * This test checks if the start value is indeed False.
	 */
	@Test
	public void testGetInBubble() {
		assertFalse(this.testEnemy.getInBubble());
	}

	/**
	 * Tests if collision with bubble gets enemy enbubbled.
	 */
	@Test
	public void testOnCollisionWithBubble() {
		this.testEnemy.onCollisionWith(new Bubble(new Vector(0, 0), 
				this.testMap, new Vector(0, 0)));
		assertTrue(this.testEnemy.getInBubble());
	}
	
	/**
	 * Tests if the time for staying in a bubble is set.
	 */
	@Test
	public void testOnCollisionWithBubbleSetTimeInBubble() {
		this.testEnemy.onCollisionWith(new Bubble(new Vector(0, 0), 
				this.testMap, new Vector(0, 0)));
		assertTrue(this.testEnemy.getTimeInBubble() > System.currentTimeMillis());
	}

	/**
	 * Tests if collision with enemy lets enemy turn around.
	 */
	@Test
	public void testOnCollisionWithEnemy() {
		this.testEnemy.setSpeed(new Vector(1, 1));
		this.testEnemy.onCollisionWith(new Enemy(new Vector(0, 0), this.testMap));
		assertTrue(-1 == this.testEnemy.getSpeed().getX());
	}

	/**
	 * Tests if collision with player not in bubble does nothing to the enemy.
	 */
	@Test
	public void testOnCollisionWithPlayerNotInBubble() {
		this.testEnemy.onCollisionWith(new Player(new Vector(0, 0), this.testMap));
		assertEquals(true, this.testMap.getEntityList().contains(this.testEnemy));
	}

	/**
	 * Tests if collision with player and in bubble removes the enemy from the
	 * game map.
	 */
	@Test
	public void testOnCollisionWithPlayerInBubble() {
		this.testEnemy.beBubbled();
		this.testEnemy.onCollisionWith(new Player(new Vector(0, 0), this.testMap));
		assertFalse(this.testMap.getEntityList().contains(this.testEnemy));
	}
	
	/**
	 * Tests if the enemy can be released from a bubble.
	 */
	@Test
	public void testGetOutOfBubble() {
		this.testEnemy.beBubbled();
		this.testEnemy.getOutOfBubble();
		assertFalse(this.testEnemy.getInBubble());
	}
}