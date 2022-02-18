package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class: Jumper
 * @author Team 405
 * Purpose: Class for a different type of enemy. Jumper inherits Enemy as a superclass using an overridden 
 * 			update method to jump at certain time intervals.
 */

public class Jumper extends Enemy {
	
	private static final double HORI_SPEED = 3;
	private static final double JUMP_SPEED = 8;
	private static final int JUMP_COOLDOWN = 60;
	
	private int ticksUntilJump;
	
	public Jumper(double x, double y) {
		super(x, y);
		this.xVelocity = HORI_SPEED;
		this.ticksUntilJump = 0;
	}
	
	@Override
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.BLUE);
		g2.fill(rect);
	}
	
	@Override
	public void update() {
		super.update();
		this.ticksUntilJump += 1;
		if(this.ticksUntilJump >= 60 && this.isFalling == false) {
			this.yVelocity = -JUMP_SPEED;
			this.ticksUntilJump = 0;
		}
	}

}
