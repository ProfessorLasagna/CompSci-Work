/**
COPYRIGHT © 2015 BENJAMIN MACKAY. All Rights Reserved. 
Bank Machine
@author benjaminmackay52@gmail.com                                                                                                    
@version 2.0 2015-11-27
 */

package bankmachine;

import java.util.Scanner;
import java.util.InputMismatchException;

public class BankMachine {

	private static int[] accountnumber = new int[4]; //Creates the account number array that will hold up to five account numbers.
	private static String[] username = new String[4]; //Creates the account username array that will hold up to five account names.
	private static int[] pin = new int[4]; //Creates the account pin array that will hold up to five account pins.
	private static double[] balance = new double[4]; //Creates the balance array that will hold up to five account balances.
	private static int arrayindexregister = 0, arrayindexlogin = 0, loopcheck; 
	//Creates the arrayindex register variable that will be used to assign the users account to the correct account and ensures only five accounts can be created. 
	//The same goes for arrayindex login. Finally the loopcheck variable will be used in multiple areas throughout the program to ensure it remains running when it is supposed too. 
	private static Scanner in = new Scanner(System.in); 

	private static char mainmenu(){

		char input;	
		//Creates a char that will be assigned as the users selection in this menu.

		System.out.format("* * * * * * * * * * * * * * * * * * * %n"
				+ "*                                   * %n"
				+ "*                                   * %n"
				+ "*           A) Login                * %n"
				+ "*                                   * %n"
				+ "*           B) Create account       * %n"
				+ "*                                   * %n"
				+ "*                                   * %n"
				+ "* * * * * * * * * * * * * * * * * * * %n");

		input = in.next().toUpperCase().charAt(0);
		return(input);
		//Returns the users input back to main to interpret their decision.

	}
//The method that will execute every time the main menu appears. It will display the menu as well as accept the users input which will be relayed back to the main method.
	private static char loggedin(){

		char input;	
		//Creates the char that will be assigned as the users input.

		System.out.format("* * * * * * * * * * * * * * * * * * * %n"
				+ "* Hello %-15.15s             * %n"
				+ "*                                   * %n"
				+ "*     A) Check Balance              * %n"
				+ "*     B) Deposit                    * %n"
				+ "*     C) Withdraw                   * %n"
				+ "*     D) Logout                     * %n"
				+ "*                                   * %n"
				+ "* * * * * * * * * * * * * * * * * * * %n", username[arrayindexlogin]); //Prints the user's name located at the index defined by the arrayindexlogin variable.


		input = in.next().toUpperCase().charAt(0);
		return(input);
		//Returns the users input back to main to interpret his decision.
	}
//The method that will execute after the user has logged in. 
	private static void login(){

		int accountinput = 0, pininput = 0, accountcheck = 0;
		//Creates the 3 variables that will check the users input against what is in the system.

		for(int b = 0; b < 4; b++){

			System.out.format("* * * * * * * * * * * * * * * * * * * %n"
					+ "*                                   * %n"
					+ "*                                   * %n"
					+ "*           Please enter            * %n"
					+ "*     your six-digit account        * %n"
					+ "*             number:               * %n"
					+ "*                                   * %n"
					+ "*                                   * %n"
					+ "* * * * * * * * * * * * * * * * * * * %n");
			try{
			//Attempts to accept the user's input.
				
			accountinput = in.nextInt();
			
			} catch (InputMismatchException e) {
				//If the user enters something other than an acceptable number then it catches the error and informs the user of what they did wrong.

				System.out.println("That is not a number!");

			}
			
			for(int a = 0; a < 4; a++){
				//Loops five times to check the user's input against the preset account number's.

				if(accountinput == accountnumber[a]){
					//Checks to see if the users input is equal to an existing account.

					arrayindexlogin = a;
					//If the account exists this variable is set to that account value to be used for the rest of the login.
					
					System.out.format("* * * * * * * * * * * * * * * * * * *  %n"
							+ "*                                   * %n"
							+ "*     Please enter your four        * %n"
							+ "*            digit PIN:             * %n"
							+ "*                                   * %n"
							+ "*                                   * %n"
							+ "*                                   * %n"
							+ "*                                   * %n"
							+ "* * * * * * * * * * * * * * * * * * *%n");
					try{
						//Attempts to accept the user's input.
						
					pininput = in.nextInt();
					
					} catch (InputMismatchException e) {
						//If the user enters something other than an acceptable number then it catches the error and informs the user of what they did wrong.

						System.out.println("That is not a number!");

					}

					for(int c = 0; c < 4; c++){
						//Loops five times to check the user's input against the existing PIN's.

						if(pininput == pin[arrayindexlogin]){
							//If the user enters the correct PIN corresponding to the account number.

							System.out.format("* * * * * * * * * * * * * * * * * * *  %n"
									+ "*                                   * %n"
									+ "*      You are now logged in.       * %n"
									+ "*     Please bank responsibly!      * %n"
									+ "*                                   * %n"
									+ "*                                   * %n"
									+ "*                                   * %n"
									+ "*                                   * %n"
									+ "* * * * * * * * * * * * * * * * * * *%n");
							
							loopcheck = 1;
							a = 5;
							b = 5; //These end all of the loops in order to "log" the user into the their account and return them to the main method.
							c = 5;
							accountcheck = 1;
						}
					}
				}
			}


			if(accountcheck == 0){
				//If the number the user entered does not exist in the array.

				System.out.format("* * * * * * * * * * * * * * * * * * *  %n"
						+ "*                                   * %n"
						+ "*      This account does not        * %n"
						+ "*     exist, please try again.      * %n"
						+ "*                                   * %n"
						+ "*                                   * %n"
						+ "*                                   * %n"
						+ "*                                   * %n"
						+ "* * * * * * * * * * * * * * * * * * *%n");
				accountcheck = 0;

			}

		}

	}

