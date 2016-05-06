package methods;

import java.util.Scanner;

public class JavadocsAssignment {
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int input1 , input2, input3, input4;
		//Creates the four variables that the user can assign a number to
				
		System.out.println("Please enter four digits, hitting enter after each digit, and I will calculate the lowest value of the four.");
		
		input1 = in.nextInt();
		input2 = in.nextInt();
		input3 = in.nextInt();
		input4 = in.nextInt();
		//Lets the user define the four variables
		
		System.out.format("The smallest number is: %d",Math.min(Math.min(input1, input2),Math.min(input3, input4)));
		//Compares two variables against each other twice and then compares the least in each set against each other to get the least value		
		
		in.close();
		
	}
	
}
