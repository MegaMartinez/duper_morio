package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.geom.Line2D;

public class Wall {
	
	private static final double WALL_LENGTH = 50;
	private static final double WALL_HEIGHT = 50;

	protected double xPos;
	protected double yPos;
	protected Rectangle2D.Double rect;
	protected ArrayList<Line2D.Double> edges;
	
	public Wall(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, WALL_LENGTH, WALL_HEIGHT);
		this.edges = new ArrayList<Line2D.Double>();
		this.edges.add(new Line2D.Double(x, y, x + WALL_LENGTH, y));
		this.edges.add(new Line2D.Double(x, y, x, y + WALL_HEIGHT));
		this.edges.add(new Line2D.Double(x, y + WALL_HEIGHT, x + WALL_LENGTH, y + WALL_HEIGHT));
		this.edges.add(new Line2D.Double(x + WALL_LENGTH, y, x + WALL_LENGTH, y + WALL_HEIGHT));
	}
	
	public boolean collision(Rectangle2D.Double hero) {
		return this.rect.contains(hero);
	}
	
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.fill(rect);
	}
	
}
