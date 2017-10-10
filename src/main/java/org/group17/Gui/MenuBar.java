package org.group17.Gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Creates the MenuBar with buttons on top of the game screen.
 * @author All
 *
 */
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	/**
	 * Creating the menu.
	 */
	public MenuBar() {
		this.setBackground(new Color(178, 189, 187));
		this.setForeground(new Color(178, 189, 187));
		JMenu jmGame = new JMenu("Game");
		JMenu jmHelp = new JMenu("Help");

		JMenuItem jmiGame = new JMenuItem("Exit");
		JMenuItem jmiHelp = new JMenuItem("Instructions");

		GUI.getInstance().getFrame().setJMenuBar(this);
		this.add(jmGame);
		this.add(jmHelp);
		
		jmGame.add(jmiGame);
		jmHelp.add(jmiHelp);

		jmiGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().getFrame().dispose();
				System.exit(0);
			}
		});
		jmiHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.getInstance().showHelpPanel();
			}
		});
	}
}