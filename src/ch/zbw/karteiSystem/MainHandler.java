package ch.zbw.karteiSystem;

import java.util.ArrayList;


import ch.zbw.karteiSystem.Card;
import ch.zbw.karteiSystem.CardFile;
import ch.zbw.karteiSystem.ViewMainFrame;

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
	
	public CardFile getCardFile(int _CardFileID)
	{
		return this.cardfiles.get(_CardFileID);
	}
	
	public ArrayList<CardFile> getAllCardFiles()
	{
		return this.cardfiles;
	}
	
	public boolean saveCardFiles(ViewMainFrame main)
	{
		XmlWriter w = new XmlWriter();
		this.initLanguage = main.getStrings().getChoosenLanguageCode();
		w.save(this);
		return true;
	}
	
	public void addCardFile(CardFile file)
	{
		/** add a CardFile to Collection  */
		try
		{
			this.cardfiles.add(file);			
		}
		catch(Exception e)
		{
			System.out.println("Cannot add CardFile" + file.getCardFileId());			
		}
	}
	
	public void removeCardFile(CardFile ID)
	{
		try
		{
		   /** remove CardFile from CardFile ArrayList */
			this.cardfiles.remove(ID);
		}
		catch(Exception e)
		{
			System.out.println("Cannot remove CardFile" + ID.getCardFileId());
		}
	}
	
	public int getPercentOfRights()
	{
		// Card.getRightAnswers / Card.getWrongAnswers
		// total = right + wrong => 100 %
		// PercentOfRight pro Karte => 100/total*right 
		
		return 80;
	}
	
	public ArrayList<Card> getMostWrongWords()
	{
		// 	card.getWrongAnswer > nextCard.getWrongAnswer
		// getCardID

		return null;
	}
	
	public int getScore()
	{
		return this.score;
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
