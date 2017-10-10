package org.group17.Units;

import java.awt.Image;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import javax.imageio.ImageIO;
import org.junit.Before;
import org.junit.Test;
import org.group17.Map.GameMap;
import org.group17.Math.Vector;

/**
 * This class tests the Player class.
 * 
 * @author Cas
 *
 */
public class TestPlayer extends AbstractTestGameObject {

	private Player testPlayer;
	private GameMap testMap = getGameMapTest();

	/**
	 * Constructor to choose which class in the AbstractTestGameObject.
	 */
	public TestPlayer() {
		super(TestClass.PLAYER);
	}

	/**
	 * This set ups everything for the tests.
	 */
	@Before
	public void setUp() {
		this.testPlayer = new Player(new Vector(0, 0), this.testMap);
		this.testMap.add(getGameObjectTest());
		}

	/**
	 * This test checks if GetImage actually returns something.
	 * 
	 * @throws Exception
	 *             - Throws an exception (Won't occur) when the file can't be
	 *             found.
	 */
	@Test
	public void testGetImageReturnsSomething() throws Exception {
		assertNotNull(this.testPlayer.getImage());
	}

	/**
	 * This test checks if GetImage actually returns the left image when it is
	 * needed.
	 * 
	 * @throws Exception
	 *             - Throws an exception (Won't occur) when the file can't be
	 *             found.
	 */
	@Test
	public void testGetImageReturnsLeft() throws Exception {
		Player p = new Player(new Vector(0, 0), this.testMap);
		p.setSpeed(new Vector(-1, -1));
		Image im = ImageIO.read(Player.class.
				getResourceAsStream(p.getConstants().getImageOfPlayerLookingRight()));
		assertTrue(im.getAccelerationPriority() == p.getImage().getAccelerationPriority());
	}

	/**
	 * This test checks if the PlayerConstructor assigns the right values.
	 */
	@Test
	public void testPlayerConstructor() {
		assertEquals(0, this.testPlayer.getPoints());
	}

	/**
	 * This test checks if points can be added to a player.
	 */
	@Test
	public void testAddPoints() {
		this.testPlayer.addPoints(10);
		assertEquals(10, this.testPlayer.getPoints());
	}

	/**
	 * This test checks if the default points value is returned.
	 */
	@Test
	public void testGetPoints() {
		assertEquals(0, this.testPlayer.getPoints());
	}
	/**
	 * This test checks if the default number of lives is returned.
	 */
	@Test
	public void testGetLives() {
		assertEquals(3, this.testPlayer.getLives());
	}
}