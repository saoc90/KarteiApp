package ch.zbw.karteiSystem;

import java.util.ArrayList;

import ch.zbw.karteiSystem.ViewCardFile;
import ch.zbw.karteiSystem.ViewMainFrame;

/**
 * @author riedener
 *
 */
public class MainHandler
{
	
	private ArrayList<ViewCardFile> cardfiles;
	private String initLanguage;
	private int score;
	
	/**
	 * @param cardfiles
	 * @param initLanguage
	 * @param score
	 */
	public MainHandler(ArrayList<ViewCardFile> cardfiles, String initLanguage,
			int score)
	{
		super();
		this.cardfiles = cardfiles;
		this.initLanguage = initLanguage;
		this.score = score;
	}
	
	public ViewCardFile getCardFile(String _CardFileID)
	{
		
		return null;
	}
	
	public ArrayList<ViewCardFile> getAllCardFiles()
	{
		return this.cardfiles;
	}
	
	public boolean saveCardFiles(ViewMainFrame main)
	{
		// 	speichert alle Daten ins XML
		// 	Holt aus mainfraim languageCode
		// return true falls erfolgreich
		return true;
	}
	
	public void addCardFile(ViewCardFile file)
	{
		// 	adds a CardFile to Collection
 
	}
	
	public void removeCardFile(ViewCardFile ID)
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
