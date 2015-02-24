package ch.zbw.karteiSystem;

import java.util.ArrayList;


public class ViewDatenLieferant {

	private ArrayList<ArrayList<String>> wordList;
	
	
	String[][] inhalt = { null };
	String[] titel = { null };

	public ViewDatenLieferant() {
		setDefaultTable();
	}

	public void setDefaultTable(){
		for(int i=0; i<200; i++){
			inhalt=new String[i][i];
		}
		getAnzahl(200);
	}
	
	
	

	public int getAnzahl(int anz) {
		return anz;
	}

	public String getSprache1(int zeile) {
		return inhalt[zeile][0];
	}

	public String getSprache2(int zeile) {
		return inhalt[zeile][1];
	}

	
	
	
	
	
//	public JTable readArray() {
//		JTable tempTable = new JTable();
//		ImportCSV impCSV = new ImportCSV();
//		ArrayList<ArrayList<String>> tempList = null;
//		try {
//			tempList = impCSV.importList(viewMainFrame);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		tempTable.setModel(new DefaultTableModel(new Object[][] { { "asdf",
//				"fdsa" } }, new String[] { "Test", "2" }));
//
//		 for(int i=0; i<tempList.get(0).size(); i++){
//		 String tempWord=tempList.get(0).get(i+1);
//		 int r=1;
//		 int c=i;
//		 tempTable.setValueAt(tempWord, r, c);
//		 }
//
//		return tempTable;
//
//	}

}
