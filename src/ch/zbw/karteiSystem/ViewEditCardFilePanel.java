package ch.zbw.karteiSystem;


import java.awt.BorderLayout;
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
import java.util.EventListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * @author Martin Thomann
 */

public class ViewEditCardFilePanel extends JPanel implements ActionListener {

	// Datenfeld
	private static final long serialVersionUID = 1L;
	private static ViewMainFrame viewMainFrame;
	private Strings strings;
	private JButton button1;
	private JButton button2;
	private GridBagConstraints gc;
	private ViewPanelTitleBar titleBar;
	private JLabel backButton;
	private Icon backButtonIcon;
	private MainHandler mainHandler;
	private ViewMyTableModel model;


//	private JTable table;
//	private JScrollPane scrollPane;

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
		this.setVisible(false);
		button1 = new JButton();
		button2 = new JButton();
		button1.setText("import");
		button1.addActionListener(this);
		button2.setText("export");
		button2.addActionListener(this);
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
					CardFile cardFile = model.updatedCardFile();
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

		// add(backButton);
		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 20, 0, 0);
		gc.gridy = 1;
		gc.gridx = 0;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		add(backButton, gc);

		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.VERTICAL;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridheight = 1;
		gc.gridwidth = 4;
		createTable(null);

		// Buttons Import/Export hinzufügen
		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 20, 0, 0);
		gc.gridy = 2;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		add(button1, gc);

		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 2;
		gc.weighty = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 20, 0, 0);
		gc.gridy = 2;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		add(button2, gc);

		setVisible(true);

	}

	// Tabelle erstellen
	public void createTable(CardFile cardFile) {
		model=new ViewMyTableModel(cardFile);
		JTable table=new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);

		JPanel p = new JPanel(new GridLayout(0, 1, 0, 20));
		p.setBackground(ViewMainFrame.COLOR5);
		p.setPreferredSize(new Dimension(360, 400));
		p.add(scrollPane);
		add(p, gc);
		setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button1)){
			model.impTable(viewMainFrame);
		}
		if(e.getSource().equals(button2)){
			model.expTable(viewMainFrame);
		}
		
		
	
	}

}
