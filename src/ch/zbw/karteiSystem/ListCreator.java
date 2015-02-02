package ch.zbw.karteiSystem;

import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public class ListCreator {

	private JList<ArrayList> list;
	private ArrayList<String> data;
	
	public ListCreator(){
		data=new ArrayList<String>();
		list=new JList((ListModel) data);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
	}
	
	
	
}
