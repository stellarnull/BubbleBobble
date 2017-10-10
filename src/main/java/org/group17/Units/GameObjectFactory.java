package org.group17.Units;

import org.group17.Map.GameMap;
import org.group17.Math.Vector;

/**
 * This factory makes gameObjects based on a selector.
 * 
 * @author rob
 *
 */
public final class GameObjectFactory {

	private GameObjectFactory() {

	}

	/**
	 * creates a GameObject based on a selector char.
	 * 
	 * @param cSelector
	 *            - the selector for the subclass of GameObject.
	 * @param iX
	 *            - the x coordinate.
	 * @param iY
	 *            - the y coordinate.
	 * @param gmMap
	 *            - the corresponding GameMap.
	 * @param iHeight
	 *            - the height of the map. Needed for coordinates.
	 * @return - A GameObject of the specified type or null.
	 */
	public static GameObject create(char cSelector, int iX, int iY, GameMap gmMap, int iHeight) {
		float fX = iX;
		float fY = iY;
		switch (cSelector) {
		case 'X':
			return new Wall(new Vector(fX + 0.5f, iHeight - fY - 0.5f), gmMap);
		case 'F':
			return new Floor(new Vector(fX + 0.5f, iHeight - fY - 0.5f), gmMap);
		case ' ':
			return null;
		case 'P':
			return new Player(new Vector(fX + 0.5f, iHeight - fY - 0.5f), gmMap);
		case 'E':
			return new Enemy(new Vector(fX + 0.5f, iHeight - fY - 0.5f), gmMap);
		case 'S':
			return new StarPowerUp(new Vector(fX + 0.5f, iHeight - fY - 0.5f), gmMap);
		default:
			return null;
		}
	}
}