package mainApp;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Enemy extends Character {
	
	private static final double HORI_SPEED = 3;
	private static final double ENEMY_WIDTH = 50;
	private static final double ENEMY_HEIGHT = 50;
	private static final Color GRUNT_COLOR = Color.BLUE;
	private static final Color OFFICER_COLOR = Color.GREEN;
	
	private Color color;
	
	public Enemy(double x, double y) {
		super(x, y, ENEMY_WIDTH, ENEMY_HEIGHT);
		this.xVelocity = HORI_SPEED;
		this.yVelocity = 0;
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
	
	@Override
	public void update() {
		super.update();
		if(this.xPos == 50 || this.xPos == 650) {
			this.xVelocity = -this.xVelocity;
		}
	}
	
	@Override
	public void platformCollide(Wall wall) {
		Rectangle2D.Double measureBox = new Rectangle2D.Double(this.rect.x + this.xVelocity, this.rect.y, this.rect.width, this.rect.height);
		if(measureBox.intersects(wall.rect)) {
			if(measureBox.x + measureBox.width >= wall.xPos && measureBox.x + measureBox.width < wall.xPos + wall.rect.width) {
				this.xPos = wall.xPos - this.rect.width;
			} else {
				this.xPos = wall.xPos + wall.rect.width;
			}
			measureBox.x -= this.xVelocity;
			this.xVelocity = -this.xVelocity;
		} else {
			measureBox.x -= this.xVelocity;
		} measureBox.y += this.yVelocity;
		if(measureBox.intersects(wall.rect)) {
			if(measureBox.y + measureBox.height >= wall.yPos && measureBox.y + measureBox.height < wall.yPos + wall.rect.height) {
				this.yPos = wall.yPos - this.rect.height;
				this.isFalling = false;
			} else {
				this.yPos = wall.yPos + wall.rect.height;
				this.isFalling = true;
			}
			this.yVelocity = 0;
		} else {
			this.isFalling = true;
		}
	}
	
//	public void platformCollide(Wall wall) {
//		if(this.rect.intersects(wall.rect)) {
//			this.yVelocity = 0;
//			this.yCoord = (int) wall.yPos - ENEMY_HEIGHT;
//		}
//	}

}
