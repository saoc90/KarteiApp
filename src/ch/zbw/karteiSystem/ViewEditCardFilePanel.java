package ch.zbw.karteiSystem;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * This class creates and manages the view of the JTable.
 * It implements the class ActionListener.
 * 
 * 
 * @author Martin Thomann
 * 
 */
public class ViewEditCardFilePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static ViewMainFrame viewMainFrame;
	private Strings strings;
	private JTextField languageJTF1; //The textfield for the language 1
	private JTextField languageJTF2; //The textfield for the language 2
	private JLabel langLabel1;
	private JLabel langLabel2;
	private JPanel languagePanel;
	private JButton button1; //The Import Button
	private JButton button2; //The Export Button
	private JButton addButton; //The add row button
	private JButton resetButton; //The resest button
	private JButton deleteButton; //The delete button
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

	
	/**
	 * Main constructor
	 * @param viewMainFrame
	 */
	@SuppressWarnings("static-access")
	public ViewEditCardFilePanel(ViewMainFrame viewMainFrame) {

		this.viewMainFrame = viewMainFrame;
		strings = viewMainFrame.getStrings();
		mainHandler = viewMainFrame.getMainHandler();
		this.setBackground(Color.decode("#52787b"));
		this.setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		
		//creates the titlebar
		titleBar = new ViewPanelTitleBar(ViewMainFrame.COLOR1,
				"viewCardFile_title", viewMainFrame);
		
		//creates the JTextFields for the first language titel
		languageJTF1 = new JTextField((strings.getString("language"))+" 1");
		strings.add(languageJTF1);
		languageJTF1.setName("language");
		//The MouseListener clears the default string in the JTextField, when MouseClicked
		languageJTF1.addMouseListener(new MouseListener() {
			
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
				languageJTF1.setText("");
			}
		});
		langLabel1 = new JLabel(strings.getString("language")+" 1");
		strings.add(langLabel1);
		langLabel1.setName("language");
		
		//creates the JTextFields for the second language titel
		languageJTF2 = new JTextField((strings.getString("language"))+" 2");
		strings.add(languageJTF2);
		languageJTF2.setName("language");
		//The MouseListener clears the default string in the JTextField, when MouseClicked
		languageJTF2.addMouseListener(new MouseListener() {
			
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
				languageJTF2.setText("");
				
			}
		});
		langLabel2 = new JLabel(strings.getString("language")+" 2");
		strings.add(langLabel2);
		langLabel2.setName("language");
		
		languagePanel = new JPanel();
		
		button1 = new JButton(strings.getString("importButton")); //creates the Import button
		button1.setName("importButton");
		strings.add(button1);
		button2 = new JButton(strings.getString("exportButton")); //creates the Export button
		button2.setName("exportButton");
		strings.add(button2);
		button1.addActionListener(this);
		button2.addActionListener(this);
		addButton = new JButton(strings.getString("addButton"));
		addButton.setName("addButton");
		strings.add(addButton);
		resetButton = new JButton(strings.getString("resetCardfile"));
		strings.add(resetButton);
		resetButton.setName("resetCardfile");
		deleteButton = new JButton(strings.getString("deleteCardfile"));
		strings.add(deleteButton);
		deleteButton.setName("deleteCardfile");
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

	
	/**
	 * Paints the titlebar, the language panel, the table and all buttons.
	 */
	private void paint() {
		// adds titelbar panel to GridBag-Layout 
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(20, 0, 0, 0);
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.gridheight = 1;
		gc.gridwidth = 6;
		gc.fill = GridBagConstraints.HORIZONTAL;
		titleBar.changeTitleToJTextField(null);
		add(titleBar, gc);

		// adds language panel to GridBag-Layout
		languagePanel.setBackground(Color.decode("#52787b"));
		languagePanel.setLayout(new FlowLayout());
		Dimension d = new Dimension(150,20);
		languageJTF1.setPreferredSize(d);
		languagePanel.add(langLabel1);
		languagePanel.add(languageJTF1);
		languageJTF2.setPreferredSize(d);
		languagePanel.add(langLabel2);
		languagePanel.add(languageJTF2);
		gc.anchor = GridBagConstraints.BASELINE;
		gc.insets = new Insets(100, 0, 0, 0);
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.gridheight = 1;
		gc.gridwidth = 6;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(languagePanel, gc);
		
		// adds back button to GridBag-Layout
		gc.fill = GridBagConstraints.VERTICAL;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 20, 0, 0);
		gc.gridy = 1;
		gc.gridx = 0;
		gc.gridwidth = 1;
		gc.gridheight = 5;
		add(backButton, gc);

		// adds the JTable to GridBag-Layout
		createTable(null);

		// adds the import button to the GridBag-Layout
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 30, 0, 10);
		gc.gridy = 1;
		gc.gridx = 5;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		add(button1, gc);

		// adds the export button to the GridBag-Layout
		gc.gridy = 2;
		add(button2, gc);
		
		// adds the add row button to the GridBag-Layout
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
		add(addButton, gc);
		
		// adds the reset button to the GridBag-Layout
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
				int choosenOption = JOptionPane.showOptionDialog(null, strings.getString("dialogResetCard"),strings.getString("attention"),
		                JOptionPane.YES_NO_CANCEL_OPTION,
		                JOptionPane.WARNING_MESSAGE, null, 
		                new String[]{strings.getString("ok"), strings.getString("cancel")}, "B");
					
				if (choosenOption == JOptionPane.OK_OPTION) {
					if(cardFile!=null)
						cardFile.resetCounters();
					writeToCardfile(false);
				}
			}
		});
		gc.gridy = 4;
		add(resetButton,gc);
		
		// adds the delete button to the GridBag-Layout
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
				int choosenOption = JOptionPane.showOptionDialog(null, strings.getString("dialogDeletCard"),strings.getString("attention"),
		                JOptionPane.YES_NO_CANCEL_OPTION,
		                JOptionPane.WARNING_MESSAGE, null, 
		                new String[]{strings.getString("ok"), strings.getString("cancel")}, "B");
					
				if (choosenOption == JOptionPane.OK_OPTION) {
						writeToCardfile(true);
						try {
							viewMainFrame.changeFrameTo("toCardFilePanel");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				
			}
		});
		gc.gridy = 5;
		add(deleteButton,gc);
	}
	
	
	/**
	 * This method creates the JTable with a TableModel
	 * and shows it in a JScrollPanel, which is added to the GridBag-Layout
	 * 
	 * @param cardFile
	 */
	public void createTable(CardFile cardFile) {
		this.cardFile = cardFile;
		if(p!=null&&p.getComponents()!=null)
			p.setVisible(false);
		model=new ViewMyTableModel(cardFile,this,viewMainFrame);
		table=new JTable(model);
		if(cardFile!=null){
			languageJTF1.setText(cardFile.getLanguage1());
			languageJTF2.setText(cardFile.getLanguage2());
			titleBar.changeTitleJTextField(cardFile.getTitle());	
		}
		scrollPane = new JScrollPane(table);
		p = new JPanel(new GridLayout(0, 1, 0, 20));
		p.setVisible(true);
		p.setBackground(ViewMainFrame.COLOR5);
		p.add(scrollPane);
		gc.weightx = 4;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridy = 1;
		gc.gridx = 1;
		gc.insets = new Insets(20,0,20,0);
		gc.gridheight = 5;
		gc.gridwidth = 4;
		add(p, gc);
	}

	/**
	 * Writes to the cardfile or delets it, if the parameter is true.
	 * 
	 * @param deleteThisCardfile
	 */
	private void writeToCardfile(boolean deleteThisCardfile){
		
		
		model.setLanguage1(languageJTF1.getText());
		if(model.getLanguage1()==null||model.getLanguage1().equals("")){
			model.setLanguage1("Unknown");
		}
		model.setLanguage2(languageJTF2.getText());
		if(model.getLanguage2()==null||model.getLanguage2().equals("")){
			model.setLanguage2("Unknown");
		}
		
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
	
	/**
	 * Returns a String of the titel, which could be changed in the titlebar JTextField.
	 * 
	 * @return String
	 */
	public String getTitle(){	
		return titleBar.getTitle();
	}
	
}

