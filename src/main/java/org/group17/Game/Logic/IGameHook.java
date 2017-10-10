package org.group17.Game.Logic;

import org.group17.Map.GameMap;

/**
 * A GameHook is a object that hooks into the Game's update loop.
 * 
 * @author rob
 *
 */
public interface IGameHook {
	
	/**
	 * This method is called for each iteration of the corresponding game.
	 * 
	 * @param gmMap
	 *            - The GameMap of the Game
	 * @param dTimePerFrame
	 *            -  The time since the last frame.
	 */
	void onEachIteration(GameMap gmMap, double dTimePerFrame);
}