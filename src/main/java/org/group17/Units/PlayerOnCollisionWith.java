package org.group17.Units;

/**
 * Collision behaviour for the player.
 * @author Cas
 *
 */
public class PlayerOnCollisionWith implements IOnCollisionWith {

	/**
	 * {@inheritDoc}
	 */
	public void onCollisionWith(GameObject goThis, GameObject goOther) {
		if (goOther.getClass().equals(Enemy.class)
				&& ((Enemy) goOther).getInBubble()) {
			((Player) goThis).addPoints(10);
		}

		if (goOther.getClass().equals(Enemy.class)
				&& ((Player) goThis).getInvulnerableTime() - System.currentTimeMillis() <= 0
				&& !((Enemy) goOther).getInBubble()) {
			((Player) goThis).setLives(((Player) goThis).getLives() - 1);
			((Player) goThis).setInvulnerableTime(System.currentTimeMillis() + 3000);
		}
		
		if (goOther.getClass().equals(Bubble.class)) {
			((Player) goThis).setInvulnerableTime(System.currentTimeMillis() + 12000);
			((Player) goThis).setMoveBehaviour(new PowerUpMovement());
		}
	}
}