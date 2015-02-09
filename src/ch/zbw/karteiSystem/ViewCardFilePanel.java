/**
 * 
 */
package ch.zbw.karteiSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * @author samuelochsner
 *
 */
public class ViewCardFilePanel extends JPanel implements EventListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ViewMainFrame mainFrame;
	private Strings strings;
	private JButton button1;
	private ViewCardFile cardFile;
	private GridBagConstraints gc;
	
	
	public ViewCardFilePanel(ViewMainFrame mainFrame){
		
		strings = mainFrame.getStrings();
		this.setBackground(Color.decode("#52787b"));
		this.setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		this.mainFrame = mainFrame;
		this.setVisible(false);
		button1 = new JButton();
		button1.setText(strings.getString("language_test"));
		paint();
		fillScrollPane();
		
	}
	
	
	public void paint(){
		// Title Panel Hinzufügen
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(20,0,0,0);
		
		
		button1.addActionListener( this);
		button1.setName("language_test");
		strings.add(button1);
		cardFile = new ViewCardFile ();
		cardFile.setVisible(true);
		//add(cardFile);
		
		add(button1);
		setVisible(false);
		
		
	}
	
	
	public void fillScrollPane(){
		
		
		
	    JPanel p = new JPanel(new GridLayout(0,1,0,20));
	    p.setBackground(ViewMainFrame.COLOR5);
	    JScrollPane jsp = new JScrollPane(p);
	    jsp.setBackground(ViewMainFrame.COLOR5);
	   

	    jsp.setPreferredSize(new Dimension(360,600));
	    //jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

	    for (int i = 0; i < 100; i++) {
	        ViewCardFile card = new ViewCardFile();
	        p.add(card);
	    }

	    add(jsp);
	    setLocation(340, 600);
	    setVisible(true);
	    
		
		
		
		
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
