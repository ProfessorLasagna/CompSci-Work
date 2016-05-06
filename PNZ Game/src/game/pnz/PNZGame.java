package game.pnz;

import java.util.Scanner;

public class PNZGame {
//PNZ Game by Benjamin MacKay
	
	public static int spaces = 0; 
	//Acts as the variable used to determine how many spaces should be printed between the pnz and the no. of tries
	
	public static int wincheck = 0;
	//Acts as the variables that determines if the user won the game
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int num1, num2, num3, userguess, tries = 1, playagain = 0, userchoice;
		//First three variables hold the three digits of the number to be guessed,
		//userguess stores the user's three digit guess, tries stores how many guesses the user takes,
		//playagain is used to determine whether or not the user would like to play another round,
		//and userchoice is used to store whether the user said yes or no to playing again

		System.out.format("Hello! Let's play the PNZ Game!"
				+ "%nIn order to play I will think of three, single digit numbers, and what position they will go in."
				+ "%nYou will then get to guess any three digits and I will tell you if any of the numbers you guessed are correct "
				+ "%nand if they are in the correct position! "
				+ "%n %nIf I say \"P\" then you got a number correct and in the right spot. "
				+ "%nIf I say \"N\" then you got a number correct but not in the right spot."
				+ "%nIf I say \"Z\" then you didn't get any number right!" + "%n %nGood Luck and Let's Play!%n");

		do{
			
			wincheck = 0; 	  //Resets the user's winstate in order for them to play another game
			tries = 1;	   	  //Resets the user's tries in order for them to play another game
			num1 = randNum(); //Generates the first random digit
			num2 = randNum(); //Generates the second random digit
			num3 = randNum(); //Generates the third random digit
			
			System.out.format("%nGuessed #       PNZ       No. of Guesses"
					+ "%n---------       ---       --------------%n  ");
			
			do{
				
				spaces = 0; //Resets how many spaces are printed between the pnz and the no. of tries
				
				userguess = in.nextInt();	
				System.out.print("                ");
				
				evaluateGuess(userguess, num1, num2, num3); //Sends the user's guess as well as the three random digits to be assessed
				spacePrinter(); //Runs the method that will print the proper number of spaces between pnz and no. of guesses
				
				System.out.format("%d%n  ", tries);
				tries++; //Increments the amount of tries the user has taken by one
				
				if(wincheck == 1){
					//If the user won the game
					
					System.out.format("%n %nCongratulations, You won!"
							+ "%nIf you would like to go another round a new number will be generated."
							+ "%nWould like to play again? (Y/N)%n");
					userchoice = in.next().toUpperCase().charAt(0);
					
					if(userchoice == 78){
						//If the user said not to play again
						
						System.out.format("%nGoodbye!");
						playagain = 1; //Makes the while loop false
						
					}
					
				}
				
			}while(wincheck == 0);
			//While the user has yet to win
			
		}while(playagain == 0);
		//While the user chooses to continue playing

		in.close();
		
	}//End main

	public static int randNum() {
		//The method used to generate the random number

		int randnum;

		randnum = (int) (9 * Math.random());
		//Randomly generates a random, one digit number, between 0 and nine;

		return randnum;

	}//End randNum

	public static void evaluateGuess(int userguess, int num1, int num2, int num3){
		//The method that evaluates the user's guess and determines what combination of PNZ to print 
		//as well as whether or not the user won the game
		
		int digit1, digit2, digit3, number, check1 = 0, check2 = 0, check3 = 0, zcheck = 0, pcheck1 = 0, pcheck2 = 0, pcheck3 = 0, numguess;
		//The first three variables are created to store the values of each digit of the user's input,
		//The number variable holds the full generated number, checks one through three are used to store whether the user got any P's,
		//The zcheck variable is used to store whether or not the user failed to get any numbers correct,
		//The pcheck variables is used to store whether or not one digit needs to evaluated against another
		//numguess is used to store the user's guess as a full number
		
		digit3 = userguess % 10;          
		digit2 = (userguess / 10) % 10;
		digit1 = (int) (userguess / 100);
		//Converts the user's guess into three individual digits
		
		number = (num1 * 100) + (num2 * 10) + (num3);
		//Converts the three individual generated numbers into one number
		
		if(((digit1 * 100) + (num2 * 10) + (num3)) == number){
			//The next three "if" statements will check to see if the user entered the correct digit in the correct spot
			
			System.out.format("P");
			check1 = 9;  //Makes it so the program doesn't print an "N" for this digit
			zcheck = 1;  //Makes sure that a "Z" does not get printed
			pcheck1 = 1; //Sets the this placement to correct so the other "if" statements don't check this
			spaces++;    //Increments the amount of spaces needed to be printed after the"PNZ" has been printed
			
		}
		
		if(((digit2 * 10) + (num1 * 100) + (num3)) == number){
			
			System.out.format("P");
			check2 = 9;
			zcheck = 1;
			pcheck2 = 1;
			spaces++;
			
		}
		
		if (((digit3) + (num1 * 100) + (num2 * 10)) == number){
			
			System.out.format("P");	
			check3 = 9;
			zcheck = 1;
			pcheck3 = 1;
			spaces++;
			
		}
		
		if(check1 == 0 && ((pcheck2 == 0 && digit1 == num2) ||(pcheck3 == 0 && digit1 == num3))){
			//The next three "if" statements will, if no "P" was printed in their position, check to see if an "N" should be printed 
			
			System.out.format("N");	
			zcheck = 1;
			spaces++;
			
		}
		
		if(check2 == 0 && ((pcheck1 == 0 && digit2 == num1) || (pcheck3 == 0 && digit2 == num3))){
			
			System.out.format("N");	
			zcheck = 1;
			spaces++;
			
		}
		
		if(check3 == 0 && ((pcheck2 == 0 && digit3 == num2) || (pcheck1 == 0 && digit3 == num1))){
			
			System.out.format("N");	
			zcheck = 1;
			spaces++;
			
		}
		
		if(zcheck == 0){
			//If not a single digit was correct
			
			System.out.format("Z");
			spaces++;
			
		}
		
		numguess = (digit1 * 100) + (digit2 * 10) + (digit3);
		//Turns the user's input back into  a whole number
		
		if(numguess == number){
			//If the user's guessed number is the same as the generated number
			
			wincheck = 1;
			//Sets the games win status to true
			
		}
		
	}//End evaluateGuess
	
	public static void spacePrinter(){
		//The method that will print the spaces after the "PNZ" in order to ensure everything is lined up
		
		if(spaces == 1){
			//If only one letter was printed
		
			for(int a = 0; a < 15; a++){
			
			System.out.print(" ");
			
			}
		
		}else if(spaces == 2){
			//If two letters were printed
			
			for(int a = 0; a < 14; a++){
				
				System.out.print(" ");
			
			}
		
		}else if(spaces == 3){
			//If three letters were printed
			
			for(int a = 0; a < 13; a++){
				
				System.out.print(" ");
			
			}
	
		}

	}//End spacePrinter	

}