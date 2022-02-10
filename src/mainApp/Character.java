package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public abstract class Character {
	
	private final double Y_ACCELERATION = 0.7;

	protected double xPos;
	protected double yPos;
	protected double xVelocity;
	protected double yVelocity;
	protected String image = "Unimplemented";
	protected Rectangle2D.Double rect;
	protected boolean isFalling;
	
	public Character() {
		this.isFalling = true;
		this.xPos = 200;
		this.yPos = 300;
		this.xVelocity = 0;
		this.yVelocity = 0;
		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, 50, 50);
	}
	
	public Character(double x, double y, double width, double height) {
		this.isFalling = true;
		this.xPos = x;
		this.yPos = y;
		this.xVelocity = 0;
		this.yVelocity = 0;
		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, width, height);
	}
	
	public void update() {
		this.xPos += this.xVelocity;
		this.yPos += this.yVelocity;
		this.rect.x += this.xVelocity;
		this.rect.y += this.yVelocity;
		if(this.isFalling) {
			this.yVelocity += this.Y_ACCELERATION;
		}
	}
	
	public void drawOn(Graphics2D g2) {
		g2.fill(rect);
	}
	
	public void platformCollide(Wall wall) {
		if(this.rect.intersects(wall.rect)) {
			this.yVelocity = 0;
			this.yPos = (int) wall.yPos - this.rect.height;
			this.isFalling = false;
		}
		else {
			this.isFalling = true;
		}
	}
}
