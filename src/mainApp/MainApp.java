package mainApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Class: MainApp
 * @author Team 405
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {
	
	public static final int TICK_DELAY = 40;
	
	
	private void runApp() {
		System.out.println("Write your cool arcade game here!");
		System.out.println("test");
		
		JFrame frame = new JFrame("Old Duper Morio Cousins");
		frame.setSize(500, 500);
		
		GameComponent gameComponent = new GameComponent();
		
		TickAdvanceListener tickAdvanceListener = new TickAdvanceListener(gameComponent);

		Timer timer = new Timer(TICK_DELAY, tickAdvanceListener);
		timer.start();
		
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