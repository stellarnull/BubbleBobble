package org.group17.Units;

import java.awt.Image;
import org.group17.Math.Vector;
import org.group17.Map.GameMap;
import org.group17.bubblebobble.Constants;

/**
 * This is the superclass of all space objects and entities in the game map.
 * 
 * @author rob
 *
 */
public abstract class GameObject {

	public static final float F_HALF_SIZE = 0.5f;
	private Vector vLocation;
	private GameMap gmMap;
	private static final float F_COLLIDING_TRESHOLD = 0.95f;
	private Constants cConstants = new Constants();

	/**
	 * Constructor for creating GameObjects.
	 * 
	 * @param vLocation
	 *            - The vector representation of the location of the object in
	 *            the map.
	 * @param gmMap
	 *            - The game map.
	 */
	public GameObject(Vector vLocation, GameMap gmMap) {
		this.vLocation = vLocation;
		this.gmMap = gmMap;
	}

	/**
	 * This method should return an image of the GameObject.
	 * 
	 * @return Image - Returns an image of the GameObject.
	 * @throws Exception
	 *             - Throws an Exception if the image can't be found.
	 */
	public abstract Image getImage() throws Exception;

	/**
	 * This method returns the location of the GameObject represented as a
	 * Vector.
	 * 
	 * @return vLocation - Vector representation of the location of the
	 *         GameObject in the map.
	 */
	public Vector getLocation() {
		return this.vLocation;
	}

	/**
	 * This method changes the location of the GameObject.
	 * 
	 * @param vLocation
	 *            - The location in Vector Representation.
	 */
	public void setLocation(Vector vLocation) {
		this.vLocation = vLocation;
		this.gmMap.getLog().write("player-position: " + this.vLocation.toString());
	}

	/**
	 * This method checks if there is a collision between two GameObjects.
	 * 
	 * @param goOther
	 *            - The other game object to check the collision with.
	 * @return boolean - Boolean value, true if collides, false if not.
	 */
	public boolean collidesWith(GameObject goOther) {
		if (goOther instanceof Floor) {
			return false;
		}
		Vector vDiff = vLocation.subtract(goOther.vLocation);
		if (vDiff.getX() >= F_COLLIDING_TRESHOLD
				|| vDiff.getX() <= -F_COLLIDING_TRESHOLD
				|| vDiff.getY() >= F_COLLIDING_TRESHOLD
				|| vDiff.getY() <= -F_COLLIDING_TRESHOLD) {

			return false;
		}

		this.gmMap.getLog().write("Collision of Game-Objects.");
		return true;
	}

	/**
	 * This method returns the Game Map.
	 * 
	 * @return this.gmMap - The Game Map.
	 */
	public GameMap getMap() {
		return this.gmMap;
	}

	/**
	 * This method sets the map.
	 * 
	 * @param gmMap
	 *            - Map.
	 */
	public void setMap(GameMap gmMap) {
		this.gmMap = gmMap;
	}
	
	/**
	 * Method to give back the constants object.
	 * @return this.sConstants - The constants object.
	 */
	public Constants getConstants() {
		return this.cConstants;
	}
}