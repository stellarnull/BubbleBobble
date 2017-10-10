package org.group17.bubblebobble;

import org.group17.Gui.GUI;

/**
 * This class is to execute the program.
 * 
 * @author Cas
 * 
 */
public final class Main {

	private static GUI gui = null;

	/**
	 * Private constructor, so that no object can be made of this class.
	 * This shouldn't happen as it only launches the game.
	 */
	private Main() {
		throw new UnsupportedOperationException("Something went wrong, "
				+ "you called a private constructor");
	}

	/**
	 * Method to start the program.
	 * 
	 * @param args
	 *            - Arguments to be used.
	 * @throws Exception
	 *             - Throws Exception. (Will change later)
	 */
	public static void main(String[] args) throws Exception {
		gui = GUI.getInstance();
		gui.init();
		gui.setFrame();
	}
}