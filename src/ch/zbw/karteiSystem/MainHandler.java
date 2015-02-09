package ch.zbw.karteiSystem;

import java.util.ArrayList;

import ch.zbw.karteiSystem.CardFile;
import ch.zbw.karteiSystem.MainFrame;

/**
 * @author riedener
 *
 */
public class MainHandler
{
	
	private ArrayList<CardFile> cardfiles;
	private String initLanguage;
	private int score;
	
	/**
	 * @param cardfiles
	 * @param initLanguage
	 * @param score
	 */
	public MainHandler(ArrayList<CardFile> cardfiles, String initLanguage,
			int score)
	{
		super();
		this.cardfiles = cardfiles;
		this.initLanguage = initLanguage;
		this.score = score;
	}
	
	public CardFile getCardFile(String _CardFileID)
	{
		
		return null;
	}
	
	public ArrayList<CardFile> getAllCardFiles()
	{
		return this.cardfiles;
	}
	
	public boolean saveCardFiles(MainFrame main)
	{
		// 	speichert alle Daten ins XML
		// 	Holt aus mainfraim languageCode
		// return true falls erfolgreich
		return true;
	}
	
	public void addCardFile(CardFile file)
	{
		// 	adds a CardFile to Collection
 
	}
	
	public void removeCardFile(CardFile ID)
	{
	   //	removesd
	}
	
	public int getPercentOfRights()
	{
		return 80;
	}
	
	public ArrayList<Card> getMostWrongWords()
	{
		// 	returns the most wrong answered words:ArrayList<Word>
		return null;
	}
	
	public int getScore()
	{
		return 55;
	}
	
	public String getInitLanguage()
	{
		// 	returns the last used languageCode:
		return this.initLanguage;
	}
	
	public void setInitLanguage(String languageCode)
	{
		this.initLanguage = languageCode;
	}
	
	public void setScore(int _score)
	{
		this.score = _score;
	}
	
}
