package game;

import java.util.Scanner;

public class Play {
	
	public static Scanner in = new Scanner(System.in);
	public static int[] dealerhand = new int[16];
	public static int[] playerhand = new int[16];
	public static int playerhandcount = 2;
	public static int dealerhandcount = 2;
	public static int playertotal, dealertotal;
	public static Shuffle deck = new Shuffle();
	
	public static void main(String args[]){
		
		char input;
		boolean playerstay = false, dealerstay = true, playagain = true;
		
		//System.out.println(deck);
		
		System.out.println("Hello! This is the Black Jack table. Please press enter to begin playing.");
		in.nextLine();
	
		do{
		
			dealerhand[0] = deck.hit();
			playerhand[0] = deck.hit();
			dealerhand[1] = deck.hit();
			playerhand[1] = deck.hit();
		
			playertotal = playerhand[0] + playerhand[1];
			dealertotal = dealerhand[0] + dealerhand[1];
		
			printDealer();
			printPlayer();
			
			do{
				
				System.out.format("%n\"H\" to hit. %n\"S\" to stay.%n");
			
				input = in.next().toUpperCase().charAt(0);
				
				switch(input){
			
				case 72: playerhand[playerhandcount] = deck.hit();
						 System.out.format("%nYou drew a %d!", playerhand[playerhandcount]);
						 printnewCard();
						 playertotal += playerhand[playerhandcount];
						 playerhandcount++;
						 playerstay = false;
						 break;
				
				case 83:playerstay = true;
						break;
			
				}
				
				if(dealertotal < 17){
					
					System.out.format("%nThe dealer hit!");
					dealerhand[dealerhandcount] = deck.hit();
					dealertotal += dealerhand[dealerhandcount];
					dealerhandcount++;
					dealerstay = false;				
					
				}else{
					
					System.out.format("%nThe dealer stayed!");
					dealerstay = true;
					
				}
				
				System.out.format("%nYour Total : %d%n", playertotal);
				
				if(dealerstay && playerstay){
					
					counterAce();
					
					System.out.format("%n%d : %d%n", playertotal, dealertotal);
					
					if(playertotal > 21 && dealertotal <= 21){
						
						System.out.format("You lost!");
						break;
						
					}else if(dealertotal > 21 && playertotal <= 21){
						
						System.out.format("You won!");
						break;
						
					}else if(playertotal > dealertotal && playertotal <= 21){
						
						System.out.format("You won!");
						break;
						
					}else if(dealertotal > playertotal && dealertotal <= 21){ 
						
						System.out.format("You lost!");
						break;
						
					}else if((dealertotal - 21) < (playertotal - 21)){
						
						System.out.format("You lost!");
						break;
						
					}else if((playertotal - 21) < (dealertotal - 21)){
						
						System.out.format("You won!");
						break;
						
					}else if(playertotal == dealertotal){
						
						System.out.format("It's a tie!");
						break;
											
					}
					
				}
	
			}while(true);
			
			System.out.format("%n%nWould you like to play again? (Y/N)%n");
			input = in.next().toUpperCase().charAt(0);
			
			if(input == 78){
				
				playagain = false;
			
			}else{
				
				deck.reshuffle();
				
				for(int p = 0; p < 16; p++){
					
					playerhand[p] = 0;
					
				}
				
				for(int p = 0; p < 16; p++){
					
					dealerhand[p] = 0;
					
				}
				
				playerhandcount = 2;
				dealerhandcount = 2;
				
				playertotal = 0;
				dealertotal = 0;
				
				System.out.println("Please press enter to begin playing.");
				in.nextLine();
				in.nextLine();
			
				
			}
		
		}while(playagain);
		
	}

	public static void printDealer(){
		
		System.out.format("%nDealer: %n%n"
				+ "----------            ----------"
				+ "%n|        |            |        |"
				+ "%n|        |            |        |"
				+ "%n|   %2d   |            |    ?   |"
				+ "%n|        |            |        |"
				+ "%n|        |            |        |"
				+ "%n----------            ----------%n%n", dealerhand[0]);
		
	}
	
	public static void printPlayer(){
		
		System.out.format("%nYou: %n%n"
				+ "----------            ----------"
				+ "%n|        |            |        |"
				+ "%n|        |            |        |"
				+ "%n|   %2d   |            |   %2d   |"
				+ "%n|        |            |        |"
				+ "%n|        |            |        |"
				+ "%n----------            ----------", playerhand[0], playerhand[1]);
		
	}
	
	public static void printnewCard(){
		
		System.out.format("%n"
				+ "----------     "
				+ "%n|        |   "
				+ "%n|        |   "
				+ "%n|   %2d   |  "
				+ "%n|        |   "
				+ "%n|        |   "
				+ "%n----------  %n ", playerhand[playerhandcount]);
		
	}
	
	public static void counterAce(){
		
		char input;
		
		for(int a = 0; a < playerhandcount; a++){
			
			if(playerhand[a] == 1){
				
				playertotal -= playerhand[a];
				
				System.out.format("%n%nWould you like your ace to count as an eleven?%n(Y/N)%n");
				
				input = in.next().toUpperCase().charAt(0);
				
				switch(input){
				
				case 89: playerhand[a] = 11;
				playertotal += playerhand[a];
						 break;
						 
				case 78: playertotal += playerhand[a]; 
						 break;
				
				}
				
			}
			
		}
		
	}
	
}
