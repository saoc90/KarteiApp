package ch.zbw.karteiSystem;


/*
 * @author Martin Thomann
 * @version 1.0
 */


import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.*;

 
public class ViewCSVtoTable extends AbstractTableModel {

	private static ViewMainFrame viewMainFrame;
	private ArrayList<ArrayList<String>> wordList;
	private String[] header;
	
	
	public ViewCSVtoTable(){
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
    public JTable readArray(){
    	JTable tempTable=new JTable();
    	ImportCSV impCSV=new ImportCSV();
		ArrayList<ArrayList<String>> tempList=null;
		try {
			tempList=impCSV.importList(viewMainFrame);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tempTable.setModel(new DefaultTableModel(
				new Object[][]{
						{"asdf", "fdsa"}
				},
				new String[]{
						"Test", "2"
				}));
		
//		for(int i=0; i<tempList.get(0).size(); i++){
//			String tempWord=tempList.get(0).get(i+1);
//			int r=1;
//			int c=i;
//			tempTable.setValueAt(tempWord, r, c);
//		}
		
		
		return tempTable;
		
    }
	
	
}