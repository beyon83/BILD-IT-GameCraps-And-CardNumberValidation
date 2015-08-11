package GameCrapsAndCardNumberValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CreditCardValidation {
	
	/**
	 * (Financial: credit card number validation) Credit card numbers follow certain patterns.
	 * A credit card number must have between 13 and 16 digits. It must start with:
	 * ■ 4 for Visa cards
	 * ■ 5 for Master cards
	 * ■ 37 for American Express cards
	 * ■ 6 for Discover cards
	 * In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card
	 * numbers. The algorithm is useful to determine whether a card number is entered
	 * correctly or whether a credit card is scanned correctly by a scanner. Credit card
	 * numbers are generated following this validity check, commonly known as the
	 * Luhn check or the Mod 10 check, which can be described as follows (for illustration,
	 * consider the card number 4388576018402626):
	 * 
	 * 1. Double every second digit from right to left. If doubling of a digit results in a
	 * two-digit number, add up the two digits to get a single-digit number.
	 * 4388576018402626
	 * 2 * 2 = 4
	 * 2 * 2 = 4
	 * 4 * 2 = 8
	 * 1 * 2 = 2
	 * 6 * 2 = 12 (1 + 2 = 3)
	 * 5 * 2 = 10 (1 + 0 = 1)
	 * 8 * 2 = 16 (1 + 6 = 7)
	 * 4 * 2 = 8
	 * 
	 * 2. Now add all single-digit numbers from Step 1.
	 * 4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 37
	 * 
	 * 3. Add all digits in the odd places from right to left in the card number.
	 * 6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 38
	 * 
	 * 4. Sum the results from Step 2 and Step 3.
	 * 37 + 38 = 75
	 * 
	 * 5. If the result from Step 4 is divisible by 10, the card number is valid; otherwise,
	 * it is invalid. For example, the number 4388576018402626 is invalid, but the
	 * number 4388576018410707 is valid.
	 * 
	 * Write a program that prompts the user to enter a credit card number as a long
	 * integer. Display whether the number is valid or invalid. Design your program to
	 * use the following methods:
	 * 
	 *  ********* Return true if the card number is valid *********
	 *  public static boolean isValid(long number)
	 *  
	 *  ///////////////////////////////////////////////////////////
	 *  
	 *  ********* Get the result from Step 2 *********
	 *  public static int sumOfDoubleEvenPlace(long number)
	 *  
	 *  ///////////////////////////////////////////////////////////
	 *  
	 *  ********* Return this number if it is a single digit, otherwise, *********
	 *  ********* return the sum of the two digits *********
	 *  public static int getDigit(int number)
	 *  
	 *  ///////////////////////////////////////////////////////////
	 *  
	 *  ********* Return sum of odd-place digits in number *********
	 *  public static int sumOfOddPlace(long number)
	 *  
	 *  ///////////////////////////////////////////////////////////
	 *  
	 *  ********* Return true if the digit d is a prefix for number *********
	 *  public static boolean prefixMatched(long number, int d)
	 *  
	 *  ///////////////////////////////////////////////////////////
	 *  
	 *  ********* Return the number of digits in d *************
	 *  public static int getSize(long d)
	 *  
	 *  ///////////////////////////////////////////////////////////
	 *  
	 *  ********* Return the first k number of digits from number. If the *********
	 *  ********* number of digits in number is less than k, return number. *********
	 *  public static long getPrefix(long number, int k)
	 *  
	 *  ///////////////////////////////////////////////////////////
	 *  
	 *  Here are sample runs of the program: (You may also implement this program by
	 *  reading the input as a string and processing the string to validate the credit card.)
	 *  
	 *  Enter a credit card number as a long integer:
	 *  4388576018410707
	 *  4388576018410707 is valid
	 *  
	 *  Enter a credit card number as a long integer:
	 *  4388576018402626
	 *  4388576018402626 is invalid
	 */
	
	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		/** Check whether is number divisible by 10 */
		if(sumOfDoubleEvenPlace(number) % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		
		/** Create ArrayList to store separate numbers into it */
		List<Long> list = new ArrayList<>();
		
		/** Create another ArrayList to store multiplied every 
		 * second number from right to the left */
		ArrayList<Integer> list2 = new ArrayList<>();
		
		int result1 = 0; // result of the doubled numbers
		int sum = 0; // Final sum of the result1 + result2
		
		/** Separate long number into single digits */
		while(number > 0) {
			/** Add single digits into ArrayList
			 * note: numbers will be added to the List in reverse order */
			list.add(number % 10);
			number = number / 10;
		}
		
		/** Reverse numbers to get them into original position */
		Collections.reverse(list);
		
		int sum2 = 0; // Declare new sum to get doubled numbers
		
		/** Iterate through the ArrayList in reverse order, and double
		 * every second number, starting from the prefix of the last number */
		for(int i = list.size()-2; i >= 0; i = i - 2) {
			sum2 = (int) (list.get(i) * 2); // Multiply numbers by *2
			if(sum2 <= 9) { // if sum of numbers is lower than 10
				list2.add(sum2); // add numbers to the list2
			} else { // otherwise
				/** Call getDigit() method and add numbers into list2 */
				list2.add(getDigit((int) (list.get(i) * 2)));
			}
		}
		
		/** Sum doubled numbers from the list2 */
		for(int i = 0; i < list2.size(); i++) {
			result1 += list2.get(i);
		}
		
		/** Sum result1 and result2 and get result */
		sum = sumOfOddPlace(number, list) + result1;
		
		return sum;
	}
	
	/** Return this number if it is a single digit, otherwise, 
	 * return the sum of the two digits */
	public static int getDigit(int number) {
		/** If multiplied number is 10 or greater */
		if(number >= 10) { 
			/** then separate two numbers into single ones */
			int number1 = number % 10;
			int number2 = (int)(number / 10);
			/** and finally add two numbers and get result */
			return number1 + number2;
		}
		return number;
	}
	
	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number, List<Long> list) {
		int result2 = 0; // sum of the odd-place numbers 
		/** Iterate through the list in backward direction
		 * to sum every second number starting from the last digit */
		for(int i = list.size()-1; i >= 0; i = i - 2) {
			result2 += list.get(i);
		}
		return result2;
	}
	
	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number) {
		/** Convert number to string, so we can check if first character match to 4, 5, 6 or 37 */
		String num = String.valueOf(number);
		if(num.charAt(0) == '4' || num.charAt(0) == '5' || num.charAt(0) == '6' || num.substring(0, 2) == "37") {
			return true;
		} else {
			return false;
		}
	}
	
	/** Return the number of digits in d */
	public static int getSize(long d) {
		/** Convert d to String, so we can get size of the numbers using length() method */
		String digit = String.valueOf(d);
		return digit.length();
	}
	
///////////////////////////////////////////////////////////
	                 /** Main */
///////////////////////////////////////////////////////////	

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		/** Prompt the user to enter a card number */
		System.out.println("Enter a card number: ");
		long cardNumber = input.nextLong();
		
	//	long sum = sumOfDoubleEvenPlace(cardNumber);
	//	System.out.println(sum);
		
		/** Check whether card number is valid or not */
		if(isValid(cardNumber) == true && prefixMatched(cardNumber) == true && getSize(cardNumber) < 13 && getSize(cardNumber) > 16) {
			System.out.println("The card number is valid.");
		} else {
			System.out.println("The card number is NOT valid");
		}
		
		input.close();
	}
}
