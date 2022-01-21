import java.util.*;

public class Pile {
  
  private ArrayList<Card> cards = new ArrayList();

	// returns the number of Cards left in the Pile
	public int size(){

	    return cards.size();
	}


	/* Randomizes the cards in this deck. 
	* You MUST use the following algorithm:
	* If the size is < 2, return;
	* If the size == 2, "flip a coin", swap if "heads"
	* If the size > 2 repeat the following steps size() * 2 times:
	* select two different indexes (make sure they are different)
	* swap them in the ArrayList
	*/ 

  public void clear(){
    cards.clear();
  }
 
	public void shuffle() {
  	/* Randomizes the cards in this deck. 
	* You must use the following algorithm:
	* If the size is < 2, return;
	* If the size == 2, "flip a coin", swap if "heads"
	* If the size > 2 repeat the following steps size() * 2 times:
	* select two different indexes (make sure they are different)
	* swap them in the ArrayList
	*/ 
  if (size() < 2) {
    return;
  } else if (size() == 2) {
    if (Math.random() > 0.5) {
      Card temp = cards.get(0);
      cards.set(0, cards.get(1));
      cards.set(1, temp);
    }
  } else {
    for (int i = 0; i < size() * 2; i++) {
      int ind1 = (int) (Math.random() * cards.size());
      int ind2 = (int) (Math.random() * cards.size());
      while (ind2 == ind1) {
        ind2 = (int) (Math.random() * cards.size());
      }
      Card temp = cards.get(ind1);
      cards.set(ind1, cards.get(ind2));
      cards.set(ind2, temp);
    }
  }
	}

	/*
	 * Returns the "top" Card from this Pile, removing it from its  
	 *  data structure */

	public Card deal(){
    return cards.remove(cards.size() - 1);
	}


  /*  Adds every Card from p to this Pile
      You should not have to change this method.
  */
  public void addPile(Pile p){
    while(p.size()>0){
      this.add(p.deal());
    }
  }
  
  
	public void add(Card c) {

      cards.add(c);
	}
	/* This returns a String representation of this Pile.  It should return 
	 *  a String built out of the Cards that the pile contains
	 */

	@Override
	public String toString(){
		String s = "";
    for (Card c: cards) {
      s += c + ", ";
    }
		return s;
	}
}
