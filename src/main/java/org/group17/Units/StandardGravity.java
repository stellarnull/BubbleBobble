package org.group17.Units;

import org.group17.Math.Vector;

/**
 * The default gravity behaviour for entities.
 * 
 * @author rob
 *
 */
public class StandardGravity implements IGravityBehaviour {
	private static final Vector V_GRAVITY = new Vector(0, -15);

	/**
	 * {@inheritDoc}
	 */
	public void apply(double dTimePerFrame, Entity eE) {
		if (!this.checkIfInWallTreshold(eE)) {
			eE.getSpeed().addLocal(V_GRAVITY.multiply(dTimePerFrame));
		} else if (eE.getSpeed().getY() < 0) {
			eE.getSpeed().setY(0);
		}
	}

	/**
	 * This method checks if the Entity is too close to the wall.
	 * 
	 * @param eE
	 *            - The Entity.
	 * @return boolean - True if it is not too close to the wall, else false.
	 */
	private boolean checkIfInWallTreshold(Entity eE) {
		for (Wall wW : eE.getMap().getWallList()) {
			if (wW.isInThreshold(eE)) {
				return true;
			}
		}
		return false;
	}
}