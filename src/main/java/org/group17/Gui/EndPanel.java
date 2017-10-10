package org.group17.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.group17.bubblebobble.Constants;

/**
 * Created the EndScreen for the game.
 * @author All
 *
 */
@SuppressWarnings("serial")
public class EndPanel extends JPanel {

	private Constants cConstants = new Constants();
	
	/**
	 * Creates the EndScreen.
	 * @param iBool -  1 if the game has won, 0 if the game is lost.
	 */
	public EndPanel(int iBool) {
		initExitButton();
		if (iBool == 1) {
			setWinningBackground();
		} else {
			setLoosingBackground();
		}
		this.setLayout(null);
	}

	/**
	 * Functionality for the back button in the help screen.
	 */
	public void initExitButton() {
		ImageIcon exitIcon = new ImageIcon(this.cConstants.getImageOfExitButton());
		ImageIcon exitIcon2 = new ImageIcon(this.cConstants.getImageOfExitButtonHover());
		JButton jbtBack = new JButton(exitIcon);
		jbtBack.setRolloverIcon(exitIcon2);
		jbtBack.setBounds(490, 590, 269, 100);
		jbtBack.setBorder(null);
		jbtBack.setOpaque(true);
		jbtBack.setContentAreaFilled(false);
		jbtBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().getFrame().dispose();
				System.exit(0);
			}
		});
		this.add(jbtBack);
	}
	
	/**
	 * Method for setting background when the game has been won.
	 */
	public void setWinningBackground() {
		ImageIcon endIcon = new ImageIcon(this.cConstants.getImageOfEndWinning());
		JLabel endPic = new JLabel(endIcon);
		endPic.setBounds(0, 0, this.cConstants.getRes()[0], this.cConstants.getRes()[1]);
		this.add(endPic);
	}
	
	/**
	 * Method for setting background when the game has been lost.
	 */
	public void setLoosingBackground() {
		ImageIcon endIcon = new ImageIcon(this.cConstants.getImageOfEndLoosing());
		JLabel endPic = new JLabel(endIcon);
		endPic.setBounds(0, 0, this.cConstants.getRes()[0], this.cConstants.getRes()[1]);
		this.add(endPic);
	}
}