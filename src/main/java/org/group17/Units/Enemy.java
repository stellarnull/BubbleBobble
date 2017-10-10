package org.group17.Units;

import java.awt.Image;
import javax.imageio.ImageIO;
import org.group17.Math.Vector;
import org.group17.Map.GameMap;

/**
 * This class defines what an enemy can do.
 * 
 * @author Ludwig
 *
 */
public class Enemy extends Entity {

	private boolean bInBubble;
	private final double dInitSpeed = Math.random();
	private final double dJump = 13;
	private boolean bSameX;
	private boolean bInJumpRange;
	private double dJumpChance = 0.005;
	private boolean bJumpValid;
	private double dTimeInBubble;

	/**
	 * Constructor for creating an enemy.
	 * Initial speed is set random to left or right.
	 * 
	 * @param vLocation
	 *            - Vector representation of the location of the enemy in the
	 *            map.
	 * @param gmMap
	 *            - The game map.
	 * 
	 */
	public Enemy(Vector vLocation, GameMap gmMap) {
		super(vLocation, gmMap, new StandardMovement(), new StandardGravity(), 
				new EnemyOnCollisionWith());
		this.bInBubble = false;
		if (this.dInitSpeed >= 0.5) {
			this.getSpeed().setX(this.dInitSpeed);
		} else {
			this.getSpeed().setX(-(0.5 - this.dInitSpeed));
		}
	}

	@Override
	public void move(double dTimePerFrame) {
		this.checkJump();
		super.move(dTimePerFrame);	
	}

	/**
	 * Checks if jump shall be performed. In case of possible jump, either
	 * random jump or attacking-player can be performed.
	 */
	public void checkJump() {
		this.checkAbove();

		if (this.bJumpValid) {
			double dJumpRandom = Math.random();
			if (dJumpRandom < this.dJumpChance) {
				this.jump();
			} else if (this.bSameX && this.bInJumpRange && this.bJumpValid) {
				this.jump();
			}
		}
	}

	/**
	 * bSameX checks if the player is in a range of +/- 0,5 within the same
	 * x-coordinate. bInJumpRange checks if the player is not further away than
	 * one floor level. bJumpValid ensures enemies do not jump when already
	 * under the ceiling.
	 */
	public void checkAbove() {

		this.bSameX = false;
		double dDiffX = Math.abs(this.getLocation().getX()
				- this.getMap().getPlayer().getLocation().getX());
		if (dDiffX < 0.5) {
			this.bSameX = true;
		}

		this.bInJumpRange = false;
		double dDiffY = this.getMap().getPlayer().getLocation().getY()
				- this.getLocation().getY();
		if (0 <= dDiffY && dDiffY <= 2.1) {
			this.bInJumpRange = true;
		}

		this.bJumpValid = false;
		if (this.getLocation().getY() < 7) {
			this.bJumpValid = true;
		}
	}

	/**
	 * Makes the enemy jump up. 
	 * Sets x speed to make a jump truly vertical.
	 */
	public void jump() {
		this.getSpeed().setY(this.dJump);
		this.getSpeed().setX(1);
	}

	@Override
	public Image getImage() throws Exception {
		if (this.bInBubble) {
			return ImageIO.read(Enemy.class.getResourceAsStream(getConstants()
					.getImageOfEnemyInBubble()));
		} else if (this.getSpeed().getX() >= 0) {
			return ImageIO.read(Enemy.class.getResourceAsStream(getConstants()
					.getImageOfEnemyLookingRight()));
		} else {
			return ImageIO.read(Enemy.class.getResourceAsStream(getConstants()
					.getImageOfEnemyLookingLeft()));
		}
	}

	/**
	 * Method to set the enemy in a bubble.
	 */
	public void beBubbled() {
		this.bInBubble = true;
		this.setGravityBehaviour(new BubbleGravity());
	}

	/**
	 * This method returns if an enemy is inside a bubble or not.
	 * 
	 * @return this.bInBubble - Boolean value, true means in bubble, false mean
	 *         not.
	 */
	public boolean getInBubble() {
		return this.bInBubble;
	}

	/**
	 * This method returns how long the enemy has to remain in a bubble.
	 * 
	 * @return this.dTimeInBubble - Double representation of the time left in
	 *         bubble.
	 */
	public double getTimeInBubble() {
		return this.dTimeInBubble;
	}

	/**
	 * This method removes the bubble from an enemy.
	 */
	public void getOutOfBubble() {
		this.bInBubble = false;
		this.setGravityBehaviour(new StandardGravity());
	}

	/**
	 * Returns the boolean of bSameX *FOR TEST PURPOSES* .
	 * 
	 * @return this.bSameX - Boolean value which represents if it is the same X
	 *         or not.
	 */
	public boolean getSameX() {
		return this.bSameX;
	}

	/**
	 * Returns the boolean value of InJumpRange *FOR TEST PURPOSES* .
	 * 
	 * @return this.bInJumpRange - Boolean value which represents if enemy is in
	 *         jump range.
	 */
	public boolean getInJumpRange() {
		return this.bInJumpRange;
	}

	/**
	 * Returns the boolean value of bJumpValid *FOR TEST PURPOSES* .
	 * 
	 * @return this.bJumpValid - Boolean value which represents if a jump is
	 *         valid.
	 */
	public boolean getJumpValid() {
		return this.bJumpValid;

	}
	
	/**
	 * Sets the time the enemy should remain in a bubble.
	 * @param dTimeInBubble - Double representation of the time in a bubble.
	 */
	public void setTimeInBubble(double dTimeInBubble) {
		this.dTimeInBubble = dTimeInBubble;
	}
}