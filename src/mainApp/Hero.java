package mainApp;

import java.awt.geom.Rectangle2D;

public class Hero extends Character {
	
	private final int HORI_SPEED = 10;
	private final int VERT_SPEED = 15;

	private final int HERO_WIDTH = 50;
	private final int HERO_HEIGHT = 50;
	
	
	

	
	public Hero() {
		
		super();
		this.rect = new Rectangle2D.Double(this.xCoord, this.yCoord, HERO_WIDTH, HERO_HEIGHT);
		this.isFalling = true;
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
	
	public void platformCollide(Wall wall) {
		if(this.rect.intersects(wall.rect)) {
			this.yVelocity = 0;
			this.yCoord = (int) wall.yPos - HERO_HEIGHT;
			this.isFalling = false;
		}
		else {
			this.isFalling = true;
		}
	}
	
	@Override
	public void update() {
		super.update();
		if (this.isFalling) {
			this.yVelocity += 0.7;
		}
	}
}
