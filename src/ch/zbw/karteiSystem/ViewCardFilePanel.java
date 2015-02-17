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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

	private Strings strings;
	private JButton button1;
	private ViewCardFile cardFile;
	private GridBagConstraints gc;
	private ViewPanelTitleBar titleBar;
	private JLabel backButton;
	private Icon backButtonIcon;
	private ArrayList<CardFile> cardFiles;
	private ArrayList<ViewCardFile> viewCardFiles;
	private static ViewMainFrame viewMainFrame;
	private MainHandler mainHandler;
	
	
	public ViewCardFilePanel(ViewMainFrame viewMainFrame){
		
		this.viewMainFrame = viewMainFrame;
		strings = viewMainFrame.getStrings();
		mainHandler = viewMainFrame.getMainHandler();
		this.cardFiles = mainHandler.getAllCardFiles();
		viewCardFiles = new ArrayList<ViewCardFile>();
		this.setBackground(Color.decode("#52787b"));
		this.setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		titleBar = new ViewPanelTitleBar(ViewMainFrame.COLOR1,"viewCardFile_title", viewMainFrame	);
		button1 = new JButton();
		button1.setText(strings.getString("language_test"));
		backButtonIcon = new ImageIcon("png/back.png");
		backButton = new JLabel(backButtonIcon);
		backButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					ViewCardFilePanel.viewMainFrame.changeFrameTo("toStartPanel");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		paint();
		
	}
	
	
	public void paint(){
		// Title Panel Hinzufügen
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(20,0,0,0);
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.gridheight = 1;
		gc.gridwidth = 5;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(titleBar,gc);
		
		button1.addActionListener( this);
		button1.setName("language_test");
		strings.add(button1);
		//cardFile = new ViewCardFile ();
		//cardFile.setVisible(true);
		//add(cardFile);
		
		//add(backButton);
		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,20,0,0);
		gc.gridy = 1;
		gc.gridx = 0;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		add(backButton,gc);
		
		//CardFiles hinzufügen
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.VERTICAL;
		gc.insets = new Insets(0,0,0,0);
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 4;
		fillScrollPane();
		
		
		
	}
	
	
	private void fillScrollPane(){
		
		
		
	    JPanel p = new JPanel(new GridLayout(0,1,0,20));
	   
	    p.setBackground(ViewMainFrame.COLOR5);
	    JScrollPane jsp = new JScrollPane(p);
	    jsp.setBackground(ViewMainFrame.COLOR5);
	   

	    jsp.setPreferredSize(new Dimension(390,498));
	    //jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

	    for (Iterator<CardFile> iterator = cardFiles.iterator(); iterator
				.hasNext();) {
			CardFile tmpCardFile = iterator.next();
			p.add(createViewCardFiles(tmpCardFile));
			
		}
	    p.add(createLastViewCardFile());
	    add(jsp,gc);
	    setVisible(true);
	    
		
		
		
		
	}
	
	
	/*creates a ViewCardFile with the data out of the given cardfiel
	 * 
	 * @param tmpCardFile Must be an object of Cardfile
	 * 
	 */
	
	public ViewCardFile createViewCardFiles(CardFile tmpCardFile){
		
		ViewCardFile panel = new ViewCardFile(tmpCardFile,strings);
		viewCardFiles.add(panel);
		return panel;
		
		
	}
	
	public ViewCardFile createLastViewCardFile(){
		
		ViewCardFile panel = new ViewCardFile(true,strings);
		return panel;
		
	}
	
	/*
	 * This methode iterrates through all ViewCardFiles and refreshes all paramtet on UI
	 * 
	 * 
	 */
	
	public void refreshAllViewCardFiles(){
		
		Iterator<ViewCardFile> it = viewCardFiles.iterator();
		while(it.hasNext()){
		ViewCardFile tmp =	it.next();
		tmp.refresh();
			
		}
		
		
	}
	

	public void actionPerformed(ActionEvent e) {

		try {
			viewMainFrame.changeFrameTo("toStartPanel");
			validate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
}
