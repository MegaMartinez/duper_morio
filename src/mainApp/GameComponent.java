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
	private ArrayList<PowerUp> powerUps;
	private int levelNum = 1;
	private int frameWidth;
	private int frameHeight;
	private int score;
	
	public GameComponent(int frameWidth, int frameHeight) {
		this.hero = new Hero();
		this.levels = new ArrayList<String>();
		this.walls = new ArrayList<Wall>();
		this.bombs = new ArrayList<Bomb>();
		this.enemies = new ArrayList<Enemy>();
		this.powerUps = new ArrayList<PowerUp>();
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.setScore(0);
		
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
		for(Wall wall : this.walls) {
			wall.drawOn(g2);
		}
		for(Bomb bomb : this.bombs) {
			bomb.drawOn(g2);
		}
		for(PowerUp powerUp : this.powerUps) {
			powerUp.drawOn(g2);
		}
		for(Enemy enemy : this.enemies) {
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
			if(bombs.get(k).checkCollision(this.hero)) {
				bombs.remove(k);
				this.score += bombs.get(k).getScore();
			}
		}
		for(int k = 0; k < this.powerUps.size(); k++) {
			if(powerUps.get(k).checkCollision(this.hero)) {
				powerUps.remove(k);
			}
		}
//		for (Enemy enemy : enemies) {
//			enemy.checkCollision(hero);
//		}
		for(int k = 0; k < this.enemies.size(); k++) {
			if(enemies.get(k).checkCollision(this.hero)) {
				enemies.remove(k);
				this.score += enemies.get(k).getScore();
			}
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
		file = new FileReader(this.levels.get(this.levelNum - 1));
		} catch (FileNotFoundException e) {
			System.out.println("Level filename does not exist.");
			System.exit(1);
		}
		Scanner scanner = new Scanner(file);
		this.walls.clear();
		this.bombs.clear();
		this.enemies.clear();
		this.powerUps.clear();
		this.hero.makePoweredUp(false);
		this.walls.add(new Wall(0, 0, this.frameWidth, BLOCK_OFFSET));
		this.walls.add(new Wall(0, this.frameHeight - BLOCK_OFFSET, this.frameWidth, BLOCK_OFFSET));
		this.walls.add(new Wall(0, BLOCK_OFFSET, BLOCK_OFFSET, this.frameHeight - BLOCK_OFFSET));
		this.walls.add(new Wall(this.frameWidth - BLOCK_OFFSET, BLOCK_OFFSET, BLOCK_OFFSET, this.frameHeight - BLOCK_OFFSET));
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
						Jumper newJumper = new Jumper(xStart, yStart);
						this.enemies.add(newJumper);
						continuousWall = false;
						break;
					case 4:
						Enemy newEnemy = new Enemy(xStart, yStart);
						this.enemies.add(newEnemy);
						continuousWall = false;
						break;
					case 5:
						PowerUp newPowerUp = new PowerUp(xStart, yStart);
						this.powerUps.add(newPowerUp);
						continuousWall = false;
						break;

				} xStart += BLOCK_OFFSET;
				
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

			xStart = BLOCK_OFFSET;
			yStart += BLOCK_OFFSET;

			continuousWall = false;
		}
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
