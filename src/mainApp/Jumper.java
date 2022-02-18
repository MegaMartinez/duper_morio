package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Class: Jumper
 * @author Team 405
 * Purpose: Class for a different type of enemy. Jumper inherits Enemy as a superclass using an overridden 
 * 			update method to jump at certain time intervals.
 */

public class Jumper extends Enemy {
	
	private static final double JUMPER_HORI_SPEED = 2.5;
	private static final double JUMP_SPEED = 11;
	private static final int JUMP_COOLDOWN = 100;
	private static final int SHOOT_COOLDOWN = 140;
	
	private int ticksUntilJump;
	private int ticksUntilShoot;
	private ArrayList<Bullet> bullets;
	
	public Jumper(double x, double y) {
		super(x, y);
		this.xVelocity = JUMPER_HORI_SPEED;
		this.ticksUntilJump = 0;
		this.ticksUntilShoot = 0;
		this.bullets = new ArrayList<Bullet>();
	}
	
	@Override
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.BLUE);
		g2.fill(rect);
	}
	
	@Override
	public void update() {
		super.update();
		this.updateBullets();
		this.ticksUntilShoot += 1;
		if(this.ticksUntilShoot >= SHOOT_COOLDOWN) {
			this.shoot();
		}
		this.ticksUntilJump += 1;
		if(this.ticksUntilJump >= JUMP_COOLDOWN) {
			this.yVelocity = -JUMP_SPEED;
			this.ticksUntilJump = 0;
		}
	}
	
	public void updateBullets() {
		for(int k = 0; k < this.bullets.size(); k++) {
			bullets.get(k).update();
			if(this.bullets.get(k).getX() <= 0 || this.bullets.get(k).getX() >= 1408 ||
					this.bullets.get(k).getY() <= 0 || this.bullets.get(k).getY() <= 768) {
				this.bullets.remove(k);
			}
		}
	}
	
	public void shoot() {
		
	}
//	 && this.isFalling == false

}
