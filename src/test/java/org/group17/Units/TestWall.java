package org.group17.Units;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.group17.Map.GameMap;
import org.group17.Math.Vector;

/**
 * This class is used to test the Wall Class and the GameObject Class.
 * 
 * @author Cas
 *
 */
public class TestWall extends AbstractTestGameObject {

	private Wall testWall;
	private GameMap testMap = getGameMapTest();

	/**
	 * Constructor to choose which class in the AbstractTestGameObject.
	 */
	public TestWall() {
		super(TestClass.WALL);
	}

	/**
	 * The setup of the tests.
	 */
	@Before
	public void setUp() {
		this.testWall = new Wall(new Vector(0, 0), this.testMap);
		this.testMap.add(getGameObjectTest());
	}

	/**
	 * This method checks if actually something is given back when creating a
	 * new Wall object.
	 */
	@Test
	public void testWallConstructor() {
		assertNotNull(new Wall(new Vector(0, 0), this.testMap));
	}

	/**
	 * If you are between the Treshold values for X and Y, if true is returned.
	 */
	@Test
	public void testIsInTreshold() {
		assertEquals(true, this.testWall.isInThreshold(
				new Player(new Vector(0.5, 0.9), this.testMap)));
	}

	/**
	 * If you get above the X Treshold value, if false will be returned.
	 */
	@Test
	public void testIsInTresholdGivesFalseBiggerThanX() {
		assertEquals(false, this.testWall.isInThreshold(
				new Player(new Vector(-2, 0), this.testMap)));
	}

	/**
	 * If you get below the X Treshold value, if false will be returned.
	 */
	@Test
	public void testIsInTresholdGivesFalseSmallerThanX() {
		assertEquals(false, this.testWall.isInThreshold(
				new Player(new Vector(2, 0), this.testMap)));
	}

	/**
	 * If you get above the specified Y value, if false will be returned.
	 */
	@Test
	public void testIsInTresholdGivesFalseBiggerThanY() {
		assertEquals(false, this.testWall.isInThreshold(
				new Player(new Vector(0, -2), this.testMap)));
	}

	/**
	 * This test tests when you get under the specified Y value, if false will
	 * be returned.
	 */
	@Test
	public void testIsInTresholdGivesFalseSmallerThanY() {
		assertEquals(false, this.testWall.isInThreshold(
				new Player(new Vector(0, 2), this.testMap)));
	}

	/**
	 * This method checks if something is actually returned.
	 * 
	 * @throws Exception
	 *             - In case the image can't be read, an IOException is thrown.
	 */
	@Test
	public void testGetImage() throws Exception {
		assertNotNull(this.testWall.getImage());
	}

	/**
	 * This test checks the Set Location method from the GameObject class.
	 */
	@Test
	public void testSetLocation() {
		this.testWall.setLocation(new Vector(1.0, 1.0));
		assertEquals(new Vector(1.0, 1.0), this.testWall.getLocation());
	}

	/**
	 * This test checks if the CollidesWith method gives back the correct
	 * result, thus true.
	 */
	@Test
	public void testCollidesWithGivesCorrectResult() {
		assertEquals(true, this.testWall.collidesWith(
				new Wall(new Vector(0, 0), this.testMap)));
	}

	/**
	 * This method checks if the CollidesWith method returns false if the
	 * condition is not met.
	 */
	@Test
	public void testCollidesWithBiggerOrEqualsX() {
		assertEquals(false, this.testWall.collidesWith(
				new Wall(new Vector(1, 0), this.testMap)));
	}

	/**
	 * This method checks if the CollidesWith method returns false if the
	 * condition is not met.
	 */
	@Test
	public void testCollidesWithSmallerOrEqualsX() {
		assertEquals(false, this.testWall.collidesWith(
				new Wall(new Vector(-1, 0), this.testMap)));
	}

	/**
	 * This method checks if the CollidesWith method returns false if the
	 * condition is not met.
	 */
	@Test
	public void testCollidesWithBiggerOrEqualsY() {
		assertEquals(false, this.testWall.collidesWith(
				new Wall(new Vector(0, 1), this.testMap)));
	}

	/**
	 * This method checks if the CollidesWith method returns false if the
	 * condition is not met.
	 */
	@Test
	public void testCollidesWithSmallerOrEqualsY() {
		assertEquals(false, this.testWall.collidesWith(
				new Wall(new Vector(0, -1), this.testMap)));
	}
}