	private static void register(){

		int pininput;
		String nameinput;
		//Creates the 2 variables that will be used during the users registration and will be used to assign the corresponding array values.

		if(arrayindexregister < 4){

			for(int a = 0; a < 1;){
				//This section of the program will loop until the user has entered an acceptable account number.

				System.out.format("* * * * * * * * * * * * * * * * * * * %n"
						+ "*                                   * %n"
						+ "*                                   * %n"
						+ "*         Your six-digit            * %n"
						+ "*        account number is:         * %n"
						+ "*             %06d                * %n"
						+ "*                                   * %n"
						+ "*       Please remeber it!          * %n"
						+ "* * * * * * * * * * * * * * * * * * * %n", accountnumber[arrayindexregister] ); //Prints the account number existing at the index based on how many accounts have been created.


				for(a = 0; a < 1;){
					//Will continuously loop until the user enter's a valid pin.

					System.out.format("* * * * * * * * * * * * * * * * * * *  %n"
							+ "*                                   * %n"
							+ "*       Please enter a four         * %n"
							+ "*            digit PIN:             * %n"
							+ "*                                   * %n"
							+ "*                                   * %n"
							+ "*                                   * %n"
							+ "*                                   * %n"
							+ "* * * * * * * * * * * * * * * * * * *%n");

					pininput = in.nextInt();
					nameinput = in.nextLine();

					if(pininput < 1000 || pininput > 9999){
						//If the user's input is not 4 digits.

						System.out.format("* * * * * * * * * * * * * * * * * * * %n"
								+ "*               ERROR               * %n"
								+ "*                                   * %n"
								+ "*            Your PIN               * %n"
								+ "*             must be               * %n"
								+ "*           four digits.            * %n"
								+ "*                                   * %n"
								+ "*        Please try again           * %n"
								+ "* * * * * * * * * * * * * * * * * * * %n");

					}

					else{

						pin[arrayindexregister] = pininput;
						//Sets the input to the index of the same value as their account number location.

						System.out.format("* * * * * * * * * * * * * * * * * * *  %n"
								+ "*                                   * %n"
								+ "*         Please enter your         * %n"
								+ "*              name:                * %n"
								+ "*      (Maximum 15 characters)      * %n"
								+ "*                                   * %n"
								+ "*                                   * %n"
								+ "*                                   * %n"
								+ "* * * * * * * * * * * * * * * * * * *%n");

						nameinput = in.nextLine();
						username[arrayindexregister] = nameinput;
						balance[arrayindexregister] = 0;
						//Accepts the user's input and defines it as the name of the same value as their account number location.
						//Now that the account is registered the user's balance is set to zero.

						System.out.format("* * * * * * * * * * * * * * * * * * *  %n"
								+ "*                                   * %n"
								+ "*            Thank you!             * %n"
								+ "*                                   * %n"
								+ "*        Your account has           * %n"
								+ "*        been registered!           * %n"
								+ "*       You may now login.          * %n"
								+ "*                                   * %n"
								+ "* * * * * * * * * * * * * * * * * * *%n");

						arrayindexregister++;
						a++;
						//This ends the registration loop. and the user will be taken to the account screen.
					}

				}

			}

		}



		else{

			System.out.format("* * * * * * * * * * * * * * * * * * *  %n"
					+ "*                                   * %n"
					+ "*              Sorry!               * %n"
					+ "*                                   * %n"
					+ "*    This bank machine can only     * %n"
					+ "*     hold up to five accounts.     * %n"
					+ "*                                   * %n"
					+ "*                                   * %n"
					+ "* * * * * * * * * * * * * * * * * * *%n");

		}

	}

