/** 
 * The game that uses a n x m board of tiles or cards.
 *  
 * Player chooses two random tiles from the board. The chosen tiles
 * are temporarily shown face up. If the tiles match, they are removed from board.
 * 
 * Play continues, matching two tiles at a time, until all tles have been matched.
 * 
 * @author PLTW
 * @version 2.0
*/
import java.util.Scanner;

/**
 * A game class to play concentration
 */
public class Game
{
  private Scanner in = new Scanner(System.in);

  private Board board;
  private int row1, col1;
  private int row2, col2;

  public void play()
  {
    // instructions
    System.out.println("Welcome!");
    System.out.println("Select the tile locations you want to match,");
    System.out.println("or enter any non-integer character to quit.");
    System.out.println("(You will need to know 2D arrays to play!)");
    System.out.println("\nPress Enter to continue...");
    in.nextLine();

    board = new Board();
    // play until all tiles are matched
    while (!board.allTilesMatch())
    {
      // get player's first selection, if not an integer, quit
      row1 = -1;
      col1 = -1;
      boolean validTile = false;
      while (!validTile)
      {
        displayBoard();
        System.out.print("First choice (row col): ");
        validTile = getTile(true); 
      }

      // display first tile
      board.showValue(row1, col1);

      // get player's second selection, if not an integer, quit
      row2 = -1;
      col2 = -1;
      validTile = false;
      while (!validTile)
      {
        displayBoard();
        System.out.print("Second choice (row col): ");
        validTile = getTile(false);
         
        // check if user chosen same tile twice
        if ((row1 == row2) && (col1 == col2))
        {
          System.out.println("You mush choose a different second tile");
          wait(2);
          validTile = false;
        }
      }

      // display second tile
      board.showValue(row2, col2);
      displayBoard();

      // determine if tiles match
      String matched = board.checkForMatch(row1, col1, row2, col2);
      System.out.println(matched);

      // wait 2 seconds to start the next turn
      wait(2); 
    }

    displayBoard();
    System.out.println("Game Over!");
  }

  /**
   * Get tile choices from the user, validating that
   * the choice falls within the range of rows and columns on the board.
   * 
   * @param firstChoice if true, saves the user's first row/col choice, otherwise sets the user's second choice
   * @return true if user has made a valid choice, false otherwise
   */

  private boolean getTile(boolean firstChoice)
  {
    int num1 = 0;
    int num2 = 0;
        
    if (in.hasNextInt())
      num1 = in.nextInt();
    else
      quitGame();
  
    if (in.hasNextInt())
      num2 = in.nextInt();
     else
      quitGame();

    in.reset(); // ignore any extra input

    if (!board.validateSelection(num1, num2))
    {
      System.out.print("Invalid input, please try again. ");
      wait(2);
      return false;
    }
    if (firstChoice)   
    {
      row1 = num1;
      col1 = num2;
    }
    else 
    {
      row2 = num1;
      col2 = num2;
    }
    return true;
  }

  /**
   * Clear the console and show the game board
   */
  public void displayBoard()
  {

    // scroll current board off screen
    for (int x = 0; x < 50; x++) {
      System.out.println();
    }

    System.out.println(board);
  }

  /**
   * Wait n seconds before clearing the console
   */
  private void wait(int n)
  {
    // a try is like an if statement, "throwing" an error if the body of the try fails
    try
    {
      Thread.sleep(n * 1000);
    } catch (InterruptedException e) { /* do nothing */ }
  }

  /** 
   * User quits game
   */
  private void quitGame() 
  {
    System.out.println("Quit game!");
    System.exit(0);
  }
}
