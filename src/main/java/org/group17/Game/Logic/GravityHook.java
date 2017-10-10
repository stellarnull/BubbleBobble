package org.group17.Game.Logic;

import org.group17.Map.GameMap;
import org.group17.Units.Entity;

/**
 * This GravityHook takes care of gravity in the game.
 * 
 * @author rob
 *
 */
public class GravityHook implements IGameHook {

	/**
	 * {@inheritDoc}
	 */
	public void onEachIteration(GameMap gmMap, double dTimePerFrame) {
		for (Entity eE : gmMap.getEntityList()) {
			eE.applyGravity(dTimePerFrame);
		}
	}
}