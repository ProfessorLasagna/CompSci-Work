package methods;

import java.util.Scanner;

public class ReplacingWords {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String songlyrics, wordreplace1, wordreplace2;
		//Creates strings for storing the song lyric, the word the user is replacing, and the word they wish to replace it with
		
		songlyrics = "I wanna be the very best!";
		//Assigns the lyrics to the variable
		
		System.out.format("Hello! I'm going to print some lyrics from a song and then you can choose which words you would like to replace. %n %n"
				+ songlyrics);
		
		System.out.format("%n %nNow you choose which word you would like to replace.%n");
		
		wordreplace1 = in.nextLine();
		
		System.out.format("Great now go ahead and pick the word you want to replace it with!%n");
		
		wordreplace2 = in.nextLine();
		
		System.out.format(songlyrics.replace(wordreplace1, wordreplace2));
		//Takes the songlyrics and replaces the defined word with a word defined by the user and print it
		
		in.close();
	}

}
