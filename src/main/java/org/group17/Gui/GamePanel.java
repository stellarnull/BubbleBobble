package org.group17.Gui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.group17.Game.Game;
import org.group17.bubblebobble.Constants;

/**
 * This class is for creating a GamePanel.
 * 
 * @author Cas
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private Thread tUpdateThread;
	private Game gGame;
	private Constants cConstants = new Constants();

	/**
	 * Returns the Thread from which the game is updated.
	 * 
	 * @return this.tUpdateThread - A thread.
	 */
	public Thread getUpdateThread() {
		return this.tUpdateThread;
	}

	/**
	 * Sets the thread from which the game is updated.
	 * 
	 * @param tUpdateThread
	 *            - A thread.
	 */
	public void setUpdateThread(Thread tUpdateThread) {
		this.tUpdateThread = tUpdateThread;
	}

	/**
	 * Constructor for creating a GamePanel.
	 * 
	 * @param gGame
	 *            - Game.
	 */
	public GamePanel(Game gGame) {
		this.gGame = gGame;
		ImageIcon backIcon = new ImageIcon(this.cConstants.getImageOfBack());
		JLabel backPic = new JLabel(backIcon);
		backPic.setBounds(0, 0, this.cConstants.getRes()[0], this.cConstants.getRes()[1]);
		this.add(backPic);
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics grGraphics) {
		try {
			super.paint(grGraphics);
			this.gGame.getMap().draw(grGraphics);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.tUpdateThread.interrupt();
	}
}