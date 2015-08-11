package GameCrapsAndCardNumberValidation;

import java.util.Random;

public class GameCraps {
	
	/**
	 * (Game: craps) Craps is a popular dice game played in casinos. Write a program
	 * to play a variation of the game, as follows:
	 * Roll two dice. Each dice has six faces representing values 1, 2, …, and 6, respectively.
	 * Check the sum of the two dice. If the sum is 2, 3, or 12 (called craps), you
	 * lose; if the sum is 7 or 11 (called natural), you win; if the sum is another value
	 * (i.e., 4, 5, 6, 8, 9, or 10), a point is established. Continue to roll the dice until either
	 * a 7 or the same point value is rolled. If 7 is rolled, you lose. Otherwise, you win.
	 * Your program acts as a single player. Here are some sample runs.
	 * 
	 * You rolled 5 + 6 = 11
	 * You win
	 * 
	 * You rolled 1 + 2 = 3
	 * You lose
	 * 
	 * You rolled 4 + 4 = 8
	 * point is 8
	 * 
	 * You rolled 6 + 2 = 8
	 * You win
	 * 
	 * You rolled 3 + 2 = 5
	 * point is 5
	 * 
	 * You rolled 2 + 5 = 7
	 * You lose
	 */
	
///////////////////////////////////////////////////////////////	
	
	public static void main(String[] args) {
		
		/** Random object */
		Random rand = new Random();
		
		int sum = 0; // Sum of two dices
		int point = 0; // Point for 4, 5, 6, 8, 9, and 10
		
		int dice1 = 1 + rand.nextInt(6); // Dice 1 randomly rolled
		int dice2 = 1 + rand.nextInt(6); // Dice 2 randomly rolled
		
		sum = dice1 + dice2; // Sum two dices
		
		System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);
		 
		if(sum == 2 || sum == 3 || sum == 12) { // if sum equals 2, e, or 12 you lose
			System.out.println("You lose!");
			System.exit(0);
		} else if(sum == 7 || sum == 11) { // if sum equals 7 or 11, you win
			System.out.println("You win!");
			System.exit(1);
		} else {
			System.out.println("Point is " + sum); // otherwise if sum is 4, 5, 6, 8, 9, or 10
			point = sum; // point is established, assign sum to the point variable and continue with rolling
		}
		
		boolean gameContinue = true; // Create boolean and initially set it to true
		
		int sum2 = 0; // Create second sum for continue game
		
		while(gameContinue) {
			int dice1Continue = 1 + rand.nextInt(6);
			int dice2Continue = 1 + rand.nextInt(6);
			
			/** Result of continue roll */
			sum2 = dice1Continue + dice2Continue;
			
			System.out.println("You rolled " + dice1Continue + " + " + dice2Continue + " = " + sum2);
			
			if(sum2 == 7) { // if sum is 7, you lose
				System.out.println("You lose!");
				System.exit(2);
			} else if(sum2 == point) { // if sum is point, you win
				System.out.println("You win!");
				gameContinue = false;
			} else { // otherwise point is established
				System.out.println("Point is " + sum2);
				point = sum2;
				gameContinue = true;
			}
			
		}
		
	}
}
