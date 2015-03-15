/**
 * 
 */
package ch.zbw.karteiSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;


/**
 * This class generates a UI View Panel. Which displays the given cardfile. Also it displays the different boxes in the cardfile.
 * The central element is the actual card, which takes user inputs and controls if the given input is correct.
 * 
 * 
 * @author samuelochsner
 *
 */
public class ViewLearnPanel extends JPanel {


	private static final long serialVersionUID = 1L;
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
	private JLabel checkButton;
	private Icon checkIcon;
	private JLabel nextButton;
	private Icon nextIcon;
	private GridBagConstraints gc;
	private Insets cardFileInsets;
	private Dimension cardFileSize;
	private JTextField input;
	private JLabel noCard;
	private Card learnCard;
	private int cardfileNr;
	private boolean alreadyAnswered;
	private MainHandler mainhandler;
	
	
	/**
	 * Main Constructor
	 * @param mainframe instance of ViewMainFrame for delegating
	 * @param cardfile the cardfile which should be displayed on the learnpanel.
	 */
	public ViewLearnPanel(ViewMainFrame mainframe,CardFile cardfile) {
		
		this.mainframe = mainframe;
		this.cardfile = cardfile;
		strings = mainframe.getStrings();
		this.mainhandler = mainframe.getMainHandler();
		
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
		noCard = new JLabel(strings.getString("noCard"));
		checkIcon = new ImageIcon("png/check.png");
		checkButton = new JLabel(checkIcon);
		nextIcon = new ImageIcon("png/next.png");
		nextButton = new JLabel(nextIcon);
		strings.add(noCard);
		cardfileNr=1;
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
		panelcardfile1.addMouseListener(new MouseListener() {
			
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
				selectCardFile(1);
			}
		});
		
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
		panelcardfile2.addMouseListener(new MouseListener() {
			
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
				selectCardFile(2);				
			}
		});
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
		panelcardfile3.addMouseListener(new MouseListener() {
			
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
				selectCardFile(3);				
			}
		});
		
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
		panelcardfile4.addMouseListener(new MouseListener() {
			
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
				selectCardFile(4);				
			}
		});
		
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
		panelcardfile5.addMouseListener(new MouseListener() {
			
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
				selectCardFile(5);				
			}
		});
		
		
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
		input.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar()=='\n')
					checkAnswer();
				if(input.getText().equals(strings.getString("typeInOnCard")))
					input.setText("");
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
			
			}
		});
		input.addMouseListener(new MouseListener() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				input.setText("");
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		input.setPreferredSize(new Dimension(300,35));
		input.setMinimumSize(new Dimension(300,35));
		input.setSize(input.getPreferredSize());
		input.setText(strings.getString("typeInOnCard"));
		input.setName("inputOfCard");
		strings.add(input);
		gcCard.gridy = 3;
		gcCard.gridx = 1;
		card.add(input,gcCard);
		
		//noCard of card
		
		card.add(noCard,gcCard);
		
		//add CheckButton /nextButton
		
		gcCard.gridx = 0;
		gcCard.gridwidth =2;
		gcCard.gridy = 4;
		gcCard.insets = new Insets(10,0,0,0);
		gcCard.anchor = GridBagConstraints.CENTER;
		card.add(checkButton,gcCard);
		card.add(nextButton,gcCard);
		
		
		checkButton.addMouseListener(new MouseListener() {
			
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
				checkAnswer();
				
			}
		});
		nextButton.addMouseListener(new MouseListener() {
			
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
				checkAnswer();
				
			}
		});
		
		
		//add card
		gc.gridx = 1;
		gc.gridwidth = 3;
		gc.anchor = GridBagConstraints.CENTER;
		
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
	
	
	
	
	
	
	/**
	 * @param cardfile cardfile which should be displayed on learnpanel
	 * @param init true if it's the first time this this method is called. So the cardfile infos are also written. False if its only for refreshig the infos.
	 */
	public void fillCardFile(CardFile cardfile, boolean init){
		
		this.cardfile = cardfile;
		
		cardfile1.setText(strings.getString("file") + " 1 / "+cardfile.getNrOfCardsOfBox(1) +" "+strings.getString("card"));
		cardfile2.setText(strings.getString("file") + " 2 / "+cardfile.getNrOfCardsOfBox(2) +" "+strings.getString("card"));
		cardfile3.setText(strings.getString("file") + " 3 / "+cardfile.getNrOfCardsOfBox(3) +" "+strings.getString("card"));
		cardfile4.setText(strings.getString("file") + " 4 / "+cardfile.getNrOfCardsOfBox(4) +" "+strings.getString("card"));
		cardfile5.setText(strings.getString("file") + " 5 / "+cardfile.getNrOfCardsOfBox(5) +" "+strings.getString("card"));
		
		if(init){
		
		
		titlebar.setTitle(cardfile.getTitle());
		
		word1Language.setText(cardfile.getLanguage1()+": ");
		word2Language.setText(cardfile.getLanguage2()+": ");
		inputLabel.setText(cardfile.getLanguage2()+": ");
		
		panelword2.setVisible(false);
		word2Language.setVisible(false);
		
		//Fill learncard with word
		
		selectCardFile(cardfileNr);
		
		}
		
		
	}
	
	
	private void showNoCard(){
		
		Component[] componentlist = card.getComponents();
		for(Component tmp : componentlist){
			
			tmp.setVisible(false);
			
		}
		noCard.setVisible(true);
	}
	
	private void showCard(){
		
		Component[] componentlist = card.getComponents();
		for(Component tmp : componentlist){
			
			tmp.setVisible(true);
			
		}
		noCard.setVisible(false);
		nextButton.setVisible(false);
		showWord2(false);
		
	}
	
	
	private void fillNextCard(int cardFileNr){
		
		if(cardfile.getNrOfCardsOfBox(cardFileNr)==0){
				showNoCard();
				return;
		}
		learnCard  = cardfile.getCard(cardFileNr);
		
		word1.setText(learnCard.getWord1());
		word2.setText(learnCard.getWord2());
		showCard();
		input.setText(strings.getString("typeInOnCard"));
		alreadyAnswered = false;
		input.requestFocusInWindow();
	}
	
	
	private void showWord2(boolean show){
		
		word2Language.setVisible(show);
		word2.setVisible(show);
		panelword2.setVisible(show);
		
	}
	
	private void setWord2Border(Color color){
		
		panelword2.setBorder(BorderFactory.createLineBorder(color));
		
	}
	
	
	private void checkAnswer(){
		
		if(!alreadyAnswered){
		
		if(input.getText().equals(learnCard.getWord2())){
			
			showWord2(true);
			setWord2Border(Color.GREEN);
			learnCard.rightAnswer();
			mainhandler.increaseScore();
			fillCardFile(cardfile, false);
			
				}else{
			
				showWord2(true);
				setWord2Border(Color.RED);
				learnCard.wrongAnswer();
				fillCardFile(cardfile, false);
				}
			alreadyAnswered = true;
			checkButton.setVisible(false);
			nextButton.setVisible(true);
		}else{
			
			fillNextCard(cardfileNr);
			alreadyAnswered = false;
			if(cardfile.getNrOfCardsOfBox(cardfileNr)!=0){
			checkButton.setVisible(true);
			nextButton.setVisible(false);
			}
			
		
		}
		
		
		
		
	}
	
	
	private void selectCardFile(int nr){
		
		panelcardfile1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelcardfile2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelcardfile3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelcardfile4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelcardfile5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
		if(nr==1){
			panelcardfile1.setBorder(BorderFactory.createLineBorder(ViewMainFrame.COLOR1));
			cardfileNr = 1;
		}
		if(nr==2){
			panelcardfile2.setBorder(BorderFactory.createLineBorder(ViewMainFrame.COLOR1));
			cardfileNr = 2;
		}
		if(nr==3){
			panelcardfile3.setBorder(BorderFactory.createLineBorder(ViewMainFrame.COLOR1));
			cardfileNr = 3;
		}
		if(nr==4){
			panelcardfile4.setBorder(BorderFactory.createLineBorder(ViewMainFrame.COLOR1));
			cardfileNr = 4;
		}
		if(nr==5){
			panelcardfile5.setBorder(BorderFactory.createLineBorder(ViewMainFrame.COLOR1));
			cardfileNr = 5;
		}
		
		fillNextCard(nr);
	}
	
	
}
