package org.group17.Units;

/**
 * Movement for when the player gets the star power up.
 * @author rob
 *
 */
public class PowerUpMovement implements IMoveBehaviour {
	private double dDuration = 12.0;
	private double dTime = 0;

	/**
	 * {@inheritDoc}
	 */
	public void move(Entity eE, double dTimePerFrame) {

		this.dTime = this.dTime + dTimePerFrame;

		if (this.dTime > this.dDuration) {
			eE.setMoveBehaviour(new StandardMovement());
		}
		eE.getLocation().addLocal(eE.getSpeed().multiply(1.5 * dTimePerFrame));
	}
}