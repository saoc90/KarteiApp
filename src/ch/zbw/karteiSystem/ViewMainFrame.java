/**
 * 
 */
package ch.zbw.karteiSystem;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @author samuelochsner
 *
 */
public class ViewMainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static Color COLOR1 = Color.decode("#ead177");
	public final static Color COLOR2 = Color.decode("#d95b45");
	public final static Color COLOR3 = Color.decode("#c12940");
	public final static Color COLOR4 = Color.decode("#552437");
	public final static Color COLOR5 = Color.decode("#52787b");
	public final static Font FONT1 = new Font("LucidaBright",Font.BOLD,20);
	public static String languageCode = "de";
	private ViewStartPanel startPanel;
	private ViewCardFilePanel cardFilePanel;
	private ViewEditCardFilePanel editCardFilePanel;
	private Container container;
	private JPanel statsPanel;
	private CardLayout cardLayout;
	private Strings strings;
	private MainHandler mainHandler;
	private HelpCardFile helpCardFile;
	private ViewLearnPanel learnPanel;
	
	public ViewMainFrame(){
		
		super("Kartei System");
		setLayout(null);
		try {
			strings = new Strings();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		helpCardFile = new HelpCardFile();
		mainHandler = new MainHandler(helpCardFile.getCardFile(),"en",0);
		container = this.getContentPane();
		cardLayout = new CardLayout();
		container.setLayout(cardLayout);

	
		HelpCardFile helpCardFile = new HelpCardFile();
		startPanel = new ViewStartPanel(this);
		cardFilePanel = new ViewCardFilePanel(this);
		editCardFilePanel = new ViewEditCardFilePanel(this);
		learnPanel = new ViewLearnPanel(this, null);
		statsPanel = new JPanel();
		
		statsPanel.setBackground(COLOR1); 
		statsPanel.setVisible(false);
		addPanel(startPanel,"startPanel");
		addPanel(cardFilePanel, "cardFilePanel");
		addPanel(editCardFilePanel, "toStatsPanel");
		addPanel(learnPanel,"learnPanel");
		
		
		cardLayout.show(container, startPanel.getName());
		
	
		
		validate();
		
	}
	
	
	/*
	 * 
	 * 
	 * @param panel Adds a panel to the MainFrame
		@param panelName give a name to the panel
		@param position takes a final String of position in the layoutManager
	 * 
	 * 
	 */
	private void addPanel(JPanel panel, String panelName){
		
		
		panel.setName(panelName);
		
		//panel.setVisible(false);
		container.add(panel, panelName);
		strings.add(panel);
		
	}
	
	public Strings getStrings(){
		
		return strings;
	}
	
	public MainHandler getMainHandler(){
		
			return mainHandler;
	}
		
	
	public void changeLearnPaneltoCardFile(CardFile cardfile){
		
		
		learnPanel.fillCardFile(cardfile);
		
		
	}
	
	public void changeEditCardFilePaneltoCardFile(CardFile cardfile){
		
		
		editCardFilePanel.changeCardFile(cardfile);
		
		
		
		try {
			changeFrameTo("toEditCardFilePanel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 *
	 * @param panelName Takes a name of a panel, on which you want to change on Mainframe
	 * @throws Exception 
 	 */
	
	public void changeFrameTo(String buttonName) throws Exception{
		
		System.out.println(buttonName);
		
		
		
		
		switch (buttonName){
		
		case "toStartPanel" :
			cardLayout.show(container, startPanel.getName());
			validate();
			break;
		
		case "toCardFilePanel" : 
			
			cardFilePanel.refreshAllViewCardFiles();
			cardLayout.show(container, cardFilePanel.getName());
			break;
			
		case "toEditCardFilePanel" : 
			
			cardLayout.show(container, editCardFilePanel.getName());
			
			break;
			
		case "toStatsPanel" :
			// please change it bac to this entry after   cardLayout.show(container, startPanel.getName());
			cardLayout.show(container, editCardFilePanel.getName());
			ViewMainFrame.languageCode = "en";
			strings.changeLanguage(Strings.ENGLISH);
			break;
			
		case "toSettingsPanel":
			cardLayout.show(container, learnPanel.getName());
			break;
			
			
		case "toLearnPanel":
			cardLayout.show(container, learnPanel.getName());
			break;
			
		default : 
			
			new Exception("Panel was not found");
		
		
		
		
		
		
		}
		
		
		
		
		
		
		
		
	}
	
}
