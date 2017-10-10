package org.group17.Game.Logic;

import org.group17.Map.GameMap;
import org.group17.Units.Enemy;
import org.group17.Units.Entity;

/**
 * This hook ensures all entities move with their speeds.
 * 
 * @author rob
 *
 */
public class MoveHook implements IGameHook {

	/**
	 * {@inheritDoc}
	 */
	public void onEachIteration(GameMap gmMap, double dTimePerFrame) {
		for (Entity eE : gmMap.getEntityList()) {
			if (eE instanceof Enemy && ((Enemy) eE).getInBubble()) {
				eE.getSpeed().setX(0);
			}
			eE.move(dTimePerFrame);
		}
	}
}