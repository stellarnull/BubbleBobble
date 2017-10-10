package org.group17.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.group17.bubblebobble.Constants;

/**
 * Created the Winning screen for the game.
 * @author All
 *
 */
@SuppressWarnings("serial")
public class WelcomePanel extends JPanel {

	private Constants cConstants = new Constants();
	
	/**
	 * Creates a WelcomePanel.
	 * @throws Exception 
	 *             - throws exception
	 */
	public WelcomePanel() throws Exception {
		initStartButton();
		initExitButton();
		initCover();
		this.setLayout(null);
	}

	/**
	 * Creates the start button.
	 * @throws Exception
	 *             - throws exception when the image couldn't be created.
	 */
	public void initStartButton() throws Exception {
		ImageIcon startIcon = new ImageIcon(this.cConstants.getImageOfStartButton());
		ImageIcon startIcon2 = new ImageIcon(this.cConstants.getImageOfStartButtonHover());
		JButton startButton = new JButton(startIcon);
		startButton.setRolloverIcon(startIcon2);
		startButton.setBounds(360, 550, 269, 100);
		startButton.setBorder(null);
		startButton.setOpaque(true);
		startButton.setContentAreaFilled(false);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().removeWelcomePanel();
				GUI.getInstance().setGameWindow();
			}
		});
		this.add(startButton);
	}

	/**
	 * Creating exit button.
	 */
	public void initExitButton() {
		ImageIcon exitIcon = new ImageIcon(this.cConstants.getImageOfExitButton());
		ImageIcon exitIcon2 = new ImageIcon(this.cConstants.getImageOfExitButtonHover());
		JButton exitButton = new JButton(exitIcon);
		exitButton.setRolloverIcon(exitIcon2);
		exitButton.setBounds(645, 550, 296, 100);
		exitButton.setBorder(null);
		exitButton.setOpaque(true);
		exitButton.setContentAreaFilled(false);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().getFrame().dispose();
				System.exit(0);
			}
		});
		this.add(exitButton);
	}

	/**
	 * Loads background image.
	 */
	public void initCover() {
		ImageIcon coverIcon = new ImageIcon(this.cConstants.getImageOfCover());
		JLabel coverPic = new JLabel(coverIcon);
		coverPic.setBounds(0, 0, this.cConstants.getRes()[0], this.cConstants.getRes()[1]);
		this.add(coverPic);
	}
}