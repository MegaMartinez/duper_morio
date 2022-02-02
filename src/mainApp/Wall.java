package mainApp;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Wall {

	private double xPos;
	private double yPos;
	private final double LENGTH = 100;
	private final double WIDTH = 50;
	private Rectangle2D.Double rect;
	
	public Wall(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		this.rect = new Rectangle2D.Double(xPos, yPos, this.LENGTH, this.WIDTH);
	}
	
	private boolean collides(Rectangle2D hero) {
		return this.rect.contains(hero);
	}
	
	
}
