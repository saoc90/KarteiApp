package ch.zbw.karteiSystem;


/*
 * @author Martin Thomann
 * @version 1.0
 */


import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

 
public class ViewCSVtoTable extends AbstractTableModel {

	private static ViewMainFrame viewMainframe;
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
	
	
    
	
	
}