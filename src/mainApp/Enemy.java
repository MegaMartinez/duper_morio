package mainApp;
import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy extends Character {
	
	private static final double HORI_SPEED = 5;
	private static final double ENEMY_WIDTH = 50;
	private static final double ENEMY_HEIGHT = 50;
	private static final Color GRUNT_COLOR = Color.BLUE;
	private static final Color OFFICER_COLOR = Color.GREEN;
	
	private Color color;
	
	public Enemy(double x, double y) {
		super(x, y, ENEMY_WIDTH, ENEMY_HEIGHT);
		this.xVelocity = HORI_SPEED;
	}
	
	public Enemy(double x, double y, String type) {
		super(x, y, ENEMY_WIDTH, ENEMY_HEIGHT);
		if(type == "Grunt") {
			this.xVelocity = HORI_SPEED;
			this.yVelocity = 0.9;
			this.color = GRUNT_COLOR;
		} else if(type == "Officer") {
			this.xVelocity = 3 * -HORI_SPEED;
			this.color = OFFICER_COLOR;
		}
	}
	
	@Override
	public void drawOn(Graphics2D g2) {
		g2.setColor(this.color);
		g2.fill(rect);
	}
	
	public Color getColor() {return this.color;}
	
	public void collides(Hero hero) {
		if (this.rect.intersects(hero.rect)) {
			hero.respawn();
		}
	}
	
//	public void platformCollide(Wall wall) {
//		if(this.rect.intersects(wall.rect)) {
//			this.yVelocity = 0;
//			this.yCoord = (int) wall.yPos - ENEMY_HEIGHT;
//		}
//	}

}
