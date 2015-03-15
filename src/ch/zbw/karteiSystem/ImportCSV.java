package ch.zbw.karteiSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ImportCSV{
	
	public ImportCSV() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return returns a 2 Dimensional ArrayList filled with Strings. The first Index are the words, the second are the two different languages.
	 * @throws FileNotFoundException 
	 * @throws Exception If the Tokenizer fails, it will throw a Exception with Message TokenizerException.
	 */
	public ArrayList<ArrayList<String>> importList(ViewMainFrame main) throws Exception{
		String path = choose(main);
		if(path==null){
			return null;
		}
		return (generateToken(readFile(path)));
		}
	
	/**
	 * Read the csv File with the given url and returns it as an ArrayListof Strings.
	 * Each line of the file is a String.
	 * @param url place where the file is saved.
	 * @return ArrayList with Strings.
	 */
	public ArrayList<String> readFile(String url) throws FileNotFoundException{
		ArrayList<String> temp = new ArrayList<>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(url));
			String line = "";
			do {
				line = reader.readLine();
				// reads a line
				if (line == null || (line.equals(""))) {
				} else {// if line not null or empty
					temp.add(line);
				}
			} while (line != null);

			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	/**
	 * @return The filepath of the choosen file.
	 */
	private String choose(ViewMainFrame main){
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", 
	            "csv");
		chooser.setFileFilter(filter);
		int value =chooser.showOpenDialog(main);	
		
		if(value==JFileChooser.APPROVE_OPTION){
		
		String path = chooser.getSelectedFile().getPath();
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


