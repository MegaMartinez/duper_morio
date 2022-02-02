package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
