package org.group17.Gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import org.group17.Game.Game;
import org.group17.Game.Logic.ControlHook;

/**
 * This class defines what the key-listeners mean.
 */
public class KeyListen implements KeyListener {

	private ControlHook controlHook = new ControlHook();
	private StopTask stopTask = null;
	private Timer timer = new Timer(false);

	/**
	 * Adds the ControlHandler to the game.
	 * @param game
	 *            - The Game.
	 */
	public KeyListen(Game game) {
		game.add(this.controlHook);
	}

	/**
	 * Class to stop a task.
	 */
	class StopTask extends TimerTask {

		@Override
		public void run() {
			controlHook.setLeft(false);
			controlHook.setRight(false);
			controlHook.setJump(false);
		}
	}

	/**
	 * This method tells what to be done when what kind of key-event is found.
	 * 
	 * @param ke
	 *            - The KeyEvent.
	 */
	public void keyPressed(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			this.controlHook.setLeft(true);
			if (this.stopTask != null) {
				this.stopTask.cancel();
				this.timer.purge();
			}
			break;
		case KeyEvent.VK_RIGHT:
			this.controlHook.setRight(true);
			if (this.stopTask != null) {
				this.stopTask.cancel();
				this.timer.purge();
			}
			break;
		case KeyEvent.VK_SPACE:
			this.controlHook.setBubble(true);
			break;
		case KeyEvent.VK_UP:
			this.controlHook.setJump(true);
			break;
		default:
			break;
		}
	}

	/**
	 * This method says what has to happen when a key is released. (For further
	 * development)
	 * 
	 * @param ke
	 *            - The Key-event.
	 */
	public void keyReleased(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (this.stopTask != null) {
				this.stopTask.cancel();
				this.timer.purge();
			}
			this.stopTask = new StopTask();
			this.timer.schedule(this.stopTask, 10);
			break;
		case KeyEvent.VK_RIGHT:
			if (this.stopTask != null) {
				this.timer.purge();
			}
			this.stopTask = new StopTask();
			this.timer.schedule(this.stopTask, 10);
			break;
		default:
			break;
		}
	}

	/**
	 * This method tells what to do when a key is typed. (For further
	 * development)
	 * 
	 * @param ke
	 *            - KeyEvent.
	 */
	public void keyTyped(KeyEvent ke) {
	}
}