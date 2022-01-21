public class Card implements Comparable<Card>{
	// need some instance variables
  private int suit;
  private int value;
 /** Must have this constructor.  You can add others*/
	public Card(int suit, int value){
    this.suit = suit;
    this.value = value;
	}
	
  // add getters
  public int getSuit() {
    return this.suit;
  }

  public int getValue() {
    return this.value;
  }

	@Override
	/** This method satisfies the Comparable interface which determines
	 * if this Object is smaller than, greater than or equal to the 
	 * specified Card c
	 * Formally, if this Card is smaller than c, a negative int is returned
	 *           if this Card is larger than c, a positive int is returned
	 *           if this Card is equal to c, zero is returned	*/
	public int compareTo(Card c){
    int answer = this.value - c.value;
    
    return answer;
	}
	
	// represents this Card in the following manner
	// if the card is the Ace of Spades, then 
	// it returns "Ace of Spades". 2 - 10 can be represented
	// as "2 of Hearts" or "Two of Hearts".  Your choice.
	@Override
	public String toString(){
		String s = "";
    if (value == 11) {
      s += "Jack";
    } else if (value == 12) {
      s += "Queen";
    } else if (value == 13) {
      s += "King";
    } else if (value == 14) {
      s += "Ace";
    } else {
      s += value;
    }
    s += " of ";
    if (suit == 0) {
      s += "Hearts";
    } else if (suit == 1) {
      s += "Diamonds";
    } else if (suit == 2) {
      s += "Clubs";
    } else if (suit == 3) {
      s += "Spades";
    }
		return s;
	}
}
