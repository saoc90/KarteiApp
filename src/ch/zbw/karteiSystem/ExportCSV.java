package ch.zbw.karteiSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ExportCSV {
	
	/**
	 * this methode opens a Filechooser where you can select and export a word list.
	 * @param list A two dimensional ArrayList filled with Strings
	 * @return true if it works.
	 * @throws IOException if an Error happens during writing the File.
	 */
	public boolean exportList(ArrayList<ArrayList<String>> list, ViewMainFrame main) throws IOException {
		ArrayList<String> textList = genarateText(list);
		String path = chooser(main);
		writeFile(path, textList);
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
			text = text+tmp.get(1);
			textList.add(text);
		}
		return textList;
	}
	
	private String chooser(ViewMainFrame main){
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", 
	            "csv");
		chooser.setFileFilter(filter);
		File f = new File(main.getStrings().getString("unknownFilename"));
		chooser.setSelectedFile(f);
		
		int value = chooser.showSaveDialog(main);
		if(value==JFileChooser.APPROVE_OPTION){
			String path = chooser.getSelectedFile().getPath();
			if(path.endsWith(".csv")){
				return path;
			} else {
				return path +".csv";
			}
		}
		return null;
		
	}
	
	private void writeFile(String path, ArrayList<String> list) throws IOException {
		PrintWriter pWriter = null; 
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter(path))); 
            for (int i = 0; i < list.size(); i++) {
            	pWriter.println(list.get(i));
            } 
     pWriter.close();       
	}
}
