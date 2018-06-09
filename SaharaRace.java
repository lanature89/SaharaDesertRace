// Author: Alexis Dionne
// This program makes 4 teams race against each other and decide of a winner
// Started on: 06/06/2018
// Last updated on: 09/06/2018

import java.util.Scanner;
import java.util.Random;

public class SaharaRace {

	public static void main(String[] args) {
		// ========================================= VARIABLES =========================================
		final int LENGTH_OF_RACE = 20;
		int[] slopes = new int[LENGTH_OF_RACE];
		int[] team_position_no_slopes = new int[4];
		int[] team_position_with_slopes = new int[4];
		int[] team_movement = new int [4];
		int number_of_days = 1;
		int random_number;
		boolean is_winning = false;
		Scanner keyboard = new Scanner(System.in);
		//int team1_move, team2_move, team3_move, team4_move = 0;
		int slope_effect = 0;
		int number_of_winners = 0;
		String[] team_names = new String[4];
		String winning_team = "";
		int team_id = 0;
		int final_position = 0;
		
		// ========================================= GREETINGS =========================================
		System.out.println("******* WELCOME TO THE SAHARA RACE! *******");
		System.out.println();
		
		// naming the 4 teams and setting up their initial position at 1.
		for (int i = 0; i < 4; ++i) {
			System.out.print("What is the name of team #" + (i+1) + "? ");
			team_names[i] = keyboard.nextLine();
			team_position_no_slopes[i] = 1;
		}

		// setting up and printing the slopes
		System.out.print("\nThe random slopes are:");
		for (int i = 0; i < LENGTH_OF_RACE; ++i) {
			random_number = (int)(Math.random()*5-3);
			slopes[i] = random_number;
			System.out.print(" " + slopes[i]);
		}
		
		// ========================================= DAY LOOP =========================================
		do {
			// print out day # and update day counter
			System.out.print("\n\nDAY #" + number_of_days);
			number_of_days ++;
			
			// ========================================= MOVEMENT =========================================
			// team 1 day movement
			random_number = (int) (Math.random ()*100);
			if (random_number < 50) { // 50% of time,
				team_movement[0] = 0;
			}
			else if  (random_number >= 50 && random_number < 80) {
				team_movement[0] = 4;
			} else {
				team_movement[0] = 3;
			}
			
			// team 2 day movement
			random_number = (int) (Math.random ()*100);
			if (random_number < 30) {
				team_movement[1] = 0;
			} else {
				team_movement[1] = 3;
			}
			
			// team 3 day movement
			team_movement[2] = 2;
			
			// team 4 day movement
			random_number = (int) (Math.random ()*100);
			if (random_number < 80) {
				team_movement[3] = 1;
			} else {
				team_movement[3] = 10;
			}
			
			// BIG LOOP
			
			
			// DEBUG
			System.out.print("\nRandom number: " + random_number + " move: " + team_movement[0]);
			
			// PRINT team 1 current position
			System.out.print("\nTeam 1 -- " + team_names[0] + " is at position " + team_position_no_slopes[0]);
			
			// team 1 updated position
			team_position_no_slopes[0] += team_movement[0];
			
			// team 1 night movement
			if (slopes[team_position_no_slopes[0]] == 0) {
				slope_effect = 0;
			} else if (slopes[team_position_no_slopes[0]] != 0) { 	// slopes
				slope_effect = team_position_no_slopes[0] - (slopes[team_position_no_slopes[0]] * team_movement[0]);
			}
			team_position_with_slopes[0] = slope_effect+team_position_no_slopes[0];
			// check if final position will be below 0
			if (team_position_with_slopes[0] < 1) {
				team_position_no_slopes[0] = 1;
			}
			
			// NIGHT MOVEMENT DEBUG
			System.out.print("\nTeam position " + team_position_no_slopes[0] + " - (" + slopes[team_position_no_slopes[0]] + " * " + team_movement[0] + ")" + " = " + slope_effect);
			
			// PRINT team 1 final position
			System.out.print("\nThey drive " + team_movement[0] + "km, but at position " + team_position_no_slopes[0]
					+ " there is a slope of " + slopes[team_position_no_slopes[0]] + " so they slip by "
					+ slope_effect + "km and end up at position " + (team_position_no_slopes[0] + slope_effect));
			// update team final position
			team_position_no_slopes[0] += slope_effect;
			
			// PRINT potential winner
			if (team_position_no_slopes[0] >= 20)
				System.out.print("\nWe might have a potential winner...");
				
			// Winning Condition
			for (int i = 0; i < 4; ++i) {
				if (team_position_no_slopes[i] >= 20) {
					is_winning = true;
					number_of_winners ++;
					winning_team = team_names[i];
					team_id = (i+1);
				}
			}
		}
		while(!is_winning || number_of_days > 40);
		
		// Winning Statement
		if (number_of_winners == 1) {
			System.out.print("\n\nTeam " + team_id + " -- " + winning_team + " wins!!!");
		} else if (number_of_winners > 1) {
			System.out.print("\nIt's a tie!");
		}
	}

}
