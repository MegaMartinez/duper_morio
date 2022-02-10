package mainApp;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JComponent;



public class GameComponent extends JComponent {
	
	private Hero hero;
	private ArrayList<String> levels;
	private ArrayList<Wall> walls;
	private ArrayList<Bomb> bombs;
	private ArrayList<Enemy> enemies;
	
	public GameComponent() {
		this.hero = new Hero();
		this.levels = new ArrayList<String>();
		this.walls = new ArrayList<Wall>();
		this.bombs = new ArrayList<Bomb>();
		this.enemies = new ArrayList<Enemy>();
		
		File dir = new File("Levels");
		for(File level : dir.listFiles()) {
			this.levels.add(level.getAbsolutePath());
		}
	}
	
	public void updateState() {
		this.hero.update();
		for(Enemy enemy : this.enemies) {
			enemy.update();
		}
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
//		g2.setColor(Color.RED);
		for(Wall wall : this.walls) {
			wall.drawOn(g2);
		}
//		g2.setColor(Color.YELLOW);
		for(Bomb bomb : this.bombs) {
			bomb.drawOn(g2);
		}
		for(Enemy enemy : this.enemies) {
//			g2.setColor(enemy.getColor());
			enemy.drawOn(g2);
		}
	}
	
	public void checkCollisions() {
		for (Wall wall : walls) {
			this.hero.platformCollide(wall);
		
			for(Enemy enemy : this.enemies) {
				enemy.platformCollide(wall);
			}
		}
	}
	
	public void loadLevel(int level) {
		FileReader file = null;
		try {
//		file = new FileReader("Level" + level);
		file = new FileReader(this.levels.get(level-1));
		} catch (FileNotFoundException e) {
			System.out.println("Level filename does not exist.");
			System.exit(1);
		}
		Scanner scanner = new Scanner(file);
		this.walls.clear();
		this.bombs.clear();
		this.enemies.clear();
		int xStart = 0;
		int yStart = 0;
		
		while(scanner.hasNext()) {
			String[] lineOfIDs = scanner.nextLine().trim().split(",");
			for(String ID : lineOfIDs) {
				if(Integer.parseInt(ID) == 1) {
					Wall newWall = new Wall(xStart, yStart);
					this.walls.add(newWall);
				} else if(Integer.parseInt(ID) == 2) {
					Bomb newBomb = new Bomb(xStart, yStart);
					this.bombs.add(newBomb);
				} else if(Integer.parseInt(ID) == 3) {
					Enemy newEnemy = new Enemy(xStart, yStart, "Grunt");
					this.enemies.add(newEnemy);
				} else if(Integer.parseInt(ID) == 4) {
					Enemy newEnemy = new Enemy(xStart, yStart, "Officer");
					this.enemies.add(newEnemy);
				} xStart += 50;
			}
			xStart = 0;
			yStart += 50;
		}
		
	}

}
