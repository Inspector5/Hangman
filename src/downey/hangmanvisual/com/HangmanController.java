package downey.hangmanvisual.com;

import java.util.Random;

public class HangmanController {

	private HangmanLibrary library;
	private int winCount = 0;
	private int loseCount = 0;
	
	//constructor for hangmanController
	public HangmanController(){
		library = new HangmanLibrary();
	}
	
	//method to pull a word at random from the instantiated library
	public String randomWord(){
		Random random = new Random();
		int number = random.nextInt(library.getSize());
		
		return library.getWordAt(number);
	}
	
	//method to cover word into mystery dashes
	public String wordDashConvert(String randWord){
		String dashWord = "";
		
		for(int i = 0; i < randWord.length(); i++){
			dashWord += "?";	
		}
		return dashWord;
	}
	
	//method to reveal the mystery random word as player guesses letters
	public String wordReveal(String randomWord, String displayWord, char letter){
		String revealWord = "";
		int tempWinCount = winCount;
		
		for(int i = 0; i < randomWord.length(); i++){
			if(randomWord.charAt(i) == letter){
				revealWord += letter;
				winCount++;
			}
			else{
				revealWord += displayWord.charAt(i);
			}
		}
		//see if winCount was incremented - if it wasn't, you didn't guess right and loseCount is incremented
		if(tempWinCount == winCount){
			loseCount++;
		}
		return revealWord;
	}
	
	//public 'getter' to return winCount value
	public int winReturn(){
		return winCount;
	}
	
	//public 'getter' to return loseCount value
	public int loseReturn(){
		return loseCount;
	}
	
	public void setWin(int set){
		winCount = set;
	}
	
	public void setLose(int set){
		loseCount = set;
	}
}
