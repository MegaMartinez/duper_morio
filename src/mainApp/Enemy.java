package mainApp;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Class: Enemy
 * @author Team 405
 * Purpose: Class to hold information for the enemies. Inherits from the Character class,
 * with different movement and collisions with the hero. Specifically, it has a method to
 * check for player collision and act accordingly, plus it reverses when hitting a wall.
 */
public class Enemy extends Character {
	
	private static final double HORI_SPEED = 6;
	private static final double ENEMY_WIDTH = 32;
	private static final double ENEMY_HEIGHT = 32;
	private static final int ENEMY_SCORE = 100;
	protected static final int JUMP_COOLDOWN = 100;
	private static final int ENEMY_JUMP_SPEED = 14;
	
	protected double originalXVelocity;
	protected int direction = -1;
	protected int ticksUntilJump;
	protected int score;
	
//	private static final Color GRUNT_COLOR = Color.BLUE;
//	private static final Color OFFICER_COLOR = Color.GREEN;
	
	private Color color;
	
	public Enemy(double x, double y) {
		super(x, y, ENEMY_WIDTH, ENEMY_HEIGHT);
		this.xVelocity = HORI_SPEED;
		this.originalXVelocity = HORI_SPEED;
		this.yVelocity = 0;
		this.ticksUntilJump = 0;
		this.score = ENEMY_SCORE;
	}
	
//	public Enemy(double x, double y, String type) {
//		super(x, y, ENEMY_WIDTH, ENEMY_HEIGHT);
//		if(type == "Grunt") {
//			this.xVelocity = HORI_SPEED;
//			this.yVelocity = 0.9;
//			this.color = GRUNT_COLOR;
//		} else if(type == "Officer") {
//			this.xVelocity = -HORI_SPEED;
//			this.color = OFFICER_COLOR;
//		}
//	}
	
	@Override
	public void update() {
	super.update();
	this.ticksUntilJump += 1;
	if(this.ticksUntilJump >= JUMP_COOLDOWN) {
		this.yVelocity = -ENEMY_JUMP_SPEED;
		this.ticksUntilJump = 0;
		}
	}
	
	@Override
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.GREEN);
		g2.fill(rect);
	}
	
//	public Color getColor() {return this.color;}
	
	public boolean checkCollision(Hero hero) {
		if (this.rect.intersects(hero.rect)) {
			if(hero.getIsPoweredUp()) {
				return true;
			} else {
				hero.respawn();
			}
		} return false;
	}
	
	@Override
	public void platformCollide(Wall wall) {
		super.platformCollide(wall);
		if(this.xVelocity == 0) {
			this.xVelocity = this.originalXVelocity * this.direction;
			this.direction *= -1;
		}
	}
	
	public int getScore() {return this.score;}

}
