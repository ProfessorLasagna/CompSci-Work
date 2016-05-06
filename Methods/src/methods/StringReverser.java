package methods;

import java.util.Scanner;

public class StringReverser {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String userstring; //String used to store users sentence
		
		System.out.format("Hello there! Go ahead and enter a sentence or someother line of text and I'll do something cool with it!%n");
		
		userstring = in.nextLine();
		System.out.format("%n");
			
		for(int b = userstring.length() - 1; b >= 0; b--){
			//Begins at the last letter of the users string and prints it, looping until every character in the string has been printed.
			
			System.out.format("%c",userstring.charAt(b));
			//Print the character at the designated location in the string.
			
		}
		
		in.close();
		
	}

}
