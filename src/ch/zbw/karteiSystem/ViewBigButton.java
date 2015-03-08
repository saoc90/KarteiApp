/**
 * 
 */
package ch.zbw.karteiSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * @author samuelochsner
 *
 */
public class ViewBigButton extends JPanel implements MouseListener{
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private Vector<ActionListener> listeners = null;
	private boolean hit = false;	
	private int intx;
	private int inty;
	private ImageIcon icon;
	private Color color;
	private JLabel title1;
	
	
	
	public ViewBigButton (String name, String title ,ImageIcon imageIcon,int x, int y,Color color){
	super();
	this.title = title;
	listeners = new Vector<ActionListener>();
	addMouseListener(this);
	this.intx = x;
	this.inty = y;
	this.icon = imageIcon;
	this.color =color;
	paintComponent();
	setName(name);
	
	
	}


	public void paintComponent(){
		
	setPreferredSize(new Dimension(intx, inty));
    setBackground(color);
	setLayout(new BorderLayout());
	GridBagConstraints gc = new GridBagConstraints();
	setBorder(new EmptyBorder(0, 30, 0, 0));
	gc.gridx = 1;
	gc.gridheight = 1;
	gc.gridwidth = 10;
	gc.anchor = GridBagConstraints.WEST;
   
	gc.insets = new Insets(2,2,2,2);
	title1 = new JLabel(title, icon,SwingConstants.LEFT);
	
	title1.setFont(new Font("LucidaBright",Font.BOLD,35)); //Schriftgrösse setzen
	//title1.setLayout();
	title1.setForeground(Color.BLACK);
	this.add(title1, BorderLayout.WEST);
	setVisible(true);
	}

	
	
	
	
	public void setText(String text){
		
	title1.setText(text);
		
	}
	
	public void mousePressed(MouseEvent e){
	hit=true;
	repaint();
	fireEvent(new ActionEvent(this,0,title));
	
	}

	public void mouseReleased(MouseEvent e){
	hit=false;
	repaint();
	}

	public void mouseClicked(MouseEvent e){
	
	}

	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

	public void addActionListener(ActionListener listener){
	listeners.addElement(listener);
	}

	public void removeActionListener(ActionListener listener){
	listeners.removeElement(listener);
	}

	private void fireEvent(ActionEvent event){
	for (int i = 0;i<listeners.size() ;i++ ){
	ActionListener listener = listeners.elementAt(i);
	listener.actionPerformed(event);
	};
	}


}
