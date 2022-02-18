package mainApp;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Bullet {
	
	private static final int BULLET_SIZE = 8;
	private static final double BULLET_SPEED = 5;
	
	private double xPos;
	private double yPos;
	private double xVelocity;
	private double yVelocity;
	protected Rectangle2D.Double rect;
	
	public Bullet(double x, double y) {
		this.xPos = x;
		this.yPos = y;
		this.xVelocity = 5;
		this.yVelocity = 5;
		this.rect = new Rectangle2D.Double(x, y, BULLET_SIZE, BULLET_SIZE);
	}
	
	public void update() {
		this.xPos += this.xVelocity;
		this.yPos += this.yVelocity;
	}
	
	public void calculateSpeed(double x, double y) {
		
	}
	
	public double getX() {return this.xPos;}
	
	public double getY() {return this.yPos;}

}
