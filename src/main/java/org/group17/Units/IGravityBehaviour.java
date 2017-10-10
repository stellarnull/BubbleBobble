package org.group17.Units;

/**
 * This behaviour defines how the entity should be effected by gravity.
 * 
 * @author rob
 *
 */
public interface IGravityBehaviour {
	/**
	 * Applies the gravity.
	 * 
	 * @param dTimePerFrame
	 *            - The time since the last frame(see also GravityHook).
	 * @param eE
	 *            - The Entity for which this behaviour applies.
	 */
	void apply(double dTimePerFrame, Entity eE);
}