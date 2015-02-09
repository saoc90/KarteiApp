package ch.zbw.karteiSystem;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewPanelTitleBar extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private ViewMainFrame mainFrame;
	private Strings strings;

	public ViewPanelTitleBar(Color color, String name, ViewMainFrame viewMainFrame) {
		this.setPreferredSize(new Dimension(800,60));
		this.setBackground(color);
		label = new JLabel();
		label.setFont(ViewMainFrame.FONT1);
		label.setName(name);
		this.mainFrame = viewMainFrame;
		strings = mainFrame.getStrings();
		strings.add(label);
		this.setVisible(true);
	}






}
