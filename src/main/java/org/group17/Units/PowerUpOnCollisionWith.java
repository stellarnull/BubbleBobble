package org.group17.Units;

/**
 * Collision behaviour for the bubble.
 * 
 * @author Cas
 *
 */
public class PowerUpOnCollisionWith implements IOnCollisionWith {

	/**
	 * {@inheritDoc}
	 */
	public void onCollisionWith(GameObject goThis, GameObject goOther) {
		if (goOther.getClass() == Player.class) {
			((StarPowerUp) goThis).getMap().remove(((StarPowerUp) goThis));
		}
	}
}