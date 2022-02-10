package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
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
		this.rect = new Rectangle2D.Double(x, y, width, height);
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
//		if(this.rect.intersects(wall.rect)) {
//			if(this.rect.y + this.rect.height > wall.yPos && this.rect.y + this.rect.height < wall.yPos + 25) {
//				this.yVelocity = 0;
////				this.yPos = wall.yPos - this.rect.height;
//				this.rect.y = wall.yPos - this.rect.height;
//				this.isFalling = false;
//			} else if(this.rect.y < wall.yPos + wall.rect.height) {
//				this.yVelocity = 0;
//				this.rect.y = wall.yPos + wall.rect.height;
//				this.isFalling = true;
//			}
//		} else {
//			this.isFalling = true;
//		}
//		if(this.rect.intersects(wall.rect)) {
//			if(this.isFalling && this.rect.x + this.rect.width > wall.xPos) {
//				this.xVelocity = 0;
//				this.rect.x = wall.xPos - this.rect.width;
//			} else if(this.isFalling && this.rect.x < wall.xPos + wall.rect.width) {
//				this.xVelocity = 0;
//				this.rect.x = wall.xPos + wall.rect.width;
//			}
//		}
		
		if(this.rect.intersects(wall.rect)) {
			if(this.rect.intersectsLine(wall.edges.get(0))) {
				this.yVelocity = 0;
				this.rect.y = wall.yPos - this.rect.height;
				this.isFalling = false;
			} else if(this.rect.intersectsLine(wall.edges.get(2))) {
				this.yVelocity = 0;
				this.rect.y = wall.yPos + wall.rect.height;
				this.isFalling = true;
			}
		} else {
			this.isFalling = true;
		}
		if(this.rect.intersects(wall.rect)) {
			if(this.rect.intersectsLine(wall.edges.get(1))) {
				this.xVelocity = 0;
				this.rect.x = wall.xPos - this.rect.width;
			} else if(this.rect.intersectsLine(wall.edges.get(3))) {
				this.xVelocity = 0;
				this.rect.x = wall.xPos + wall.rect.width;
			}
		}
	}
}
