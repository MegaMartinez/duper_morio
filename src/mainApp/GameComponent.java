package mainApp;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComponent;



public class GameComponent extends JComponent {
	
	private Hero hero;
	private ArrayList<Wall> walls;
	
	public GameComponent() {
		this.hero = new Hero();
		this.walls = new ArrayList<Wall>();
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
		g2.setColor(Color.RED);
		for(Wall wall : this.walls) {
			wall.drawOn(g2);
		}

	}
	
	public void loadLevel(int level) throws FileNotFoundException {
		FileReader file = new FileReader("Level" + level);
		Scanner scanner = new Scanner(file);
		this.walls.clear();
		int xStart = 0;
		int yStart = 0;
		
		while(scanner.hasNext()) {
			String[] lineOfIDs = scanner.nextLine().split(",");
			for(String ID : lineOfIDs) {
				if(Integer.parseInt(ID.trim()) == 1) {
					Wall newWall = new Wall(xStart, yStart);
					this.walls.add(newWall);
				} xStart += 50;
			}
			xStart = 0;
			yStart += 50;
		}
		
	}

}
