package ch.zbw.karteiSystem;
import java.awt.Dimension;




/**
 * MainClass which generates the JFrame.
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
				Dimension dimension = new Dimension(900,700);
				mainframe.setMinimumSize(dimension);
				mainframe.setLocationRelativeTo(null);
				mainframe.setVisible(true);
			}
	
		
	}


