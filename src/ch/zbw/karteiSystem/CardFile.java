package ch.zbw.karteiSystem;

import java.util.ArrayList;
import java.util.Random;

import ch.zbw.karteiSystem.Card;

/**
 *  This Class handels a Card File, icluding the languages and titel. 
 * 
 * @author M.Riedener & J.Nagel
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
	 * Creats a new Cardfile.
	 * 
	 * @param wordList ArrayList of Card which should be inside of this Cardfile.
	 * @param titel Title of this cardFile
	 * @param language1 Language 1 must be equal to the language of the word 1 of the Cards.
	 * @param language2 Language 2 must be equal to the language of the word 2 of the Cards.
	 * @param id of CardFile
	 * @param languageSwitched when the Languege is switched.
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
	
	/**
	 * @param titel
	 */
	public void setTitle(String titel)
	{
		this.titel = titel;
		
	}
	
	/**
	 * @return titel of cardfile
	 */
	public String getTitle()
	{
		return this.titel;
	}
	
	/**
	 * @return id of CardFile
	 */
	public int getCardFileId()
	{
		return this.id;
	}
	
	/**
	 * @return language1 of cardfile
	 */
	public String getLanguage1()
	{
		return this.language1;
	}

	/**
	 * @return language2 of Cardfile
	 */
	public String getLanguage2()
	{
		return this.language2;
	}

	/**
	 * @return the progress in percent of the whole cardfile.
	 */
	public int getProgress()
	{
		if(wordList==null)
			return 0;
		int progress = 0;
		for(Card card:wordList){
			if(card.getBoxNr()<CardFile.MAXBOXES+2){
				progress += (card.getBoxNr()-1);
			}
		}
		if(wordList.size()==0){
			return 0;
		}
		progress = (100*progress)/(CardFile.MAXBOXES*wordList.size());
		return progress;
	}
	
	/**
	 * @return the number of Cards in the Cardfile.
	 */
	public int getNumberOfCards()
	{
		if(wordList==null)
			return 0;
		return wordList.size();
	}
	
	/**
	 * @return true when the language is switched, else false.
	 */
	public boolean isLanguageSwitched()
	{
		return this.languageSwitched;
	}
	
	/**
	 * Changes all the words in this Cardfile including the language parameter.
	 * So you can change the Language of a Cardfile.
	 */
	public void setLanguageSwitched()
	{
		String lang = this.language1;
		this.language1 = this.language2;
		this.language2 = lang;

		this.languageSwitched = !this.languageSwitched;
		
		for(Card card:wordList){
			String w1 = card.getWord1();
			String w2 = card.getWord2();
			card.setWord1(w2);
			card.setWord2(w1);
		}
	}
	
	/**
	 * returns a card from a cardfile. It prefers cards with more wrong answers.
	 * 
	 * @param boxNr number from where the card should be.
	 * @return a random calculated card from the boxNr given. If there isn't anymore a card it returns null.
	 */
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
	
	/**
	 * @return all cards as ArrayList.
	 */
	public ArrayList<Card> getAllCards()
	{
		return this.wordList;
	}
	
	/**
	 * returns the number of cards in a boxnr.
	 * @param BoxNr 
	 * @return the number of cards in the given bornumber.
	 */
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
	
	/**
	 * resets all Cards to default values.
	 */
	public void resetCounters()
	{
		for(Card card:wordList){
			card.reset();
		}
	}
	
	/**
	 * Adds a new Card to the cardfile.
	 * @param newCard the card which shoud be added to the cardFile.
	 * @return true when the card is added.
	 */
	public boolean addCard(Card newCard)
	{
		if(wordList==null)
			wordList = new ArrayList<Card>();
		return this.wordList.add(newCard);
	}
	
	/**
	 * @param language1
	 */
	public void setLanguage1(String language)
	{
		this.language1 = language;
	}
	/**
	 * @param language2
	 */
	public void setLanguage2(String language)
	{
		this.language2 = language;
	}
}
