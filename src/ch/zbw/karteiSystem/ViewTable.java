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
import java.util.ArrayList;
 
public class ViewTable extends JPanel {
    
	
	private static final long serialVersionUID = 1L;
//	private boolean DEBUG = false;
//	private String language1;
//	private String language2;
	private static ViewMainFrame main;
	private String[] columnNames;
	private Object[][] data;
	private ArrayList<ArrayList<String>> wordList;

	
	//Konstruktor
    public ViewTable() throws Exception {
        super(new GridLayout(1,0));
        columnNames = new String[] {"Sprache A", "Sprache B"};   	
        data = new Object[][]{{"Wort 1A", "Wort 1B"}};
        createTable();  
    }
 
    
    //Tablle erstellen
    public void createTable(){
    	
    	JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
 
        //Scrollleiste erzeugen
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Scrollleiste hinzufügen
        add(scrollPane);
    }
    
    public void takeList(){
    	ImportCSV impCSV=new ImportCSV();
    	try {
			wordList=impCSV.importList(main);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	data = new Object[][]{{wordList.toArray()}};
    	columnNames = new String[]{"Deutsch", "Englisch"};
    	createTable();
    	
    }
    
    
  
    
//    //GUI zeichnen
//    private static void createAndShowGUI() throws Exception {
//        //Fenster erstellen
//        JFrame frame = new JFrame("Wortlisten");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 
//        //Inhalt erstellen
//        ViewTable newContentPane = new ViewTable();
//        newContentPane.setOpaque(true); 
//        frame.setContentPane(newContentPane);
// 
//        //Fenster anzeigen
//        frame.pack();
//        frame.setVisible(true);
//    }
//    
//
// 
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