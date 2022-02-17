package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Hero extends Character {
	
	private static final int HORI_SPEED = 10;
	private static final int VERT_SPEED = 15;

	private static final double HERO_WIDTH = 50;
	private static final double HERO_HEIGHT = 50;
	
	private double startingX;
	private double startingY;
	
	
	private int lives;
	
	public Hero() {
		super(300, 300, HERO_WIDTH, HERO_HEIGHT);
		this.startingX = 300;
		this.startingY = 300;
		this.lives = 99999;
//		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, HERO_WIDTH, HERO_HEIGHT);
	}
	
	public void changeSpeed(char direction) {
		if(direction == 'R') {
			this.xVelocity = HORI_SPEED;
			return;
		} else if(direction == 'L') {
			this.xVelocity = -HORI_SPEED;
			return;
		} else if(direction == '-') {
			this.xVelocity = 0;
			return;
		} else if(direction == 'U') {
			this.yVelocity = -VERT_SPEED;
			return;
		} else if(direction == 'D') {
			this.yVelocity = VERT_SPEED;
			return;
		} else if(direction == '|') {
			this.yVelocity = 0;
			return;
		} 
	}
	
	@Override
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fill(rect);
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public void respawn() {
		this.xPos = this.startingX;
		this.yPos = this.startingY;
		this.yVelocity = 0;
		this.lives -= 1;
		if(this.lives < 0) {
			System.exit(1);
		}
	}
	
	
	
//	public void platformCollide(Wall wall) {
//		if(this.rect.intersects(wall.rect)) {
//			this.yVelocity = 0;
//			this.yPos = (int) wall.yPos - HERO_HEIGHT;
//			this.isFalling = false;
//		}
//		else {
//			this.isFalling = true;
//		}
//	}

}
