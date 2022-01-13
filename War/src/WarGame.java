import java.util.*;


public class WarGame {// plays a game of War with two players
// probably need more instance variables
	private Deck d; //central pile?
	private Player one, two;
	private int numRounds = 0;
	private boolean gameOver = false;
	private Scanner in = new Scanner(System.in);
  private Pile cardsToBeAdded;


  /** This method plays a game of war between two players.  This returns the number of rounds it took until the game ended.*/
	public int playAGame() {
		d = new Deck();
		one = new Player("Mr. H");
		two = new Player("Mr. K");
		dealCardsToPlayers();
    cardsToBeAdded = new Pile();

		while(!gameOver){
			numRounds++;

			System.out.println("\nRounds Played: "+numRounds+ " Hit Enter to continue.");
			
			playRound();
			displayRound();
			checkGameOver();
			
			// uncomment the line below to stop after every round
			in.nextLine();
		}
		System.out.println("Game over!");
		return numRounds;
	}

	/* This deals the cards from the deck to the two players*/
	private void dealCardsToPlayers() {
    
	}


	/* Displays the result of the round.  This should show the cards that were played, as well as the winner of the round */
	private void displayRound() {
  
	}


	/* this takes a card from each player and puts them into a pile.
	 *  whichever player had the largest card gets the cards in the pile.  
	 *  if there is a tie, the players who tied put one more card into the pile
	 *  whoever had the highest wins the pile. If still a tie, repeat.  If one 
	 *  player runs out of cards, that player loses.*/	
	private void playRound() {
    

    
	}


	// Checks to see if game is over, if it is, it sets 
	// the variable gameOver to true, and Displays an appropriate message
  // The game is over if either player is out of cards
	private void checkGameOver() {


	}
  
}
