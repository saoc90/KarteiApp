package ch.zbw.karteiSystem;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author samuelochsner
 *
 */

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
				ViewMainFrame mainframe = new ViewMainFrame();
				mainframe.setSize(800, 600);
				Dimension dimension = new Dimension(800,600);
				mainframe.setMinimumSize(dimension);
				mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainframe.setVisible(true);
			}
	
		
	}


