package datastructs;

import java.util.Scanner;

public class NickName {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String[] nicknames = {"Apple", "Bear", "Castle", "Dolphin", "Echo", "Fear", "Gorilla", "Hawk", "Illusive", "Joy", "King Cobra", "Lightning", "Mysterious", "Noble", "Ocelotte", "Prince/Princess", "Quiet", "Revolver", "Star", "Tarantula", "Umbrella", "Venom", "Wasp", "X-Factor", "Yak", "Zebra"};
		//Establishes every nickname to be used
		
		String firstname, lastname;
		//Holds the users first and last name
		
		int index = 0;	  //Holds which index value in the array has in common with the users last name 
		
		System.out.format("Hello! This program will give you a nickname based on your real name!");
		
		do{
			
			System.out.format("%nPlease enter your first name or type exit to quit: ");
			
			firstname = in.nextLine();
			
			if(firstname.equals("exit")) //If the user chose to stop entering names
				break;
			
			System.out.format("Please enter your last name: ");
			
			lastname = in.nextLine();
			
			for(int a = 0; a < 25; a++){
				
				if(lastname.toLowerCase().charAt(0) == (nicknames[a].toLowerCase().charAt(0))){
					//If the user's initial matches that of any of the nicknames
					
					index = a;
					//Holds the nickname at the index specified
					
					break;
										
				}	
				
			}
		
			System.out.format("%n %nYour new nickname is %s \"The %s\" %s!%n %n", firstname, nicknames[index], lastname);
			
		}while(true);
		//Until the user quits
		
		System.out.format("%n %nGoodbye!");
		
		in.close();
		
	}//End main
	
}
