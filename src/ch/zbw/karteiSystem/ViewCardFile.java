/**
 * 
 */
package ch.zbw.karteiSystem;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
 *This class is UI class. It generates a cardfile which can be displayed on the overview of all cardfile panels which is know as pardfilepanel
 *It offers different controlls, like switch languages and acces to the cardfile settings.
 * @author samuelochsner
 *
 */
public class ViewCardFile extends JPanel implements MouseListener {
	
	
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
	private ViewMainFrame mainframe;
	private JLabel addCardFile;
	private boolean isLastCard;

	/**
	 * Standard Constructor with a normal cardfile in it.
	 * 
	 * @param mainframe it needs a reference of a ViewMainFrame, which is the panel manager and contains all informations
	 * @param cardfile a reference of a cardfile which contains all the data of a cardfile.
	 * @param strings Strings handels all changes of languages and buttons. It fires an event, if the language has changed.
	 */
	public ViewCardFile(ViewMainFrame mainframe, CardFile cardfile, Strings strings) {
		this.cardFile = cardfile;
		this.mainframe = mainframe;
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
		addMouseListener(this);
		
		
	}
	
	
	/**
	 * This constructor is for the last cardfile, wich is used as button to add a new cardfile.
	 * @param isEmty It creates the last cardfile of the list, which is used to add new cardfiles
	 * @param strings strings Strings handels all changes of languages and buttons. It fires an event, if the language has changed.
	 */
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

		
		paintLastCard();
		addMouseListener(this);
	}
	
	/*
	 * This Method paints the standard cardfile panel
	 */
	private void paint(){
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
		settingsLabel.addMouseListener(this);
		settingsLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
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
				mainframe.changeEditCardFilePaneltoCardFile(cardFile);
				try {
					mainframe.changeFrameTo("toEditCardFilePanel");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		add(settingsLabel, gc);
		
	}
	
	
	
	/**
	 * refreshes all parameter of the viewCardFile with the actual parameters of cardfile
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
	

	/**
	 *paints the last card of the list, which is a button to add a new cardfile
	 */
	public void paintLastCard(){
		
		Icon add = new ImageIcon("png/add.png");
		
		addCardFile = new JLabel(strings.getString("addCardFile"),add,GridBagConstraints.CENTER);
		addCardFile.setFont(new Font("LucidaBright",Font.BOLD,25));
		addCardFile.setName("addCardFile");
		strings.add(addCardFile);
		
		isLastCard = true;
		add(addCardFile,gc);
		
	}
	
	
	
	
	/**
	 * @return Cardfile with all cardfiles in it
	 */
	public CardFile getCardFile(){
		
		
		return cardFile;
	}
	
	
	/**
	 * checks if its the last cardfile in the view
	 * @return returns true if this cardfile is the last on the list, which is used as button for a new cardfile
	 */
	public boolean isLastCard() {
		return isLastCard;
	}

	/**
	 * changes the datafield lastcard
	 * @param isLastCard marks it as the last cardfile in the list
	 */
	public void setLastCard(boolean isLastCard) {
		this.isLastCard = isLastCard;
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
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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


	


	

}
