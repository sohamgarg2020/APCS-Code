import java.util.*;

public class Pile {
  
  protected  ArrayList<Card>pile;
	// returns the number of Cards left in the Pile
	public int size(){
    return 0;
	}


	/**
  This method empties the pile 
	*/ 

  public void clear(){
    
  }

 	/** Randomizes the cards in this deck. 
	* You must use the following algorithm:
	* If the size is < 2, return;
	* If the size == 2, "flip a coin", swap if "heads"
	* If the size > 2 repeat the following steps size() * 2 times:
	* select two different indexes (make sure they are different)
	* swap them in the ArrayList
	*/ 
	public void shuffle() {
  
      
	}

	/*
	 * Returns the "top" Card from this Pile, removing it from its  
	 *  data structure */

	public Card deal(){
		Card c = null;
    
    return c;
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
   
	}
	/* This returns a String representation of this Pile.  It should return 
	 *  a String built out of the Cards that the pile contains
	 */

	@Override
	public String toString(){
		String s = "";
    
		return s;
	}
}
