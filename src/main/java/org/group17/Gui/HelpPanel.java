package org.group17.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.group17.bubblebobble.Constants;

/**
 * Creates the HelpScreen in the game.
 * @author All
 *
 */
@SuppressWarnings("serial")
public class HelpPanel extends JPanel {

	private Constants cConstants = new Constants();
	
	/**
	 * Help window sketched.
	 */
	public HelpPanel() {
		initHelpBackButton();
		setHelpBackground();
		this.setLayout(null);
	}

	/**
	 * Functionality for the back button in the help screen.
	 */
	public void initHelpBackButton() {
		ImageIcon backIcon = new ImageIcon(this.cConstants.getImageOfContinueButton());
		ImageIcon backIcon2 = new ImageIcon(this.cConstants.getImageOfContinueButtonHover());
		JButton jbtBack = new JButton(backIcon);
		jbtBack.setRolloverIcon(backIcon2);
		jbtBack.setBounds(227, 568, 208, 168);
		jbtBack.setBorder(null);
		jbtBack.setOpaque(true);
		jbtBack.setContentAreaFilled(false);
		jbtBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().closeHelpPanel();
			}
		});
		this.add(jbtBack);
	}

	/**
	 * Method for creating help button.
	 */
	public void setHelpBackground() {
		ImageIcon helpIcon = new ImageIcon(this.cConstants.getImageOfHelpPageBackground());
		JLabel helpPic = new JLabel(helpIcon);
		helpPic.setBounds(0, 0, this.cConstants.getRes()[0], this.cConstants.getRes()[1]);
		this.add(helpPic);
	}
}