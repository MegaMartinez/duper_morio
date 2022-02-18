package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.geom.Line2D;

/**
 * Class: Wall
 * @author Team 405
 * Purpose: Holds position, size, and hitbox information for the platforms and walls. Also draws them and checks collisions
 */

public class Wall {
	
	private static final double WALL_LENGTH = 64;
	private static final double WALL_HEIGHT = 64;

	protected double xPos;
	protected double yPos;
	protected Rectangle2D.Double rect;
	
	public Wall(int x, int y) {
		this.xPos = x;
		this.yPos = y;
		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, WALL_LENGTH, WALL_HEIGHT);
	}
	
	public Wall(int x, int y, double width, double height) {
		this.xPos = x;
		this.yPos = y;
		this.rect = new Rectangle2D.Double(x, y, width, height);
	}
	
//	public boolean checkCollision(Rectangle2D.Double hero) {
//		return this.rect.contains(hero);
//	}
	public boolean checkCollision(Hero hero) {
		return this.rect.intersects(hero.rect);
	}
	
	public void extend() {
		this.rect.width += WALL_LENGTH;
	}
	
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.fill(rect);
	}
	
}
