package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class KeyboardListener implements KeyListener {

	private GameComponent component;
	private int levelNum;
	
	public KeyboardListener(GameComponent component) {
		this.component = component;
		this.levelNum = 1;
		
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
			this.component.moveHero('L');
			break;
		case KeyEvent.VK_RIGHT:
			this.component.moveHero('R');
			break;
		case KeyEvent.VK_UP:
			this.component.moveHero('U');
			break;
//		case KeyEvent.VK_DOWN:
//			this.component.moveHero('D');
//			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_LEFT:
			this.component.moveHero('-');
			break;
		case KeyEvent.VK_RIGHT:
			this.component.moveHero('-');
			break;
		case KeyEvent.VK_UP:
//			this.component.moveHero('U');
//			this.component.moveHero('|');
			break;
//		case KeyEvent.VK_DOWN:
//			this.component.moveHero('|');
//			break;

		case KeyEvent.VK_U:
			if(this.levelNum < 2) {
				levelNum += 1;
			} this.component.changeLevel(true);
//			this.component.loadLevel(this.levelNum);
			break;
		case KeyEvent.VK_D:
			if(this.levelNum > 1) {
				levelNum -= 1;
			} this.component.changeLevel(false);
//			this.component.loadLevel(this.levelNum);
			break;
		}
	}

}
