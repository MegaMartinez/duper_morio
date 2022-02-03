package mainApp;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Bomb extends Wall {
	
	private final double BOMB_WIDTH = 30;
	private final double BOMB_LENGTH = 30;
	
	public Bomb(int x, int y) {
		super(x, y);
		this.xPos = x + 10;
		this.yPos = y + 10;
		this.rect = new Rectangle2D.Double(this.xPos, this.yPos, BOMB_WIDTH, BOMB_LENGTH);
	}

}
