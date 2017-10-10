package org.group17.Units;

/**
 * Interface for the move behaviour of entities.
 * 
 * @author Cas
 *
 */
public interface IMoveBehaviour {

	/**
	 * Method to let an entity move.
	 * 
	 * @param eE
	 *            - Entity to perform the movement on.
	 * @param dTimePerFrame
	 *            - The time per frame.
	 */
	void move(Entity eE, double dTimePerFrame);
}