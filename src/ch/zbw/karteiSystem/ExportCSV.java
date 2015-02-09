package ch.zbw.karteiSystem;

import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ExportCSV {
	
	/**
	 * this methode opens a Filechooser where you can select and export a word list.
	 * @param list A two dimensional ArrayList filled with Strings
	 * @return true if it works.
	 */
	public boolean exportList(ArrayList<ArrayList<String>> list, MainFrame main) {
		ArrayList<String> textList = genarateText(list);
		System.out.println(chooser(main));
		return true;
	}

	/**
	 * @param list A two dimensional ArrayList filled with Strings
	 * @return an ArrayList filled with the given String delemited by a semicolon
	 */
	
	private ArrayList<String> genarateText(ArrayList<ArrayList<String>> list){
		ArrayList<String> textList = new ArrayList<>();
		for (ArrayList<String> tmp : list) {
			String text = tmp.get(0)+";";//semicolon is the delemiter
			text = tmp.get(1);
			textList.add(text);
		}
		return textList;
	}
	
	private String chooser(MainFrame main){
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", 
	            "csv");
		chooser.setFileFilter(filter);
		
		
		int value = chooser.showSaveDialog(main);
		if(value==JFileChooser.APPROVE_OPTION){
			return chooser.getSelectedFile().getPath();
		}
		return null;
		
	}
}
