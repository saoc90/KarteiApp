package ch.zbw.karteiSystem;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Jwo Nagel
 * This class is for handling all the shown Strings in the application.
 *
 */
public class Strings extends CsvReader {
	
	private ArrayList<ArrayList<String>> list; //for saving all the String ojects.
	public static final String ENGLISH="en";
	public static final String GERMAN="de";
	public static final String FRENCH="fr";
	public static final String ITALIAN="it";
	public static final String RUSSIAN="ru";
	
	public Strings() {
		super();
		list = new ArrayList<>();
		generateTokens(readFile("Strings.csv"));
	}
	
	
	/**
	 * @param languageCode language code for chosen language. The  
	 * @param id the word in the first column of the csv File.
	 * @return the chosen String. If the value of the parameters incorrect, it will return unknown.
	 */
	public String getString(String languageCode,String id){
		int i=0;
		switch (languageCode) {
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
	public void generateTokens(ArrayList<String> line){
		
		for(int i=0;i<line.size();i++){
			ArrayList<String> temp = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(line.get(i), ";"); // semicolon is the delimiter in a csv file.
			while(st.hasMoreTokens()){
				temp.add(st.nextToken());
			}
			list.add(temp);
		}
	}
}
