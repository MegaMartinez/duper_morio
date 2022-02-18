package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

/**
 * Class: Bomb
 * @author Team 405
 * Purpose: Class to hold methods and information for the bomb class. Draws and checks collisions with the hero.
 * 			Extends Wall as a superclass for position and hitbox information
 */

public class Bomb extends Wall {
	
	private final double BOMB_WIDTH = 32;
	private final double BOMB_HEIGHT = 32;
	
	public Bomb(int x, int y) {
		super(x, y);
		this.xPos = x + BOMB_WIDTH/2;
		this.yPos = y + BOMB_HEIGHT/2;
		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, BOMB_WIDTH, BOMB_HEIGHT);
	}
	
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.YELLOW);
		g2.fill(rect);
	}
	
//	public boolean checkCollision(Hero hero) {
//		return this.rect.intersects(hero.rect);
//	}

}
