package ch.zbw.karteiSystem;


/*
 * @author Martin Thomann
 * @version 1.0
 */


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
public class ViewTable extends JPanel {
    
	
	private static final long serialVersionUID = 1L;
//	private boolean DEBUG = false;
	private String language1;
	private String language2;
 
    public ViewTable() {
        super(new GridLayout(1,0));
 
        
        createTable();  
    }
 
    
    //Tablle erstellen
    public void createTable(){
    	String[] columnNames = {"Deutsch", "Englisch"};
    	 
        Object[][] data = {
        {"Hallo", "hello"},
        {"Haus", "house"},
        {"Tür", "door"}};
        
    	
    	
    	JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
 
        //Scrollleiste erzeugen
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Scrollleiste hinzufügen
        add(scrollPane);
    }
    
    
    
    //GUI zeichnen
    private static void createAndShowGUI() {
        //Fenster erstellen
        JFrame frame = new JFrame("Wortlisten");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Inhalt erstellen
        ViewTable newContentPane = new ViewTable();
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);
 
        //Fenster anzeigen
        frame.pack();
        frame.setVisible(true);
    }
 
//    public static void main(String[] args) {
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
}