package mainApp;

import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

/**
 * Class: Bomb
 * @author Team 405
 * Purpose: Class to hold methods and information for the bomb class. Draws and checks collisions with the hero.
 * 			Extends Wall as a superclass for position and hitbox information
 */

public class Bomb extends Wall {
	
	private static final double BOMB_WIDTH = 32;
	private static final double BOMB_HEIGHT = 32;
	private static final int BOMB_SCORE = 50;
	
	public Bomb(int x, int y) {
		super(x, y);
		this.xPos = x + BOMB_WIDTH/2;
		this.yPos = y + BOMB_HEIGHT/2;
		this.image = Toolkit.getDefaultToolkit().getImage("images\\coin.png");
		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, BOMB_WIDTH, BOMB_HEIGHT);
	}
	
	public void drawOn(Graphics2D g2) {
		g2.drawImage(this.image, (int) this.xPos, (int) this.yPos, null);
	}
	
	public int getScore() {return BOMB_SCORE;}
	
}
