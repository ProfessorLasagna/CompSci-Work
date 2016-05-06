package rng2thereturn;

import java.util.Scanner;
import java.util.InputMismatchException;

public class RNG2TheReturn {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		String username = null; // Stores the name entered by the user
		int randnum = 0, quit = 1, winstate = 0, guess; // Creates the quit and
														// winstate variables so
														// that the game doesn't
														// stop until the user
														// wins or decides to
														// quit
														// Also creates the
														// random number
														// variable that will be
														// defined by the
														// getRandomnumber
														// method

		System.out.format("Hello there! Today we are going to play a guessing game. I'll start by thinking of a number and then you guess!"
						+ "%nBefore we begin why don't you tell me your name?%n");

			
		username = in.nextLine();

		System.out.format("Nice to meet you %s! I've already figured out my number so let's begin!%n", username);

		while (quit == 1) {
			// Until the user chooses to quit

			winstate = 0;
			// Resets the user's win status so that they can play a new game

			System.out.format("The number will be between 100 and 200."
					+ "%nGo ahead and take a guess and then I'll tell you whether you need to guess higher or lower, good luck!%n");

			randnum = getRandomInteger();
			// Assigns the games random number, calling from the random number
			// method

			do {

				guess = getGuess();
				// Calls the getGuess method in order to assign the user's guess
				// to the guess variable

				if (guess == randnum) {
					// If the user guesses the correct number

					System.out.format("Congratulations %s! The number I was thinking of was %d! Great work!"
									+ "%nIf you want to play again please type 1 otherwise press 2.%n",username, randnum);
							
							

					quit = in.nextInt();
					// Checks to see if the user wishes to play again

					winstate = 1;
					// Changes the winstate to a win

				} else if(guess == -1){
				
					
					
				}else if (guess < randnum) {
					// If the user guessed to low

					System.out.format("You need to go higher!%n");

				} else if (guess > randnum) {
					// If the user guessed to high

					System.out.format("You need to go lower!%n");
				}

			} while (winstate == 0);
			// Will continue to loop until the user wins the game

		}

		System.out.format("Goodbye %s! Thanks for playing!", username);

		in.close();

	}

	public static int getRandomInteger() {
		// Method for generating the random number to be used in the game

		int randnum;

		randnum = (int) (100 * Math.random() + 100);
		// Creates a random number between 100 and 200

		return randnum;

	}

	public static int getGuess() {
		// Method for taking the user's guesses

		int userguess = 0;		

			try {
				
				userguess = in.nextInt();
				
			} catch (InputMismatchException e) {
				// If the user enters something other than an acceptable number
				// then it catches the error and informs the user of what they
				// did wrong.

				in.nextLine();
				System.out.println("That is not a number!");
				userguess = -1;
				
		}

		return userguess;

	}

}
