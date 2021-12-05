/** 
 * A game board of NxM board of tiles.
 * 
 *  @author PLTW
 * @version 2.0
 */

/** 
 * A Board class for concentration
 */
public class Board
{  
  private static String[] tileValues = {"lion", "lion",
                                        "penguin", "penguin",
                                        "dolphin", "dolphin",
                                        "fox", "fox",
                                        "monkey", "monkey",
                                        "turtle", "turtle"}; 
  private Tile[][] gameboard = new Tile[3][4];
  private static String[] copyOfTiles = tileValues;

  /**  
   * Constructor for the game. Creates the 2D gameboard
   * by populating it with card values
   * 
   */
  public Board()
  {
    int num;
    /* your code here */

    /*
    int numRows = gameboard.length;
    int numColumns = gameboard[0].length;
    int tileValuesCounter = 0;
    for (int i = 0; i < numRows; i++){
      for (int j = 0; j < numColumns; j++){
        gameboard[i][j] = new Tile(tileValues[tileValuesCounter]);
        tileValuesCounter++;
      }
    }
    */
    for (int i = 0; i < gameboard.length; i++){
      for (int j = 0; j < gameboard[0].length; j++){
        while (true){
          num = (int)Math.floor(Math.random()*copyOfTiles.length);
          if (copyOfTiles[num] == null){
            continue;
          } else {
            break;
          }
        }
        gameboard[i][j] = new Tile(copyOfTiles[num]);
        copyOfTiles[num] = null;
      }
    }
    /*
    used for testing only
    System.out.println(java.util.Arrays.toString(gameboard[0]));
    System.out.println(java.util.Arrays.toString(gameboard[1]));
    System.out.println(java.util.Arrays.toString(gameboard[2]));
    System.out.println(java.util.Arrays.toString(gameboard[3]));
    */
  }

 /** 
   * Returns a string representation of the board, getting the state of
   * each tile. If the tile is showing, displays its value, 
   * otherwise displays it as hidden.
   * 
   * Precondition: gameboard is populated with tiles
   * 
   * @return a string represetation of the board
   */
  public String toString()
  {
 
    /* your code here */

    String res = "";
    int numRows = gameboard.length;
    int numColumns = gameboard[0].length;
    int tileValuesCounter = 0;
    for (int i = 0; i < numRows; i++){
      for (int j = 0; j < numColumns; j++){
        if (gameboard[i][j].isShowingValue()){
          res += gameboard[i][j].getValue();
          res += "\t";
        
        } else {
          res += gameboard[i][j].getHidden();
          res += "\t";
        }
        tileValuesCounter++;
      }
      res += "\n";
    }
 
    return res;
  }

  /** 
   * Determines if the board is full of tiles that have all been matched,
   * indicating the game is over.
   * 
   * Precondition: gameboard is populated with tiles
   * 
   * @return true if all tiles have been matched, false otherwse
   */
  public boolean allTilesMatch()
  {

    /* your code  here */
    int numRows = gameboard.length;
    int numColumns = gameboard[0].length;
    int tileValuesCounter = 0;
    for (int i = 0; i < numRows; i++){
      for (int j = 0; j < numColumns; j++){
        if (gameboard[i][j].matched() == false){
          return false;
        }
        tileValuesCounter++;
      }
    }
    
    return true;
  }

  /** 
   * Sets the tile to show its value (like a playing card face up)
   * 
   * Preconditions:
   *   gameboard is populated with tiles,
   *   row values must be in the range of 0 to gameboard.length,
   *   column values must be in the range of 0 to gameboard[0].length
   * 
   * @param row the row value of Tile
   * @param column the column value of Tile
   */
  public void showValue (int row, int column)
  {
   
    /* your code here */
    gameboard[row][column].show();
  }  

  /** 
   * Checks if the Tiles in the two locations match.
   * 
   * If Tiles match, show Tiles in matched state and return a "matched" message
   * If Tiles do not match, re-hide Tiles (turn face down).
   * 
   * Preconditions:
   *   gameboard is populated with Tiles,
   *   row values must be in the range of 0 to gameboard.length,
   *   column values must be in the range of 0 to gameboard[0].length
   * 
   * @param row1 the row value of Tile 1
   * @param col1 the column value of Tile 1
   * @param row2 the row value of Tile 2
   * @param col2 the column vlue of Tile 2
   * @return a message indicating whether or not a match occured
   */
  public String checkForMatch(int row1, int col1, int row2, int col2)
  {
    String msg = "";

     /* your code here */
    if (gameboard[row1][col1].equals(gameboard[row2][col2])){
      msg = "Matched.";
      gameboard[row1][col1].foundMatch();
      gameboard[row2][col2].foundMatch();
    } else {
      msg = "It was not a match. Try again.";
      gameboard[row1][col1].hide();
      gameboard[row2][col2].hide();
    }
    
     return msg;
  }

  /** 
   * Checks the provided values fall within the range of the gameboard's dimension
   * and that the tile has not been previously matched
   * 
   * @param row the row value of Tile
   * @param col the column value of Tile
   * @return true if row and col fall on the board and the row,col tile is unmatched, false otherwise
   */
  public boolean validateSelection(int row, int col)
  {

    /* your code here */
    if (row < gameboard.length && col < gameboard[0].length){
      if (gameboard[row][col].matched() == false ){
        return true;
      }
    }
    return false;
  }

}
