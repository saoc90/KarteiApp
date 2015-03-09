package ch.zbw.karteiSystem;

public class Card
{
	
	private String word1;
	private String word2;
	private String title;
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
		super(); //f�r import
		this.boxNr = 1;
		this.word1 = word1;
		this.word2 = word2;
		this.wrongAnswer = 0;
		this.wrongAnswer = 0;
	}

	public String getWord1()
	{
		return this.word1;
	}
	public String getWord2()
	{
		return this.word2;
	}
	public int getBoxNr()
	{
		return this.boxNr;
	}
	public void setBoxNr (int _BoxNr)
	{
		this.boxNr = _BoxNr;
	}
	public void wrongAnswer()
	{
		this.wrongAnswer++;
		boxNr = 1;
	}
	
	public void rightAnswer()
	{
		this.rightAnswer++;
		boxNr++;
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
		/**	set all counters back to zero.
		 * 	WrongAnswer und Rightanswer werden zur�ckgesetzt
		 *  BoxNr wird zur�ckgesetzt (back to 1)
		 */ 
		this.wrongAnswer = 0;
		this.rightAnswer = 0;
		this.boxNr = 1;
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
		this.rightAnswer = number;
		//
	}

	public void setWrongAnswer(int number)
	{
		this.wrongAnswer = number;
	}
}
