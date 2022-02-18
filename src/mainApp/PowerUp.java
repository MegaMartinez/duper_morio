package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class PowerUp extends Wall {

	private final double POWERUP_WIDTH = 32;
	private final double POWERUP_HEIGHT = 32;
	
	public PowerUp(int x, int y) {
		super(x, y);
		this.xPos = x + POWERUP_WIDTH/2;
		this.yPos = y + POWERUP_HEIGHT/2;
		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, POWERUP_WIDTH, POWERUP_HEIGHT);
	}
	
	@Override
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.PINK);
		g2.fill(rect);
	}
	
	@Override
	public boolean checkCollision(Hero hero) {
		if(super.checkCollision(hero)) {
			hero.makePoweredUp(true);
			return true;
		} return false;
		
	}
	
}
