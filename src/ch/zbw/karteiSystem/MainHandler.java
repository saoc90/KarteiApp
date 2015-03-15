package ch.zbw.karteiSystem;

import java.util.ArrayList;


import ch.zbw.karteiSystem.Card;
import ch.zbw.karteiSystem.CardFile;
import ch.zbw.karteiSystem.ViewMainFrame;

/**
 * This class handles all the cardFiles and save part. It's the main logic part.
 * 
 * @author M.Riedener & J.Nagel
 */
public class MainHandler
{
	
	private ArrayList<CardFile> cardfiles;
	private String initLanguage;
	private int score;
	
	
	/**
	 * Creats an Instance of Mainhandler
	 * 
	 * @param cardfiles an arryList<CardFile>
	 * @param initLanguage start language of the Application
	 * @param score the state of score by initialisation.
	 */
	public MainHandler(ArrayList<CardFile> cardfiles, String initLanguage,
			int score)
	{
		super();
		this.cardfiles = cardfiles;
		this.initLanguage = initLanguage;
		this.score = score;
	}
	
	/**
	 * Returns the cardFile instance of the given index
	 * 
	 * @param cardFileID index of the CardFile which should return
	 * @return the cardFile with the given Index if cardFileID is out of Index it returns null
	 */
	public CardFile getCardFile(int cardFileID)
	{
		if(cardFileID>=cardfiles.size()||cardFileID<0){
			return null;
		}
		return this.cardfiles.get(cardFileID);
	}
	
	/**

	 * @return returns an ArrayList with All cardFiles
	 */
	public ArrayList<CardFile> getAllCardFiles()
	{
		return this.cardfiles;
	}
	
	/**
	 * This method saves all data to data.bin to the same directory as the .jar file.
	 * 
	 * @param main The ViewMainFrame main object.
	 * @return true if it worked
	 */
	public boolean saveCardFiles(ViewMainFrame main)
	{
		XmlWriter w = new XmlWriter();
		this.initLanguage = main.getStrings().getChoosenLanguageCode();
		w.save(this);
		return true;
	}
	
	/**
	 * assCardFile adds a new CardFile to the CardFile list.
	 * 
	 * @param file a new created CardFile
	 */
	public void addCardFile(CardFile file){
			this.cardfiles.add(file);			
	}
	
	/**
	 * For removing a CardFile from cardFiles.
	 * 
	 * @param cardFile the cardFile which should be removed
	 * @return true if it worked.
	 */
	public boolean removeCardFile(CardFile cardFile){
			return this.cardfiles.remove(cardFile);
	}
	
	/**
	 * This method calculates how many words are tipped in correct in percent.
	 * 
	 * @return an integer between 0 and 100 
	 */
	public int getPercentOfRights(){
		int wrongAnswers = 0;
		int rightAnswers = 0;
		for(CardFile cardFile:cardfiles){
			for(Card card:cardFile.getAllCards()){
				wrongAnswers += card.getWrongAnswers();
				rightAnswers += card.getRightAnswers();
			}
		}
		if((rightAnswers+wrongAnswers==0)){
			return 0;
		}
		return (100*rightAnswers)/(rightAnswers+wrongAnswers);
	}
	
	/**
	 * Searches the three (firs the which found) words which are most often wrong answered.
	 * 
	 * @return an ArrayList<Card> with three cards inside.
	 */
	public ArrayList<Card> getMostWrongWords()
	{
		ArrayList<Card> list = new ArrayList<>();
		for(CardFile cardFile:cardfiles){
			for(Card card:cardFile.getAllCards()){
				list.add(card);
			}
		}
		int change = 1;
		while(change!=0){
			change = 0;
			for(int i=0;i<list.size();i++){
				if(i+1!=list.size()){
					if(list.get(i).getWrongAnswers()<list.get(i+1).getWrongAnswers()){
						Card tmp = list.remove(i);
						list.add(i+1, tmp);
						change++;
					}
				}
			}
		}
		ArrayList<Card> mostWrongWords = new ArrayList<>();
		for(int i=0;i<3;i++){
			if(list.size()-i>=0){
			mostWrongWords.add(list.get(i));
			} else{
				return mostWrongWords;
			}
		}
		return mostWrongWords;
	}
	
	/**
	 * @return returns the score of the player.
	 */
	public int getScore(){
	return this.score;
	}
	
	/**
	 * increase the score 
	 */
	public void increaseScore(){
		this.score++;
	}
	
	/**
	 * @return  the last used languageCode
	 */
	public String getInitLanguage()
	{
	
		return this.initLanguage;
	}
	
	/**
	 * Sets the initLanguage
	 * 
	 * @param languageCode langueage code as String. Find all the codes on Strings. (f.e Strings.ENGLISH)
	 */
	public void setInitLanguage(String languageCode)
	{
		this.initLanguage = languageCode;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	/**
	 * set anything except the language back to manufacture settings.
	 * 
	 * @return true when it worked.
	 */
	public boolean resetApplication(){
		this.score=0;
		cardfiles = new ArrayList<>();
		return true;
	}
	
}
