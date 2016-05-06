package simplecalc;

import java.util.Scanner;

public class SimpleCalc {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int loopcheck = 0; // Variable that will be used to check if the user would like to exit the program
		double number1 = 0, number2 = 0; // The variables for the user's two number inputs
		char input = 0; // The variable for determining what operation the user would like to perform

		System.out.format("This is a simple calculator.%n");

		do {

			System.out.format("Please enter the type of calculation you would like to do. (+,-,*,/,Exit)%n");

			for (int b = 0; b < 1;) {
				// A loop that will continue until the user has selected an
				// operation

				input = in.next().toUpperCase().charAt(0);

				if (input != 43 && input != 45 && input != 42 && input != 47 && input != 69) {
					// Checks to see if the user chose something other than the
					// predefined operations

					System.out.format("That is not a valid input. Please try again.%n");
					b = -1;

				}

				b++;

			}

			if (input == 69) {
				// If the user chooses to exit the program

				System.out.format("Goodbye!%n");
				break;

			}

			System.out.format("Please enter the first number: ");

			number1 = in.nextDouble();

			for (int a = 0; a < 1;) {
				// A loop for ensuring the user does not choose zero as their
				// second number when dividing

				System.out.format("Please enter the second number: ");

				number2 = in.nextDouble();

				if (input == 47 && number2 == 0) {
					// If the user chose to divide and their second number was
					// zero

					System.out.format("You cannot divide by zero!%n");

				} else {

					a++;

				}

			}

			switch (input) {
			// Takes the users input and determines which operation method to
			// call

			case 43:
				System.out.format("The result is: %.2f%n", add(number1, number2)); // For adding																	
				break;

			case 45:
				System.out.format("The result is: %.2f%n", subtract(number1, number2)); // For subtracting
				break;

			case 42:
				System.out.format("The result is: %.2f%n", multiply(number1, number2)); // For multiplying
				break;

			case 47:
				System.out.format("The result is: %.2f%n", divide(number1, number2)); // For dividing
				break;

			}

		} while (loopcheck == 0);
		// Continues until broken out of when the user decides to exit

		in.close();

	}//end main

	public static double add(double number1, double number2) {
		// Method for adding, takes the two provided inputs and adds them
		// together, returning the result

		double sum;

		sum = number1 + number2;

		return sum;

	}//end add

	public static double subtract(double number1, double number2) {
		// Method for subtracting, takes the two provided inputs and subtracts
		// them, returning the result

		double difference;

		difference = number1 - number2;

		return difference;

	}//end subtract

	public static double multiply(double multiple1, double multiple2) {
		// Method for multiplying, takes the two provided inputs and multiplies
		// them together, returning the result

		double product;

		product = multiple1 * multiple2;

		return product;

	}//end multiply

	public static double divide(double dividend, double divisor) {
		// Method for dividing, takes the two provided inputs and divides them,
		// returning the result

		double quotient;

		quotient = dividend / divisor;

		return quotient;

	}//end divide

}
