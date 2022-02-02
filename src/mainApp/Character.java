package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public abstract class Character {

	protected int xCoord;
	protected int yCoord;
	protected int xVelocity;
	protected int yVelocity;
	protected String image = "Unimplemented";
	protected Rectangle2D.Double tempBox;
	
	public Character() {
		this.xCoord = 200;
		this.yCoord = 300;
		this.xVelocity = 0;
		this.yVelocity = 0;
		this.tempBox = new Rectangle2D.Double(this.xCoord, this.yCoord, 50, 50);
	}
	
	public void update() {
		this.xCoord += this.xVelocity;
		this.yCoord += this.yVelocity;
		this.tempBox.x += this.xVelocity;
		this.tempBox.y += this.yVelocity;
	}
	
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fill(tempBox);
	}
}
