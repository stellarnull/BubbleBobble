package org.group17.Game.Logic;

import org.group17.Map.GameMap;
import org.group17.Units.Entity;
import org.group17.Units.Enemy;

/**
 * This class deals with if the enemy will be released from a bubble or not.
 * 
 * @author Cas
 *
 */
public class BubbleHook implements IGameHook {

	/**
	 * {@inheritDoc}
	 */
	public void onEachIteration(GameMap gmMap, double dTimePerFrame) {
		for (Entity eE : gmMap.getEntityList()) {
			if (eE.getClass().equals(Enemy.class)) {
				checkReleasement((Enemy) eE);
			}
		}
	}

	/**
	 * This method checks if an enemy has been enough time in the bubble and can
	 * be released.
	 * 
	 * @param enE
	 *            - The enemy.
	 */
	private void checkReleasement(Enemy enE) {
		double dEnemiesTimeInBubble = enE.getTimeInBubble();
		if (dEnemiesTimeInBubble - System.currentTimeMillis() <= 0 && enE.getInBubble()) {
			enE.getOutOfBubble();
			enE.getSpeed().setX(0.05);
		}
	}
}