package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class KeyboardListener implements KeyListener {

	private GameComponent component;
	private int levelNum;
	
	public KeyboardListener(GameComponent component) {
		this.component = component;
		this.levelNum = 0;
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
//		int keyCode = e.getKeyCode();
//		switch(keyCode) {
//			case KeyEvent.VK_LEFT:
//				System.out.println("Left key typed.");
//				this.component.moveHero('L');
//				break;
//			case KeyEvent.VK_RIGHT:
//				System.out.println("Right key typed.");
//				this.component.moveHero('R');
//				break;
//			case KeyEvent.VK_UP:
//				System.out.println("Up key typed.");
//				this.component.moveHero('L');
//				break;
//		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_LEFT:
//			System.out.println("Left key pressed.");
			this.component.moveHero('L');
			break;
		case KeyEvent.VK_RIGHT:
//			System.out.println("Right key pressed.");
			this.component.moveHero('R');
			break;
		case KeyEvent.VK_UP:
//			System.out.println("Up key pressed.");
			this.component.moveHero('U');
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("Key released.");
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_LEFT:
			this.component.moveHero('-');
			break;
		case KeyEvent.VK_RIGHT:
			this.component.moveHero('-');
			break;
		case KeyEvent.VK_UP:
			this.component.moveHero('D');
			break;
		case KeyEvent.VK_U:
			System.out.println("U key is running.");
			if(this.levelNum < 2) {
				levelNum += 1;
				System.out.println("Level number got increased to " + this.levelNum);
			}
			try {
			this.component.loadLevel(this.levelNum);
			} catch (FileNotFoundException error) {
				System.out.println("Level filename got borked.");
				System.exit(1);
			} break;
		case KeyEvent.VK_D:
			System.out.println("D key is running.");
			if(this.levelNum > 1) {
				levelNum -= 1;
				System.out.println("Level number got decreased to " + this.levelNum);
			}
			try {
			this.component.loadLevel(this.levelNum);
			} catch (FileNotFoundException error) {
				System.out.println("Level filename got borked.");
				System.exit(1);
			} break;
		}
	}

}
