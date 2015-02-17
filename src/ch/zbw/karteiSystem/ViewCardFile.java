/**
 * 
 */
package ch.zbw.karteiSystem;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * @author samuelochsner
 *
 */
public class ViewCardFile extends JPanel implements ActionListener {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private String progressString;
	private int cardsInCardFile;
	private Icon languagesIcon;
	private Icon cardsIcon;
	private Icon successIcon;
	private Icon changeLanguagesIcon;
	private Icon settings;
	private Dimension dimension;
	private GridBagConstraints gc;
	private Insets  insetLeft, insetTop, insetRight, insetButtomLeft,insetButtomRight;
	private CardFile cardFile;
	private Strings strings;
	JLabel addCardFile;

	/**
	 * 
	 */
	public ViewCardFile(CardFile cardFile, Strings strings) {
		this.cardFile = cardFile;
		this.strings = strings;
		dimension = new Dimension(340,140);
		setPreferredSize(dimension);
		setBackground(ViewMainFrame.COLOR2);
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		titleFont = new Font("LucidaBright",Font.BOLD,20);
		//borderTitle = BorderFactory.createLineBorder(ViewMainFrame.COLOR1);
		changeLanguagesIcon = new ImageIcon("png/changeLanguageIcon.png");
		languagesIcon = new ImageIcon("png/languages.png");
		cardsIcon = new ImageIcon("png/cards.png");
		successIcon = new ImageIcon("png/success.png");
		insetTop = new Insets(5,20,5,20);
		insetLeft = new Insets(5,20,5,5);
		insetRight = new Insets(5,5,5,20);
		insetButtomLeft = new Insets(5,20,15,5);
		insetButtomRight = new Insets(5,5,15,20);
		paint();
		addMouseListener(new MouseListener() {
			
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
				setBorder(null);				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(ViewMainFrame.COLOR1));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	public ViewCardFile(Boolean isEmty,Strings strings) {
		this.strings = strings;
		dimension = new Dimension(340,140);
		setPreferredSize(dimension);
		setBackground(ViewMainFrame.COLOR2);
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		titleFont = new Font("LucidaBright",Font.BOLD,20);
		//borderTitle = BorderFactory.createLineBorder(ViewMainFrame.COLOR1);
		insetTop = new Insets(5,20,5,20);
		insetLeft = new Insets(5,20,5,5);
		insetRight = new Insets(5,5,5,20);
		insetButtomLeft = new Insets(5,20,15,5);
		insetButtomRight = new Insets(5,5,15,20);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				//to addCardFilePanel with null reference of cardFile
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(null);				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(ViewMainFrame.COLOR1));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		paintLastCard();
	}
	
	/*
	 * This Method paints the standard cardfile panel
	 */
	public void paint(){
		//Add Titel JLabel//
		gc.gridwidth = 5;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = insetTop;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.weighty = 1;
		gc.weightx = 1;
		gc.gridheight = 2;
		gc.ipadx = 5;
		gc.ipady = 30;
		gc.gridy = 0;
		gc.gridx = 1;
		title = new JLabel(cardFile.getTitle());
		title.setFont(titleFont);
		title.setBorder(borderTitle);
		add(title	, gc);
		
		// Add Langugages //
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = insetLeft;
		gc.gridwidth = 6;
		gc.gridheight = 1;
		gc.gridy = 2;
		gc.ipady = 24;
		gc.gridx = 0;
		languages = new JLabel(cardFile.getLanguage1()+" - "+cardFile.getLanguage2(),languagesIcon,SwingConstants.CENTER);
		languages.setPreferredSize(new Dimension(250,16));
		System.out.println(languages.getPreferredSize());
		add(languages, gc);
		
		
		// Add Change Icon ///
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = insetRight;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.ipady = 24;
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
				changeLanguages.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				changeLanguages.setBorder(BorderFactory.createLineBorder(ViewMainFrame.COLOR1));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				cardFile.setLanguageSwitched();
				refresh();
				
				System.out.println("Language Changed");
			}
		});
		add(changeLanguages, gc);
		
		
		//Add Cards in Cardfiles label////
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = insetLeft;
		gc.gridy = 3;
		gc.gridx = 0;
		gc.ipady = 20;
		gc.gridwidth = 6;
		gc.gridheight = 1;
		cards = new JLabel(cardFile.getNumberOfCards()+" "+strings.getString("numberOfCards"),cardsIcon,SwingConstants.CENTER);
		strings.add(cards);
		add(cards, gc);
		
		
		//Add Progress Indicator Label//
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = insetButtomLeft;
		gc.gridy = 4;
		gc.gridx = 0;
		gc.gridwidth = 6;
		gc.gridheight = 1;
		progress = new JLabel(""+cardFile.getProgress()+"% "+strings.getString("finished"),successIcon,SwingConstants.CENTER);
		strings.add(progress);
		add(progress, gc);
		
		
		//Settings Icon
		
		gc.gridy = 4;
		gc.gridx = 5;
		gc.ipady = 24;
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
				settingsLabel.setBorder(null);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				settingsLabel.setBorder(BorderFactory.createLineBorder(ViewMainFrame.COLOR1));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Settings klicked");
			}
		});
		add(settingsLabel, gc);
		
	}
	
	
	/*
	 * refreshes all parameter of the viewCardFile with the actual parameters of cardfile
	 * 
	 * 
	 */
	
	public void refresh(){
		
		if(title!=null){
		title.setText(cardFile.getTitle());
		languages.setText(cardFile.getLanguage1()+" - "+cardFile.getLanguage2());
		cards.setText(cardFile.getNumberOfCards()+" "+strings.getString("numberOfCards"));
		progress.setText(""+cardFile.getProgress()+"% "+strings.getString("finished"));
		}
	}
	
	/*
	 * paints the last card of the list, which is a button to add a new cardfile
	 * 
	 */
	private void paintLastCard(){
		
		Icon add = new ImageIcon("png/add.png");
		
		addCardFile = new JLabel(strings.getString("addCardFile"),add,GridBagConstraints.CENTER);
		addCardFile.setFont(new Font("LucidaBright",Font.BOLD,25));
		strings.add(addCardFile);
		add(addCardFile,gc);
		
	}
	
	
	
	



	@Override
	public String toString() {
		return "ViewCardFile [wokredHours=" + wokredHours + ", label=" + label
				+ ", title=" + title + ", languages=" + languages + ", cards="
				+ cards + ", progress=" + progress + ", changeLanguages="
				+ changeLanguages + ", settingsLabel=" + settingsLabel
				+ ", titleFont=" + titleFont + ", language1=" + language1
				+ ", language2=" + language2 + ", borderTitle=" + borderTitle
				+ ", progressString=" + progressString + ", cardsInCardFile="
				+ cardsInCardFile + ", settings=" + settings + "]";
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
