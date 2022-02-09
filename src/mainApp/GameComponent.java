package mainApp;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JComponent;



public class GameComponent extends JComponent {
	
	private Hero hero;
	private ArrayList<Wall> walls;
	private ArrayList<Bomb> bombs;
	
	public GameComponent() {
		this.hero = new Hero();
		this.walls = new ArrayList<Wall>();
		this.bombs = new ArrayList<Bomb>();
	}
	
	public void updateState() {
		this.hero.update();
		this.checkCollisions();
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
		g2.setColor(Color.YELLOW);
		for(Bomb bomb : this.bombs) {
			bomb.drawOn(g2);
		}
	}
	
	public void checkCollisions() {
		for (Wall wall : walls) {
			this.hero.platformCollide(wall);
		}
	}
	
	
	public void loadLevel(int level) {
		FileReader file = null;
		try {
		file = new FileReader("Level" + level);
		} catch (FileNotFoundException e) {
			System.out.println("Level filename does not exist.");
			System.exit(1);
		}
		Scanner scanner = new Scanner(file);
		this.walls.clear();
		this.bombs.clear();
		int xStart = 0;
		int yStart = 0;
		
		while(scanner.hasNext()) {
			String[] lineOfIDs = scanner.nextLine().split(",");
			for(String ID : lineOfIDs) {
				if(Integer.parseInt(ID.trim()) == 1) {
					Wall newWall = new Wall(xStart, yStart);
					this.walls.add(newWall);
				} else if(Integer.parseInt(ID.trim()) == 2) {
					Bomb newBomb = new Bomb(xStart, yStart);
					this.bombs.add(newBomb);
				} xStart += 50;
			}
			xStart = 0;
			yStart += 50;
		}
		
	}

}
