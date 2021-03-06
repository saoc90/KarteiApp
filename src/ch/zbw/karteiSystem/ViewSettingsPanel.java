/**
 * 
 */
package ch.zbw.karteiSystem;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class shows the settings. 
 * You can choose the application language and reset the stats.
 * It extends JPanel and implements the ActionListener.
 * @author samuelochsner
 *
 */
public class ViewSettingsPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ViewPanelTitleBar titleBar;
	private JLabel backButton;
	private ImageIcon backIcon;
	private JComboBox<String> languages;
	private ViewMainFrame mainframe;
	private Strings strings;
	private JButton reset;
	private JLabel languageLabel;
	private JLabel resetLabel;
	private String [] languageStrings;
	
	
	/**
	 * The constructor needs an instance of the ViewMainFrame
	 * 
	 * @param mainframe
	 */
	public ViewSettingsPanel(ViewMainFrame mainframe) {
		
		this.mainframe = mainframe;
		strings = mainframe.getStrings();
		setLayout(new GridBagLayout());
		languageStrings = new String[]{"English","Deutsch","Francais","Italiano"};
		languages = new JComboBox<String>(languageStrings);
		backIcon = new ImageIcon("png/back.png");
		backButton = new JLabel(backIcon);
		titleBar = new ViewPanelTitleBar(ViewMainFrame.COLOR3, "settingsPanel", mainframe);
		setBackground(ViewMainFrame.COLOR5);
		paint();
	}
	

	/**
	 * This method paints the settings panel.
	 */
	private void paint(){
		
		backButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				try {
					mainframe.changeFrameTo("toStartPanel");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		// add TitleBar
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.NORTH;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridwidth = 3;
		gc.gridheight = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(20, 0, 0, 0);
		add(titleBar,gc);
		
		//add BackButton
		gc.gridwidth = 1;
		gc.gridy =1;
		gc.gridx = 0;
		gc.insets = new Insets(0,20,0,0);
		gc.anchor = GridBagConstraints.WEST;
		gc.fill = GridBagConstraints.BOTH;
		add(backButton,gc);
		
		//add SettingsPanel
		
		JPanel settingsPanel = new JPanel(new GridBagLayout());
		settingsPanel.setBackground(ViewMainFrame.COLOR5);
		settingsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK)));
		
		strings.add(settingsPanel);
		GridBagConstraints gcp = new GridBagConstraints();
		gcp.gridx = 0;
		gcp.gridy = 0;
		
		//add LanguageLabel
		gcp.anchor = GridBagConstraints.LINE_START;
		gcp.ipadx = 50;
		gc.ipady = 50;
		languageLabel = new JLabel(strings.getString("languageLabel"));
		languageLabel.setName("languageLabel");
		strings.add(languageLabel);
		settingsPanel.add(languageLabel, gcp);
		
		//add Lanugage dropdown
		languages.addActionListener(this);
		gcp.gridx = 1;
		settingsPanel.add(languages,gcp);
		
		//add resetLabel
		gcp.gridy = 1;
		gcp.gridx = 0;
		resetLabel = new JLabel(strings.getString("resetLabel"));
		strings.add(resetLabel);
		resetLabel.setName("resetLabel");
		settingsPanel.add(resetLabel,gcp);
		
		//add resetButton
		gcp.gridx = 1;
		
		reset = new JButton(strings.getString("reset"));
		reset.setName("reset");
		strings.add(reset);
		reset.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int choosenOption = JOptionPane.showOptionDialog(null, strings.getString("dialog"),strings.getString("attention"),
		                JOptionPane.YES_NO_CANCEL_OPTION,
		                JOptionPane.WARNING_MESSAGE, null, 
		                new String[]{strings.getString("ok"), strings.getString("cancel")}, "B");
					
				if(choosenOption==JOptionPane.OK_OPTION){
					mainframe.getMainHandler().resetApplication();
				}
			}
		});
		settingsPanel.add(reset, gcp);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridwidth = 2;
		gc.insets = new Insets(0,0,50,150);
		gc.ipadx = 200;
		gc.ipady = 350;
		add(settingsPanel,gc);
		
		
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> combo = (JComboBox<String>)e.getSource();
		String selected = (String)combo.getSelectedItem();
		
		switch (selected){
		
		
		case "English": strings.changeLanguage("en");break;
		case "Deutsch": strings.changeLanguage("de");break;
		case "Francais": strings.changeLanguage("fr");break;
		case "Italiano": strings.changeLanguage("it");break;
		}
		
	}

	
}
