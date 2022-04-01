import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Game {

    private Snake snake;
	private ArrayList<GameObject> objects = new ArrayList<>();

    public Game(){
        
    }
    


	/**
	 * This is called every time the Timer goes off.  Right now, it moves all 
	 * the Objects and checks for collisions.  This is common in games with flying
	 * Objects.  You can do more, though.  Like add items or move to new screens
	 * or check to see if the turn is over or...
	 */
	public void updateGame() {
		System.out.println("Moving Objects!!");
		moveObjects();
		checkCollisions();

	}
    /**
	 * Right now I am checking for collisions between GameObjects
	 */
	public void checkCollisions() {
		
	}

	/**
	 * get it...
	 */
	public void moveObjects() {
		snake.move();
	}


	/**
	 * Draws all the stuff in the game without changing them
	 * No reason to change this unless you wanted a background
	 * or something.
	 * @param g
	 */
    public void drawTheGame(Graphics g) {
		snake.draw(g);
		for(GameObject go:this.objects) {
			go.draw(g);
		}

	}
		
	
	/** called when the left arrow is pressed.  Probably move something
	 *  to the left, or turn left or... */
	public void ltHit(ActionEvent e) {
		System.out.println("Left!!");
	}
	/** called when the left arrow is released.  You don't have to do anything
	 * here, but you can if your game uses this event*/
    public void leftReleased(ActionEvent e) {
        System.out.println("Released Left!!");
    }
	/** called when the right arrow is pressed.  Probably move something
	 *  to the right, or turn right or... */
	public void rtHit(ActionEvent e) {
        
		System.out.println("Right!");
	}
	/** called when the right arrow is released.  You don't have to do anything
	 * here, but you can if your game uses this event*/
    public void rightReleased(ActionEvent e) {
		System.out.println("Released &&&&  Right!!");
    }
	/** called when the up arrow is pressed.  You don't have to do anything
	 * here, but you can if your game uses this event*/
    public  void upHit(ActionEvent e) {
		System.out.println("Up!!");
	}
	/** called when the up arrow is released.  You don't have to do anything
	 * here, but you can if your game uses this event*/
	public void upReleased(ActionEvent e) {
		System.out.println("Released ^^^^  Up!!");
    }

	

    

}
