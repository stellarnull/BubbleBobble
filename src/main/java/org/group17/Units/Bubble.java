package org.group17.Units;

import java.awt.Image;
import javax.imageio.ImageIO;
import org.group17.Math.Vector;
import org.group17.Map.GameMap;

/**
 * A class to create a bubble the player can shoot.
 * 
 * @author Cas
 *
 */
public class Bubble extends Entity {

	private double dTimeOfExistenceCountDown;

	/**
	 * Constructor.
	 * 
	 * @param vLocation
	 *            - Vector of the location of the bubble.
	 * @param gmMap
	 *            - The game map.
	 * @param vSpeed
	 *            - The speed of the bubble.
	 */
	public Bubble(Vector vLocation, GameMap gmMap, Vector vSpeed) {
		super(vLocation, gmMap, new StandardMovement(), new BubbleGravity(), 
				new BubbleOnCollisionWith());
		this.dTimeOfExistenceCountDown = System.currentTimeMillis() + 10000;
		this.setSpeed(vSpeed);
	}

	@Override
	public Image getImage() throws Exception {
		return ImageIO.read(Wall.class.getResourceAsStream(getConstants()
				.getImageOfBubble()));
	}

	/**
	 * Method to get the time existence of the bubble.
	 * 
	 * @return this.dTimeOfExistenceCountDown - Integer value for the bubble's
	 *         existing time.
	 */
	public double getTimeOfExistenceCountDown() {
		return this.dTimeOfExistenceCountDown;
	}

	/**
	 * Method to set the time existence of the bubble.
	 * 
	 * @param dTimeOfExistenceCountDown
	 *            - Integer value to set the existence time.
	 */
	public void setTimeOfExistenceCountDown(double dTimeOfExistenceCountDown) {
		this.dTimeOfExistenceCountDown = dTimeOfExistenceCountDown;
	}
}