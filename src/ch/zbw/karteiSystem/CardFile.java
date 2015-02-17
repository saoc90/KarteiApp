/**
 * 
 */
package ch.zbw.karteiSystem;

import java.util.ArrayList;

/**
 * @author riedener
 *
 */
public class CardFile
{
	private ArrayList<Card> wordList;
	private String titel;
	private String language1;
	private String language2;
	private int id;
	private boolean languageSwitched;
	/**
	 * @param wordList
	 * @param titel
	 * @param language1
	 * @param language2
	 * @param id
	 * @param languageSwitched
	 */
	public CardFile(ArrayList<Card> wordList, String titel, String language1,
			String language2, int id, boolean languageSwitched)
	{
		super();
		this.wordList = wordList;
		this.titel = titel;
		this.language1 = language1;
		this.language2 = language2;
		this.id = id;
		this.languageSwitched = languageSwitched;
	}
	
	public void setTitle(String titel)
	{
		this.titel = titel;
	}
	
	public String getTitle()
	{
		return this.titel;
	}
	
	public int getCardFileId()
	{
		return this.id;
	}
	
	public String getLanguage1()
	{
		return this.language1;
	}

	public String getLanguage2()
	{
		return this.language2;
	}

	public int getProgress()
	{
		// return Progress
		return 80;
	}
	
	public int getNumberOfCards()
	{
		
		// return number of all cards
		return 500;
	}
	
	public boolean isLanguageSwitched()
	{
		if(this.languageSwitched)
			return true;
		else
			return false;
	}
	
	public void setLanguageSwitched()
	{
		String lang = this.language1;

		this.languageSwitched = !this.languageSwitched;

		this.language1 = this.language2;
		this.language2 = lang;
	}
	
	public Card getCard(int boxNr)
	{
		return this.wordList.get(boxNr);
	}
	
	public ArrayList<Card> getAllCards()
	{
		return this.wordList;
	}
	
	public int getNrOfCardsOfBox(int BoxNr)
	{
		int cardZaehler = 0;
		for(int i = 0; i < wordList.size(); i++)
		{
			if(wordList.get(i).getBoxNr() == BoxNr)
				cardZaehler++;
		}
		
		return cardZaehler;
	}
	
	public void resetCounters()
	{
		// reset all counter to zero
	}
	
	public boolean addCard(Card newCard)
	{
		this.wordList.add(newCard);
		
		return true;
	}
	
	public void setLanguage1(String language)
	{
		this.language1 = language;
	}
	public void setLanguage2(String language)
	{
		this.language2 = language;
	}
	
	
}
