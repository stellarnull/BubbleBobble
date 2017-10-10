package org.group17.bubblebobble;

/**
 * This class contains global constants for the game.
 * It's purpose is to give an easy overview for the developer to change these constants.
 * @author Cas
 *
 */
public class Constants {

	/**
	 * FOLDERS.
	 */
	private String sResourceLocation = "src/main/resources";
	private String sImageLocation = "/pic/";
	private String sLevelsLocation = "/levels/";
	
	/**
	 * LEVELS.
	 */
	private String sLevelOne = sResourceLocation + sLevelsLocation + "level1.txt";
	
	/**
	 * IMAGES WelcomeScreen/EndScreen.
	 */
	private String sStartButton = 
			sResourceLocation + sImageLocation + "start_1.png";
	private String sStartButtonHover = 
			sResourceLocation + sImageLocation + "start_2.png";
	private String sExitButton = 
			sResourceLocation + sImageLocation + "exit_1.png";
	private String sExitButtonHover = 
			sResourceLocation + sImageLocation + "exit_2.png";
	private String sCover = sResourceLocation + sImageLocation + "cover.jpg";
	
	private String sEndLoosing = sResourceLocation + sImageLocation + "loosing.jpg";
	private String sEndWinning = sResourceLocation + sImageLocation + "winning.jpg";
	
	/**
	 * IMAGES HelpPage.
	 */
	private String sContinueButton = 
			sResourceLocation + sImageLocation + "return_1.jpg";
	private String sContinueButtonHover = 
			sResourceLocation + sImageLocation + "return_2.jpg";
	
	private String sHelpPageBackground = sResourceLocation + sImageLocation + "help.jpg";
	

	/**
	 * Game resolution switches: {width, height}.
	 */
	private int[] iaRes = new int[] {1280, 743};
	
	/**
	 * IMAGES GameObjects.
	 */
	private String sBubble = sImageLocation + "Bubble.png";
	private String sWall = sImageLocation + "Wall.png";
	private String sEnemyLookingLeft = sImageLocation + "dog_left.png";
	private String sEnemyLookingRight =  sImageLocation + "dog_right.png";
	private String sEnemyInBubble = sImageLocation + "dog_bubbled.png";
	private String sPlayerLookingLeft = sImageLocation + "horse_car_left.png";
	private String sPlayerLookingRight = sImageLocation + "horse_car_right.png";
	private String sScore = sImageLocation + "score.jpg";
	private String sHeart = sImageLocation + "heart.png";
	private String sBackground =  sResourceLocation + sImageLocation + "Background.jpg";
	private String sPowerGirl = sImageLocation + "power_girl.png";
	private String sPowerGrapes = sImageLocation + "power_grapes.png";
	private String sStar = sImageLocation + "star.png";
	
	/**
	 * Returns the location of the image of the start button from the welcome screen.
	 * @return this.sStartButton - The string representation of the location.
	 */
	public String getImageOfStartButton() {
		return this.sStartButton;
	}
	
	/**
	 * Returns the location of the image for the power up girl.
	 * @return this.sPowerGirl - The string representation of the location.
	 */
	public String getImageOfPowerGirl() {
		return this.sPowerGirl;
	}
	
	/**
	 * Returns the location of the image for the power up grapes.
	 * @return this.sPowerGrapes - The string representation of the location.
	 */
	public String getImageOfPowerGrapes() {
		return this.sPowerGrapes;
	}
	
	/**
	 * Returns the background image for the score display.
	 * @return this.sScore - The string representation of the location.
	 */
	public String getImageOfScore() {
		return this.sScore;
	}
	
	/**
	 * Returns the heart image for the display of the lives.
	 * @return this.sHeart - The string representation of the location.
	 */
	public String getImageOfLife() {
		return this.sHeart;
	}
	
	/**
	 * Returns the location to the image for the background of the game.
	 * @return this.sBackground - The string representation of the location.
	 */
	public String getImageOfBack() {
		return this.sBackground;
	}
	
	/**
	 * Returns the location of the image for when hovering over the start button of the welcome
	 * screen.
	 * @return this.sStartButtonHover - The string representation of the image.
	 */
	public String getImageOfStartButtonHover() {
		return this.sStartButtonHover;
	}
	
