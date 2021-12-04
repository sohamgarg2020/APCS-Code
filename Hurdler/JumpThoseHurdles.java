import kareltherobot.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class JumpThoseHurdles {
	// This is the Robot we will use to jump the hurdles
	Robot hurdler = new Robot(1,1,Directions.East, 0);
	String line32 = "";
	int line3 = 0;
	List worldNames = new ArrayList();
	String line33 = "";
	int line2 = 0;

	public static void turnRight(Robot rob){
		rob.turnLeft();

		rob.turnLeft();
		rob.turnLeft();
	}
	
	public static void main(String[] args){
		new JumpThoseHurdles().start();

	}

	public void start(){
		worldNames.add('a');
		worldNames.add('b');
		worldNames.add('c');
		worldNames.add('d');
		

		Scanner myObj = new Scanner(System.in);  // Create a Scanner object

    	System.out.print("What world do you want? Type a, b, c, d: ");

    	char userName = myObj.next().charAt(0);  // Read user input

		if (worldNames.contains(userName)) {
			loadWorld(userName);
			
			try {
				line32 = Files.readAllLines(Paths.get("world" + userName + ".wld")).get(2);
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				line33 = Files.readAllLines(Paths.get("world" + userName + ".wld")).get(1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			line33 = line33.replace("streets ", "");
			line32 = line32.replace("avenues ", "");
			int maxhurdler3 = 0;
			int sum = 0;
			int numberofhurdler = 0;
			int highesthurdler = 0;
			
			int x = 0;
			int y = 1;
			try{
				line3 = Integer.parseInt(line32);
			} catch (NumberFormatException e){
				line3 = 0;
			}

			try{
				line2 = Integer.parseInt(line33);
			} catch (NumberFormatException e) {
				line2 = 0;
			}
			int lowestHurdlerDistance = line2;
			while (true) {
				int w1 = findHurdle();
				if (w1 == -1) {
					break;
				} 
				int h1 = climbHurdle();
				clearHurdle();
				numberofhurdler ++;
				sum += h1;
				if (h1 > maxhurdler3){
					maxhurdler3 = h1;
					highesthurdler = y;
				}
				if (w1 < lowestHurdlerDistance) {
					if (w1 == -1){
						lowestHurdlerDistance = lowestHurdlerDistance;
					}
					else {
						lowestHurdlerDistance = w1 - 1;
					}
				}
				x ++;
				y ++;
			}
			float average = (sum)/numberofhurdler;
			System.out.println("The tallest with a height of " + maxhurdler3);
			System.out.println("The tallest hurdle is hurdle number " + highesthurdler);
			System.out.println("The shortest distance from one hurdle to the next is " + lowestHurdlerDistance);
			System.out.println("The average height of the hurdles is " + average);
		} else {
			System.out.println("Please give a proper input");
		}

		
		

		
	}

	/**
	 * This method assumes the Robot is named hurdler and is facing East
	 * This moves hurdler to the next wall (hurdle). It returns the number
	 * of moves it took to get to the hurdle
	 */
	private int findHurdle() {

		int x = 0;
		boolean hasReached = false;
		while (hasReached == false) {
				if (hurdler.frontIsClear()) {
					if (hurdler.avenue() == line3) {
						return -1;
					}
					hurdler.move();
				
				} else {
					hasReached = true;
					
					
				}
				x ++;
			}
			
			return x;


		
		
	}
	/**
	 * This method assumes the Robot is named hurdler, is facing East and
	 * is at the base of the hurdle. 
	 * This moves the Robot to the top of the hurdle so that it can clear
	 * the wall.  
	 * @return The number of steps to get above the hurdle (height)
	 */
	private int climbHurdle() {
		int y = 0;
		boolean reachedTop = false;
		while (reachedTop == false){
			if (hurdler.frontIsClear() == false) {
				hurdler.turnLeft();
				hurdler.move();
				turnRight(hurdler);
				y ++;
			} else {
				reachedTop = true;
			}
		}
		return y;
	}

	/** 
	 * Moves the Robot (hurdler) over the wall and moves it to the ground so 
	 * that the Robot has its back to the hurdle and is facing the next one.
	 */
	private void clearHurdle() {
		// TODO Auto-generated method stub
		hurdler.move();
		turnRight(hurdler);
		while (hurdler.frontIsClear() == true) {
			hurdler.move();
		}
		hurdler.turnLeft();
		
	}

	private void loadWorld(char userName) {
		// line below "hardcodes" this to use one specific world
		// it would be better to ask the user...
		String worldName = "world" + userName + ".wld";
		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(5);
	}

}
