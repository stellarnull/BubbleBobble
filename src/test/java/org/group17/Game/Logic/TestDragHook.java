package org.group17.Game.Logic;

import static org.junit.Assert.assertTrue;

import org.group17.Map.GameMap;
import org.group17.Math.Vector;
import org.group17.Units.Player;
import org.junit.Test;

/**
 * This class tests the drag hook class.
 * @author Rob
 *
 */
public class TestDragHook {

	/**
	 * This is a test test method.
	 */
	@Test
	public void testDragHook() {
		GameMap gmMap = new GameMap();
		gmMap.add(new Player(new Vector(0, 0), gmMap));
		gmMap.getPlayer().setSpeed(new Vector(1.0, 0));
		DragHook dh = new DragHook();
		dh.onEachIteration(gmMap, 0.5);
		assertTrue(gmMap.getPlayer().getSpeed().getX() < 1);
		assertTrue(gmMap.getPlayer().getSpeed().getX() > 0);
	}
}