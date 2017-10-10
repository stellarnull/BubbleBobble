package org.group17.Units;

/**
 * Collision behaviour for the bubble.
 * @author Cas
 *
 */
public class BubbleOnCollisionWith implements IOnCollisionWith {
		
	/**
	 * {@inheritDoc}
	 */
	public void onCollisionWith(GameObject goThis, GameObject goOther) {
		((Bubble) goThis).getMap().remove(((Bubble) goThis));
	}
}