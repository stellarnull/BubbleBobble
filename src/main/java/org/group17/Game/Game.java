package org.group17.Game;

import java.awt.Image;
import java.util.ArrayList;

import org.group17.Game.Logic.CollisionHook;
import org.group17.Game.Logic.DragHook;
import org.group17.Game.Logic.IGameHook;
import org.group17.Game.Logic.GravityHook;
import org.group17.Game.Logic.MoveHook;
import org.group17.Game.Logic.EndingHook;
import org.group17.Game.Logic.BubbleHook;
import org.group17.Gui.GUI;
import org.group17.Map.GameMap;
import org.group17.Map.MapReader;
import org.group17.Units.Player;
import org.group17.bubblebobble.Constants;

/**
 * This class contains general information on the game.
 * 
 * @author Ludwig
 * @author Rob
 * @author Cas
 *
 */
public class Game implements Runnable {
	private ArrayList<IGameHook> alGameHookList = new ArrayList<IGameHook>();
	private GameMap gmMap;
	private static int iDefaultSleep = 30;
	private Thread runThread = new Thread(this);
	private volatile boolean bRunning;
	private Constants cConstants = new Constants();

	/**
	 * Returns the score of the player.
	 * 
	 * @return - Returns the Points the player has.
	 */
	public int getScore() {
		return this.gmMap.getPlayer().getPoints();
	}

	/**
	 * Constructor.
	 * 
	 * @throws Exception
	 *             - Throws Exception.
	 */
	public Game() throws Exception {
		this.add(new CollisionHook());
		this.add(new GravityHook());
		this.add(new MoveHook());
		this.add(new DragHook());
		this.add(new EndingHook());
		this.add(new BubbleHook());
		this.bRunning = false;
		this.gmMap = new MapReader().getMap(this.cConstants.getLevelOne());
	}

	/**
	 * Method returns the player.
	 * 
	 * @return this.gmMap.getPlayer() - Player Object.
	 */
	public Player getPlayer() {
		return this.gmMap.getPlayer();
	}

	/**
	 * This methods starts the game on a new Thread. It returns immediately
	 * after the game starts.
	 * 
	 */
	public void start() {
		this.bRunning = true;
		this.runThread.start();
	}

	/**
	 * This method stops the game. The game will first finish the cycle it is
	 * busy on.
	 */
	public void stop() {
		this.bRunning = false;
	}

	/**
	 * This method lets you check if the game is running or not.
	 * 
	 * @return this.bRunning - Boolean value, true means running, false means
	 *         not.
	 */
	public synchronized boolean getRunning() {
		return this.bRunning;
	}

	/**
	 * This method is used to interrupt the running thread.
	 */
	public void interrupt() {
		this.runThread.interrupt();
	}

	/**
	 * This method returns the runningThread (Exists for test purposes).
	 * 
	 * @return this.runThread - The thread.
	 */
	public Thread getThread() {
		return this.runThread;
	}

	/**
	 * This method runs until this.running is false.
	 */
	public void run() {
		long lMillis = System.currentTimeMillis();

		while (this.bRunning) {
			long lTime = System.currentTimeMillis() - lMillis;
			lMillis += lTime;
			lTime = Math.min(lTime, 2 * iDefaultSleep);
			double dTimePerFrame = lTime / 1000f;

			gameLogic(dTimePerFrame);

			GUI.refreshGame();
			try {
				Thread.sleep(lMillis + iDefaultSleep - System.currentTimeMillis());
			} catch (InterruptedException e) {
			} catch (IllegalArgumentException e) {
			}
		}
	}

	/**
	 * This method executes a hook on each hook available.
	 * 
	 * @param dTimePerFrame
	 *            - Double value that represents the tag per frame.
	 */
	private void gameLogic(double dTimePerFrame) {
		for (IGameHook hook : this.alGameHookList) {
			hook.onEachIteration(this.gmMap, dTimePerFrame);
		}
	}

	/**
	 * This method returns the image.
	 * 
	 * @return this.gmMap.getImage() - Image.
	 * @throws Exception
	 *             - Throws an Exception if failed to get image.
	 */
	public Image getImage() throws Exception {
		return this.gmMap.getImage();
	}

	/**
	 * Method to return the GameMap.
	 * 
	 * @return this.gmMap - The map of the game..
	 */
	public GameMap getMap() {
		return this.gmMap;
	}

	/**
	 * Adds a GameHook to the Game that hooks into the update loop.
	 * 
	 * @param gh
	 *            - The Game Hook.
	 * @return - True if the hook is added and else false;
	 */
	public boolean add(IGameHook gh) {
		return alGameHookList.add(gh);
	}

	/**
	 * Method to win the game.
	 */
	public void gameWon() {
		GUI.getInstance().gameHasBeenWon();
	}

	/**
	 * Method to loose the game.
	 */
	public void gameLost() {
		GUI.getInstance().gameHasBeenLost();
	}
}