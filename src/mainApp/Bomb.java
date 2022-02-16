package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Bomb extends Wall {
	
	private final double BOMB_WIDTH = 32;
	private final double BOMB_LENGTH = 32;
	
	public Bomb(int x, int y) {
		super(x, y);
		this.xPos = x + 16;
		this.yPos = y + 16;
		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, BOMB_WIDTH, BOMB_LENGTH);
	}
	
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.YELLOW);
		g2.fill(rect);
	}
	
	public boolean checkCollision(Hero hero) {
		return this.rect.intersects(hero.rect);
	}

}
