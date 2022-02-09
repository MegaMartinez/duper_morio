package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public abstract class Character {
	
	private final double Y_ACCELERATION = 0.7;

	protected int xCoord;
	protected int yCoord;
	protected int xVelocity;
	protected int yVelocity;
	protected String image = "Unimplemented";
	protected Rectangle2D.Double rect;
	protected boolean isFalling;
	
	public Character() {
		this.isFalling = true;
		this.xCoord = 200;
		this.yCoord = 300;
		this.xVelocity = 0;
		this.yVelocity = 0;
		this.rect = new Rectangle2D.Double(this.xCoord, this.yCoord, 50, 50);
	}
	
	public Character(int x, int y, int width, int height) {
		this.xCoord = x;
		this.yCoord = y;
		this.xVelocity = 0;
		this.yVelocity = 0;
		this.rect = new Rectangle2D.Double(this.xCoord, this.yCoord, width, height);
	}
	
	public void update() {
		this.xCoord += this.xVelocity;
		this.yCoord += this.yVelocity;
		this.rect.x += this.xVelocity;
		this.rect.y += this.yVelocity;
		if (this.isFalling) {
			this.yVelocity += this.Y_ACCELERATION;
		}
	}
	
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fill(rect);
	}
	
	public abstract void platformCollide(Wall wall);
}
