import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import kareltherobot.*;

public class Driver implements Directions {
// declared here so it is visible in all the methods!! 
// It will be assigned a value in the getInfo method
	Robot roomba; 
	List directions = new ArrayList();
	String line32 = "";
	int line3 = 0;
	String line33 = "";
	int line2 = 0;
	char c; // Direction of the Robot given by the user
	int length;
	int width;
	int pile;
	int beeperPile=0; // Number of piles in the room
	int biggestPile;
	int beeperss = 0; // This is the total number of beepers picked up


	// You will add very many variables!!

	
	public static void main(String[] args) {
		
		// LEAVE THIS ALONE!!!!!!
		Driver d = new Driver();
		d.getInfo();
		d.cleanRoom();
		d.displayResults();
	}

	/**
	 * This method gets info from the user in the following order: 1. Ask the user
	 * which world file they wish to process. Right now, that world file name is
	 * hardcoded in. 2. Ask the user for the starting location and direction of the
	 * Robot. A new Robot should be constructed and assigned to the global
	 * (instance) variable named roomba that is declared on line 10.
	 * 
	 * An inelegant way to interact with the user is via the console, using
	 * System.out.println and a Scanner that scans System.in (input from the
	 * console). A more elegant way to get user input might include using a
	 * JOptionPane.
	 */
	private void getInfo() {
		Scanner myObj = new Scanner(System.in);

		System.out.print("What world do you want to load: ");

		String wrldName = myObj.nextLine();
		wrldName += ".wld";



		World.readWorld(wrldName);
		World.setVisible(true);
		World.setDelay(1);
		  // Create a Scanner object



		System.out.print("Where do you want the robot to start? Print x-value: ");
		int streets = myObj.nextInt();
		System.out.print("Where do you want the robot to start? Print y-value: ");
		int avenue = myObj.nextInt();

		System.out.print("Where do you want the robot to be facing? Enter n, w, s, e: ");
		c = myObj.next().charAt(0);
		directions.add('n');
		directions.add('w');
		directions.add('s');
		directions.add('e');

		while (true){
			if (directions.contains(c)) {
				break;
			} else {
				System.out.println("That is not a valid direction.");
				System.out.print("Where do you want the robot to be facing? Enter n, w, s, e: ");
				c = myObj.next().charAt(0);
			}
		}
		if (c == 'n') {
			roomba = new Robot(avenue, streets, North, 0);
		} else if (c == 'w') {
			roomba = new Robot(avenue, streets, West, 0);
		} else if (c == 's') {
			roomba = new Robot(avenue, streets, South, 0);
		} else if (c == 'e') {
			roomba = new Robot(avenue, streets, East, 0);
		}

	}

	/** This method will have all the logic that takes the Robot to every location 
	 * and cleans up all piles of beepers.  Think about ways you can break this
	 * large, complex task into smaller, easier to solve problems.
	 */
	private void cleanRoom() {
		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		if (c == 'n') {
			roomba.turnLeft();
			while (roomba.frontIsClear() == true) {
				roomba.move();
			}
			roomba.turnLeft();
			while(roomba.frontIsClear() == true) {
				roomba.move();
			}
		} else if (c == 'e') {
			roomba.turnLeft();
			roomba.turnLeft();
			while (roomba.frontIsClear() == true) {
				roomba.move();
			}
			roomba.turnLeft();
			while(roomba.frontIsClear() == true) {
				roomba.move();
			}
		} else if (c == 'w') {
			while (roomba.frontIsClear() == true) {
				roomba.move();
			}
			roomba.turnLeft();
			while(roomba.frontIsClear() == true) {
				roomba.move();
			}
		} else {
			turnRight(roomba);
			while (roomba.frontIsClear() == true) {
				roomba.move();
			}
			roomba.turnLeft();
			while(roomba.frontIsClear() == true) {
				roomba.move();
			}
		}
		roomba.turnLeft();

		length = 0;
		width = 0;
		biggestPile = 0;
		
		while (true){
			length = 0;
			cleanLength(roomba);
			roomba.turnLeft();
			if (roomba.frontIsClear() != true){
				break;
			}
			roomba.move();
			roomba.turnLeft();
			width++;
			cleanLength(roomba);
			turnRight(roomba);
			if (roomba.frontIsClear() != true){
				break;
			}
			roomba.move();
			turnRight(roomba);
			width++;

		}


			

		// obviously, lots more here
	}

	public void turnRight(Robot bob) {
		bob.turnLeft();
		bob.turnLeft();
		bob.turnLeft();
	}

	/** This method displays the results of cleaning the room.  All of the info
	 * in the pdf that describes the problem need to be displayed.  You can present
	 * this info in the console (boring) or you can present using JOptionPane (cool!)
	 */
	private void displayResults() {
		double beeperPile1 = beeperPile;
		if (width == 0){
			if (length == 0) {
				width += 2;
				length +=2;
				System.out.println("The width is " + width + " and the length is " + length);
				System.out.println("The area of the room is " + (width)*(length));
				System.out.println("The percent of the room that is dirty is " + (beeperPile1)/(width*length)*100 + "%");
			} else {
				width += 2;
				length += 1;
				System.out.println("The width is " + width + " and the length is " + length);
				System.out.println("The area of the room is " + (width)*length);
				System.out.println("The percent of the room that is dirty is " + (beeperPile1)/(width*length)*100 + "%");
			}
		} else {
			if (length == 0) {
				length +=2;
				width +=1;
				System.out.println("The width is " + width + " and the length is " + length);
				System.out.println("The area of the room is " + (width)*(length));
				System.out.println("The percent of the room that is dirty is " + (beeperPile1)/(width*length)*100 + "%");
			} else {
				length += 1;
				width += 1;
				System.out.println("The width is " + width + " and the length is " + length);
				System.out.println("The area of the room is " + (width)*length);
				System.out.println("The percent of the room that is dirty is " + (beeperPile1)/(width*length)*100 + "%");
			}

		}
		
		System.out.println("The biggest pile was " + biggestPile);
		
		System.out.println("The number of piles is " + beeperPile);
		double beeperss1 = beeperss;
		
		double averagebeepers = beeperss1/beeperPile1;
		averagebeepers = Math.round(averagebeepers*100.0)/100.0;
		System.out.println("The average number of beepers is " + averagebeepers);
		System.out.println("The number of beepers were " + beeperss);
		
	}

	public void cleanLength(Robot roomba){
		
		while (roomba.frontIsClear() == true) {
			
			
			if (roomba.nextToABeeper() == true) {
				while (roomba.nextToABeeper() == true) {
					roomba.pickBeeper();
					pile++;
					beeperss++;
					
				}
				beeperPile++;
			}
			if (pile > biggestPile) {
				biggestPile= pile;
			} else {
				biggestPile = biggestPile;
			}
			roomba.move();
			pile = 0;
			if (roomba.nextToABeeper() == true) {
				while (roomba.nextToABeeper() == true) {
					roomba.pickBeeper();
					pile++;
					beeperss++;
				}
				beeperPile++;
			}
			if (pile > biggestPile) {
				biggestPile= pile;
			} else {
				biggestPile = biggestPile;
			}

			
			
			pile = 0;
			length ++;
		}
		if (roomba.nextToABeeper() == true) {
			while (roomba.nextToABeeper() == true) {
				roomba.pickBeeper();
				pile++;
				beeperss++;
			}
			beeperPile++;
		}
		if (pile > biggestPile) {
			biggestPile= pile;
		} else {
			biggestPile = biggestPile;
		}
	}

}
