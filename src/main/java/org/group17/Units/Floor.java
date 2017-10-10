package org.group17.Units;

import org.group17.Math.Vector;
import org.group17.Map.GameMap;

/**
 * A wall, except you can jump to the bottom.
 * 
 * @author rob
 *
 */
public class Floor extends Wall {
	
	/**
	 * Just a constructor which runs the same as Wall(vLocation,gmMap).
	 * 
	 * @param vLocation
	 *            - Location of the Floor in the GameMap.
	 * @param gmMap
	 *            - The corresponding GameMap.
	 */
	public Floor(Vector vLocation, GameMap gmMap) {
		super(vLocation, gmMap);
	}
}