/**
 * 
 */
package ch.zbw.karteiSystem;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * This class handles all the panels of the application. Also it contains the colorpallet as static datafields.
 * @author samuelochsner
 *
 */
public class ViewMainFrame extends JFrame {

	
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
	private ViewDiagramm statsPanel;
	private Container container;
	private CardLayout cardLayout;
	private Strings strings;
	private MainHandler mainHandler;
	private HelpCardFile helpCardFile;
	private ViewLearnPanel learnPanel;
	private ViewSettingsPanel settingsPanel;
	
	
	/**
	 * Main Contructor
	 * 
	 */
	public ViewMainFrame(){
		
		super("Kartei System");
		setLayout(null);
		try {
			strings = new Strings();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XmlReader reader = new XmlReader();
		mainHandler =  reader.readFile();
		
		strings.changeLanguage(mainHandler.getInitLanguage()); //sets initial language.

		helpCardFile = new HelpCardFile();
		
		container = this.getContentPane();
		cardLayout = new CardLayout();
		container.setLayout(cardLayout);


		
		startPanel = new ViewStartPanel(this);
		cardFilePanel = new ViewCardFilePanel(this);
		editCardFilePanel = new ViewEditCardFilePanel(this);
		learnPanel = new ViewLearnPanel(this, null);
		statsPanel = new ViewDiagramm(this);
		settingsPanel = new ViewSettingsPanel(this);
		statsPanel.setBackground(COLOR1); 
		statsPanel.setVisible(false);
		addPanel(startPanel,"startPanel");
		addPanel(cardFilePanel, "cardFilePanel");
		addPanel(editCardFilePanel, "editCardFilePanel");
		addPanel(learnPanel,"learnPanel");
		addPanel(statsPanel, "statsPanel");
		addPanel(settingsPanel,"settingsPanel");
		
		
		cardLayout.show(container, startPanel.getName());
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				save();
				System.exit(ABORT);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		validate();
		
	}
	
	public void save(){
		mainHandler.saveCardFiles(this);
	}
	
	
	
	private void addPanel(JPanel panel, String panelName){
		
		
		panel.setName(panelName);
		
		//panel.setVisible(false);
		container.add(panel, panelName);
		strings.add(panel);
		
	}
	
	/**
	 * @return Instance of strings class, which handles all the elements for multilanguage.
	 */
	public Strings getStrings(){
		
		return strings;
	}
	
	/**
	 * @return Instance of MainHandler class, which handles all the inport export stuff.
	 */
	public MainHandler getMainHandler(){
		
			return mainHandler;
	}
		
	
	/**
	 * This method refreshes the Learnpanel with the given cardfile.
	 * 
	 * @param cardfile Instance of carfile
	 */
	public void changeLearnPaneltoCardFile(CardFile cardfile){
		
		
		learnPanel.fillCardFile(cardfile,true);
		
		
	}
	
	
	
	/**
	 * This method refreshes the CardFilePanel to the actual informations of the cardfile ArrayList. It should be called on every call of the cardfilepanel.
	 */
	public void refreshCardFilePanel(){
		
		cardLayout.removeLayoutComponent(cardFilePanel);
		cardFilePanel = new ViewCardFilePanel(this);
		addPanel(cardFilePanel, "cardFilePanel");
		
		
	}

	
	
	/**
	 * This method refreshes the statistics panel. It should be called on every call of the statisticspanel.
	 */
	public void refreshStatsPanel(){
		
		cardLayout.removeLayoutComponent(statsPanel);
		statsPanel = new ViewDiagramm(this);
		addPanel(statsPanel, "statsPanel");
		
		
	}
	
	
	/**
	 * This method refreshes the Edit Cardfile panel. It should be called on every call of the editCardFilePanel.
	 */
	public void refreshViewEditCardFilePanel(){
		
		
		cardLayout.removeLayoutComponent(editCardFilePanel);
		editCardFilePanel = new ViewEditCardFilePanel(this);
		addPanel(editCardFilePanel, "editCardFilePanel");
		
	}
	
	
	/**
	 * This method refreshes the Edit Cardfile panel to the given cardfile.
	 * 
	 * @param cardfile the cardfile which should be configured.
	 */
	public void changeEditCardFilePaneltoCardFile(CardFile cardfile){
		
		
		editCardFilePanel.createTable(cardfile);
		editCardFilePanel.repaint();
		
		
		
		try {
			changeFrameTo("toEditCardFilePanel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 *This method changes the showed panel in the application. 
	 *
	 *
	 * @param buttonName Takes a name of a panel, on which you want to change on Mainframe
	 * @throws Exception 
 	 */
	
	public void changeFrameTo(String buttonName) throws Exception{
	
		switch (buttonName){
		
		case "toStartPanel" :
			cardLayout.show(container, startPanel.getName());
			validate();
			break;
		
		case "toCardFilePanel" : 
			
			cardFilePanel.refreshAllViewCardFiles();
			refreshCardFilePanel();
			cardLayout.show(container, cardFilePanel.getName());
			cardFilePanel.repaint();
			break;
			
		case "toEditCardFilePanel" : 
			
			cardLayout.show(container, editCardFilePanel.getName());
			
			break;
			
		case "toStatsPanel" :
			// please change it bac to this entry after   cardLayout.show(container, startPanel.getName());
			refreshStatsPanel();
			cardLayout.show(container, statsPanel.getName());
			break;
			
		case "toSettingsPanel":
			cardLayout.show(container, settingsPanel.getName());
			break;
			
			
		case "toLearnPanel":
			cardLayout.show(container, learnPanel.getName());
			break;
		
		case "closeApp":
			mainHandler.saveCardFiles(this);
			System.exit(DO_NOTHING_ON_CLOSE);			
		default : 
			
			new Exception("Panel was not found");
		
		
		
		
		
		
		}
		
		
		
		
		
		
		
		
	}
	
}