	/**
	 * Returns the location of the exit button for the welcome screen.
	 * @return this.sExitButton - The string representation of the image.
	 */
	public String getImageOfExitButton() {
		return this.sExitButton;
	}
	
	/**
	 * Returns the location of the exit button when hovering over it in the welcome screen.
	 * @return this.sExitButtonHover - The string representation of the image.
	 */
	public String getImageOfExitButtonHover() {
		return this.sExitButtonHover;
	}
	
	/**
	 * Returns the location of the cover in the welcome screen.
	 * @return this.sCover - The string representation of the image.
	 */
	public String getImageOfCover() {
		return this.sCover;
	}	
	
	/**
	 * Returns the location of the image for the continue button in the help page.
	 * @return this.sContinueButton - The string representation of the image.
	 */
	public String getImageOfContinueButton() {
		return this.sContinueButton;
	}
	
	/**
	 * Returns the location of the image when hovering over the continue button in the help page.
	 * @return this.sContinueButtonHover - The string representation of the image.
	 */
	public String getImageOfContinueButtonHover() {
		return this.sContinueButtonHover;
	}
	
	/**
	 * Returns the location of the background image for the help page.
	 * @return sHelpPageBackground - The string representation of the image.
	 */
	public String getImageOfHelpPageBackground() {
		return this.sHelpPageBackground;
	}
	
	/**
	 * Returns the location of the bubble image.
	 * @return this.sBubble - The string representation of the image.
	 */
	public String getImageOfBubble() {
		return this.sBubble;
	}
	
	/**
	 * Returns the location of the wall image.
	 * @return this.sWall - The string representation of the image.
	 */
	public String getImageOfWall() {
		return this.sWall;
	}
	
	/**
	 * Returns the location of the enemy looking left image.
	 * @return this.sEnemyLookingLeft - The string representation of the image.
	 */
	public String getImageOfEnemyLookingLeft() {
		return this.sEnemyLookingLeft;
	}
	
	/**
	 * Returns the location of the enemy looking right image.
	 * @return this.sEnemyLookingRight - The string representation of the image.
	 */
	public String getImageOfEnemyLookingRight() {
		return this.sEnemyLookingRight;
	}
	
	/**
	 * Returns the location of the enemy in bubble image.
	 * @return this.sEnemyInBubble - The string representation of the image.
	 */
	public String getImageOfEnemyInBubble() {
		return this.sEnemyInBubble;
	}
	
	/**
	 * Returns the location of the player looking left image.
	 * @return this.sPlayerLookingLeft - The string representation of the image.
	 */
	public String getImageOfPlayerLookingLeft() {
		return this.sPlayerLookingLeft;
	}
	
	/**
	 * Returns the location of the player looking right image.
	 * @return this.sPlayerLookingRight - The string representation of the image.
	 */
	public String getImageOfPlayerLookingRight() {
		return this.sPlayerLookingRight;
	}
	
	/**
	 * Returns the location of the image of the background for the end page.
	 * @return this.sEndBackground - The string representation of the image.
	 */
	public String getImageOfEndPageBackground() {
		return this.sEndLoosing;
	}
		
	/**
	 * Returns the location of the image of loosing a game page.
	 * @return this.sEndBackground - The string representation of the image.
	 */
	public String getImageOfEndLoosing() {
		return this.sEndLoosing;
	}
	
	/**
	 * Returns the location of the image of winning a game page.
	 * @return this.sEndBackground - The string representation of the image.
	 */
	public String getImageOfEndWinning() {
		return this.sEndWinning;
	}

	/**
	 * Returns the location of the first level of the game.
	 * @return this.sLevelOne - The string representation of the first level location.
	 */
	public String getLevelOne() {
		return this.sLevelOne;
	}
	
	/**
	 * Returns the resolution key numbers of the game.
	 * @return int[] with resolution key-numbers
	 */
	public int[] getRes() {
		return this.iaRes;
	}
	
	/**
	 * Returns the location of the star image for the power up.
	 * @return this.sStar - The string representation of the location of the star image.
	 */
	public String getImageOfStar() {
		return this.sStar;
	}
}