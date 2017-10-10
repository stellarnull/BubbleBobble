package org.group17.Map;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import org.group17.Units.Player;
import org.group17.Units.Wall;
import org.group17.bubblebobble.Constants;
import org.group17.Units.Entity;
import org.group17.Logging.Log;
import org.group17.Units.GameObject;

/**
 * This class represents the GameMap, which contains all the entities, walls and
 * floors.
 * 
 * @author rob
 *
 */
public class GameMap {

	private CopyOnWriteArrayList<Entity> alEntityList = new CopyOnWriteArrayList<Entity>();
	private ArrayList<Wall> alWallList = new ArrayList<Wall>(100);
	private Player pPlayer = null;
	public static final int I_PIXELS_PER_UNIT = 80;
	private BufferedImage biBackground = null;
	private Log lLogging = Log.getInstance();
	private Constants cConstants = new Constants();
	private Image imScore;
	private Image imLife;
	private Color[] colColor = new Color[3];
	private int iLives;

	/**
	 * This method returns the logger.
	 * 
	 * @return this.lLogging - The Log object.
	 */
	public Log getLog() {
		return this.lLogging;
	}

	/**
	 * This method returns an image.
	 * 
	 * @return biImage - Image.
	 * @throws Exception
	 *             - Throws exception if image couldn't be taken.
	 */
	public Image getImage() throws Exception {
		BufferedImage biImage = new BufferedImage(this.cConstants.getRes()[0], 
				this.cConstants.getRes()[1],
				BufferedImage.TYPE_INT_RGB);
		Graphics2D gGraphics = biImage.createGraphics();
		gGraphics.setBackground(Color.BLACK);

		for (Wall wW : this.alWallList) {
			double dX = wW.getLocation().getX() - 0.5f;
			double dY = 9f - wW.getLocation().getY() - 0.5f;
			gGraphics.drawImage(wW.getImage(), (int) (dX * I_PIXELS_PER_UNIT), 
					(int) (dY * I_PIXELS_PER_UNIT), I_PIXELS_PER_UNIT, I_PIXELS_PER_UNIT, null);
		}

		for (Entity eE : this.alEntityList) {
			double dX = eE.getLocation().getX() - 0.5f;
			double dY = 9f - eE.getLocation().getY() - 0.5f;
			gGraphics.drawImage(eE.getImage(), (int) (dX * I_PIXELS_PER_UNIT), 
					(int) (dY * I_PIXELS_PER_UNIT), I_PIXELS_PER_UNIT, I_PIXELS_PER_UNIT, null);
		}
		return biImage;
	}

	/**
	 * This method is used to draw images.
	 * 
	 * @param gGraphics
	 *            - Graphics.
	 * @throws Exception
	 *             - An Exception when the image can't be gotten.
	 */
	public void draw(Graphics gGraphics) throws Exception {
		Graphics g;
		if (this.biBackground == null) {
			this.biBackground = new BufferedImage(this.cConstants.getRes()[0], 
					this.cConstants.getRes()[1],
					BufferedImage.TYPE_INT_ARGB);
			g = biBackground.createGraphics();
			for (Wall wW : this.alWallList) {
				double dX = wW.getLocation().getX() - 0.5f;
				double dY = 9f - wW.getLocation().getY() - 0.5f;
				g.drawImage(wW.getImage(), (int) (dX * I_PIXELS_PER_UNIT), 
						(int) (dY * I_PIXELS_PER_UNIT), I_PIXELS_PER_UNIT, I_PIXELS_PER_UNIT, null);
			}
		}
		gGraphics.drawImage(this.biBackground, 0, 0, null);

		for (Entity eE : this.alEntityList) {
			double dX = eE.getLocation().getX() - 0.5f;
			double dY = 9f - eE.getLocation().getY() - 0.5f;
			gGraphics.drawImage(eE.getImage(), (int) (dX * I_PIXELS_PER_UNIT), 
					(int) (dY * I_PIXELS_PER_UNIT), I_PIXELS_PER_UNIT, I_PIXELS_PER_UNIT, null);
		}
		drawScore(gGraphics);
		drawLives(gGraphics);
	}

	/**
	 * Draws the score in the screen.
	 * 
	 * @param gGraphics
	 *            - Creates the score and lives of player on screen
	 * @throws Exception
	 *             - if image not found
	 */
	public void drawScore(Graphics gGraphics) throws Exception {
		gGraphics.setColor(Color.BLACK);
		String points = "" + this.getPlayer().getPoints();
		gGraphics.setFont(new Font("TimesRoman", Font.PLAIN, 20));

		try {
			this.imScore = ImageIO.read(GameMap.class.getResourceAsStream(
					this.cConstants.getImageOfScore()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		gGraphics.drawImage(this.imScore, 540, 650, null);
		gGraphics.drawString(points, 565, 691);

	}

	/**
	 * Draws the amount of lives in the screen.
	 * 
	 * @param gGraphics
	 *            - Creates the score and lives of player on screen
	 */
	public void drawLives(Graphics gGraphics) {

		try {
			this.imLife = ImageIO.read(GameMap.class.getResourceAsStream(
					this.cConstants.getImageOfLife()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.iLives = this.getPlayer().getLives();
		this.colColor[2] = new Color(255, 255, 77, 97);
		this.colColor[1] = new Color(255, 122, 77);
		this.colColor[0] = new Color(255, 38, 38);

		int iColor = 2;
		if (this.iLives <= 2) {
			iColor = this.iLives - 1;
		}

		gGraphics.setColor(this.colColor[iColor]);
		gGraphics.fillOval(600 + this.iLives * 50, 660, 38, 45);

		for (int iHeart = 0; this.iLives > iHeart; iHeart++) {
			gGraphics.drawImage(this.imLife, 655 + iHeart * 50, 665, null);
		}
	}

	/**
	 * This method returns the entity list.
	 * 
	 * @return this.alEntityList - The entity list.
	 */
	public CopyOnWriteArrayList<Entity> getEntityList() {
		return this.alEntityList;
	}

	/**
	 * This method returns the wall list.
	 * 
	 * @return this.alWallList - The wall list.
	 */
	public ArrayList<Wall> getWallList() {
		return this.alWallList;
	}

	/**
	 * This method is used to add game objects to their list.
	 * 
	 * @param go
	 *            - The Game Object.
	 * @return boolean - False if could not been added, otherwise returns the
	 *         list.
	 */
	public boolean add(GameObject go) {
		if (go instanceof Entity) {
			if (go instanceof Player) {
				this.pPlayer = ((Player) go);
			}
			return this.alEntityList.add((Entity) go);
		}

		if (go instanceof Wall) {
			return this.alWallList.add((Wall) go);
		}
		return false;
	}

	/**
	 * This method is used to remove Entities from the entity list.
	 * 
	 * @param eO
	 *            - An entity object.
	 * @return - The entity list with the entity removed.
	 */
	public boolean remove(Entity eO) {
		return this.alEntityList.remove(eO);
	}

	/**
	 * Returns the Player object.
	 * 
	 * @return this.pPlayer - The Player Object.
	 */
	public Player getPlayer() {
		return this.pPlayer;
	}
}