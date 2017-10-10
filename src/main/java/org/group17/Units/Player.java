package org.group17.Units;

import java.awt.Image;
import javax.imageio.ImageIO;
import org.group17.Math.Vector;
import org.group17.Map.GameMap;

/**
 * This class defines what a player is capable of.
 * 
 * @author Cas
 *
 */
public class Player extends Entity {

	private int iScore;
	private int iLives;
	private double dInvulnerableTime;

	/**
	 * Constructor for creating a player which calls the superclass's
	 * constructor.
	 * 
	 * @param vLocation
	 *            - The Location of the player on the board in vector
	 *            representation.
	 * @param gmMap
	 *            - The Game Map.
	 */
	public Player(Vector vLocation, GameMap gmMap) {
		super(vLocation, gmMap, new StandardMovement(), new StandardGravity(), 
				new PlayerOnCollisionWith());
		this.iScore = 0;
		this.iLives = 3;
	}

	@Override
	public Image getImage() throws Exception {
		if (this.getSpeed().getX() >= 0) {
			return ImageIO.read(Player.class.getResourceAsStream(getConstants()
					.getImageOfPlayerLookingRight()));
		}
		return ImageIO.read(Player.class.getResourceAsStream(getConstants()
				.getImageOfPlayerLookingLeft()));
	}

	/**
	 * With this method points can be added to the score of the player.
	 * 
	 * @param iAmountOfPointsToAdd
	 *            - The amount of points to be added to the score.
	 */
	public void addPoints(int iAmountOfPointsToAdd) {
		this.iScore += iAmountOfPointsToAdd;
	}

	/**
	 * Returning the score of the player.
	 * 
	 * @return this.iScore - An integer value which represents the amount of points a
	 *         player has.
	 */
	public int getPoints() {
		return this.iScore;
	}

	/**
	 * This method returns the amount of lives of the player.
	 * 
	 * @return this.iLives - Integer representation of the amount of lives.
	 */
	public int getLives() {
		return this.iLives;
	}

	/**
	 * This method let's you change the amount of lives.
	 * 
	 * @param iLives
	 *            - Integer value of the amount of lives to be set.
	 */
	public void setLives(int iLives) {
		this.iLives = iLives;
	}

	/**
	 * This method sets the time the player is invulnerable.
	 * 
	 * @param dInvulnerableTime
	 *            - The time the plaeyr is invulnerable.
	 */
	public void setInvulnerableTime(double dInvulnerableTime) {
		this.dInvulnerableTime = dInvulnerableTime;
	}
	
	/**
	 * Returns the time until which the player is invulnerable.
	 * @return this.dInvulnerableTime 
	 * 							- Double representation of until which the player is invulnerable.
	 */
	public double getInvulnerableTime() {
		return this.dInvulnerableTime;
	}
}