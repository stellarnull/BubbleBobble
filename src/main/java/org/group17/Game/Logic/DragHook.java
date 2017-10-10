package org.group17.Game.Logic;

import org.group17.Map.GameMap;
import org.group17.Units.Entity;

/**
 * This DragHook takes care of the speed in the game.
 * 
 * @author Rob
 * 
 */
public class DragHook implements IGameHook {
	private static final double D_DRAGCONSTANT = 0.9;

	/**
	 * {@inheritDoc}
	 */
	public void onEachIteration(GameMap gmMap, double dTimePerFrame) {
		for (Entity e : gmMap.getEntityList()) {
			e.getSpeed().multiplyLocal((1 - dTimePerFrame) * D_DRAGCONSTANT);
		}
	}
}