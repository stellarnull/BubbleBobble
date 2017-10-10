package org.group17.Units;

import org.group17.Math.Vector;

/**
 * The gravity behaviour for bubbles and bubbled entities.
 * 
 * @author rob
 *
 */
public class BubbleGravity implements IGravityBehaviour {
	private static final Vector V_GRAVITY = new Vector(0, 15);

	/**
	 * {@inheritDoc}
	 */
	public void apply(double dTimePerFrame, Entity eE) {
		eE.getSpeed().addLocal(V_GRAVITY.multiply(dTimePerFrame));
	}
}