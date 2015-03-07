  /**
 * 
 */
package ch.zbw.karteiSystem;

import java.util.ArrayList;

/**
 * @author samuelochsner
 *
 */
public class HelpCardFile {

	
	
	private ArrayList<CardFile> cardFile;
	/**
	 * 
	 */
	public HelpCardFile() {

		
		cardFile = new ArrayList<CardFile>();
		
		fillCardFile();
		
	}

	
	
	
	private void fillCardFile(){
		
		
		Card tmpCard;
		ArrayList<Card> tmpCardList;
		CardFile tmpCardFile;
		
		for (int i =0; i<3;i++){
			
			tmpCardList = new ArrayList<Card>();
			for(int i1 = 0; i1<10; i1++){
				
				tmpCard = new Card("Testwort"+i1,"Testwort2"+i1,1,1,1);
				tmpCardList.add(tmpCard);
				
				
			}
			
			tmpCardFile = new CardFile(tmpCardList,"Titel"+i,"Language1"+i,"Language2"+i,i,false);
			cardFile.add(tmpCardFile);
		}
		
		
		
	}
	
	
	public ArrayList<CardFile> getCardFile(){
		
		return cardFile;
		
	}
}
