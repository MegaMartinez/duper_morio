package mainApp;

public class Enemy extends Character {
	
	private static final double HORI_SPEED = 5;
	private static final double ENEMY_WIDTH = 50;
	private static final double ENEMY_HEIGHT = 50;
	
	public Enemy(double x, double y) {
		super(x, y, ENEMY_WIDTH, ENEMY_HEIGHT);
		this.xVelocity = HORI_SPEED;
	}
	
	public void platformCollide(Wall wall) {
		if(this.rect.intersects(wall.rect)) {
			this.yVelocity = 0;
			this.yCoord = (int) wall.yPos - ENEMY_HEIGHT;
		}
	}

}
