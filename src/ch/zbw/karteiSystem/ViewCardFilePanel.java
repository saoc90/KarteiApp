/**
 * 
 */
package ch.zbw.karteiSystem;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;



/**
 * This class generates a UI View, which shows all cardfiles as buttons in a JScrollPane. 
 * The last cardfile in this list is a button to add a cardfile.
 * 
 * @author samuelochsner
 *
 */
public class ViewCardFilePanel extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Strings strings;
	private JButton button1;
	private GridBagConstraints gc;
	private ViewPanelTitleBar titleBar;
	private JLabel backButton;
	private Icon backButtonIcon;
	private ArrayList<CardFile> cardFiles;
	private ArrayList<ViewCardFile> viewCardFiles;
	private static ViewMainFrame viewMainFrame;
	private MainHandler mainHandler;
	private JScrollPane jsp;
	
	
	public ViewCardFilePanel(ViewMainFrame viewMainFrame){
		
		this.viewMainFrame = viewMainFrame;
		strings = viewMainFrame.getStrings();
		mainHandler = viewMainFrame.getMainHandler();
		this.cardFiles = mainHandler.getAllCardFiles();
		viewCardFiles = new ArrayList<ViewCardFile>();
		this.setBackground(ViewMainFrame.COLOR5);
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
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0,0,0,0);
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 4;
		gc.weightx = 1;
		gc.weighty = 1;
		fillScrollPane();
		
		
		
	}
	
	
	public void fillScrollPane(){
		
		if(jsp!=null)
			remove(jsp);
		
		
	    //JPanel p = new JPanel(new GridLayout(0,1,0,20));
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints gcsp = new GridBagConstraints();
		gcsp.fill = GridBagConstraints.HORIZONTAL;
		gcsp.gridheight = 1;
		gcsp.gridwidth = 1;
		gcsp.gridx = 0;
		gcsp.gridy = 0;
		gcsp.weightx = 1;
		gcsp.weighty = 1;
		gcsp.insets = new Insets(0,0,10,0);
		
	   
	    p.setBackground(ViewMainFrame.COLOR5);
	    for (Iterator<CardFile> iterator = cardFiles.iterator(); iterator
				.hasNext();) {
			CardFile tmpCardFile = iterator.next();
			ViewCardFile tmpcard = createViewCardFiles(tmpCardFile);
			tmpcard.addMouseListener(this);
			p.add(tmpcard,gcsp);
			gcsp.gridy ++;
			
		}
	    jsp = new JScrollPane(p);
	    jsp.setBackground(ViewMainFrame.COLOR5);

	    jsp.setPreferredSize(new Dimension(390,495));
	    //jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    jsp.setBorder(null);

	   
	    //Create and add last Cardfile to the scrollpanel
	    ViewCardFile tmpLastCard = createLastViewCardFile();
	    tmpLastCard.addMouseListener(this);
	    gcsp.insets = new Insets(0,0,0,0);
	    p.add(tmpLastCard,gcsp);
	    
	    
	    //add Scrollpanel to the Panel
	    gc.fill = GridBagConstraints.VERTICAL;
	    gc.insets = new Insets(5,0,0,0);
	    add(jsp,gc);
	    repaint();
	    revalidate();
	    setVisible(true);
	    
		
		
		
		
	}
	
	
	
	
	/*creates a ViewCardFile with the data out of the given cardfiel
	 * 
	 * @param tmpCardFile Must be an object of Cardfile.
	 * 
	 */
	
	public ViewCardFile createViewCardFiles(CardFile tmpCardFile){
		
		ViewCardFile panel = new ViewCardFile(viewMainFrame,tmpCardFile,strings);
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


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	// if ViewCardFile is clicked, it switches automaticly to the learnpanel and gives it the cartefile
	@Override
	public void mousePressed(MouseEvent e) {
		
		ViewCardFile tmpcard = (ViewCardFile) e.getSource();
		if(tmpcard.isLastCard()){
			
			viewMainFrame.changeEditCardFilePaneltoCardFile(null);
			return;
			
		}
		viewMainFrame.changeLearnPaneltoCardFile(tmpcard.getCardFile());
		try {
			viewMainFrame.changeFrameTo("toLearnPanel");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
