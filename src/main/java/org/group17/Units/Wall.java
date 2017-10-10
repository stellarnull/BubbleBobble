package org.group17.Units;

import java.awt.Image;
import javax.imageio.ImageIO;
import org.group17.Math.Vector;
import org.group17.Map.GameMap;

/**
 * This Class is for all the properties of a wall.
 * 
 * @author Cas
 *
 */
public class Wall extends GameObject {

	private static final float F_WALL_THRESHOLD_VERTICAL = 0.375f;
	private static final float F_WALL_THRESHOLD_HORIZONTAL = 0.9375f;

	/**
	 * A constructor for creating a wall. It uses the constructor from the
	 * superclass Entity.
	 * 
	 * @param vLocation
	 *            - A vector representation of the location of the wall in the map.
	 * @param gmMap
	 *            - A Representation of the GameMap.
	 */
	public Wall(Vector vLocation, GameMap gmMap) {
		super(vLocation, gmMap);
	}

	@Override
	public Image getImage() throws Exception {
		return ImageIO.read(Wall.class.getResourceAsStream(getConstants().getImageOfWall()));
	}

	/**
	 * Each wall has a small amount of space above itself where gravity is
	 * disabled. This is called the Threshold.
	 * 
	 * @param eOther
	 *            - Another instance of Entity.
	 * @return boolean - A boolean value that says if the Entity is in this
	 *         Threshold or not.
	 */
	public boolean isInThreshold(Entity eOther) {
		Vector vDiff = this.getLocation().subtract(eOther.getLocation());
		if (vDiff.getX() > F_WALL_THRESHOLD_HORIZONTAL
				|| vDiff.getX() < -F_WALL_THRESHOLD_HORIZONTAL
				|| vDiff.getY() > -1 + F_WALL_THRESHOLD_VERTICAL
				|| vDiff.getY() < -1 - F_WALL_THRESHOLD_VERTICAL) {
			return false;
		}

		if (eOther.getSpeed().getY() <= 0) {
			eOther.getLocation().setY(this.getLocation().getY() + 1);
		}
		return true;
	}
}