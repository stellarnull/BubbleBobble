package org.group17.Units;

/**
 * Collision behaviour for the enemy.
 * @author Cas
 *
 */
public class EnemyOnCollisionWith implements IOnCollisionWith {
	
	private double dTimeEnemyIsBubbled = 7000;
	
	/**
	 * {@inheritDoc}
	 */
	public void onCollisionWith(GameObject goThis, GameObject goOther) {
		if (goOther instanceof Bubble) {
			((Enemy) goThis).beBubbled();
			((Enemy) goThis).setTimeInBubble(System.currentTimeMillis() 
					+ this.dTimeEnemyIsBubbled);
		} else {
			((Enemy) goThis).getSpeed().setX(-((Enemy) goThis).getSpeed().getX());
			if (goOther instanceof Player && ((Enemy) goThis).getInBubble()) {
				((Enemy) goThis).getMap().remove(((Enemy) goThis));
			}
		}
	}
}