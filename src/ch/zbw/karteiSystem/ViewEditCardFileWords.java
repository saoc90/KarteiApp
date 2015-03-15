package ch.zbw.karteiSystem;

/**
 * 
 * @author Martin Thomann
 * 
 * An object of this class holds two words.
 * This object are managed in a vector in the table model.
 *
 */

public class ViewEditCardFileWords {

	private String word1;
	private String word2;
	
	/**
	 * constructor
	 * 
	 * @param word1
	 * @param word2
	 */
	public ViewEditCardFileWords(String word1, String word2){
		this.word1=word1;
		this.word2=word2;
		
	}

	/**
	 * 
	 * @return word1
	 */
	public String getWord1() {
		return word1;
	}
	

	/**
	 * @param word1
	 */
	public void setWord1(String word1) {
		this.word1 = word1;
	}
	

	/**
	 * @return word2
	 */
	public String getWord2() {
		return word2;
	}

	/**
	 * @param word2
	 */
	public void setWord2(String word2) {
		this.word2 = word2;
	}
	
	
}