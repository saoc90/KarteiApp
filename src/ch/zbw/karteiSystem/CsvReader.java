/**
 * 
 */
package ch.zbw.karteiSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Jwo Nagel
 * 
 * 
 * It's read the Strings from a csv file. 
 * 
 *
 */
public class CsvReader {
	

	/**
	 * Read the csv File with the given url and returns it as an ArrayListof Strings.
	 * Each line of the file is a String.
	 * @param url place where the file is saved.
	 * @return ArrayList with Strings.
	 */
	public ArrayList<String> readFile(String url) {
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
		
	

	
}
