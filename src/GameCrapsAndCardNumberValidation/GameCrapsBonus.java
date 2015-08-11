package GameCrapsAndCardNumberValidation;

import java.util.Random;

public class GameCrapsBonus {
	
	/**
	 * (Game: chance of winning at craps) Revise Exercise 6.30 to run it 10,000 times
	 * and display the number of winning games.
	 */

	public static void main(String[] args) {
		
		/** Random object */
		Random rand = new Random();
		
		int win = 0;
		int lose = 0;
		
		int sum = 0; // Sum of two dices
		int point = 0; // Point for 4, 5, 6, 8, 9, and 10
		
		int dice1 = 1 + rand.nextInt(6); // Dice 1 randomly rolled
		int dice2 = 1 + rand.nextInt(6); // Dice 2 randomly rolled
		
		sum = dice1 + dice2; // Sum two dices
		
		if(sum == 2 || sum == 3 || sum == 12) { // if sum equals 2, e, or 12 you lose
			lose++;
		} else if(sum == 7 || sum == 11) { // if sum equals 7 or 11, you win
			win++;
		} else {
			point = sum; // point is established, assign sum to the point variable and continue with rolling
		}
		
		int sum2 = 0; // Create second sum for continue game
		
		int counter = 0;
		
		while(counter < 10000) {
			int dice1Continue = 1 + rand.nextInt(6);
			int dice2Continue = 1 + rand.nextInt(6);
			
			/** Result of continue roll */
			sum2 = dice1Continue + dice2Continue;
			
			if(sum2 == 7) { // if sum is 7, you lose
				lose++;
				counter++;
			} else if(sum2 == point) { // if sum is point, you win
				win++;
				counter++;
			} else { // otherwise point is established
				point = sum2;
			}
		}
		
		System.out.println("You won " + win + " times.");
		System.out.println("You lost " + lose + " times.");
		
	}

}
