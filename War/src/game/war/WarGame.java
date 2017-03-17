package game.war;

import java.util.Scanner;

public class WarGame extends Card{

	public static int cardamount1 = 26;
	public static int cardamount2 = 26;
	
	public static void main(String args[]){
		
		Card card = new Card();
		card.deck();
		
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.format("Welcome to the card game war!"
				+ "%nThis game is a true test of luck. You will be computing against me, the computer!"
				+ "%nI will deal twenty-six cards to you and then 26 to myself."
				+ "%nWe will then begin by placing our first card down. The player with the highest value card wins both cards."
				+ "%nIf we both draw the same card that means we have to go to war!"
				+ "%nIn the case of war we will each place two cards, one face up, and one face down."
				+ "%nThe player with the highest card that was just placed down gets all of the cards on the table!"
				+ "This will continue until one of us has no cards left."
				+ "%n%nPlease press the 'Enter' key to begin!");
		
		in.nextLine();
		
		cardDraw();
		
		in.nextLine();
		
		cardDraw();
		
		in.nextLine();
		
		cardDraw();
		in.close();
		
		
		
	}
	
	public static void cardDraw(){
		
		String card1, card2;
		
		card1 = hand1.remove();
		card2 = hand2.remove();
		
		System.out.format("%nCards Remaining: %2d         Cards Remaining: %2d", cardamount1, cardamount2);
		
		System.out.format("%n __________                  __________  "
						+ "%n|          |                |          | "
						+ "%n|          |                |          | "
						+ "%n|    %2s    |       VS       |    %2s    |"
						+ "%n|          |                |          | "
						+ "%n|          |                |          | "
						+ "%n|__________|                |__________| ", card1, card2);
		
			if(Integer.parseInt(card1) < Integer.parseInt(card2)){
				
				System.out.format("%nYou Lost! Press enter to draw again.");
				
				cardamount2++;
				cardamount1--;
				
			}else if(Integer.parseInt(card1) > Integer.parseInt(card2)){
				
				System.out.format("%nYou Won! Press enter to draw again.%n%n%n");
				
				cardamount1++;
				cardamount2--;
				
			}
		
	}
	
}
