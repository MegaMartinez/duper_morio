package mainApp;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Wall {

	private double xPos;
	private double yPos;
	private final double LENGTH = 50;
	private final double WIDTH = 50;
	private Rectangle2D.Double rect;
	
	public Wall(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, this.LENGTH, this.WIDTH);
	}
	
	public boolean collision(Rectangle2D.Double hero) {
		return this.rect.contains(hero);
	}
	
	public void drawOn(Graphics2D g2) {
		g2.fill(rect);
	}
	
}
