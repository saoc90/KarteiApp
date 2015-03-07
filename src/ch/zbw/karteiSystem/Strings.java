package ch.zbw.karteiSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;



/**
 * @author Jwo Nagel
 * This class is for handling all the shown Strings in the application.
 *
 */
public class Strings{
	
	
	private ArrayList<ArrayList<String>> list; //for saving all the String ojects.
	public static final String ENGLISH="en";
	public static final String GERMAN="de";
	public static final String FRENCH="fr";
	public static final String ITALIAN="it";
	public static final String RUSSIAN="ru";
	
	private String choosenLanguageCode;
	
	private ArrayList<JTextField> JTextfieldList;
	private ArrayList<ViewBigButton> bigButtonList;
	private ArrayList<JLabel> JLabelList;
	private ArrayList<JButton> JButtonList;
	
	
	public Strings() throws FileNotFoundException {
		JTextfieldList = new ArrayList<>();
		bigButtonList = new ArrayList<>();
		JLabelList = new ArrayList<>();
		JButtonList= new ArrayList<>();
		list = new ArrayList<>();
		generateTokens(readFile("Strings.csv"));
	}
	
	/**
	 * Read the csv File with the given url and returns it as an ArrayListof Strings.
	 * Each line of the file is a String.
	 * @param url place where the file is saved.
	 * @return ArrayList with Strings.
	 */
	public ArrayList<String> readFile(String url) throws FileNotFoundException{
		ArrayList<String> temp = new ArrayList<>();
		try {
			InputStream is = getClass().getResourceAsStream(url);
			InputStreamReader fr = new InputStreamReader(is);
		    BufferedReader reader = new BufferedReader(fr);
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
	 * @param languageCode language code for chosen language. 
	 * @param id the word in the first column of the csv File.
	 * @return the chosen String. If the value of the parameters incorrect, it will return unknown.
	 */
	public String getString(String id){
		int i=0;
		switch (choosenLanguageCode) {
		case ENGLISH: i=1; break;
		case GERMAN: i=2; break;
		case FRENCH: i=3; break;
		case ITALIAN: i=4; break;
		case RUSSIAN: i=1; break;	
		default:
			return "unknown";
		}
		for(int c=0;c<list.size();c++){
			if(id.equals(list.get(c).get(0))){
				return list.get(c).get(i);
				
			}
		}
		return "unknown";
	}
	
	/**
	 * 
	 * 
	 * @param List of Strings whitch are delemited by semicolon.
	 */
	private void generateTokens(ArrayList<String> line){
		
		for(int i=0;i<line.size();i++){
			ArrayList<String> temp = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(line.get(i), ";"); // semicolon is the delimiter in a csv file.
			while(st.hasMoreTokens()){
				temp.add(st.nextToken());
			}
			list.add(temp);
		}
	}
	
	public boolean add(Object obj){
		if(obj instanceof JTextField){
			return JTextfieldList.add((JTextField)(obj));
		} else if(obj instanceof ViewBigButton){
			return bigButtonList.add((ViewBigButton)(obj));
		} else if(obj instanceof JLabel){
			return JLabelList.add((JLabel)(obj));
		} else if(obj instanceof JButton){
			return JButtonList.add((JButton)(obj));
		}
		return false;
	}
	
	public void changeLanguage(String languageCode){
		this.choosenLanguageCode = languageCode;
		for(JTextField tmp: JTextfieldList){
		 String text = getString(tmp.getName());
		 tmp.setText(text);
	 }
	 for(JLabel tmp: JLabelList){
		 if(tmp.getName()!=null){
		 String text = getString(tmp.getName());
		 tmp.setText(text);
		 }
	 }
	 for(ViewBigButton tmp:bigButtonList){
		 String text = getString(tmp.getName());
		 tmp.setText(text);

	 }
	 for(JButton tmp:JButtonList){
		 if(tmp.getName()!=null){
		 String text = getString(tmp.getName());
		 tmp.setText(text);
		 }
	 }
	 }


	/**
	 * @return the choosenLanguageCode
	 */
	public String getChoosenLanguageCode() {
		return choosenLanguageCode;
	}


	/**
	 * @param choosenLanguageCode the choosenLanguageCode to set
	 */
	public void setChoosenLanguageCode(String choosenLanguageCode) {
		this.choosenLanguageCode = choosenLanguageCode;
	}
	
	
}
