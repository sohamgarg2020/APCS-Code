import java.util.*;

/** A Deck is a special kind of Pile that essentially is Initialized to be 
    a complete standard deck of cards with 52 cards.  13 of each suit*/

public class Deck extends Pile {

  public Deck(){
		initDeck();
	}

	/* Initializes the Cards in this deck, constructing them all and
	 *  placing them into the data structure holding them.*/			
	private void initDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                add(new Card(i, j));
            }
        }
        shuffle();
	}

}
