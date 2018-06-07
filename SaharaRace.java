// Author: Alexis Dionne
// This program makes 4 teams race against each other and decide of a winner
// Started on: 06/06/2018
// Last updated on: 06/06/2018

import java.util.Scanner;
import java.util.Random;

public class SaharaRace {

	public static void main(String[] args) {
		// variables
		final int LENGTH_OF_RACE = 20, NUMBER_OF_TEAMS = 4;
		int[] team_position = new int[LENGTH_OF_RACE];
		int[] slopes = new int[LENGTH_OF_RACE];
		String[] team_names = new String[NUMBER_OF_TEAMS];
		int team_id = 0;
		Scanner keyboard = new Scanner(System.in);
		String userInput;
		int move;
		int random_number;
		boolean is_winning = false;
			
		// greetings
		System.out.println("******* WELCOME TO THE SAHARA RACE! *******");
		System.out.println();
		
		// naming the teams
		for (int i = 0; i < NUMBER_OF_TEAMS; ++i) {
			System.out.print("What is the name of team #" + ((team_id % NUMBER_OF_TEAMS) + 1) + "? ");
			team_names[i] = keyboard.nextLine();
			team_id++;
		}
		
		// setting up the slopes
		for (int i = 0; i < LENGTH_OF_RACE; ++i) {
			random_number = (int)(Math.random()*5-3);
			slopes[i] = random_number;
		}
		
		// printing the array
		System.out.println();
		System.out.println("The random slopes are:");
		for (int i = 0; i < LENGTH_OF_RACE; ++i) {
			System.out.print(slopes[i] + " ");
		}
		
		// main loop
		do {
			// DAY MOVE
			// team 1 moves
			random_number = (int)(Math.random ()*100);
			if (random_number < 50) 						// 50% of time, do not move
				move = 0;
			if (random_number >= 50 && random_number < 70) 	// 30% of time, drive 4km
				move = 4;
			else 
				move = 3; 									// 20% of the time, move 3km
			team_position[0] += move;
			
			// team 2 moves
			move = 2;										// always move by 2
			team_position[1] += move;
			
			// team 3 moves
			random_number = (int)(Math.random ()*100);
			if (random_number < 30)							// 30% of time, do not move
				move = 0;
			else
				move = 3;									// 70% of time, move 3
			team_position[2] += move;
			
			// team 4 moves
			random_number = (int)(Math.random ()*100);
			if (random_number < 80)							// 80% of time, move 1
				move = 1;
			else
				move = 10;									// 20% of time, move 10
			team_position[3] += move;
			
			// NIGHT MOVE
			for (int i = 0; i < NUMBER_OF_TEAMS; ++i) {
				if (slopes[team_position[0]] < 0 ) {
					
				}
					
			}
		}
		while (!is_winning);
		


	}

}
