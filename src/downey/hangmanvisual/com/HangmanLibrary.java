package downey.hangmanvisual.com;

import java.util.ArrayList;
import java.io.*;

public class HangmanLibrary{
	private ArrayList<String> library;
	private BufferedReader stream;
	
	
	//constructor to create hangman library and populate with words from .txt file
	public HangmanLibrary(){
		library = new ArrayList<>();
		
		//add the words into the arraylist from the .txt through a buffered stream
		try{
			String wordsIn = null;
			stream = new BufferedReader(new FileReader("WordLibrary.txt"));
			while((wordsIn = stream.readLine()) != null){
				library.add(wordsIn);
			}
		
		}
		catch(IOException ioExcep){
			System.out.println("Error loading word for .txt file into library");
		}
		
	}
	
	//return size of the current word library
	public int getSize(){
		int size = 0;
		
		for(String word: library){
			size++;
		}
		return size;
	}
	
	//public 'getter' to access word in library by index
	public String getWordAt(int index){
		
		return library.get(index);
	}
}
