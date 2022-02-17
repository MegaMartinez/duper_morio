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

/**
 * Class: GameComponent
 * @author Team 405
 * Purpose: Class to run all the game's operations. Handles drawing, movement, and collsions for all objects. Also loads and changes 
 * 			levels from files.
 */

public class GameComponent extends JComponent {
	
	private static final int BLOCK_OFFSET = 64;
	
	private Hero hero;
	private ArrayList<String> levels;
	private ArrayList<Wall> walls;
	private ArrayList<Bomb> bombs;
	private ArrayList<Enemy> enemies;
	private int levelNum = 1;
	
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
		this.checkCollisions();
		if(bombs.size() == 0) {
			this.changeLevel(true);
		}
		this.hero.update();
		for(Enemy enemy : this.enemies) {
			enemy.update();
		}
	}
	
	public void drawScreen() {
		this.repaint();
	}
	
	public int getLives() {
		return this.hero.getLives();
	}
	
	public void moveHero(char direction) {
		this.hero.changeSpeed(direction);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
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
		this.hero.drawOn(g2);
	}
	
	public void checkCollisions() {
		for (Wall wall : walls) {
			this.hero.platformCollide(wall);
		
			for(Enemy enemy : this.enemies) {
				enemy.platformCollide(wall);
			}
		}

		for(int k = 0; k < this.bombs.size(); k++) {
			if(bombs.get(k).rect.intersects(hero.rect)) {
				bombs.remove(k);
			}
		}
		
		for (Enemy enemy : enemies) {
			enemy.collides(hero);
		}
	}
	
	public void changeLevel(boolean up) {
		if(up) {
			levelNum += 1;
			this.loadLevel();
		} else {
			levelNum -= 1;
			this.loadLevel();
		}
	}
	
	/**
	 * Purpose:Reads files and loads levels from them based on the characters in the file
	 * Restrictions: Files have to be premade with the correct formatting and number of characters for the method to work properly.
	 */
	public void loadLevel() {
		FileReader file = null;
		try {
		file = new FileReader(this.levels.get(this.levelNum-1));
		} catch (FileNotFoundException e) {
			System.out.println("Level filename does not exist.");
			System.exit(1);
		}
		Scanner scanner = new Scanner(file);
		this.walls.clear();
		this.bombs.clear();
		this.enemies.clear();
		this.walls.add(new Wall(0, 0, 1408, 64));
		this.walls.add(new Wall(0, 704, 1408, 64));
		this.walls.add(new Wall(0, 64, 64, 704));
		this.walls.add(new Wall(1344, 64, 64, 704));
		int xStart = 64;
		int yStart = 64;
		boolean continuousWall = false;
		
		while(scanner.hasNext()) {
			String[] lineOfIDs = scanner.nextLine().trim().split(",");
			for(String ID : lineOfIDs) {
				switch(Integer.parseInt(ID)){
					default:
						continuousWall = false;
						break;
					case 1:
						if(continuousWall) {
							this.walls.get(this.walls.size()-1).extend();
						} else {
							Wall newWall = new Wall(xStart, yStart);
							this.walls.add(newWall);
							continuousWall = true;
						}
						break;
					case 2:
						Bomb newBomb = new Bomb(xStart, yStart);
						this.bombs.add(newBomb);
						continuousWall = false;
						break;
					case 3:
						{
//						Enemy newEnemy = new Enemy(xStart, yStart, "Grunt");
//						this.enemies.add(newEnemy);
						Jumper newJumper = new Jumper(xStart, yStart);
						this.enemies.add(newJumper);
						continuousWall = false;
						}
						break;
					case 4:
						{
						Enemy newEnemy = new Enemy(xStart, yStart, "Officer");
						this.enemies.add(newEnemy);
						continuousWall = false;
						}
						break;

				} xStart += 64;
				
				// if(Integer.parseInt(ID) == 1) {
				// 	if(continuousWall) {
				// 		this.walls.get(this.walls.size()-1).extend();
				// 	} else {
				// 		Wall newWall = new Wall(xStart, yStart);
				// 		this.walls.add(newWall);
				// 		continuousWall = true;
				// 	}
				// } else if(Integer.parseInt(ID) == 2) {
				// 	Bomb newBomb = new Bomb(xStart, yStart);
				// 	this.bombs.add(newBomb);
				// 	continuousWall = false;
				// } else if(Integer.parseInt(ID) == 3) {
				// 	Enemy newEnemy = new Enemy(xStart, yStart, "Grunt");
				// 	this.enemies.add(newEnemy);
				// 	continuousWall = false;
				// } else if(Integer.parseInt(ID) == 4) {
				// 	Enemy newEnemy = new Enemy(xStart, yStart, "Officer");
				// 	this.enemies.add(newEnemy);
				// 	continuousWall = false;
				// } else {
				// 	continuousWall = false;
				// } xStart += 50;
			}

			xStart = 64;
			yStart += 64;

			continuousWall = false;
		}
		
	}

}
