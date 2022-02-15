package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.geom.Line2D;

public class Wall {
	
	private static final double WALL_LENGTH = 64;
	private static final double WALL_HEIGHT = 64;

	protected double xPos;
	protected double yPos;
	protected Rectangle2D.Double rect;
//	protected ArrayList<Line2D.Double> edges;
	
	public Wall(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, WALL_LENGTH, WALL_HEIGHT);
//		this.edges = new ArrayList<Line2D.Double>();
//		this.edges.add(new Line2D.Double(x, y, x + WALL_LENGTH, y));
//		this.edges.add(new Line2D.Double(x, y, x, y + WALL_HEIGHT));
//		this.edges.add(new Line2D.Double(x, y + WALL_HEIGHT, x + WALL_LENGTH, y + WALL_HEIGHT));
//		this.edges.add(new Line2D.Double(x + WALL_LENGTH, y, x + WALL_LENGTH, y + WALL_HEIGHT));
	}
	
//	public Wall(boolean top) {
//		if(top) {
//			this.yPos = 0;
//		} else {
//			this.yPos = 700;
//		} this.xPos = 0;
//		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, 750, 50);
//	}
	
	public Wall(int x, int y, double width, double height) {
		this.xPos = x;
		this.yPos = y;
		this.rect = new Rectangle2D.Double(x, y, width, height);
	}
	
	public boolean collision(Rectangle2D.Double hero) {
		return this.rect.contains(hero);
	}
	
	public void extend() {
		this.rect.width += WALL_LENGTH;
	}
	
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.fill(rect);
	}
	
}
