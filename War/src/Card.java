
public class Card implements Comparable<Card>{
	// need some instance variables
 
 /** Must have this constructor.  You can add others*/
	public Card(int suit, int value){

	}
	
  // add getters



	@Override
	/** This method satisfies the Comparable interface which determines
	 * if this Object is smaller than, greater than or equal to the 
	 * specified Card c
	 * Formally, if this Card is smaller than c, a negative int is returned
	 *           if this Card is larger than c, a positive int is returned
	 *           if this Card is equal to c, zero is returned	*/
	public int compareTo(Card c){
    int answer = 0;
    
    return answer;
	}
	
	// represents this Card in the following manner
	// if the card is the Ace of Spades, then 
	// it returns "Ace of Spades". 2 - 10 can be represented
	// as "2 of Hearts" or "Two of Hearts".  Your choice.
	@Override
	public String toString(){
		String s = "";
		
		return s;
	}
}
