import java.util.*;


public class WarGame {// plays a game of War with two players
// probably need more instance variables
	private Deck d; //central pile?
	private Player one, two;
	private int numRounds = 0;
	private boolean gameOver = false;
	private Scanner in = new Scanner(System.in);
  private Pile cardsToBeAdded;
	private Card[] lastPlayed = new Card[2];
	private int roundWinner;


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
		for (int i = 0; i < 26; i++) {
		  one.addCard(d.deal());
		  two.addCard(d.deal());
		}
	}


	/* Displays the result of the round.  This should show the cards that were played, as well as the winner of the round */
	private void displayRound() {
		System.out.println("Player " + roundWinner + " won the round. Player 1 has " + one.cardsLeft() + " cards left. Player 2 has " + two.cardsLeft() + " cards left.");	
		System.out.println("Cards played: ");
		System.out.println("Player 1: " + lastPlayed[0]);
		System.out.println("Player 2: " + lastPlayed[1]);
	}


	/* this takes a card from each player and puts them into a pile.
	 *  whichever player had the largest card gets the cards in the pile.  
	 *  if there is a tie, the players who tied put one more card into the pile
	 *  whoever had the highest wins the pile. If still a tie, repeat.  If one 
	 *  player runs out of cards, that player loses.*/	
	private void playRound() {
    Card card1 = one.getCard();
    Card card2 = two.getCard();


    if (card1.compareTo(card2) > 0) {
		cardsToBeAdded.add(card1);
		cardsToBeAdded.add(card2);
    	one.add(cardsToBeAdded);
		roundWinner = 1;
    }
    else if (card1.compareTo(card2) < 0) {
		cardsToBeAdded.add(card1);
		cardsToBeAdded.add(card2);
		two.add(cardsToBeAdded);
		roundWinner = 2;
    }

	else {
		cardsToBeAdded.add(card1);
		cardsToBeAdded.add(card2);
    	for (int i = 0; i < 3 && one.cardsLeft() > 0 && two.cardsLeft() > 0; i++) {
			cardsToBeAdded.add(one.getCard());
			cardsToBeAdded.add(two.getCard());
		}
		checkGameOver();
		playRound();
    }
	lastPlayed[0] = card1;
	lastPlayed[1] = card2;
    
	}


	// Checks to see if game is over, if it is, it sets
	// the variable gameOver to true, and Displays an appropriate message
  // The game is over if either player is out of cards
	private void checkGameOver() {
    if (one.cardsLeft() == 0) {
      gameOver = true;
      System.out.println("Player 2 won the game!");
    }
    else if (two.cardsLeft() == 0) {
      gameOver = true;
      System.out.println("Player 1 won the game!");
    }

	}
  
}
