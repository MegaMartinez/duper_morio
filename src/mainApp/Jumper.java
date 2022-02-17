package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Jumper extends Enemy {
	
	private static final double JUMP_SPEED = 8;
	
	private int ticksUntilJump;
	
	public Jumper(double x, double y) {
		super(x, y);
		this.ticksUntilJump = 0;
	}
	
	@Override
	public void drawOn(Graphics2D g2) {
		g2.setColor(Color.BLUE);
		g2.fill(rect);
	}
	
	@Override
	public void update() {
		super.update();
		this.ticksUntilJump += 1;
//		System.out.println("Jumper's current y velocity is: " + this.yVelocity);
		if(this.ticksUntilJump >= 40) {
//			System.out.println("Jumper should be jumping.");
			this.yVelocity = -JUMP_SPEED;
			this.ticksUntilJump = 0;
		}
	}

}
