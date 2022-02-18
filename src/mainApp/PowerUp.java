package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

public class PowerUp extends Wall {

	private static final double POWERUP_WIDTH = 32;
	private static final double POWERUP_HEIGHT = 32;
	
	public PowerUp(int x, int y) {
		super(x, y, POWERUP_WIDTH, POWERUP_HEIGHT);
		this.xPos = x + POWERUP_WIDTH/2;
		this.yPos = y + POWERUP_HEIGHT/2;
		this.image = Toolkit.getDefaultToolkit().getImage("images\\stor.png");
//		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, POWERUP_WIDTH, POWERUP_HEIGHT);
	}
	
	@Override
	public void drawOn(Graphics2D g2) {
//		g2.setColor(Color.PINK);
//		g2.fill(rect);
		g2.drawImage(this.image, (int) this.xPos, (int) this.yPos, null);
	}
	
	@Override
	public boolean checkCollision(Hero hero) {
		if(super.checkCollision(hero)) {
			hero.makePoweredUp(true);
			return true;
		} return false;	
	}
	
}
