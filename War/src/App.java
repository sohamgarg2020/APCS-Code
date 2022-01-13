import java.util.*;

/**
This class has the code for testing classes and for running a game of War.
*/
public class App {
  private static Scanner in = new Scanner(System.in);
	
  public static void main(String[] args) {
		
    System.out.println("1- Test Card class ");
    System.out.println("2- Test Deck class ");
    System.out.println("3- Run a WarGame ");
    System.out.println("Anything else to exit ");
    System.out.print("Enter your choice: ");
    String choice = in.nextLine();
    // trim white spaces from back and front
    choice = choice.trim();
    if(choice.equals("1")){
      new App().testCard();
    }
    else if(choice.equals("2")){
      new App().testDeck();
    }
    else if(choice.equals("3")){
      new App().play();
    }
    else{
      System.exit(0);
    }
	}

  /**  You can add more tests into this method.  These are the basic tests it should pass*/
  private void testCard() {
		System.out.println("Testing the Card class");
		Card c = new Card(1,4);// four of something
		Card c2 = new Card(3,8);// 8 of something
		System.out.println("Testing the Card toString method");
		System.out.println("Card 1: "+ c);
		System.out.println("Card 2: "+ c2);
		if(c.compareTo(c2)<0)
			System.out.println(c2+" is bigger");
		else if(c.compareTo(c2)>0)
			System.out.println(c+" is bigger");
		else
			System.out.println(c+" equals "+c2);
	}

	private void testDeck() {
		System.out.println("Testing the Deck and Pile");
		Deck d = new Deck();
		System.out.println("Printing 4 cards");
		for(int i = 0; i<4; i++){
			System.out.println((i+1)+"  "+d.deal());
		}
		Pile hand1 = new Pile(),
         hand2 = new Pile();
		while(d.size()>10){
			hand1.add(d.deal());
		}
		while(d.size()>0){
			hand2.add(d.deal());
		}

    System.out.println("Hand1: "+hand1);
    System.out.println("Hand2: "+hand2);

		while(hand1.size() > 0 &&hand2.size() > 0){
			Card c1 = hand1.deal(),
				 c2 = hand2.deal();
			if(c1.compareTo(c2)>0)
				System.out.println(c1 + " is bigger than "+c2+" so player 1 wins");
			else if(c1.compareTo(c2)<0)
				System.out.println(c2 + " is bigger than "+c1+" so player 2 wins");
			else
				System.out.println(c1 + " and "+c2+" are the same, so tie");
		}
    System.out.println("Hand1: "+hand1);
    System.out.println("Hand2: "+hand2);
	}

  private void play(){
   
      WarGame wg = new WarGame();
     // Starts a new Game of War 
     // in order to do many simulations, this needs to be 
     // looped!
		  wg.playAGame();
  }
	
}
