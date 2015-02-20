/**
 * 
 */
package ch.zbw.karteiSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


/**
 * @author samuelochsner
 *
 */
public class ViewLearnPanel extends JPanel {

	private ViewMainFrame mainframe;
	private CardFile cardfile;
	private Strings strings;
	private JLabel cardfile1,cardfile2,cardfile3,cardfile4,cardfile5;
	private JPanel panelcardfile1,panelcardfile2,panelcardfile3,panelcardfile4,panelcardfile5;
	private ViewPanelTitleBar titlebar;
	private JPanel card;
	private JPanel panelword1,panelword2;
	private JLabel word1,word1Language;
	private JLabel word2,word2Language;
	private JLabel inputLabel;
	private JLabel backButton;
	private Icon backIcon;
	private JLabel okButton;
	private Icon okIcon;
	private JLabel nextButton;
	private Icon nextIcon;
	private GridBagConstraints gc;
	private Insets cardFileInsets;
	private Dimension cardFileSize;
	private JTextField input;
	
	/**
	 * 
	 */
	public ViewLearnPanel(ViewMainFrame mainframe,CardFile cardfile) {
		
		this.mainframe = mainframe;
		this.cardfile = cardfile;
		strings = mainframe.getStrings();
		
		//Panel settings
		setBackground(ViewMainFrame.COLOR5);
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		titlebar = new ViewPanelTitleBar(ViewMainFrame.COLOR1,"",mainframe);
		cardFileInsets = new Insets(1,1,1,1);
		cardFileSize = new Dimension(160,60);
		panelcardfile1 = new JPanel();
		panelcardfile2 = new JPanel();
		panelcardfile3 = new JPanel();
		panelcardfile4 = new JPanel();
		panelcardfile5 = new JPanel();
		panelword1= new JPanel();
		panelword2= new JPanel();
		inputLabel = new JLabel("2");
		Border border1 = BorderFactory.createLineBorder(Color.BLACK, 1);
		paint();
		
		
		
	
	}

	
	private void paint(){
		
		//add tilebar
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth = 5;
		gc.insets = new Insets(20,0,0,0);
		gc.weightx = 1;
		gc.weighty = 0;
		add(titlebar,gc);
		
		//add CardFiles
		
		// cardfile 1
		cardfile1 = new JLabel("1");
		cardfile1.setHorizontalAlignment(SwingConstants.CENTER);
		panelcardfile1.setBackground(ViewMainFrame.COLOR1);
		panelcardfile1.setMinimumSize(cardFileSize);
		panelcardfile1.setPreferredSize(cardFileSize);
		panelcardfile1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelcardfile1.setLayout(new BorderLayout());
		panelcardfile1.add(cardfile1,BorderLayout.CENTER);
		gc.insets = cardFileInsets;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		add(panelcardfile1,gc);
		
		// cardfile 2
		cardfile2 = new JLabel("2");
		cardfile2.setHorizontalAlignment(SwingConstants.CENTER);
		panelcardfile2.setBackground(ViewMainFrame.COLOR2);
		panelcardfile2.setMinimumSize(cardFileSize);
		panelcardfile2.setPreferredSize(cardFileSize);
		panelcardfile2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelcardfile2.setLayout(new BorderLayout());
		panelcardfile2.add(cardfile2,BorderLayout.CENTER);
		gc.gridx = 1;
		add(panelcardfile2,gc);
		
		// cardfile 3

		cardfile3 = new JLabel("3");
		cardfile3.setHorizontalAlignment(SwingConstants.CENTER);
		panelcardfile3.setBackground(ViewMainFrame.COLOR3);
		panelcardfile3.setMinimumSize(cardFileSize);
		panelcardfile3.setPreferredSize(cardFileSize);
		panelcardfile3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelcardfile3.setLayout(new BorderLayout());
		panelcardfile3.add(cardfile3,BorderLayout.CENTER);
		gc.gridx = 2;
		add(panelcardfile3,gc);
		
		// cardfile 4
		cardfile4 = new JLabel("4");
		cardfile4.setHorizontalAlignment(SwingConstants.CENTER);
		panelcardfile4.setBackground(ViewMainFrame.COLOR3);
		panelcardfile4.setMinimumSize(cardFileSize);
		panelcardfile4.setPreferredSize(cardFileSize);
		panelcardfile4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelcardfile4.setLayout(new BorderLayout());
		panelcardfile4.add(cardfile4,BorderLayout.CENTER);
		gc.gridx = 3;
		add(panelcardfile4,gc);
		
		// cardfile 5 
		cardfile5 = new JLabel("5");
		cardfile5.setHorizontalAlignment(SwingConstants.CENTER);
		panelcardfile5.setBackground(ViewMainFrame.COLOR5);
		panelcardfile5.setMinimumSize(cardFileSize);
		panelcardfile5.setPreferredSize(cardFileSize);
		panelcardfile5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelcardfile5.setLayout(new BorderLayout());
		panelcardfile5.add(cardfile5,BorderLayout.CENTER);
		gc.gridx = 4;
		add(panelcardfile5,gc);
		
		
		//Backbutton
		
		backIcon = new ImageIcon("png/back.png");
		backButton = new JLabel(backIcon);
		gc.insets = new Insets(0,20,0,0);
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		add(backButton,gc);
		
		// Card
		
		card = new JPanel();
		card.setLayout(new GridBagLayout());
		GridBagConstraints gcCard = new GridBagConstraints();
		card.setBackground(panelcardfile1.getBackground());
		card.setMinimumSize(new Dimension(460,180));
		card.setSize(new Dimension(460,180));
		card.setPreferredSize(new Dimension(460,180));
		
		
		
		//Label of word1
		
		
		word1Language = new JLabel("1");
		
		gcCard.gridy = 1;
		gcCard.gridx = 0;
		gcCard.gridwidth = 1;
		gcCard.gridheight = 1;
		gcCard.weightx = 1;
		gcCard.weighty =0;
		card.add(word1Language,gcCard);
		
		
		//word1 of card
		word1 = new JLabel("");
		
		panelword1.setBackground(card.getBackground());
		panelword1.setMinimumSize(new Dimension(300,35));
		panelword1.setPreferredSize(new Dimension(300,35));
		panelword1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelword1.add(word1);
		gcCard.gridy = 1;
		gcCard.gridx = 1;
		card.add(panelword1,gcCard);
		
		
		
		
		//label of word 2
		word2Language = new JLabel("2");
		gcCard.gridx = 0;
		gcCard.gridy = 2;
		card.add(word2Language, gcCard);
		
		
		//word2 of card
		word2 = new JLabel("");
		panelword2.setBackground(card.getBackground());
		panelword2.setMinimumSize(new Dimension(300,35));
		panelword2.setPreferredSize(new Dimension(300,35));
		panelword2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panelword2.add(word2,gcCard);
		gcCard.gridy = 2;
		gcCard.gridx = 1;
		card.add(panelword2,gcCard);
		
		
		
		//Language panel of Card
		
		
		gcCard.gridx = 0;
		gcCard.gridy = 3;
		card.add(inputLabel,gcCard); 
		
		//input of card
		input = new JTextField();
		input.setPreferredSize(new Dimension(300,35));
		input.setMinimumSize(new Dimension(300,35));
		input.setSize(input.getPreferredSize());
		input.setText(strings.getString("typeInOnCard"));
		gcCard.gridy = 3;
		gcCard.gridx = 1;
		
		
		
		//add card
		gc.gridx = 1;
		gc.gridwidth = 3;
		gc.anchor = GridBagConstraints.CENTER;
		card.add(input,gcCard);
		add(card,gc);
		setVisible(true);
		
		
		
		
		
		//Mouselistener
		
		
		backButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					mainframe.changeFrameTo("toCardFilePanel");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
				
			}
		});
		
		
	}
	
	
	
	
	
	
	public void fillCardFile(CardFile cardfile){
		
		
		this.cardfile = cardfile;
		
		titlebar.setTitle(cardfile.getTitle());
		
		cardfile1.setText(strings.getString("file") + " 1 / "+cardfile.getNrOfCardsOfBox(1) +" "+strings.getString("card"));
		cardfile2.setText(strings.getString("file") + " 2 / "+cardfile.getNrOfCardsOfBox(2) +" "+strings.getString("card"));
		cardfile3.setText(strings.getString("file") + " 3 / "+cardfile.getNrOfCardsOfBox(3) +" "+strings.getString("card"));
		cardfile4.setText(strings.getString("file") + " 4 / "+cardfile.getNrOfCardsOfBox(4) +" "+strings.getString("card"));
		cardfile5.setText(strings.getString("file") + " 5 / "+cardfile.getNrOfCardsOfBox(5) +" "+strings.getString("card"));
		
		word1Language.setText(cardfile.getLanguage1()+": ");
		word2Language.setText(cardfile.getLanguage2()+": ");
		inputLabel.setText(cardfile.getLanguage2()+": ");
		
		panelword2.setVisible(false);
		word2Language.setVisible(false);
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
