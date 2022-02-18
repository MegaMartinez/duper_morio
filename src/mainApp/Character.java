package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

/**
 * Class: Character
 * @author Team 405
 * Purpose: Abstract class that holds necessary information and methods shared by the hero and enemies. Also has the method to check
 * 			collision with the platforms.
 */

public abstract class Character {
	
	private final double Y_ACCELERATION = 0.3;

	protected double xPos;
	protected double yPos;
	protected double xVelocity;
	protected double yVelocity;
	protected Image image;
	protected Rectangle2D.Double rect;
	protected boolean isFalling;
	
//	public Character() {
//		this.isFalling = true;
//		this.xPos = 200;
//		this.yPos = 300;
//		this.xVelocity = 0;
//		this.yVelocity = 0;
//		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, 50, 50);
//	}
	
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
		this.rect.x = this.xPos;
		this.rect.y = this.yPos;
//		if(this.isFalling) {
			this.yVelocity += this.Y_ACCELERATION;
//		}
	}
	
	public void drawOn(Graphics2D g2) {
//		g2.fill(rect);
		g2.drawImage(this.image, (int) this.xPos, (int) this.yPos, null);
	}
	
	/**
	 * @param wall used to check collision with certain wall
	 * Purpose: Handles collisions from all directions between a character and a wall or platform
	 * Restrictions: none
	 */
	public void platformCollide(Wall wall) {
		
		Rectangle2D.Double measureBox = new Rectangle2D.Double(this.xPos + this.xVelocity, this.yPos, this.rect.width, this.rect.height);
		if(measureBox.intersects(wall.rect)) {
			if(measureBox.x + measureBox.width >= wall.xPos && measureBox.x + measureBox.width < wall.xPos + wall.rect.width) {
				this.xPos = wall.xPos - this.rect.width;
			} else {
				this.xPos = wall.xPos + wall.rect.width;
			}
			measureBox.x -= this.xVelocity;
			this.xVelocity = 0;
		} else {
			measureBox.x -= this.xVelocity;
		} measureBox.y += this.yVelocity;
		if(measureBox.intersects(wall.rect)) {
			if(measureBox.y + measureBox.height >= wall.yPos && measureBox.y + measureBox.height < wall.yPos + wall.rect.height) {
				this.yPos = wall.yPos - this.rect.height;
				this.isFalling = false;
			} else {
				this.yPos = wall.yPos + wall.rect.height;
				this.isFalling = true;
			}
			this.yVelocity = 0;
		} else {
			this.isFalling = true;
		}
		
	}
	
}
