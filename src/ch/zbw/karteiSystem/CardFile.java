package ch.zbw.karteiSystem;

import java.util.ArrayList;
import java.util.Random;

import ch.zbw.karteiSystem.Card;

/**
 * @author M.Riedener
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
	private static final int MAXBOXES = 5; //number of boxes 
	
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
		if(wordList==null)
			return 0;
		int progress = 0;
		for(Card card:wordList){
			if(card.getBoxNr()<CardFile.MAXBOXES){
				progress += card.getBoxNr();
			}
		}
		if(wordList.size()==0){
			return 0;
		}
		progress = (100*progress)/(CardFile.MAXBOXES*wordList.size());
		return progress;
	}
	
	public int getNumberOfCards()
	{
		if(wordList==null)
			return 1;
		return wordList.size();
	}
	
	public boolean isLanguageSwitched()
	{
		return this.languageSwitched;
	}
	
	public void setLanguageSwitched()
	{
		String lang = this.language1;
		this.language1 = this.language2;
		this.language2 = lang;

		this.languageSwitched = !this.languageSwitched;
	}
	
	public Card getCard(int boxNr)
	{
		ArrayList<Card> tmp = new ArrayList<>();
		for(int i = 0;i<wordList.size();i++){ 
			if(wordList.get(i).getBoxNr()==boxNr){
				tmp.add(this.wordList.get(i)); // gets all words from this box.
			}
		}
		if(tmp.size()==0){
		return null;
		}
		int c = 1;
		while(c!=0){//sort the tmp list 
			c=0;
			for(int i=0;i<(tmp.size()-1);i++){ //-1 for if advice.
				if(tmp.get(i).getWrongAnswers()>tmp.get(i+1).getWrongAnswers()){
					tmp.add(i, tmp.remove(i+1));
					c++;
				}
			}
		}
		Random r = new Random();
		int cardnr = r.nextInt(tmp.size());
		int deltaWrong = r.nextInt(tmp.get(tmp.size()-1).getWrongAnswers()+1);
		if(deltaWrong>2&&cardnr<tmp.size()-2){
			cardnr +=2;
		}
		return tmp.get(cardnr);
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
		for(Card card:wordList){
			card.reset();
		}
	}
	
	public boolean addCard(Card newCard)
	{
		if(wordList==null)
			wordList = new ArrayList<Card>();
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
