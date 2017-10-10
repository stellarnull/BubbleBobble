package org.group17.Game.Logic;

import java.util.concurrent.CopyOnWriteArrayList;
import org.group17.Map.GameMap;
import org.group17.Units.Entity;
import org.group17.Game.Game;

/**
 * This class deals with if the game has to end or not.
 * 
 * @author Cas
 *
 */
public class EndingHook implements IGameHook {

	/**
	 * {@inheritDoc}
	 */
	public void onEachIteration(GameMap gmMap, double dTimePerFrame) {
		CopyOnWriteArrayList<Entity> alEntityList = gmMap.getEntityList();
		if (alEntityList.size() == 1) {
			gameEnding(0);
		}

		if (gmMap.getPlayer().getLives() <= 0) {
			gameEnding(1);
		}
	}

	/**
	 * This method calls the ending method from the Game class.
	 * 
	 * @param iBool
	 *            - Integer value that represents lost or win, 0 is win, 1 is
	 *            lost.
	 */
	public void gameEnding(int iBool) {
		try {
			Game gGame = new Game();
			if (iBool == 0) {
				gGame.gameWon();
			}
			if (iBool == 1) {
				gGame.gameLost();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}