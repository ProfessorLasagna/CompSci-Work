package datastructs;

import java.util.Scanner;

public class Translator {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String[] english = {"Yes", "No", "Maybe", "Hello", "Goodbye", "Friend", "Love", "Hate", "Tired", "Death", "Sick", "Animal", "Happy", "Sad", "Dance"};
		String[] robot = {"AFFIRMATIVE", "DENIED", "INSUFFICIENT KNOWLEDGE", "COMPULSORY FRIENDLY GREETING", "COMFIRMATION OF SEPERATION", "TRUSTED DATA SOURCE", "STRONG POSITIVE EMOTION", "STRONG NEGATIVE EMOTION", "LOW ENERGY RESERVES","DIMINISHED POWER SOURCE","MALWARE INFECTED", "BIOLOGICAL ORGANISM", "EXPERIENCING HEIGHTENED ENDORPHIN LEVELS", "EXPERIENCING LOWERED ENDORPHIN LEVELS", "UNATURAL ERRATIC LIMB MOVEMENT"};
		//The two 15 word lists used for translation
		
		
		String term; //Used to accept the users word to be translated
		int index, translationchoice; //The index stores the address of the word in its array
		
		System.out.format("BEEP, BOOP. HELLO AND WELCOME TO THE ENGLISH TO ROBOT TERM TRANSLATOR. THIS SERVICE CAN TRANSLATE A NUMBER OF"
				+ "%nTERMS TO AND FROM ROBOT. WORLD YOU LIKE TO TRANSLATE FROM:%n"
				+ "1. ENGLISH TO ROBOT%n"
				+ "2. ROBOT TO ENGLISH%n");
	
		translationchoice = in.nextInt();
		
		do{
		
			if(translationchoice == 1){
				//If the user chose to translate from english to robot
			
				System.out.format("PLEASE ENTER ONE OF THE TERMS LISTED BELOW TO TRANSLATE IT TO ITS ROBOT COUNTERPART:%n %n");
				
				for(int a = 0; a < 15; a++){
					//Prints out all of the English words
					
					System.out.format("%s%n", english[a]);
					
				}
				
				System.out.format(" %n");
				in.nextLine();
				term = in.nextLine();
				
				index = search(english, term);
				//Set's the index to the word that the method finds
				
				if(index == -1){
					//If the method couldn't find that word
					
					System.out.format("%nYOUR SELECTED TERM WAS NOT PRESENT ON THE LIST. PLEASE TRY AGAIN.%n");
					
				} else{
				
					System.out.format("%nTHE ROBOTIC TERM THAT BEST MATCHES THE WORD \"%s\" IS: %s%n", english[index], robot[index]);
				
				}
			
			}else if(translationchoice == 2){
				//If the user chose to translate from robot to english
				
				System.out.format("PLEASE ENTER ONE OF THE TERMS LISTED BELOW TO TRANSLATE IT TO ITS ENGLISH COUNTERPART:%n %n");
				
				for(int a = 0; a < 15; a++){
					//Prints out all of the English words
					
					System.out.format("%s%n", robot[a]);
					
				}
				
				System.out.format(" %n");
				in.nextLine();
				term = in.nextLine();
				
				index = search(robot, term);
				//Set's the index to the word that the method finds
				
				if(index == -1){
					//If the method couldn't find that word
					
					System.out.format("%nYOUR SELECTED TERM WAS NOT PRESENT ON THE LIST. PLEASE TRY AGAIN.%n");
					
				} else{
				
					System.out.format("%nTHE ENGLISH TERM THAT BEST MATCHES THE WORD \"%s\" IS: %s%n", robot[index], english[index]);
				
				}		
				
			}
			
			System.out.format("%n %nWHAT WOULD YOU LIKE TO DO?%n"
						+ "1. ENGLISH TO ROBOT%n"
						+ "2. ROBOT TO ENGLISH%n"
						+ "3. Exit%n");
			
			translationchoice = in.nextInt();
			
			if(translationchoice == 3) //If the user chose to exit
			break;
					
		}while(true);
		//Until the user chooses to quit
		
		System.out.format("%nCOMFIRMATION OF SEPERATION. (Goodbye!)");
		
		in.close();
		
	}//End main

	public static int search(String[] english, String term){
		//The method that will compare the user's input against the predefined list of words
		
		int index = -1;
		//The default value for index in case the user entered a friend that did not exist
		
		for(int a = 0; a < 15; a++){
			//Goes through all ten friends and compares them to the input
			
			if(english[a].equals(term)){
				//If the current comparison is true
				
				index = a; //Assigns the index value to the current index so that the words other lanquage counterpart can be retrieved
				break;
				
			}
			
		}
		
		return index;
		//Returns the found index value or returns the default one in case of a lack of a matching word
		
	}//End search
	
}
