package ch.zbw.karteiSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


/*
 * @author Martin Thomann
 */

public class ViewEditCardFilePanel extends JPanel implements EventListener, ActionListener {

	//Datenfeld
	private static final long serialVersionUID = 1L;
	private static ViewMainFrame mainframe;
	private Strings strings;
	private JButton button1;
	private JButton button2;
	private ViewTable table;
	
	//Konstruktor
	public ViewEditCardFilePanel(ViewMainFrame mainframe){
		
		strings = mainframe.getStrings();
		this.setBackground(Color.decode("#52787b"));
		this.setLayout(new FlowLayout());
		this.mainframe = mainframe;
		this.setVisible(false);
		button1 = new JButton();
		button2 = new JButton();
		button1.setText(strings.getString("lernen"));
		button1.setText("import");
		paint();
		fillScrollPane();
	}
	

	
	//GUI zeichnen
	public void paint(){
		button1.addActionListener( this);
		button1.setName("language_test");
		button2.addActionListener(this);
		button2.setName("import");
		strings.add(button1);
		strings.add(button2);
		try {
			table = new ViewTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setVisible(true);
		//add(cardFile);
		
		add(button1);
		add(button2);
		setVisible(true);
	}
	
	
	public void fillScrollPane(){
		
	    JPanel p = new JPanel(new GridLayout(0,1,0,20));
	    p.setBackground(ViewMainFrame.COLOR5);

	    
	    p.setPreferredSize(new Dimension(360,400));
	    try{
	    	ViewTable table = new ViewTable();
		    p.add(table);
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    
	    
	    add(p);
	    setLocation(360, 400);
	    setVisible(true);
	}
	
	

	public void actionPerformed(ActionEvent e) {

		try {
			ViewTable table = new ViewTable();
			table.takeList();
//			mainFrame.changeFrameTo("toStartPanel");
			validate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
}
