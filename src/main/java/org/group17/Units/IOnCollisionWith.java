package org.group17.Units;

/**
 * Interface for the collision behaviour of entities.
 * 
 * @author Cas
 *
 */
public interface IOnCollisionWith {

	/**
	 * Method to execute onCollision behaviour with this entity.
	 * 
	 * @param goThis
	 *            - The game object that is colliding.
	 * @param goOther
	 *            - The game object it is colliding with.
	 */
	void onCollisionWith(GameObject goThis, GameObject goOther);
}