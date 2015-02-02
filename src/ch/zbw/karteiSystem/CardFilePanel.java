/**
 * 
 */
package ch.zbw.karteiSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
	private JButton button1;
	private CardFile cardFile;
	
	
	public CardFilePanel(MainFrame mainFrame){
		
		strings = mainFrame.getStrings();
		this.setBackground(Color.decode("#52787b"));
		this.setLayout(new FlowLayout());
		this.mainFrame = mainFrame;
		this.setVisible(false);
		button1 = new JButton();
		button1.setText(strings.getString("language_test"));
		paint();
		
	}
	
	
	public void paint(){
		
		
		button1.addActionListener( this);
		button1.setName("language_test");
		strings.add(button1);
		cardFile = new CardFile ();
		cardFile.setVisible(true);
		add(cardFile);
		
		add(button1);
		setVisible(false);
		
		
	}
	
	

	public void actionPerformed(ActionEvent e) {

		try {
			mainFrame.changeFrameTo("toStartPanel");
			validate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
}
