package org.group17.Game;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * This class tests the Directione num class.
 * 
 * @author Cas
 *
 */
public class TestDirection {

	/**
	 * This method tests if all enum types exists.
	 */
	@Test
	public void test() {
		assertNotNull(Direction.DOWN);
		assertNotNull(Direction.RIGHT);
		assertNotNull(Direction.LEFT);
		assertNotNull(Direction.UP);
	}
}