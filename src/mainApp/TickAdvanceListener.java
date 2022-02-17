package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class: TickAdvanceListener
 * @author Team 405
 * Purpose: Action listener for the timer, advances the game foreward by one tick everytime it is called.
 */

public class TickAdvanceListener implements ActionListener {
	
	private GameComponent gameComponent;

	public TickAdvanceListener(GameComponent gameComponent) {
		this.gameComponent = gameComponent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		advanceOneTick();
	}

	public void advanceOneTick() {
		this.gameComponent.updateState();
		this.gameComponent.drawScreen();
	}
}
