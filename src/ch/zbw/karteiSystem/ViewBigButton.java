package ch.zbw.karteiSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 
 * *
 *         This class paints the big buttons on the ViewStartPanel. It
 *         implements the MouseListener for the buttons.
 * @author samuelochsner
 *
 */
public class ViewBigButton extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private String title;
	private Vector<ActionListener> listeners = null;
	private boolean hit = false;
	private int intx;
	private int inty;
	private ImageIcon icon;
	private Color color;
	private JLabel title1;

	
	/**
	 * @param name name of the button (not the text on it)
	 * @param title title of the button (text on the button)
	 * @param imageIcon icon which is diplayed on the left on the button
	 * @param x weight of the button in pixels
	 * @param y height of the button in pixels
	 * @param color color of the button background (intance of COLOR) eg. ViewMainFrame.COLOR1 
	 */
	public ViewBigButton(String name, String title, ImageIcon imageIcon, int x,
			int y, Color color) {
		super();
		this.title = title;
		listeners = new Vector<ActionListener>();
		addMouseListener(this);
		this.intx = x;
		this.inty = y;
		this.icon = imageIcon;
		this.color = color;
		paintComponent();
		setName(name);

	}

	/*
	 * Paints the components title, imageIcon and color in the button
	 * and sets the size.
	 */
	public void paintComponent() {

		setPreferredSize(new Dimension(intx, inty));
		setBackground(color);
		setLayout(new BorderLayout());
		GridBagConstraints gc = new GridBagConstraints();
		setBorder(new EmptyBorder(0, 30, 0, 0));
		gc.gridx = 1;
		gc.gridheight = 1;
		gc.gridwidth = 10;
		gc.anchor = GridBagConstraints.WEST;

		gc.insets = new Insets(2, 2, 2, 2);
		title1 = new JLabel(title, icon, SwingConstants.LEFT);

		title1.setFont(new Font("LucidaBright", Font.BOLD, 35)); // set the font size
		title1.setForeground(Color.BLACK);
		this.add(title1, BorderLayout.WEST);
		setVisible(true);
	}

	/**
	 * @param text changes the text of the button to the given string
	 */
	public void setText(String text) {
		title1.setText(text);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		hit = true;
		repaint();
		fireEvent(new ActionEvent(this, 0, title));

	}

	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
		hit = false;
		repaint();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * @param listener adds the given ActionListener to the action fire list.
	 */
	public void addActionListener(ActionListener listener) {
		listeners.addElement(listener);
	}

	/**
	 * @param listener remove the given ActionListener from the fire list.
	 */
	public void removeActionListener(ActionListener listener) {
		listeners.removeElement(listener);
	}

	/**
	 * @param event fires a event to the Actionlistener in the list.
	 */
	private void fireEvent(ActionEvent event) {
		for (int i = 0; i < listeners.size(); i++) {
			ActionListener listener = listeners.elementAt(i);
			listener.actionPerformed(event);
		}
		;
	}

}
