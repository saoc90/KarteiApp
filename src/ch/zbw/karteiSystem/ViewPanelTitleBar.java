package ch.zbw.karteiSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class generates a UI View panel which is used for the title bar in every panel of this application.
 * 
 * @author samuelochsner
 *
 */
public class ViewPanelTitleBar extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private ViewMainFrame mainFrame;
	private Strings strings;
	private GridBagConstraints gc;
	private JTextField jtf;

	/**
	 * @param color should be a Color from the colorpallet ViewMainFrame.COLOR1-5
	 * @param name a string which is diplayed as title
	 * @param viewMainFrame Instance of ViewMainFrame for delegating
	 */
	public ViewPanelTitleBar(Color color, String name, ViewMainFrame viewMainFrame) {
		setPreferredSize(new Dimension(600,60));
		setMinimumSize(new Dimension(600,60));
		setBackground(color);
		setLayout(new GridBagLayout());
		
		this.mainFrame = viewMainFrame;
		gc = new GridBagConstraints();
		strings = mainFrame.getStrings();
		label = new JLabel(strings.getString(name));
		strings.add(label);
		label.setFont(ViewMainFrame.FONT1);
		label.setName(name);
		label.setText(strings.getString(name));
		strings.add(label);
		label.setName(name);
		add(label, gc);
		this.setVisible(true);
	}

	/**
	 * changes the title of the titlebar
	 * 
	 * @param title sets the title of the titlebar to the given string
	 */
	public void setTitle(String title){
		
		this.label.setText(title);
		
	}
	
	/**
	 * 
	 * This method changes the JLabel in the titlebar to a JTextField and changes the text in it.
	 * @param name text which is displayed as dummytext in the JTextField.
	 */
	public void changeTitleToJTextField(String name){
		jtf=new JTextField();
		label.setVisible(false);
		jtf.setName(name);
		jtf.setPreferredSize(new Dimension(200, 20));
		add(jtf, gc);
		strings.add(jtf);
		this.jtf.setText(strings.getString("editTitle"));
		
		jtf.addMouseListener(new MouseListener() {
			
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
				jtf.setText("");
			}
		});
	}
	
	public void changeTitleJTextField(String name){
		if(jtf!=null){
			
			jtf.setText(name);
			
		}
		
		
	}
	
	/**
	 * @return Title of the titlebar.
	 */
	public String getTitle(){
		
		if(jtf!=null)
			return jtf.getText();
		
		return null;
		
	}
	
	/**
	 * @return Label of the titlebar
	 */
	public JLabel getLabel() {
		return label;
	}





}
