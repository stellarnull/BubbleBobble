package org.group17.Gui;

/** This class contains the graphic interface of the game. 
 * @author Chen
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.group17.Game.Game;
import org.group17.bubblebobble.Constants;

/**
 * This class defines the GUI of the Game.
 * @author Cas
 * @author Ludwig
 */
public final class GUI {

	private JFrame frame;
	private JPanel coverPanel;
	private GamePanel gamePanel = null;
	private JPanel helpPanel;
	private JPanel endPanel;
	private JMenuBar menuBar;
	private JLabel[][] gameLabels;
	private Game game;
	private KeyListen keyListen = null;
	private Constants constant = new Constants();

	/**
	 * Implementation of the Singleton-Pattern. Ensures that no evil-twins take
	 * over.
	 */
	private static GUI uniqueGUI = new GUI();

	/**
	 * Private constructor, never should be allowed to be called -> Singleton Class.
	 */
	private GUI() {
	}

	/**
	 * Gives back the only instance of the GUI -> Singleton.
	 * @return uniqueGUI - GUI ensures single instantiation.
	 */
	public static GUI getInstance() {
		return uniqueGUI;
	}

	/**
	 * Set Frame.
	 */
	public void setFrame() {
		frame.setUndecorated(true);
		frame.setFocusable(true);
		frame.setSize(constant.getRes()[0], constant.getRes()[1]);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(coverPanel);
		frame.setVisible(true);
	}

	/**
	 * Set Game Window.
	 */
	public void setGameWindow() {
		initGame();
		menuBar.setVisible(true);
		gamePanel.setLayout(null);
		keyListen = new KeyListen(game);
		frame.addKeyListener(keyListen);
		frame.add(gamePanel);
		frame.setVisible(true);
		game.start();
	}

	/**
	 * Method for creating a game.
	 */
	public void initGame() {
		for (int j = 0; j < 16; j++) {
			for (int i = 0; i < 16; i++) {
				gameLabels[i][j] = new JLabel();
				gameLabels[i][j].setBounds(299 + j * 48, i * 48, 48, 48);
				gameLabels[i][j].setBorder(null);
				gameLabels[i][j].setOpaque(true);
				gameLabels[i][j].setBackground(null);
				gamePanel.add(gameLabels[i][j]);
			}
		}
	}

	/**
	 * Initializing game variables.
	 * 
	 * @throws Exception
	 *             - Throws exception.
	 */
	public void init() throws Exception {

		frame = new JFrame("Bubble Bobble");
		coverPanel = new WelcomePanel();
		helpPanel = new HelpPanel();
		menuBar = new MenuBar();
		gameLabels = new JLabel[24][32];
		game = new Game();
		gamePanel = new GamePanel(game);
	}

	/**
	 * Returns the GUI part that is responsible for rendering the game.
	 * @return gamePanel - A GamePanel
	 */
	public GamePanel getGamePanel() {
		return gamePanel;
	}

	/**
	 * Refreshes the gamePanel. Should be called after any changes in the game
	 * from the gameThread.
	 */
	public static void refreshGame() {
		getInstance().getGamePanel().setUpdateThread(Thread.currentThread());
		getInstance().getGamePanel().repaint();
		if (!Thread.interrupted()) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				
			}
		}
	}

	/**
	 * Getting the frame in which everything is handled.
	 * @return frame - Frame of the game
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Closing welcome screen.
	 */
	public void removeWelcomePanel() {
		frame.remove(coverPanel);
	}

	/**
	 * Closing the HelpScreen.
	 */
	public void closeHelpPanel() {
		frame.remove(helpPanel);
		gamePanel.setVisible(true);
		menuBar.setVisible(true);
		frame.requestFocus();
		frame.addKeyListener(keyListen);
		frame.setVisible(true);
	}

	/**
	 * Starting the HelpScreen.
	 */
	public void showHelpPanel() {
		gamePanel.setVisible(false);
		menuBar.setVisible(false);
		frame.add(helpPanel);
		frame.setVisible(true);
	}
	
	/**
	 * When the game ends this screen will be shown.
	 */
	public void gameHasBeenWon() {
		gamePanel.setVisible(false);
		menuBar.setVisible(false);
		endPanel = new EndPanel(1);
		frame.add(endPanel);
		frame.setVisible(true);
	}
	
	/**
	 * When the game ends this screen will be shown.
	 */
	public void gameHasBeenLost() {
		gamePanel.setVisible(false);
		menuBar.setVisible(false);
		endPanel = new EndPanel(0);
		frame.add(endPanel);
		frame.setVisible(true);
	}
}