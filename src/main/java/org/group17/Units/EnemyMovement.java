package org.group17.Units;

/**
 * This class specifies the standard movement behaviour for an enemy.
 * 
 * @author Cas
 *
 */
public class EnemyMovement implements IMoveBehaviour {

	private final double dMaxXSpeed = 3;

	/**
	 * {@inheritDoc}
	 */
	public void move(Entity eE, double dTimePerFrame) {
		eE.getLocation().addLocal(eE.getSpeed().multiply(dTimePerFrame));
		accelerate(eE);
	}

	/**
	 * Method for the player to speed-up. The enemy increases its speed until a
	 * maximum speed value
	 * 
	 * @param eE
	 *            - The entity who's speed wil be accelerated.
	 */
	public void accelerate(Entity eE) {
		if (Math.abs(eE.getSpeed().getX() * 1.25) <= this.dMaxXSpeed) {
			eE.getSpeed().setX(eE.getSpeed().getX() * 1.25);
		}
	}
}