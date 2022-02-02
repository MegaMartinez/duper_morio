package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class KeyboardListener implements KeyListener {

	private char direction;
	private GameComponent component;
	
	public KeyboardListener(GameComponent component, char direction) {
		this.component = component;
		this.direction = direction;
		
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
			try {
			this.component.loadLevel(1);
			} catch (FileNotFoundException error) {
				System.out.println("Level filename got borked.");
				System.exit(1);
			}
		}
	}

}
