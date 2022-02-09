package mainApp;

public class Enemy extends Character {
	
	private final int HORI_SPEED = 5;
	private final int ENEMY_WIDTH = 50;
	private final int ENEMY_HEIGHT = 50;
	
	public Enemy() {
		super();
	}
	
	public void platformCollide(Wall wall) {
		if(this.rect.intersects(wall.rect)) {
			this.yVelocity = 0;
			this.yCoord = (int) wall.yPos - ENEMY_HEIGHT;
		}
	}

}
