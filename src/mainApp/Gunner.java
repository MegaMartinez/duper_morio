package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 * Class: Gunner
 * @author Team 405
 * Purpose: Class for a different type of enemy. Gunner inherits Enemy as a superclass using an overridden 
 * 			update method to jump at certain time intervals.
 */

public class Gunner extends Enemy {
	
	private static final double GUNNER_HORI_SPEED = 2.5;
	private static final int SHOOT_COOLDOWN = 300;
	
	private int ticksUntilShoot;
	private ArrayList<Bullet> bullets;
	
	public Gunner(double x, double y) {
		super(x, y);
		this.xVelocity = GUNNER_HORI_SPEED;
		this.originalXVelocity = GUNNER_HORI_SPEED;
		this.ticksUntilJump = 0;
		this.ticksUntilShoot = 0;
		this.image = Toolkit.getDefaultToolkit().getImage("images\\winged_goomba.png");
		this.bullets = new ArrayList<Bullet>();
	}
	
	@Override
	public void drawOn(Graphics2D g2) {
		super.drawOn(g2);
		g2.setColor(Color.BLACK);
		for(Bullet bullet : this.bullets) {
			bullet.drawOn(g2);
		}
	}
	
	public void updateBullets(Hero hero) {
		for(int k = 0; k < this.bullets.size(); k++) {
			bullets.get(k).update();
			if(bullets.get(k).checkCollision(hero)) {
				this.bullets.remove(k);
				if(hero.getIsPoweredUp() == false) {
					hero.respawn(true);
				}
			} else if(this.bullets.get(k).getX() <= 0 || this.bullets.get(k).getX() >= 1408 ||
					this.bullets.get(k).getY() <= 0 || this.bullets.get(k).getY() >= 768) {
				this.bullets.remove(k);
			}
		}
		this.ticksUntilShoot += 1;
		if(this.ticksUntilShoot >= SHOOT_COOLDOWN) {
			ticksUntilShoot = 0;
			this.shoot(hero);
		}
	}
	
	public void shoot(Hero hero) {
		double angle = Math.atan2((hero.yPos-this.yPos), (hero.xPos-this.xPos));
		Bullet newBullet = new Bullet(this.xPos, this.yPos, angle);
		this.bullets.add(newBullet);
	}
	
	@Override
	public boolean checkCollision(Hero hero) {
		if(super.checkCollision(hero)) {
			this.bullets.clear();
			return true;
		} return false;
	}
}
