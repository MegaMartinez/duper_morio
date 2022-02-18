package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class: KeyboardListener
 * @author Team 405
 * Purpose: Checks key inputs for the GameComponent class.
 */

public class KeyboardListener implements KeyListener {

	private GameComponent component;
	private int levelNum;
	boolean left;
	boolean right;
	
	public KeyboardListener(GameComponent component) {
		this.component = component;
		this.levelNum = 1;
		this.left = false;
		this.right = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		return;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_LEFT:
			this.component.moveHero('L');
			this.left = true;
			break;
		case KeyEvent.VK_RIGHT:
			this.component.moveHero('R');
			this.right = true;
			break;
		case KeyEvent.VK_UP:
			this.component.moveHero('U');
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_LEFT:
			if(this.right == false) {
				this.component.moveHero('-');
			} this.left = false;
			break;
		case KeyEvent.VK_RIGHT:
			if(this.left == false) {
				this.component.moveHero('-');
			} this.right = false;
			break;
		case KeyEvent.VK_UP:
			this.component.moveHero('|');
			break;

		case KeyEvent.VK_U:
			this.component.changeLevel(true);
			break;
		case KeyEvent.VK_D:
			if(this.levelNum > 1) {
				levelNum -= 1;
			} this.component.changeLevel(false);
			break;
		}
	}

}
