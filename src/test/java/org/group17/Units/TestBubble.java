package org.group17.Units;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.group17.Map.GameMap;
import org.group17.Math.Vector;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * This Class tests the Bubble Class.
 * @author Cas
 *
 */
public class TestBubble extends AbstractTestGameObject {

	private Bubble testBubble;
	private GameMap testMap = new GameMap();
	
	/**
	 * Constructor to choose which class in the AbstractTestGameObject.
	 */
	public TestBubble() {
		super(TestClass.BUBBLE);
	}
	
	/**
	 * Preparing tests.
	 */
	@Before
	public void setUp() {
		this.testBubble = new Bubble(new Vector(0, 0), this.testMap, new Vector(0.0, 0.0));
		this.testMap.add(this.testBubble);
	}
	
	/**
	 * This test checks if the constructor superclass variables are instantiated.
	 */
	@Test
	public void testConstructorSuperClass() {
		assertTrue(this.testBubble.getLocation().getX() == 0
				&& this.testBubble.getLocation().getY() == 0);
		assertTrue(this.testBubble.getMap().equals(this.testMap));
	}
	
	/**
	 * This test checks if the existencetime of the bubble is instantiated.
	 */
	@Test
	public void testConstructorTimeOfExistenceVariable() {
		assertTrue((this.testBubble.getTimeOfExistenceCountDown() 
				- (System.currentTimeMillis() + 10000)) < 5000);
	}
	
	/**
	 * This test checks if the getimage actually returns something.
	 * @throws Exception
	 *             - If the picture can't be loaded (Won't happen), an
	 *             IOException is thrown.
	 */
	@Test
	public void testGetImageReturnsSomething() throws Exception {
		assertNotNull(this.testBubble.getImage());
	}
	
	/**
	 * This test checks if you can set the time of existence.
	 */
	@Test
	public void testSetTimeOfExistence() {
		this.testBubble.setTimeOfExistenceCountDown(5);
		assertTrue(5 == this.testBubble.getTimeOfExistenceCountDown());
	}
	
	/**
	 * Tests if the bubble gets removed when colliding with enemy.
	 */
	@Test
	public void testOnCollisionWith() {
		this.testBubble.onCollisionWith(new Enemy(new Vector(0, 0), this.testMap));
		assertFalse(this.testMap.getEntityList().contains(this.testBubble));
	}
}