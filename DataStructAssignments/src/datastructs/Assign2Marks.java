package datastructs;

import java.util.Scanner;

public class Assign2Marks {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int selection, loop = 0; //Creates two variables meant for allowing the user to continue looking up student data
		char choice; //The variable the user will define as a "y" or an "n"
		
		String[] students = {"Bob", "Jim", "Sally", "Benjamin", "Susan", "Zoey", "Jack", "Kyle", "Amelia", "Donald"};
		int[] gradelevel = {10, 12, 11, 11, 12, 10, 11, 10, 10, 12};
		int[] test1 = {98, 88, 76, 96, 57, 100, 63, 74, 85, 100};
		int[] test2 = {81, 94, 74, 98, 63, 98, 54, 83, 88, 100};
		int[] test3 = {92, 98, 77, 100, 64, 96, 56, 88, 88, 100};
		//Creates 5 arrays and assigns each place as a students data 
		
		System.out.println(students[0]);
		System.out.println(gradelevel[0]);
		System.out.println(test1[0]);
		System.out.println(test2[0]);
		System.out.println(test3[0]);
		//Prints all of the first students data
		
		System.out.format("%n %n");
		
		System.out.println(students[9]);
		System.out.println(gradelevel[9]);
		System.out.println(test1[9]);
		System.out.println(test2[9]);
		System.out.println(test3[9]);
		//Prints all of the last students data
		
		System.out.format("%n %n");
		
		for(int a = 0; a < 10; a++){
		//Prints all of the students names in order	
			System.out.format("%n%d.%s",(a+1), students[a]);
			
		}
		
		do{
		
			System.out.format("%n %nPlease enter the number from above for the student you would like to look up: ");
			
			selection = in.nextInt();
			
			System.out.format("%n%d.%s Grade %d %nTest Scores: %n%d %n%d %n%d ", (selection), students[selection-1], gradelevel[selection-1], test1[selection-1], test2[selection-1], test3[selection-1]);
			//Prints the user's selection as a whole bunch of student data
			
			System.out.format("%n %nWould you like to check up on another student? (Y/N)%n");
			
			choice = in.next().toUpperCase().charAt(0);
			
			if(choice == 78) //If the users chose to stop looking up data
			break;		
		
		}while(loop == 0);
		//Until the user breaks out
		
		System.out.format("%nGoodbye!");
		in.close();
		
	}

}