	private static void balancecheck(){

		@SuppressWarnings("unused")
		char input;

		System.out.format("* * * * * * * * * * * * * * * * * * * %n"
				+ "*                                   * %n"
				+ "*       Your balance is:            * %n"
				+ "*            $%-22.2f* %n"
				+ "*                                   * %n"
				+ "*        Enter any key to           * %n"
				+ "*       return to the menu.         * %n"
				+ "*                                   * %n"
				+ "* * * * * * * * * * * * * * * * * * * %n", balance[arrayindexlogin]);//Prints the user's balance at the index specified during  the login process.	

		input = in.next().toUpperCase().charAt(0);
		//Lets the user press "any" key to continue.

	}

	private static void deposit(){

		char input;
		int loopdeposit;
		double deposit;

		do{
			//Begins a loop that will continue until the user has finished making deposits.

			loopdeposit = 0;
			deposit = 0;

			System.out.format("* * * * * * * * * * * * * * * * * * * %n"
					+ "*                                   * %n"
					+ "*                                   * %n"
					+ "*     Please enter the amount       * %n"
					+ "*     to be deposited:              * %n"
					+ "*                                   * %n"
					+ "*                                   * %n"
					+ "*                                   * %n"
					+ "* * * * * * * * * * * * * * * * * * * %n");
			try{
				
			deposit = in.nextDouble();
			//Allows the user to define their deposit amount.
			
			} catch (InputMismatchException e) {

				System.out.println("That is not a number!");

			}

			if(deposit < 0){
				//Prevents the user from depositing a negative amount.

				System.out.format("* * * * * * * * * * * * * * * * * * * %n"
						+ "*             ERROR                 * %n"
						+ "*                                   * %n"
						+ "*          You cannot               * %n"
						+ "*   deposit a negative amount.      * %n"
						+ "*                                   * %n"
						+ "*                                   * %n"
						+ "*       Please try again            * %n"
						+ "* * * * * * * * * * * * * * * * * * *%n");

			}

			else{

				balance[arrayindexlogin] = balance[arrayindexlogin] + deposit;
				//Adds the user's deposit to their balance.

				System.out.format("* * * * * * * * * * * * * * * * * * * %n"
						+ "*                                   * %n"
						+ "*              $%-20.2f* %n"
						+ "*           succesfully             * %n"
						+ "*           deposited.              * %n"
						+ "*      Would you like to make       * %n"
						+ "*         another deposit?          * %n"
						+ "*              (Y/N)                * %n"
						+ "* * * * * * * * * * * * * * * * * * * %n", deposit);

				input = in.next().toUpperCase().charAt(0);
				//Lets the user decide if they want to make another deposit.

				if(input == 78){
					//If the user is finished making deposits the loop is ended and they are returned to the mainmenu.

					loopdeposit = 1;
					//Ends the loop.

				}

			}

		}while(loopdeposit == 0);
		//Checks to see if the user is done making deposits.

	}

