package ch.zbw.karteiSystem;
import java.awt.Dimension;



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
	 * @throws Exception 
	 */
	public static void main(String[] args) {
	
		
				ViewMainFrame mainframe = new ViewMainFrame();
				mainframe.setSize(800, 600);
				Dimension dimension = new Dimension(800,600);
				mainframe.setMinimumSize(dimension);
				mainframe.setVisible(true);
			}
	
		
	}


