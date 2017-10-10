package org.group17.Game.Logic;

import org.group17.Map.GameMap;
import org.group17.Units.Entity;
import org.group17.Units.Wall;

/**
 * This CollisionHook takes care of the collisions in the game.
 * 
 * @author rob
 *
 */
public class CollisionHook implements IGameHook {

	/**
	 * {@inheritDoc}
	 */
	public void onEachIteration(GameMap gmMap, double dTimePerFrame) {
		for (Entity eE : gmMap.getEntityList()) {
			for (Entity eE2 : gmMap.getEntityList()) {			
				if (eE2 != eE && eE.collidesWith(eE2)) {
					eE.collideWith(eE2);
				}
			}
			for (Wall wW : gmMap.getWallList()) {
				if (eE.collidesWith(wW)) {
					eE.collideWith(wW);
				}
			}
		}
	}
}