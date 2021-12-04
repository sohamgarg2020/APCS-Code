/*  
 * Play the game of Concentration
 * 
 * The runner creates a game board and shows the board. It gets a 2-tile selection from the user,
 * checks if the cards at the 2 tile locations match, and then re-displays the board. 
 */
public class GameRunner
{
  public static void main(String[] args)
  {
    Game game = new Game();
    game.play();
  }
}
