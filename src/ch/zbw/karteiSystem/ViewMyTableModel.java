package ch.zbw.karteiSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


/**
 * This class is the connection between the JTable and the data, which should be shown in the table.
 * It implements the Class TableModel.
 * 
 * 
 * @author Martin Thomann
 * 
 */

public class ViewMyTableModel implements TableModel {

	private CardFile cardFile;
	private Strings strings;
	private ArrayList<Card> wordListCard;
	private String headerLanguage1 = "Sprache 1"; // table header 1
	private String headerLanguage2 = "Sprache 2"; // table header 2
	private String language1="Sprache 1";
	private String language2="Sprache 2";
	private static ViewMainFrame viewMainFrame;
	private ViewEditCardFilePanel editCardFilePanel;

	@SuppressWarnings("rawtypes")
	private Vector wordListJTable = new Vector();
	@SuppressWarnings("rawtypes")
	private Vector listener = new Vector();

	
	/**
	 * Constructor reads the CardFile if it isn't null,
	 * else it creates a new table.
	 * 
	 * @param cardFile
	 * @param editCardFilePanel
	 * @param viewMainFrame
	 */
	public ViewMyTableModel(CardFile cardFile,
			ViewEditCardFilePanel editCardFilePanel, ViewMainFrame viewMainFrame) {
		this.viewMainFrame = viewMainFrame;
		strings = viewMainFrame.getStrings();
		headerLanguage1 = strings.getString("language") + " 1";
		strings.add(headerLanguage1);
		headerLanguage2 = strings.getString("language") + " 2";
		strings.add(headerLanguage2);
		this.cardFile = cardFile;
		this.editCardFilePanel = editCardFilePanel;
		if (cardFile != null) {
			readCardFile();
		} else {
			createNewTable();
		}
	}

	/**
	 * Adds a row to the table with to empty fields.
	 */
	@SuppressWarnings("unchecked")
	public void addRow() {
		wordListJTable.add(new ViewEditCardFileWords(null, null));
	}

	/**
	 * Reads the CardFiles and saves the data to the data fields.
	 */
	@SuppressWarnings("unchecked")
	public void readCardFile() {
		language1 = cardFile.getLanguage1();
		language2 = cardFile.getLanguage2();
		wordListCard = cardFile.getAllCards();

		wordListJTable.clear();

		/**
		 * Reads the CardFiles, puts the Words in a Object of
		 * ViewEditCardFileWords and add the Object to the wordListJTable.
		 */
		int c = 0;
		while (c < wordListCard.size()) {
			String tempWord1 = wordListCard.get(c).getWord1();
			String tempWord2 = wordListCard.get(c).getWord2();
			ViewEditCardFileWords words = new ViewEditCardFileWords(tempWord1,
					tempWord2);
			wordListJTable.add(words);
			c++;
		}

		// Creates a TableModelEvent and sends the changed data to the listener.
		TableModelEvent e = new TableModelEvent(this);
		for (int i = 0, n = listener.size(); i < n; i++) {
			((TableModelListener) listener.get(i)).tableChanged(e);
		}
	}

	/**
	 * Creates a new table with 20 rows.
	 */
	@SuppressWarnings("unchecked")
	public void createNewTable() {

		wordListCard = new ArrayList<Card>();
		wordListJTable.clear();
		for (int i = 0; i < 20; i++) {
			String tempWord1 = "";
			String tempWord2 = "";
			ViewEditCardFileWords words = new ViewEditCardFileWords(tempWord1,
					tempWord2);
			wordListJTable.add(words);
		}

		// Creates a TableModelEvent and sends the changed data to the listener.
		TableModelEvent e = new TableModelEvent(this);
		for (int i = 0, n = listener.size(); i < n; i++) {
			((TableModelListener) listener.get(i)).tableChanged(e);
		}
	}

	/**
	 * Updates the CardFile with changed data and returns a CardFile.
	 * 
	 * @return the changed CardFile with the new words.
	 */
	@SuppressWarnings("unchecked")
	public CardFile updatedCardFile() {
		deleteNullRows();
		if(wordListJTable.isEmpty()){
			wordListJTable.add(new ViewEditCardFileWords("",""));
		}
		if (cardFile == null)
			cardFile = new CardFile(null, null, null, null, 0, false);
		cardFile.setTitle(editCardFilePanel.getTitle());
		cardFile.setLanguage1(language1);
		cardFile.setLanguage2(language2);
		if (wordListCard != null)
			wordListCard.clear();
		Card tempCard;
		for (int i = 0; i < wordListJTable.size(); i++) {
			ViewEditCardFileWords tempWords = (ViewEditCardFileWords) wordListJTable
					.get(i);
			String tempWord1 = tempWords.getWord1();
			String tempWord2 = tempWords.getWord2();
			tempCard = new Card(tempWord1, tempWord2);
			cardFile.addCard(tempCard);
		}

		return cardFile;
	}

