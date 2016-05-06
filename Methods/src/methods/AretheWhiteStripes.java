package methods;

import java.util.Scanner;

public class AretheWhiteStripes {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String userbands;
		//Creates the string the user will assign all of their bands to

		System.out.format("Hello there! Out of curiosity how about you tell me what your favorite bands are!%n");

		userbands = in.nextLine().toLowerCase();
		//Stores the users favorite bands and ensures all the characters are lower case for easy comparison

		if (userbands.contains("white")){
			//If any of the words in the users list includes the word white 

			System.out.format("Cool! You have pretty good taste.%n");

		} else {
			
			System.out.format("Well I suppose we all have different tastes, too bad your choice isn't mine.");

		}

		in.close();
		
	}

}
