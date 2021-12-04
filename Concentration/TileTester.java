/*
 * Activity 3.8.1
 */
public class TileTester
{
  private static String[] tileValues =
  { "lion", "lion",
    "penguin", "penguin",
    "dolphin", "dolphin",
    "fox", "fox",
    "monkey", "monkey",
    "turtle", "turtle" }; 

  public static void main(String[] args)
  {
    
    /* your code here */
    int count = 0;
    Tile gameboard[][] = new Tile[3][4];
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 4; j++){
        gameboard[i][j] = new Tile(tileValues[count]);
        count++;
      }
    }
    System.out.println(java.util.Arrays.toString(gameboard[0]));
    System.out.println(java.util.Arrays.toString(gameboard[1]));
    System.out.println(java.util.Arrays.toString(gameboard[2]));
  }
}
