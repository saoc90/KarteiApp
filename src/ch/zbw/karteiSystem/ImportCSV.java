package ch.zbw.karteiSystem;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;


public class ImportCSV extends CsvReader{
	
	public ImportCSV() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return returns a 2 Dimensional ArrayList filled with Strings. The first Index are the words, the second are the two different languages.
	 * @throws Exception If the Tokenizer fails, it will throw a Exception with Message TokenizerException.
	 */
	public ArrayList<ArrayList<String>> importList(Strings s,MainFrame main) throws Exception{
		String path = choose(s, main);
		if(path==null){
			return null;
		}
		return (generateToken(readFile(path)));
		}
	
	
	/**
	 * @return The filepath of the choosen file.
	 */
	private String choose(Strings s, MainFrame main){
		JFileChooser chooser = new JFileChooser();
	//	chooser.setDialogTitle(dialogTitle);
		int wert =chooser.showDialog(main, s.getString("openDialog"));		
		if(wert==JFileChooser.APPROVE_OPTION){
		
		String path = chooser.getSelectedFile().getPath();
		if(path.endsWith("csv")) 
			return path;
		}
		
		return null;
	}

	private ArrayList<ArrayList<String>> generateToken(ArrayList<String> list) throws Exception{
		ArrayList<ArrayList<String>> wordList = new ArrayList<>();
		for (String tmp : list) {
			boolean failed = false;
			ArrayList<String> tmpList = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(tmp, ";");
			if(st.hasMoreTokens()){
			tmpList.add(st.nextToken());
			} else {
				failed =! failed;
			}
			if(st.hasMoreElements()){
			tmpList.add(st.nextToken());
			} else{
				failed=!failed;
			}
			if(failed){
				throw new Exception("TokenizerException");
			}
			wordList.add(tmpList);	
			}
		return wordList;
		}
	}


