/**
 * 
 */
package ch.zbw.karteiSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.crypto.spec.GCMParameterSpec;
import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author samuelochsner
 *
 */
public class ViewStartPanel extends JPanel implements ActionListener {

	private static ViewMainFrame mainFrame;
	private Strings strings;
	private ViewBigButton lernen, stats, settings, exit;
	
	public ViewStartPanel(ViewMainFrame mainFrame){
		
		this.setBackground(Color.decode("#52787b"));
		this.setLayout( new GridBagLayout());
		this.mainFrame = mainFrame;
		this.setVisible(true);
		strings = mainFrame.getStrings();
		strings.setChoosenLanguageCode("en");
		
		setMenu();
	}
	
	
	
	
	
	public void setMenu(){
		
		////// First Row //////////
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0;
		gc.weighty = 0;//Abstand zwischen den Buttons
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		//Abstände zwischen den Buttons
		gc.insets = new Insets(1,1,1,1);
		
		/// Lernen Button ///////
		lernen = new ViewBigButton("toCardFilePanel", strings.getString("toCardFilePanel"),new ImageIcon("png/learn.png"),370,70,Color.decode("#ead177"));
		lernen.addActionListener(this);
		strings.add(lernen);
		this.add(lernen, gc);
		
		
		
		
		///// Statistiken Button ////////
		
		gc.gridy = 1;
		
		/// Lernen Button ///////
				stats = new ViewBigButton("toStatsPanel" , strings.getString("toStatsPanel"),new ImageIcon("png/stats.png"),370,70,Color.decode("#d95b45"));
				stats.addActionListener(this);
				strings.add(stats);
				this.add(stats, gc);
				
				
				
		/// Einstellungen Button ///////		
			
			gc.gridy = 2;
				
						settings = new ViewBigButton("toSettingsPanel", strings.getString("toSettingsPanel"),new ImageIcon("png/settings.png"),370,70,Color.decode("#c12940"));
						settings.addActionListener(this);
						strings.add(settings);
						this.add(settings, gc);
				
						
		//// Beenden Button ///////
						
						gc.gridy = 3;

						exit = new ViewBigButton("closeApp", strings.getString("closeApp"),new ImageIcon("png/exit.png"),370,70,Color.decode("#552437"));
						exit.addActionListener(this);
						strings.add(exit);
						this.add(exit, gc);
				
	}





	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			mainFrame.changeFrameTo(((ViewBigButton) e.getSource()).getName());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			new JOptionPane(e1.getMessage());
		}
		
	}
	
	

		
		
		
		

	
	
	
	
}
