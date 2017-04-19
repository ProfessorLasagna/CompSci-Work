package game;

import java.util.Scanner;

public class Play {
	
	public static Scanner in = new Scanner(System.in);
	public int dealercount = 0;
	public int playerhand = 0;
	
	public static void main(String args[]){
		
		Shuffle deck = new Shuffle();
		
		//System.out.println(deck);
		
		System.out.println("Hello! This is the Black Jack table. Please press enter to begin playing.");
		in.nextLine();
		
		//printHands();
		
		do{
			
			deck.shuffledeck.remove();
			
		}while(true);
		
	}

	public static void printHands(){
		
		System.out.format("Dealer: %n%n"
				+ "----------"
				+ "%n|        |"
				+ "%n|        |"
				+ "%n|   %2d   |"
				+ "%n|        |"
				+ "%n|        |"
				+ "%n----------");
		
	}
	
}
