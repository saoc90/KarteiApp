package ch.zbw.karteiSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
	private GridBagConstraints gc;

	public ViewPanelTitleBar(Color color, String name, ViewMainFrame viewMainFrame) {
		setPreferredSize(new Dimension(600,60));
		setMinimumSize(new Dimension(600,60));
		setBackground(color);
		setLayout(new GridBagLayout());
		
		this.mainFrame = viewMainFrame;
		gc = new GridBagConstraints();
		strings = mainFrame.getStrings();
		strings.add(label);
		label = new JLabel();
		label.setFont(ViewMainFrame.FONT1);
		label.setName(name);
		label.setText(strings.getString(name));
		add(label, gc);
		this.setVisible(true);
	}

	public void setTitle(String title){
		
		this.label.setText(title);
		
	}
	
	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public ViewMainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(ViewMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public Strings getStrings() {
		return strings;
	}

	public void setStrings(Strings strings) {
		this.strings = strings;
	}

	public GridBagConstraints getGc() {
		return gc;
	}

	public void setGc(GridBagConstraints gc) {
		this.gc = gc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ViewPanelTitleBar [label=" + label + ", mainFrame=" + mainFrame
				+ ", strings=" + strings + ", gc=" + gc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gc == null) ? 0 : gc.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result
				+ ((mainFrame == null) ? 0 : mainFrame.hashCode());
		result = prime * result + ((strings == null) ? 0 : strings.hashCode());
		return result;
	}




}
