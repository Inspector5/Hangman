package downey.hangmanvisual.com;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class HangmanGUI{
	
	//global variables for GUI
	private JFrame window;
	JButton a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q,
			r, s, t, u, v, w, x, y, z;
	
	private HangmanController controller;
	
	//the random word chosen from the library
	private String randomWord;
	
	//the word to be displayed on the GUI (will be '?' before guessed correctly)
	private String displayWord;
	
	//text field where mystery word is displayed
	private JTextField mysteryWord;
	
	//label where hangman picture is displayed
	private JLabel picLabel;
	
	//array for buttons and images to display
	private ImageIcon[] imageArray;
	private JButton[] buttonArray;
	
	//keeps track of whether the user chooses to play another round or quit the game
	private int optionPaneButton = JOptionPane.YES_NO_OPTION;
	
	//keeps track of the correct/incorrect count of letters guessed
	
	
	public HangmanGUI(){
		//instantiate global variables in constructor
		window = new JFrame("Java Hangman");
		controller = new HangmanController();
		randomWord = controller.randomWord();
		displayWord = controller.wordDashConvert(randomWord);
		mysteryWord = new JTextField(displayWord);
		
		
		//instantiate button array and load with buttons (letters)
		buttonArray = new JButton[26];
		LetterHandler handler = new LetterHandler();
		
		buttonArray[0] = a = new JButton("A");
		buttonArray[1] = b = new JButton("B");
		buttonArray[2] = c = new JButton("C");
		buttonArray[3] = d = new JButton("D");
		buttonArray[4] = e = new JButton("E");
		buttonArray[5] = f = new JButton("F");
		buttonArray[6] = g = new JButton("G");
		buttonArray[7] = h = new JButton("H");
		buttonArray[8] = i = new JButton("I");
		buttonArray[9] = j = new JButton("J");
		buttonArray[10] = k = new JButton("K");
		buttonArray[11] = l = new JButton("L");
		buttonArray[12] = m = new JButton("M");
		buttonArray[13] = n = new JButton("N");
		buttonArray[14] = o = new JButton("O");
		buttonArray[15] = p = new JButton("P");
		buttonArray[16] = q = new JButton("Q");
		buttonArray[17] = r = new JButton("R");
		buttonArray[18] = s = new JButton("S");
		buttonArray[19] = t = new JButton("T");
		buttonArray[20] = u = new JButton("U");
		buttonArray[21] = v = new JButton("V");
		buttonArray[22] = w = new JButton("W");
		buttonArray[23] = x = new JButton("X");
		buttonArray[24] = y = new JButton("Y");
		buttonArray[25] = z = new JButton("Z");
		
		
		//instantiate image array and load with images (hangman images)
		imageArray = new ImageIcon[9];
		
		try{
		
			imageArray[0] = new ImageIcon(ImageIO.read(new File("E:\\Java\\workspace\\Hangman Visual\\Hangman Pictures\\Pic1.png")));
			imageArray[1] = new ImageIcon(ImageIO.read(new File("E:\\Java\\workspace\\Hangman Visual\\Hangman Pictures\\Pic2.png")));
			imageArray[2] = new ImageIcon(ImageIO.read(new File("E:\\Java\\workspace\\Hangman Visual\\Hangman Pictures\\Pic3.png")));
			imageArray[3] = new ImageIcon(ImageIO.read(new File("E:\\Java\\workspace\\Hangman Visual\\Hangman Pictures\\Pic4.png")));
			imageArray[4] = new ImageIcon(ImageIO.read(new File("E:\\Java\\workspace\\Hangman Visual\\Hangman Pictures\\Pic5.png")));
			imageArray[5] = new ImageIcon(ImageIO.read(new File("E:\\Java\\workspace\\Hangman Visual\\Hangman Pictures\\Pic6.png")));
			imageArray[6] = new ImageIcon(ImageIO.read(new File("E:\\Java\\workspace\\Hangman Visual\\Hangman Pictures\\Pic7.png")));
			imageArray[7] = new ImageIcon(ImageIO.read(new File("E:\\Java\\workspace\\Hangman Visual\\Hangman Pictures\\Pic8.png")));
			imageArray[8] = new ImageIcon(ImageIO.read(new File("E:\\Java\\workspace\\Hangman Visual\\Hangman Pictures\\Pic9.png")));
			
		}catch(IOException e){
			System.out.println("Error loading hangman pictures into array");
			
		}
		
		
		
		//Declare and instantiate panels + layout constraints
		JPanel mainPanel = new JPanel();
		JPanel picPanel = new JPanel();
		JPanel wordPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		wordPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		//set up text field to display mystery word
		JLabel wordLabel = new JLabel("Word:");
		c.insets = new Insets(0,0,15,0);
		wordPanel.add(wordLabel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 7;
		mysteryWord.setEditable(false);
		wordPanel.add(mysteryWord, c);
		
		
		//set up panel/hangman images on the screen (as Jlabel)
		c.fill = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0,0,0,0);
		picLabel = new JLabel(imageArray[0]);
		picPanel.add(picLabel);
		
		//tracks coordinates in word panel gridbag to lay out buttons
		int x = 0;
		int y = 1;
		
		//add each button to the panel and add action listener to each button
		for(int i = 0; i <= buttonArray.length-1; i++){
			buttonArray[i].addActionListener(handler);
			buttonArray[i].setPreferredSize(new Dimension(50,50));
			c.gridx = x;
			c.gridy = y;
			wordPanel.add(buttonArray[i], c);
			
			//format the key rows - last row (3) only has 4 buttons, so it's centered
			if(x / 6 == 1){
				y++;
				x = -1;
				if(y == 4)
					x = 0;
			}
			x++;
		}
		

		mainPanel.add(picPanel);
		mainPanel.add(wordPanel);
		window.add(mainPanel);
		
	}
	

	
	//method to run the GUI
	public void runGUI(){
		window.setSize(800,335);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
		
	}
	
	//method that manages user's choice to play another round (through option pane)
	public void playAgain(){
		if(optionPaneButton == JOptionPane.YES_OPTION){
			resetGame();
		}
		if(optionPaneButton == JOptionPane.NO_OPTION){
			window.setVisible(false);
			window.dispose();
		}
		
	}
	
	//method that displays losing option pane and option to play again
	public void gameLost(){
		if(controller.loseReturn() == 7){	
			optionPaneButton = JOptionPane.showConfirmDialog(window, "You lose! The word was: " + randomWord + "\n\nWould you like to play again?","You lose. . .", optionPaneButton);
			playAgain();
			
		}	
	}
	
	//method that displays winning option pane and option to play again
	public void gameWon(){
		if(controller.winReturn() == randomWord.length()){	
			picLabel.setIcon(imageArray[8]);
			picLabel.repaint();
			optionPaneButton = JOptionPane.showConfirmDialog(window, "You win! the word was: " + randomWord + "\n\nWould you like to play again?","Winner!", optionPaneButton);
			playAgain();
		}	
	}
	
	//method that manages updating the picture when a wrong letter is guessed (updates when right too, but no change to picture)
	public void updatePicture(){
		picLabel.setIcon(imageArray[controller.loseReturn()]);
		picLabel.repaint();
	}
	
	//method to reset the game if user chooses to play again
	public void resetGame(){
		//reset picture back to beginning
		picLabel.setIcon(imageArray[0]);
		picLabel.repaint();
		
		//reset win/lose counts tracked in both GUI and controller
		
		controller.setLose(0);
		controller.setWin(0);
		
		//pull a new random word from the library, convert to dashes and display
		randomWord = controller.randomWord();
		displayWord = controller.wordDashConvert(randomWord);
		mysteryWord.setText(displayWord);
		
		//enable all buttons again
		for(int i = 0; i <= buttonArray.length-1; i++){
			buttonArray[i].setEnabled(true);
		}
		
		//set optiontPane back to yes/no for win/lose option pane
		optionPaneButton = JOptionPane.YES_NO_OPTION;
	}
	
	
		//private class to handle the letter buttons for guessing
		private class LetterHandler implements ActionListener{
			public void actionPerformed(ActionEvent event){
				
				JButton theButton = (JButton) event.getSource();
				final String letter = theButton.getText().toLowerCase();
				
				displayWord = controller.wordReveal(randomWord, displayWord, letter.charAt(0));
				mysteryWord.setText(displayWord);
				theButton.setEnabled(false);
				
				updatePicture();
				gameLost();
				gameWon();
				
			}
		}
			
}

