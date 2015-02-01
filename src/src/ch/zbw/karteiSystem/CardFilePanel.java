/**
 * 
 */
package ch.zbw.karteiSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author samuelochsner
 *
 */
public class CardFilePanel extends JPanel implements EventListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame mainFrame;
	private Strings strings;
	
	
	public CardFilePanel(MainFrame mainFrame){
		
		strings = new Strings();
		this.setBackground(Color.decode("#52787b"));
		this.setLayout( new BorderLayout());
		this.mainFrame = mainFrame;
		this.setVisible(false);
		paint();
		
	}
	
	
	public void paint(){
		JButton button1 = new JButton();
		button1.setText(strings.getString(MainFrame.languageCode, "language_test"));
		button1.addActionListener( this);
		
		add(button1);
		setVisible(false);
		
		
	}
	
	

	public void actionPerformed(ActionEvent e) {

		try {
			mainFrame.changeFrameTo("toStartPage");
			validate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
}
