package ch.zbw.karteiSystem;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;


public class ImportCSV extends CsvReader{
	
	public ImportCSV() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return returns a 2 Dimensional ArrayList filled with Strings. The first Index are the words, the second are the two different languages.
	 */
	public ArrayList<ArrayList<String>> importList(){
		String path = choose();
		if(path==null){
			return null;
		}
		return (generateToken(readFile(path)));
		}
	
	
	/**
	 * @return The filepath of the choosen file.
	 */
	private String choose(){
		JFileChooser chooser = new JFileChooser();
		int wert =chooser.showOpenDialog(null);
				
		if(wert==JFileChooser.APPROVE_OPTION){
		
		String path = chooser.getSelectedFile().getPath();
		if(path.endsWith("csv")) 
			return path;
		}
		
		return null;
	}

	private ArrayList<ArrayList<String>> generateToken(ArrayList<String> list){
		ArrayList<ArrayList<String>> wordList = new ArrayList<>();
		for (String tmp : list) {
			ArrayList<String> tmpList = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(tmp, ";");
			tmpList.add(st.nextToken());
			tmpList.add(st.nextToken());
			wordList.add(tmpList);	
			}
		return wordList;
		}
	}


