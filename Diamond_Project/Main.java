import kareltherobot.*;
import java.util.Scanner;


public class Main implements Directions{

  public static void turnRight(Robot x) {
    x.turnLeft();
    x.turnLeft();
    x.turnLeft();
  }

  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.print("How long do you want each side of the diamond to be: ");

    int sidelength = myObj.nextInt();  // Read user input



    World.setVisible(true);// allows us to see the run output
    // the bigger the street, the farther north
    World.setSize(sidelength+sidelength+1, sidelength+sidelength+1);// 20 streets by 20 avenues.
    World.setDelay(2);


    // The line below creates a Robot that we will refer to as rob  
    // Find out what the numbers and direction do!
    // Put rob in a better location for your initials.
    Robot rob = new Robot(sidelength+1,sidelength+1,West,sidelength*sidelength);



    int i = 0;
    while (i < sidelength-1) {
      rob.move();
      i++;
    }
    int x = 0;

    while (x < 4) {
      turnRight(rob);

      rob.putBeeper();
      i = 0;
      while (i < sidelength-1) {
        
        rob.move();
        turnRight(rob);
        rob.move();
        rob.turnLeft();
        rob.putBeeper();
        i++;
      }
      x++;
    }


    


    
    // done with the line, now on the curve
    // dude.turnLeft();
  }
}