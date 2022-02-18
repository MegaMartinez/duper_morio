package mainApp;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class: MainApp
 * @author Team 405
 * <br>Purpose: Top level class for CSSE220 Project containing main method, create frame and components 
 * <br>Restrictions: None
 */
public class MainApp {
	
	public static final int TICK_DELAY = 15;
	public static final int FRAME_WIDTH = 1408;
	public static final int FRAME_HEIGHT = 768;
	
	private void runApp() {		
		JFrame frame = new JFrame("Old Duper Morio Cousins");

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		
		GameComponent component = new GameComponent(FRAME_WIDTH, FRAME_HEIGHT);
		
		JPanel scoreboard = new JPanel();
		JLabel lives = new JLabel("Lives Remaining: " + component.getLives());
		
		scoreboard.add(lives);
		frame.add(scoreboard, BorderLayout.SOUTH);
		
		
		component.loadLevel();
		frame.add(component, BorderLayout.CENTER);
		
		TickAdvanceListener tickAdvanceListener = new TickAdvanceListener(component, lives);
		Timer timer = new Timer(TICK_DELAY, tickAdvanceListener);
		timer.start();
		
		KeyboardListener keyboardListener = new KeyboardListener(component);
		frame.addKeyListener(keyboardListener);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	} // runApp

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp();		
	} // main

}