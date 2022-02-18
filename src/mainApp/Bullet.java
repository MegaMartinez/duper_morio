package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Bullet extends Wall {
	
	private static final double BULLET_SIZE = 8;
	private static final double BULLET_SPEED = 3;
	
	private double angle;
	private double xVelocity;
	private double yVelocity;
	
	public Bullet(double x, double y, double angle) {
		super((int) x, (int) y, BULLET_SIZE, BULLET_SIZE);
		this.xVelocity = BULLET_SPEED * Math.cos(angle);
		this.yVelocity = BULLET_SPEED * Math.sin(angle);
	}
	
	public void update() {
		this.xPos += this.xVelocity;
		this.yPos += this.yVelocity;
		this.rect.x = this.xPos;
		this.rect.y = this.yPos;
	}
	
	public void drawOn(Graphics2D g2) {
		g2.fill(rect);
	}
	
	public double getX() {return this.xPos;}
	
	public double getY() {return this.yPos;}

}
