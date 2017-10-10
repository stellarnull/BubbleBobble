package org.group17.Logging;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Logging System.
 * 
 * @author Ludwig
 */
public final class Log {

	private String sFilename;
	private PrintWriter pwOut;
	private Calendar calCal = null;
	private SimpleDateFormat sdfFormat = null;
	
	/**
	 * Implementation of the Singleton Pattern.
	 */
	private static Log loggy = new Log();
	
	/**
	 * Constructor ensures singleton.
	 */
	private Log() { 
		createLog(); 
	}
	
	/**
	 * Method to get the instance of the logging system.
	 * @return loggy - Log ensures single instance
	 */
	public static Log getInstance() {
		return loggy;
	}

	/**
	 * Creates the logger.
	 */
	public void createLog() {
		this.calCal = Calendar.getInstance();
		this.sdfFormat = new SimpleDateFormat("dd.MM.yy_[HH-mm-ss]");
		this.sFilename = "Logging/" + this.sdfFormat.format(this.calCal.getTime()) + "-Log.txt";

		try {
			this.pwOut = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(sFilename), "UTF-8")));
			this.pwOut.println(this.sdfFormat.format(this.calCal.getTime()) 
					+ " == LOGGING IS ONBOARD ==");
			this.pwOut.flush();
		} catch (IOException eException) {
			System.err.println("Could not create logfile.");
		}
	}

	/**
	 * Method to write to the log-file.
	 * 
	 * @param sEntry
	 *            - The text to be written to the game.
	 */
	public void write(String sEntry) {
		this.pwOut.println(this.sdfFormat.format(this.calCal.getTime()) + ": " + sEntry);
		this.pwOut.flush();
	}
}