package ch.zbw.karteiSystem;

public class Card
{
	
	private String word1;
	private String word2;
	private int boxNr;
	private int wrongAnswer;
	private int rightAnswer;
	/**
	 * @param word1
	 * @param word2
	 * @param boxNr
	 * @param wrongAnswer
	 * @param rightAnswer
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
	public Card(String word1, String word2)
	{
		super(); //für import
	}

	
	public String getWord1()
	{
		
		return "";
	}
	public String getWord2()
	{
		return "";
	}

	public int getBoxNr()
	{
		// 	returnsBoxNr:int
		return 0;
	}
	
	public void setBoxNr (int _BoxNr)
	{
		this.boxNr = _BoxNr;
	}

	public void wrongAnswer()
	{
		this.wrongAnswer++;
		// 	counts +1 to wrong Answer
		// puts the word to the first box
		
	}
	
	public void rightAnswer()
	{
		this.rightAnswer++;
		// 	put the word to the next box
		// counts +1 to the right Answer

	}
	
	public int getWrongAnswers()
	{
		return this.wrongAnswer;
	}
	public int getRightAnswers()
	{
		return this.rightAnswer;
	}
	
	public void reset()
	{
		// 	set all counters back to zero.
	}
	
	public void setWord1(String word)
	{
		this.word1 = word;
	}
	public void setWord2(String word)
	{
		this.word2 = word;
	}
	public void setRightAnswer(int number)
	{
		//
	}
	public void setWrongAnswer(int number)
	{

	}
}
