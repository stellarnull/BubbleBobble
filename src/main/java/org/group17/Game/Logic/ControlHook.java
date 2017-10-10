package org.group17.Game.Logic;

import org.group17.Map.GameMap;
import org.group17.Math.Vector;
import org.group17.Units.Bubble;
import org.group17.Units.Player;
import org.group17.Units.Wall;

/**
 * This class takes care of the input from the keyboard.
 * 
 * @author Rob
 * @author Cas
 *
 */
public class ControlHook implements IGameHook {
	private boolean bBubble, bJump, bLeft, bRight = false;
	private static final double D_JUMP_SPEED = 13;
	private static final double D_BUBBLE_SPEED = 16;
	private static final double D_BUBBLE_OFFSET = 1.125;
	private static final Vector V_ACCELERATION_RIGHT = new Vector(14, 0);

	/**
	 * This method sets the player into a jump or not.
	 * 
	 * @param bJump
	 *            - Boolean value, true if jumping, false if not.
	 */
	public synchronized void setJump(boolean bJump) {
		this.bJump = bJump;
	}

	/**
	 * This method sets the players left direction.
	 * 
	 * @param bLeft
	 *            - Boolean true if left, false if not.
	 */
	public synchronized void setLeft(boolean bLeft) {
		this.bLeft = bLeft;
	}

	/**
	 * This method sets the players right direction.
	 * 
	 * @param bRight
	 *            - Boolean, true if right, false if not.
	 */
	public synchronized void setRight(boolean bRight) {
		this.bRight = bRight;
	}

	/**
	 * This method creates a bubble in the game.
	 * 
	 * @param gmMap
	 *            - The map of the game.
	 */
	private void bubble(GameMap gmMap) {
		Player pPlayer = gmMap.getPlayer();
		if (bBubble) {
			Bubble newBubble;
			if (pPlayer.getSpeed().getX() >= 0) {
				Vector vBubbleLocation = pPlayer.getLocation().add(new Vector(D_BUBBLE_OFFSET, 0));
				newBubble = new Bubble(vBubbleLocation, gmMap, new Vector(D_BUBBLE_SPEED, 0));
			} else {
				Vector vBubbleLocation = pPlayer.getLocation().add(new Vector(-D_BUBBLE_OFFSET, 0));
				newBubble = new Bubble(vBubbleLocation, gmMap, new Vector(-D_BUBBLE_SPEED, 0));
			}
			gmMap.add(newBubble);
			bBubble = false;
		}
	}

	/**
	 * This methods makes the player jump.
	 * 
	 * @param gmMap
	 *            - The map of the game.
	 */
	private void jump(GameMap gmMap) {

		boolean bOnWall = false;
		Player pPlayer = gmMap.getPlayer();
		for (Wall wW : gmMap.getWallList()) {
			if (wW.isInThreshold(pPlayer)) {
				bOnWall = true;
				break;
			}
		}
		if (bJump && bOnWall && pPlayer.getSpeed().getY() == 0) {
			pPlayer.getSpeed().setY(D_JUMP_SPEED);
			bJump = false;

			gmMap.getLog().write("player-jumps: " + gmMap.getPlayer().getLocation().toString());
		}
	}

	/**
	 * This method sets the horizontal acceleration for the player.
	 * 
	 * @param gmMap
	 *            - The map of the game.
	 * @param dTimePerFrame
	 *            - The time per frame.
	 */
	private void accelerateHorizontal(GameMap gmMap, double dTimePerFrame) {
		Player pPlayer = gmMap.getPlayer();
		if (bLeft && !bRight) {
			pPlayer.getSpeed().addLocal(V_ACCELERATION_RIGHT.multiply(-dTimePerFrame));
		}
		if (!bLeft && bRight) {
			pPlayer.getSpeed().addLocal(V_ACCELERATION_RIGHT.multiply(dTimePerFrame));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public synchronized void onEachIteration(GameMap gmMap, double dTimePerFrame) {
		jump(gmMap);
		accelerateHorizontal(gmMap, dTimePerFrame);
		bubble(gmMap);
	}

	/**
	 * This method sets a bubble.
	 * 
	 * @param bBubble
	 *            - True if a bubble is in the game else false.
	 */
	public void setBubble(boolean bBubble) {
		this.bBubble = bBubble;
	}

	/**
	 * This method exists for test purposes.
	 * 
	 * @return this.bJump - Boolean value for jump, true if it jumps else false..
	 */
	public synchronized boolean getJump() {
		return this.bJump;
	}

	/**
	 * This method exists for test purposes.
	 * 
	 * @return this.bLeft - Boolean value for left, true if going left else false.
	 */
	public synchronized boolean getLeft() {
		return this.bLeft;
	}

	/**
	 * This method exists for test purposes.
	 * 
	 * @return this.bRight - Boolean value for right, true if going right else false.
	 */
	public synchronized boolean getRight() {
		return this.bRight;
	}

	/**
	 * This method exists for test purposes.
	 * 
	 * @return this.bBubble - Boolean value for being in bubble, true if in bubble else false.
	 */
	public synchronized boolean getBubble() {
		return this.bBubble;
	}
}