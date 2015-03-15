package ch.zbw.karteiSystem;
/**
 * This class saves the words of a cardfile with all relevants parameters.
 * 
 * 
 * @author J.Nagel & M.Riedener.
 *
 */
public class Card
{
	
	private String word1;
	private String word2;
	private int boxNr;
	private int wrongAnswer;
	private int rightAnswer;

	
	/**
	 * Creats a new instance of a card including all parameters. 
	 * Take this constructor when all parameters are given.
	 * @param word1 word in language 1
	 * @param word2 word in language 2
	 * @param boxNr the boxnumber in which the card is.
	 * @param wrongAnswer number of wrong Answers in this card
	 * @param rightAnswer number of correct Answers in this card
	 */
	public Card(String word1, String word2, int boxNr, int wrongAnswer, int rightAnswer)
	{
		super();
		this.word1 = word1;
		this.word2 = word2;
		this.boxNr = boxNr;
		this.wrongAnswer = wrongAnswer;
		this.rightAnswer = rightAnswer;
	}
	/**
	 * Creats a new instance of a card just with two words as parameter. 
	 * Take this constructor when you haven't additional parameters.
	 * The parameters boxNumber, wrongAnswer and rightAnswer are fillt by default values.
	 * @param word1
	 * @param word2
	 */
	public Card(String word1, String word2)
	{
		super(); //for import
		this.boxNr = 1;
		this.word1 = word1;
		this.word2 = word2;
		this.wrongAnswer = 0;
		this.rightAnswer = 0;
	}

	/** 
	 * @return word1
	 */
	public String getWord1()
	{
		return this.word1;
	}
	/**
	 * @return word2
	 */
	public String getWord2()
	{
		return this.word2;
	}
	/**
	 * @return boxnumber of the card.
	 */
	public int getBoxNr()
	{
		return this.boxNr;
	}
	/**
	 * @param _BoxNr sets the word to the choosen boxnr.
	 */
	public void setBoxNr (int _BoxNr)
	{
		this.boxNr = _BoxNr;
	}
	/**
	 * throws the card to the first box and increase the value of wrongAnswer.
	 */
	public void wrongAnswer()
	{
		this.wrongAnswer++;
		boxNr = 1;
	}
	
	/**
	 * throws the card to the next box and increase the value of rightAnswer.
	 */
	public void rightAnswer()
	{
		this.rightAnswer++;
		boxNr++;
	}

	/**
	 * @return the value of wrongAnswers
	 */
	public int getWrongAnswers()
	{
		return this.wrongAnswer;
	}

	/**
	 * @return the value of rightAnswers.
	 */
	public int getRightAnswers()
	{
		return this.rightAnswer;
	}

	/**
	 * set all counters back to default.
	 */ 
	public void reset()
	{

		this.wrongAnswer = 0;
		this.rightAnswer = 0;
		this.boxNr = 1;
	}

	/**
	 * @param word 
	 */
	public void setWord1(String word)
	{
		this.word1 = word;
	}

	/**
	 * @param word
	 */
	public void setWord2(String word)
	{
		this.word2 = word;
	}

	/**
	 * @param number
	 */
	public void setRightAnswer(int number)
	{
		this.rightAnswer = number;
		//
	}

	/**
	 * @param number
	 */
	public void setWrongAnswer(int number)
	{
		this.wrongAnswer = number;
	}
}
