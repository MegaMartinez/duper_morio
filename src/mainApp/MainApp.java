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
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {
	
	public static final int TICK_DELAY = 40;
	
	
	private void runApp() {
//		System.out.println("Write your cool arcade game here!");
//		System.out.println("test");
		
		JFrame frame = new JFrame("Old Duper Morio Cousins");
		frame.setSize(750, 800);
		GameComponent component = new GameComponent();
		
		JPanel scoreboard = new JPanel();
		JLabel lives = new JLabel("Lives Remaining: " + component.getLives());
		
		Timer t = new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lives.setText("Lives Remaining: " + component.getLives());
			}
		});
		t.start();
		scoreboard.add(lives);
		frame.add(scoreboard, BorderLayout.SOUTH);
		
		
		component.loadLevel();
		frame.add(component, BorderLayout.CENTER);
		
		TickAdvanceListener tickAdvanceListener = new TickAdvanceListener(component);
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