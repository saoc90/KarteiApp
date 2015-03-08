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
			
		}
	}
	
	public int getPercentOfRights()
	{
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