	private static void withdraw(){

		char input;
		int loopwithdrawal = 0;

		do{

			//Begins allowing the user to make withdrawals until the user decides they are finished.
			double withdrawal = 0;

			//Resets the loop

			System.out.format("* * * * * * * * * * * * * * * * * * * %n"
					+ "*                                   * %n"
					+ "*                                   * %n"
					+ "*     Please enter the amount       * %n"
					+ "*     to be withdrawn:              * %n"
					+ "*                                   * %n"
					+ "*                                   * %n"
					+ "*                                   * %n"
					+ "* * * * * * * * * * * * * * * * * * * %n");
			try {

				withdrawal = in.nextDouble();
				//Defines the users input as the amount they are withdrawing.

			} catch (InputMismatchException e) {

				System.out.println("That is not a number!");

			}
			if(withdrawal < 0){
				//Provides an error if the user attempts to withdraw a negative amount.

				System.out.format("* * * * * * * * * * * * * * * * * * * %n"
						+ "*              ERROR                * %n"
						+ "*                                   * %n"
						+ "*           You cannot              * %n"
						+ "*    withdraw a negative amount.    * %n"
						+ "*                                   * %n"
						+ "*                                   * %n"
						+ "*         Please try again          * %n"
						+ "* * * * * * * * * * * * * * * * * * * %n");

			}

			else if(withdrawal > balance[arrayindexlogin]){
				//Provides an error if the user attempts to withdraw more than they have in their balance.

				System.out.format("* * * * * * * * * * * * * * * * * * * %n"
						+ "*               ERROR               * %n"
						+ "*                                   * %n"
						+ "*             You cannot            * %n"
						+ "*    withdraw a more than your      * %n"
						+ "*         current  balance.         * %n"
						+ "*                                   * %n"
						+ "*         Please try again          * %n"
						+ "* * * * * * * * * * * * * * * * * * *%n");

			}

			else{

				balance[arrayindexlogin] = balance[arrayindexlogin] - withdrawal;
				//Removes the specified amount from the users balance.

				System.out.format("* * * * * * * * * * * * * * * * * * * %n"
						+ "*                                   * %n"
						+ "*             $%-21.2f* %n"
						+ "*          succesfully              * %n"
						+ "*           withdrawn.              * %n"
						+ "*      Would you like to make       * %n"
						+ "*        another withdrawal?        * %n"
						+ "*              (Y/N)                * %n"
						+ "* * * * * * * * * * * * * * * * * * * %n", withdrawal);

				input = in.next().toUpperCase().charAt(0);
				//Lets the user decide if they are done making withdrawals.

				if(input == 78 ){
					//If they decide they are done the withdrawal loop is ended and the user is returned the account menu.

					loopwithdrawal = 1;
					//Ends the loop.

				}

			}

		}while(loopwithdrawal == 0);
		//Checks to see if the user is done making withdrawals.


	}

	public static void main(String[] args){

		char input;
		
		for(int a = 0; a < 4; a++){

			accountnumber[a] = (int) (Math.random() * 1000000);
			//This entire process generates five six digit account numbers to be used for each of the five accounts.

		}
		
		do{

			System.out.format("* * * * * * * * * * * * * * * * * * * %n"
					+ "*          Bank of Ben              * %n"
					+ "*                                   * %n"
					+ "*      To navigate this program     * %n"
					+ "*     simply enter the character    * %n"
					+ "* next to the option you would like * %n"
					+ "*           to select.              * %n"
					+ "*                                   * %n"
					+ "* * * * * * * * * * * * * * * * * * * %n");
			do{

				loopcheck = 0;

				switch(mainmenu()){ //Runs the very beginning main menu.

				case 65: login(); //If the user selected to login.
				break;

				case 66: register(); //If the user selected to register.
				break;

				}

			}while(loopcheck == 0);

			do{

				loopcheck = 0;

				switch(loggedin()){ //Runs the users logged in menu.

				case 65: balancecheck(); //If the user chose to check their balance.
				break;

				case 66: deposit(); //If the user chose to make a deposit.
				break;

				case 67: withdraw(); //If the user chose to make a withdrawal.
				break;

				case 68: //If the user chose to logout.
					
				System.out.format("* * * * * * * * * * * * * * * * * * * %n"
						+ "*            Goodbye!               * %n"
						+ "*                                   * %n"
						+ "*         Are you sure              * %n"
						+ "*      you want to logout?          * %n"
						+ "*                                   * %n"
						+ "*             (Y/N)                 * %n"
						+ "*                                   * %n"
						+ "* * * * * * * * * * * * * * * * * * * %n");

				input = in.next().toUpperCase().charAt(0);
				//Lets the user confirm their selection.

				if(input == 89){
				//If the user says to logout, otherwise they are returned to the account menu.

					loopcheck = 1;
					//ends the loop.

				}

				break;

				}

			}while(loopcheck == 0);
			
			System.out.format("* * * * * * * * * * * * * * * * * * *%n"
					+ "*                                   * %n"
					+ "*            Goodbye!               * %n"
					+ "*           Thank you               * %n"
					+ "*           for using               * %n"
					+ "*        The Bank of Ben.           * %n"
					+ "*                                   * %n"
					+ "*                                   * %n"
					+ "* * * * * * * * * * * * * * * * * * * %n");

			loopcheck = 0;
			//Prevents the program from ever terminating.

		}while(loopcheck == 0); //Prevents the program from ever terminating.

		in.close();
		
	}	

}


