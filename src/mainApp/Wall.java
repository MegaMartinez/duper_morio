package mainApp;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

/**
 * Class: Wall
 * @author Team 405
 * Purpose: Holds position, size, and hitbox information for the platforms and walls. Also draws them and checks collisions
 */

public class Wall {
	
	private static final double WALL_WIDTH = 64;
	private static final double WALL_HEIGHT = 64;

	protected double xPos;
	protected double yPos;
	protected Image image;
	protected Rectangle2D.Double rect;
	
	public Wall(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		this.image = Toolkit.getDefaultToolkit().getImage("images\\grass_tile.png");
		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, WALL_WIDTH, WALL_HEIGHT);
	}
	
	public Wall(int x, int y, double width, double height) {
		this.xPos = x;
		this.yPos = y;
		this.image = Toolkit.getDefaultToolkit().getImage("images\\grass_tile.png");
		this.rect = new Rectangle2D.Double(x, y, width, height);
	}
	
	public boolean checkCollision(Hero hero) {
		return this.rect.intersects(hero.rect);
	}
	
	public void extend() {
		this.rect.width += WALL_WIDTH;
	}
	
	public void drawOn(Graphics2D g2) {
		int xStart = (int) this.xPos;
		int yStart = (int) this.yPos;
		for(int k = 0; k < this.rect.width / WALL_WIDTH; k++) {
			g2.drawImage(this.image, xStart, (int) this.yPos, null);
			xStart += WALL_WIDTH;
		}
		for(int k = 1; k < this.rect.height / WALL_HEIGHT; k++) {
			g2.drawImage(this.image, (int) this.xPos, yStart, null);
			yStart += WALL_WIDTH;
		}
	}
	
}
