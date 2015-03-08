package ch.zbw.karteiSystem;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/*
 * Die Klasse ViewMyTableModel ist die Verbindung zwischen der JTable und den eigentlichen Daten.
 * Hier werden die Daten aufbereitet und in der JTable dargestellt.
 * 
 * @author Martin Thomann
 */


public class ViewMyTableModel implements TableModel {

	private CardFile cardFile;
	private ArrayList<Card> wordListCard;
	private String titel;
	private String language1 = "Sprache1";
	private String language2 = "Sprache2";
	private int id;
	private boolean languageSwitched;
	private static ViewMainFrame viewMainFrame;

	@SuppressWarnings("rawtypes")
	private Vector wordListJTable=new Vector();
	@SuppressWarnings("rawtypes")
	private Vector listener = new Vector();

	//Konstruktor - Diesem wird entweder ein CardFile oder null übergeben.
	//Wenn Null übergeben wird, wird eine neue Tabelle erzeugt, ansonsten die CardFile ausgelesen.
	public ViewMyTableModel(CardFile cardFile) {
		this.cardFile = cardFile;
		if (cardFile != null) {
			readCardFile();
		} else {
			createNewTable();
		}
	}

	//Das übergebene CardFile wird ausgelesen und in die Datenfelder gespeichert.
	@SuppressWarnings("unchecked")
	public void readCardFile() {
		titel = cardFile.getTitle();
		language1 = cardFile.getLanguage1();
		language2 = cardFile.getLanguage2();
		id = cardFile.getCardFileId();
		wordListCard = cardFile.getAllCards();
		
		wordListJTable.clear();
		int c = 0;
		while (c <= wordListCard.size()) {
			String tempWord1=wordListCard.get(c).getWord1();
			String tempWord2=wordListCard.get(c).getWord1();
			ViewEditCardFileWords words= new ViewEditCardFileWords(tempWord1, tempWord2);
			wordListJTable.add(words);
			c++;
		}
		
		TableModelEvent e = new TableModelEvent(this);

		// Nun das Event verschicken
		for (int i = 0, n = listener.size(); i < n; i++) {
			((TableModelListener) listener.get(i)).tableChanged(e);
		}
	}

	//Es wird eine neue Tabelle mit 20 Zeilen erstellt
	@SuppressWarnings("unchecked")
	public void createNewTable() {
		wordListJTable.clear();
		for(int i=0; i<=200; i++){
			String tempWord1="A"+i;
			String tempWord2="B"+i;
			ViewEditCardFileWords words= new ViewEditCardFileWords(tempWord1, tempWord2);
			wordListJTable.add(words);
		}

		TableModelEvent e = new TableModelEvent(this);

		// Nun das Event verschicken
		for (int i = 0, n = listener.size(); i < n; i++) {
			((TableModelListener) listener.get(i)).tableChanged(e);
		}
	}
	
	//Das gespeicherte CardFile wird mit den neuen veränderten Werte gespeichert.
	public CardFile updatedCardFile(){
		cardFile.setTitle(titel);
		cardFile.setLanguage1(language1);
		cardFile.setLanguage2(language2);
		wordListCard.clear();
		Card tempCard;
		for(int i=0; i<=wordListJTable.size(); i++){
			ViewEditCardFileWords tempWords=(ViewEditCardFileWords) wordListJTable.get(i);
			String tempWord1 = tempWords.getWord1();
			String tempWord2 = tempWords.getWord2();
			tempCard=new Card(tempWord1, tempWord2);
			wordListCard.add(tempCard);
		}
		return cardFile;
	}
	
	//Eine CSV Wörter-Tabelle wird importiert. Diese wird in die wordListJTable gespeichert.
	@SuppressWarnings("unchecked")
	public void impTable(ViewMainFrame viewMainFrame){
		wordListJTable.clear();
		ImportCSV imp=new ImportCSV();
		try {
			ArrayList<ArrayList<String>> tempWordListAL=imp.importList(viewMainFrame);
			ArrayList<String> tempWordList1=tempWordListAL.get(0);
			ArrayList<String> tempWordList2=tempWordListAL.get(0);
			
			for(int i=0; i<=tempWordList1.size(); i++){
				String tempWord1 = tempWordList1.get(i);
				String tempWord2 = tempWordList2.get(i);
				ViewEditCardFileWords tempWords = new ViewEditCardFileWords(tempWord1, tempWord2);
				wordListJTable.add(tempWords);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TableModelEvent e = new TableModelEvent(this);

		// Nun das Event verschicken
		for (int i = 0, n = listener.size(); i < n; i++) {
			((TableModelListener) listener.get(i)).tableChanged(e);
		}
	}
	
	//Die wordListJTable wird als CSV exportiert.
//	public void expTable(ViewMainFrame viewMainFrame){
//		ExportCSV exp=new ExportCSV();
//		try {
//			exp.exportList(wordListJTable, viewMainFrame);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	
	

	@Override
	public int getRowCount() {
		return wordListJTable.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {

		switch (columnIndex) {
		case 0:
			return language1;
		case 1:
			return language2;
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ViewEditCardFileWords words=(ViewEditCardFileWords) wordListJTable.get(rowIndex);
		switch(columnIndex){
		case 0: return words.getWord1();
		case 1: return words.getWord2();
		default: return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ViewEditCardFileWords tempWords = (ViewEditCardFileWords)wordListJTable.get( rowIndex );
		 
		switch( columnIndex ){
			case 0: 
				tempWords.setWord1( (String)aValue );
				break;
			case 1: 
				tempWords.setWord2( (String)aValue );
				break;
		}
	
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		listener.add(l);

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listener.remove(l);

	}

}