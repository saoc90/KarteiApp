/**
 * 
 */
package ch.zbw.karteiSystem;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author samuelochsner
 *
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static Color COLOR1 = Color.decode("#ead177");
	public final static Color COLOR2 = Color.decode("#d95b45");
	public final static Color COLOR3 = Color.decode("#c12940");
	public final static Color COLOR4 = Color.decode("#552437");
	public final static Color COLOR5 = Color.decode("#52787b");
	public static String languageCode = "de";
	private StartPanel startPanel;
	private CardFilePanel cardFilePanel;
	private Container container;
	private JPanel statsPanel;
	private CardLayout cardLayout;
	
	public MainFrame(){
		
		super("Kartei System");
		setLayout(null);
		container = this.getContentPane();
		cardLayout = new CardLayout();
		container.setLayout(cardLayout);

		//container.setPreferredSize(new Dimension(this.getSize()));
		//container.setBackground(MainFrame.COLOR5);
	
		
		startPanel = new StartPanel(this);
		cardFilePanel = new CardFilePanel(this);
		statsPanel = new JPanel();
		statsPanel.setBackground(COLOR1);
		statsPanel.setVisible(false);
		addPanel(startPanel,"startPanel");
		addPanel(cardFilePanel, "cardFilePanel");
		
		addPanel(statsPanel,"statsPanel");
		
		cardLayout.show(container, startPanel.getName());
	
		
		validate();
		//addPanel(new JPanel().setVisible(false), "statsPanel",BorderLayout.CENTER);
	
		
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
	
		
	}
	
	
	private void hidePanels(){
		
	for (Component component : container.getComponents()){
		
		component.setVisible(false);
		
		
	}
		
	}
	
/*	
private JPanel getPanel(String panelName)throws Exception{
	
	int pnCnt = container.getRootPane().getComponentCount();
	
	for (int i = 0; i< pnCnt;i++){
		
		JPanel panel = (JPanel) container.getRootPane().getComponent(i);
		
		if(panel.getName().equals(panelName))
			return panel;
	}
		throw (new Exception("Panel in MainFrame not found"));
		
	
}
*/


	/**
	 *
	 * @param panelName Takes a name of a panel, on which you want to change on Mainframe
	 * @throws Exception 
 	 */
	
	public void changeFrameTo(String buttonName) throws Exception{
		
		System.out.println(buttonName);
		
		
		
		
		switch (buttonName){
		
		case "toStartPage" :
			cardLayout.show(container, startPanel.getName());
			validate();
			break;
		
		case "toLearnPage" : 
			//hidePanels();
			cardLayout.show(container, cardFilePanel.getName());
			break;
			
		case "toStatsPage" :
			cardLayout.show(container, startPanel.getName());
			MainFrame.languageCode = "en";
			validate();
			startPanel.validate();
			break;
			
			
		default : 
			
			new Exception("Panel was not found");
		
		
		
		
		
		
		}
		
		
		
		
		
		
		
		
	}
	
}
