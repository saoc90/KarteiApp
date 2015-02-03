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
	private JLabel cards;
	private JLabel progress;
	private JLabel changeLanguages;
	private JLabel settingsLabel;
	private Font titleFont;
	private String language1;
	private String language2;
	private Border borderTitle;
	private Border borderContent;
	private String progressString = "60% Abgeschlossen";
	private int cardsInCardFile;
	private Icon languagesIcon;
	private Icon statsIcon;
	private Icon time;
	private Icon changeLanguagesIcon;
	private Icon settings;
	private Dimension dimension;
	private GridBagConstraints gc;
	private Insets  insetLeft, insetTop, insetRight, insetButtomLeft,insetButtomRight;

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
		insetTop = new Insets(5,20,5,20);
		insetLeft = new Insets(5,20,5,5);
		insetRight = new Insets(5,5,5,20);
		insetButtomLeft = new Insets(5,20,15,5);
		insetButtomRight = new Insets(5,5,15,20);
		paint();
		
	}
	
	
	public void paint(){
		//Add Titel JLabel//
		gc.gridwidth = 5;
		gc.insets = insetTop;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.weighty = 1;
		gc.weightx = 1;
		gc.gridheight = 2;
		gc.ipadx = 5;
		gc.ipady = 5;
		gc.gridy = 0;
		gc.gridx = 1;
		title = new JLabel("Lernkartei 1 Name");
		title.setFont(titleFont);
		title.setBorder(borderTitle);
		add(title	, gc);
		
		// Add Langugages //
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = insetLeft;
		gc.gridwidth = 6;
		gc.gridheight = 1;
		gc.gridy = 2;
		gc.gridx = 0;
		languages = new JLabel("Language 1 - Language 2");
		languages.setPreferredSize(new Dimension(250,16));
		System.out.println(languages.getPreferredSize());
		add(languages, gc);
		
		
		// Add Change Icon ///
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = insetRight;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.gridy = 2;
		gc.gridx = 5;
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
		
		
		//Add Cards in Cardfiles label////
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = insetLeft;
		gc.gridy = 3;
		gc.gridx = 0;
		gc.gridwidth = 6;
		gc.gridheight = 1;
		cards = new JLabel("60 Karten");
		add(cards, gc);
		
		
		//Add Progress Indicator Label//
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = insetButtomLeft;
		gc.gridy = 4;
		gc.gridx = 0;
		gc.gridwidth = 6;
		gc.gridheight = 1;
		progress = new JLabel("20% abbgeschlossen"	);
		add(progress, gc);
		
		
		//Settings Icon
		
		gc.gridy = 4;
		gc.gridx = 5;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = insetButtomRight;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		settings = new ImageIcon ("png/settingssmall.png");
		settingsLabel = new JLabel(settings);
		settingsLabel.addMouseListener(new MouseListener() {
			
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
				System.out.println("Settings klicked");
			}
		});
		add(settingsLabel, gc);
		
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
