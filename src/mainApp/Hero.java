package mainApp;

import java.awt.geom.Rectangle2D;

public class Hero extends Character {
	
	private final int HORI_SPEED = 10;
	private final int VERT_SPEED = 15;
	
//	private int xCoord;
//	private int yCoord;
//	private int xVelocity = 0;
//	private int yVelocity = 0;
//	private String image = "Unimplemented";
//	private Rectangle2D.Double tempBox;
	
	public void changeSpeed(char direction) {
		if(direction == 'R') {
			this.xVelocity = HORI_SPEED;
			return;
		} if(direction == 'L') {
			this.xVelocity = -HORI_SPEED;
			return;
		} if(direction == '-') {
			this.xVelocity = 0;
			return;
		} if(direction == 'U') {
			this.yVelocity = -VERT_SPEED;
			return;
		} if(direction == 'D') {
			this.yVelocity = 0;
			return;
		} 
	}

}
