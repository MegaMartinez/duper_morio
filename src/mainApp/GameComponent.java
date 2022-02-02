package mainApp;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;



public class GameComponent extends JComponent {
	
	private Hero hero;
	
	public GameComponent() {
		this.hero = new Hero();
	}
	
	public void updateState() {
		this.hero.update();
	}
	
	public void drawScreen() {
		this.repaint();
	}
	
	public void moveHero(char direction) {
		this.hero.changeSpeed(direction);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		this.hero.drawOn(g2);

	}

}
