package org.group17.Units;

/**
 * This class specifies the standard movement behaviour for a player.
 * 
 * @author Cas
 *
 */
public class StandardMovement implements IMoveBehaviour {

	/**
	 * {@inheritDoc}
	 */
	public void move(Entity eE, double dTimePerFrame) {
		eE.getLocation().addLocal(eE.getSpeed().multiply(dTimePerFrame));
	}
}