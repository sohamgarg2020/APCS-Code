/**
 * A tile in the game of Concentration
 * 
 * Tiles are arranged on an n x m board, represented in a 2D array.
 * 
 * A tile is similar to a playing card and tiles are 
 * shown in 1 of 3 states:
 *   with their value (face up)
 *   as hidden (face down)
 *   as matched (no long in play)
 * 
 * @author PLTW
 * @version 2.0
 */

/**
 * A Tile class for a gameboard
 */
public class Tile
{   
  private boolean isMatched;
  private boolean isShowing;
  
  private String value;
  private String hidden;
  private String matched;
  
  /**
   * Construct a tile with a string value. The default state
   * of a tile is hidden (face down) on the board and is unmatched.
   * 
   * @param  value the string value of the tile (face up value)
   */
  public Tile(String value) 
  {
    this.value = value; // face up value

    isMatched = false;
    isShowing = false;
    hidden =  "_____"; //  face down value
    matched = "  *  ";   // a tile that is no longer in play
  }
  /**
   * Get the value of this tile (face up value)
   *  
   * @return the value of the tile
   */
  public String getValue()
  {
    return value;
  }
    
  /**
   * Get the hidden value of this tile (face down value)
   * 
   * @return the hidden string
   */
  public String getHidden()
  {
    return hidden;
  }

  /**
   * Show this tile (turn it face up)
   */
  public void show()
  {
    isShowing = true;
  }

  /** 
   * Hide this tile (turn it face down)
   */
  public void hide()
  {
    isShowing = false;
  }

  /**
   * Determine if the tile is currently showing its value (face up)
   * 
   * @return true if the tile is showing a value, false otherwise
   */
  public boolean isShowingValue()
  {
    return isShowing;
  }

  /**
   * A matching tile to this tile has been found, set matched to true
   * and change the way the tile is shown 
   */
  public void foundMatch()
  {
    isMatched = true;
    value = matched;
    hidden = matched;
  }
  
  /**
   * Determine if this tile has been previously matched
   * 
   * @return true of the tile was previously matched, false otherwise
   */
  public boolean matched()
  {
    return isMatched;
  }
    
  /**
   * Determines if two tiles have the same value
   * 
   * @param tile the tile to compare this tile to
   * @return true if their values are the same, false otherwise
   */
  public boolean equals(Tile tile)
  {      
    if (this.value.equals(tile.value))
      return true;
    return false;
  }

  /**
   * Return the value of this tile
   */
  public String toString()
  {
    return value;
  }
}
