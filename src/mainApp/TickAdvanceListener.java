package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

/**
 * Class: TickAdvanceListener
 * @author Team 405
 * Purpose: Action listener for the timer, advances the game foreward by one tick everytime it is called.
 */

public class TickAdvanceListener implements ActionListener {
	
	private GameComponent gameComponent;
	private JLabel lifeDisplay;
	private JLabel scoreDisplay;

	public TickAdvanceListener(GameComponent gameComponent, JLabel lifeDisplay, JLabel scoreDisplay) {
		this.gameComponent = gameComponent;
		this.lifeDisplay = lifeDisplay;
		this.scoreDisplay = scoreDisplay;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		advanceOneTick();
	}

	public void advanceOneTick() {
		this.gameComponent.updateState();
		this.gameComponent.drawScreen();
		this.lifeDisplay.setText("Lives Remaining: " + this.gameComponent.getLives());
		this.scoreDisplay.setText("Score: " + this.gameComponent.getScore());
	}
}
