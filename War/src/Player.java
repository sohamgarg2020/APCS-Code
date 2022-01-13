
public class Player {
	private Pile toPlay;// This is the Pile of Cards that I will play
  private Pile capturedCards;// Pile of cards that I have won
	private String name;// This player's name

	public Player(String s){
    this.name = s;
		toPlay = new Pile();
		capturedCards = new Pile();
	}
	/** Don't need to change this*/
	public Card getCard(){
		if(toPlay.size()<=0){
			if(capturedCards.size()<=0)
				return null;
			else{
				// line below just randomizes the captured
				// cards so that we don't get cyclic results where
				// the game never ends
				capturedCards.shuffle();
				while(capturedCards.size()>0)
					toPlay.add(capturedCards.deal());
			}
		}
		return toPlay.deal();
	}
	public void addCard(Card c){
		capturedCards.add(c);
	}
  public void add(Pile p){
    while (p.size() > 0) {
      addCard(p.deal());
    }
  }
  // leave the method below alone
  public int cardsLeft(){
    return capturedCards.size()+toPlay.size();
  }

   	
}
