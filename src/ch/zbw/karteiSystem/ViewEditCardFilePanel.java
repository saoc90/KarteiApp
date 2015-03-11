package ch.zbw.karteiSystem;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


/*
 * @author Martin Thomann
 */

public class ViewEditCardFilePanel extends JPanel implements ActionListener {

	// Datenfeld
	private static final long serialVersionUID = 1L;
	private static ViewMainFrame viewMainFrame;
	private Strings strings;
	private JTextField language1;
	private JTextField language2;
	private JPanel languagePanel;

	private JButton button1;
	private JButton button2;
	private JButton addButton;
	private JButton resetButton;
	private JButton deleteButton;
	private GridBagConstraints gc;
	private ViewPanelTitleBar titleBar;
	private JLabel backButton;
	private Icon backButtonIcon;
	private MainHandler mainHandler;
	private ViewMyTableModel model;
	private JPanel p;
	private JTable table;
	private JScrollPane scrollPane;
	private CardFile cardFile;


	// Konstruktor
	public ViewEditCardFilePanel(ViewMainFrame viewMainFrame) {

		this.viewMainFrame = viewMainFrame;
		strings = viewMainFrame.getStrings();
		mainHandler = viewMainFrame.getMainHandler();
		this.setBackground(Color.decode("#52787b"));
		this.setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		titleBar = new ViewPanelTitleBar(ViewMainFrame.COLOR1,
				"viewCardFile_title", viewMainFrame);
		language1 = new JTextField((strings.getString("language"))+" 1");
		strings.add(language1);
		language1.addMouseListener(new MouseListener() {
			
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
				language1.setText("");
			}
		});
		language1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String word1 = language1.getText();
				model.setLanguage1(word1);
				
			}
		});
		
		
		language2 = new JTextField((strings.getString("language"))+" 2");
		strings.add(language2);

		language2.addMouseListener(new MouseListener() {
			
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
				language2.setText("");
				
			}
		});
		languagePanel = new JPanel();
		
		
		button1 = new JButton(strings.getString("importButton"));
		button2 = new JButton(strings.getString("exportButton"));
		button1.addActionListener(this);
		button2.addActionListener(this);
		addButton = new JButton(strings.getString("addButton"));
		strings.add(addButton);
		resetButton = new JButton(strings.getString("resetCardfile"));
		strings.add(resetButton);
		deleteButton = new JButton(strings.getString("deleteCardfile"));
		strings.add(deleteButton);
		backButtonIcon = new ImageIcon("png/back.png");
		backButton = new JLabel(backButtonIcon);
		backButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
					writeToCardfile(false);
					ViewEditCardFilePanel.viewMainFrame.changeFrameTo("toCardFilePanel");
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
		paint();
	}

	// GUI zeichnen
	public void paint() {
		// Title Panel Hinzufügen
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(20, 0, 0, 0);
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.gridheight = 1;
		gc.gridwidth = 5;
		gc.fill = GridBagConstraints.HORIZONTAL;
		titleBar.changeTitleToJTextField(null);
		add(titleBar, gc);

		//Sprachen Panel einfügen
		languagePanel.setBackground(Color.decode("#52787b"));
		languagePanel.setLayout(new FlowLayout());
		languagePanel.add(language1);
		languagePanel.add(language2);
		gc.anchor = GridBagConstraints.BASELINE;
		gc.insets = new Insets(100, 0, 0, 0);
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.gridheight = 1;
		gc.gridwidth = 5;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(languagePanel, gc);
		
		
		// add(backButton);
		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 20, 0, 0);
		gc.gridy = 1;
		gc.gridx = 0;
		gc.gridwidth = 1;
		gc.gridheight = 4;
		add(backButton, gc);

		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.VERTICAL;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 2;
		createTable(null);

		
		// Buttons Import/Export hinzufügen
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 10, 0, 10);
		gc.gridy = 1;
		gc.gridx = 4;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		add(button1, gc);

		
		gc.weightx = 2;
		gc.weighty = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 10, 0, 10);
		gc.gridy = 2;
		gc.gridx = 4;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		add(button2, gc);
		
		
		//add resetcardfile button
				addButton.addMouseListener(new MouseListener() {
					
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
						model.addRow();
					}
				});
				gc.gridy = 3;
				
				add(addButton,gc);
		
		//add resetcardfile button
		resetButton.addMouseListener(new MouseListener() {
			
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
				cardFile.resetCounters();
				writeToCardfile(false);
				viewMainFrame.refreshViewEditCardFilePanel();
			}
		});
		gc.gridy = 4;
		
		add(resetButton,gc);
		
		//add deletecardfile button
		deleteButton.addMouseListener(new MouseListener() {
			
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
				writeToCardfile(true);
				try {
					viewMainFrame.changeFrameTo("toCardFilePanel");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		gc.gridy = 5;
		add(deleteButton,gc);

		

	}

	// Tabelle erstellen
	public void createTable(CardFile cardFile) {
		this.cardFile = cardFile;
		if(p!=null&&p.getComponents()!=null)
			p.setVisible(false);
		model=new ViewMyTableModel(cardFile,this);
		table=new JTable(model);
		if(cardFile!=null)
		titleBar.changeTitleJTextField(cardFile.getTitle());
		//table.setPreferredSize(new Dimension(400,500));
		scrollPane = new JScrollPane(table);
		//scrollPane.setPreferredSize(new Dimension(450,501));
		p = new JPanel(new GridLayout(0, 1, 0, 20));
		//p.setPreferredSize(new Dimension(455, 502));
		p.setVisible(true);
		p.setBackground(ViewMainFrame.COLOR5);
		//p.setPreferredSize(new Dimension(360, 400));
		p.add(scrollPane);
		gc.fill = GridBagConstraints.BOTH;
		gc.gridy = 1;
		gc.gridx = 2;
		gc.insets = new Insets(20,0,20,0);
		gc.gridheight = 5;
		add(p, gc);
		
	}

	
	private void writeToCardfile(boolean deleteThisCardfile){
		
		cardFile = model.updatedCardFile();
		
		//check if the same cardfile allready exists.
		ArrayList<CardFile> cardFiles =  mainHandler.getAllCardFiles();
		for(int i=0;i<cardFiles.size();i++){
			
			if (cardFiles.get(i).equals(cardFile))
				cardFiles.remove(i);
		}
		if(deleteThisCardfile!=true)
		mainHandler.addCardFile(cardFile);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button1)){
			model.impTable(viewMainFrame);
		}
		if(e.getSource().equals(button2)){
			model.expTable(viewMainFrame);
		}
		
		
	
	}

	public String getTitle(){
		
		return titleBar.getTitle();
		
	}
	
}
