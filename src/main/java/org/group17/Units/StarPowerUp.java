package org.group17.Units;

import java.awt.Image;

import javax.imageio.ImageIO;

import org.group17.Map.GameMap;
import org.group17.Math.Vector;

/**
 * A star power-up, which gives extra speed and makes the player invulnerable.
 * 
 * @author rob
 *
 */
public class StarPowerUp extends Entity {

	/***
	 * Constructor for StarPowerUp.
	 * 
	 * @param vLocation
	 *            - The location of the power up in the map.
	 * @param gmMap
	 *            = The game map.
	 */
	public StarPowerUp(Vector vLocation, GameMap gmMap) {
		super(vLocation, gmMap, new StandardMovement(), new StandardGravity(), 
				new PowerUpOnCollisionWith());
	}

	@Override
	public Image getImage() throws Exception {
		return ImageIO.read(StarPowerUp.class
				.getResourceAsStream(getConstants().getImageOfStar()));
	}
}