	/**
	 * Deletes the rows, when both cells in the same row are empty.
	 */
	public void deleteNullRows() {
		@SuppressWarnings("rawtypes")
		Vector tempList = wordListJTable;
		@SuppressWarnings("unchecked")
		Iterator<ViewEditCardFileWords> it = tempList.iterator();
		while (it.hasNext()) {
			ViewEditCardFileWords words = it.next();
			if (words.getWord1().equals("") && words.getWord2().equals("")) {
				it.remove();
			}
		}
		wordListJTable = tempList;
	}

	/**
	 * Imports a table from a CSV file.
	 * 
	 * @param viewMainFrame
	 */
	@SuppressWarnings("unchecked")
	public void impTable(ViewMainFrame viewMainFrame) {
		ImportCSV imp = new ImportCSV();
		try {
			ArrayList<ArrayList<String>> tempWordListAL = imp.importList(viewMainFrame);

			if(tempWordListAL!=null){
				wordListJTable.clear();
				for (int i = 0; i < tempWordListAL.size(); i++) {
					ArrayList<String> tempWordList = tempWordListAL.get(i);
					String tempWord1 = tempWordList.get(0);
					String tempWord2 = tempWordList.get(1);
					ViewEditCardFileWords tempWords = new ViewEditCardFileWords(
							tempWord1, tempWord2);
					wordListJTable.add(tempWords);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creates a TableModelEvent and sends the changed data to the listener.
		TableModelEvent e = new TableModelEvent(this);
		for (int i = 0, n = listener.size(); i < n; i++) {
			((TableModelListener) listener.get(i)).tableChanged(e);
		}
	}

	/**
	 * Exports the table to a CSV file.
	 * 
	 * @param viewMainFrame
	 */
	public void expTable(ViewMainFrame viewMainFrame) {
		ExportCSV exp = new ExportCSV();
		ArrayList<ArrayList<String>> tempExpList = new ArrayList<ArrayList<String>>();

		try {
			for (int i = 0; i < wordListJTable.size(); i++) {
				ViewEditCardFileWords tempWords = (ViewEditCardFileWords) wordListJTable
						.get(i);
				ArrayList<String> wordList = new ArrayList<String>();
				wordList.add(tempWords.getWord1());
				wordList.add(tempWords.getWord2());
				tempExpList.add(wordList);
			}

			exp.exportList(tempExpList, viewMainFrame);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Returns the number of rows in the table.
	 * 
	 * @return int
	 */
	@Override
	public int getRowCount() {
		return wordListJTable.size();
	}

	/**
	 * Returns the number of columns.
	 * 
	 * @return int
	 */
	@Override
	public int getColumnCount() {
		return 2;
	}

	/**
	 * Returns the column name.
	 * 
	 * @param columnIndex
	 * @return headerLanguage1 or headerLanguage2
	 */
	@Override
	public String getColumnName(int columnIndex) {

		switch (columnIndex) {
		case 0:
			return headerLanguage1;
		case 1:
			return headerLanguage2;
		default:
			return null;
		}
	}

	/**
	 * Gets the classtype of a column. All columns are Strings.
	 * 
	 * @param columnIndex
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	/**
	 * Sets the cell to editable. All cells are editable.
	 * 
	 * @return true
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	/**
	 * Gets a value form the table and and returns a Object of the word.
	 * 
	 * @param rowIndex, columnIndex
	 * @return Object of word1 or word2
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ViewEditCardFileWords words = (ViewEditCardFileWords) wordListJTable.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return words.getWord1();
		case 1:
			return words.getWord2();
		default:
			return null;
		}
	}

	/**
	 * Sets a value to the table.
	 * 
	 * @param aValue, rowIndex, columnIndex
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ViewEditCardFileWords tempWords = (ViewEditCardFileWords) wordListJTable.get(rowIndex);

		switch (columnIndex) {
		case 0:
			tempWords.setWord1((String) aValue);
			break;
		case 1:
			tempWords.setWord2((String) aValue);
			break;
		}

	}

	/**
	 * Adds a TableModelListener to the listener vector.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addTableModelListener(TableModelListener l) {
		listener.add(l);
	}

	/**
	 * Removes the TableModelListener form the listener vector.
	 */
	@Override
	public void removeTableModelListener(TableModelListener l) {
		listener.remove(l);

	}
	
	/**
	 * @return String of the language1
	 */
	public String getLanguage1() {
		return language1;
	}

	/**
	 * @param language1
	 */
	public void setLanguage1(String language1) {
		this.language1 = language1;
		getColumnName(0);
	}

	/**
	 * @return String of language2
	 */
	public String getLanguage2() {
		return language2;
	}

	/**
	 * @param language2
	 */
	public void setLanguage2(String language2) {
		this.language2 = language2;
		getColumnName(0);
	}

	/**
	 * @return headerLanguage1
	 */
	public String getHeaderLanguage1() {
		return headerLanguage1;
	}

	/**
	 * @param headerLanguage1
	 */
	public void setHeaderLanguage1(String headerLanguage1) {
		this.headerLanguage1 = headerLanguage1;
	}

	/**
	 * @return headerLanguage2
	 */
	public String getHeaderLanguage2() {
		return headerLanguage2;
	}

	/**
	 * @param headerLanguage2
	 */
	public void setHeaderLanguage2(String headerLanguage2) {
		this.headerLanguage2 = headerLanguage2;
	}

}