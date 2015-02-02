/**
 * 
 */
package ch.zbw.karteiSystem;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author samuelochsner
 *
 */
public class CardFile extends JPanel implements ActionListener {
	
	
	
	private double wokredHours;
	private String label;
	private JLabel title;
	private JLabel languages;
	private JLabel stats;
	private JLabel workingHours;
	private JLabel changeLanguages;
	private Font titleFont;
	private String language1;
	private String language2;
	private Border borderTitle;
	private Border borderContent;
	private String progress;
	private int cardsInCardFile;
	private Icon languagesIcon;
	private Icon statsIcon;
	private Icon time;
	private Icon changeLanguagesIcon;
	private Icon settings;
	private Dimension dimension;
	private GridBagConstraints gc;

	/**
	 * 
	 */
	public CardFile() {
	
		dimension = new Dimension(340,120);
		setPreferredSize(dimension);
		setBackground(MainFrame.COLOR2);
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		titleFont = new Font("LucidaBright",Font.BOLD,20);
		borderTitle = BorderFactory.createLineBorder(MainFrame.COLOR5);
		changeLanguagesIcon = new ImageIcon("png/changeLanguageIcon.png");
		paint();
		
	}
	
	
	public void paint(){
		//Add Titel JLabel//
		gc.gridwidth = GridBagConstraints.REMAINDER;
		gc.gridheight = 2;
		gc.gridy = 0;
		gc.insets = new Insets(5,20,5,20);
		title = new JLabel("Lernkartei 1 Name");
		title.setFont(titleFont);
		title.setBorder(borderTitle);
		add(title	, gc);
		
		// Add Langugages //
		
		gc.gridwidth = 3;
		gc.gridheight = 1;
		gc.gridy = 3;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = new Insets (0,0,0,0);
		languages = new JLabel("Language 1 - Language 2");
		add(languages, gc);
		
		
		// Add Change Icon ///
		
		gc.gridwidth = 2;
		gc.gridheight = 1;
		gc.gridy = 3;
		gc.gridx = 3;
		gc.fill = GridBagConstraints.RELATIVE;
		gc.anchor = GridBagConstraints.EAST;
		changeLanguages = new JLabel(changeLanguagesIcon);
		changeLanguages.addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				System.out.println("Language Changed");
			}
		});
		add(changeLanguages, gc);
		
		
	}
	
	
	
	
	
	
	

	/**
	 * @param layout
	 */
	public CardFile(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isDoubleBuffered
	 */
	public CardFile(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public CardFile(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
