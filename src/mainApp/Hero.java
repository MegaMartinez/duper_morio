package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Class: Enemy
 * @author Team 405
 * Purpose: Class to hold information for the Hero. Inherits from the Character class. Also has a variable to track the hero's lives
 * 			and a method to respawn the hero while it has lives or exit the program if it doesn't. 		
 */

public class Hero extends Character {
	
	private static final int HORI_SPEED = 6;
	private static final int VERT_SPEED = 8;
	private static final int LIVES = 3;
	private static final int STARTING_X = 300;
	private static final int STARTING_Y = 300;
	private static final double HERO_WIDTH = 50;
	private static final double HERO_HEIGHT = 50;
	
	private double startingX;
	private double startingY;
	private boolean isPoweredUp;
	private int powerUpFrameCount;
	
	
	private int lives;
	
	public Hero() {
		super(STARTING_X, STARTING_Y, HERO_WIDTH, HERO_HEIGHT);
		this.startingX = STARTING_X;
		this.startingY = STARTING_Y;
		this.lives = LIVES;
		this.isPoweredUp = false;
		this.powerUpFrameCount = 0;
	}
	
	@Override
	public void update() {
		super.update();
		this.powerUpFrameCount++;
		if(this.powerUpFrameCount > 80) {
			this.isPoweredUp = false;
			this.powerUpFrameCount = 0;
		}
	}
	
	public void changeSpeed(char direction) {
		if(direction == '|') {
			this.yVelocity = 0;
			return;
		} else if(direction == 'R') {
			this.xVelocity = HORI_SPEED;
			return;
		} else if(direction == 'L') {
			this.xVelocity = -HORI_SPEED;
			return;
		} else if(direction == '-') {
			this.xVelocity = 0;
			return;
		} else if(direction == 'U') {
//			if(this.isFalling == true) {
//				return;
//			}
			this.yVelocity = -VERT_SPEED;
			return;
		} else if(direction == 'D') {
			this.yVelocity = VERT_SPEED;
			return;
		}
	}
	
	@Override
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fill(rect);
	}

	public int getLives() {return lives;}

	public void setLives(int lives) {this.lives = lives;}
	
	public void makePoweredUp() {
		this.isPoweredUp = true;
		this.powerUpFrameCount = 0;
	}
	
	/**
	 * Purpose: Resets position, subtracts lives, and checks for the loss condition.
	 * Restrictions: none
	 */
	public void respawn() {
		this.xPos = this.startingX;
		this.yPos = this.startingY;
		this.yVelocity = 0;
		this.lives -= 1;
		if(this.lives < 0) {
			System.exit(1);
		}
	}
}
