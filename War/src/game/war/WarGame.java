package game.war;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WarGame extends Card{

	public static Scanner in = new Scanner(System.in);
	
	public static void main(String args[]){
		
		String test = "n";
		
		Card card = new Card();
		card.deck();
		
		Scanner in = new Scanner(System.in);
		
		System.out.format("Welcome to the card game war!"
				+ "%nThis game is a true test of luck. You will be computing against me, the computer!"
				+ "%nI will deal twenty-six cards to you and then 26 to myself."
				+ "%nWe will then begin by placing our first card down. The player with the highest value card wins both cards."
				+ "%nIf we both draw the same card that means we have to go to war!"
				+ "%nIn the case of war we will each place another card on the playing field."
				+ "%nThe player with the highest card that was just placed down gets all of the cards on the table!"
				+ "%nThis will continue until one of us has no cards left."
				+ "%n%nPlease press the 'Enter' key to begin!");
		
		do{	 
			test = in.nextLine();
			if(test == "h"){
				
				
				System.out.format("%n%n%n%n%n%n");
				
				for(int a = 0; a < hand1.size(); a++){
					
					System.out.format("%s%n", hand1.remove());
					
				}
				
				System.out.format("%n%n%n%n%n%n");
				
				for(int a = 0; a < hand2.size(); a++){
					
					System.out.format("%s%n", hand2.remove());
					
				}
				
				break;
				
			}
			
			cardDraw();
						
		}while(hand1.size() > 0 && hand2.size() > 0);
		

		if(hand1.size() == 0)
			System.out.format("%n%nOh no! You lost! ");
		
		if(hand2.size() == 0)
			System.out.format("%n%nYay! You Won!");
		
		in.close();
	
	}
	
	public static void cardDraw(){
		
		String card1, card2;
		
		System.out.format("%nCards Remaining: %2d         Cards Remaining: %2d", hand1.size(), hand2.size());
		
		try{
			
			card1 = hand1.remove();
		
		}catch(NoSuchElementException e){
			
			return;
			
		}
		
		try{
			
			card2 = hand2.remove();
		
		}catch(NoSuchElementException e){
			
			return;
			
		}
		
		
		
		System.out.format("%n __________                  __________  "
						+ "%n|          |                |          | "
						+ "%n|          |                |          | "
						+ "%n|    %2s    |       VS       |    %2s    |"
						+ "%n|          |                |          | "
						+ "%n|          |                |          | "
						+ "%n|__________|                |__________| ", card1, card2);
		
			if(Integer.parseInt(card1) < Integer.parseInt(card2)){
				
				System.out.format("%nYou Lost! Press enter to draw again.%n%n%n");
				
				hand2.add(card2);
				hand2.add(card1);
				
			}else if(Integer.parseInt(card1) > Integer.parseInt(card2)){
				
				System.out.format("%nYou Won! Press enter to draw again.%n%n%n");
				
				hand1.add(card2);
				hand1.add(card1);
				
			}else
				war(card1, card2);
		
	}
	
	public static void war(String card1, String card2){
		
		ArrayList<String> field = new ArrayList<String>();
		
		field.add(card2);
		field.add(card1);
		
		System.out.format("%nThis means war! Press enter to draw your next card!%n");
		
		do{
			
			in.nextLine();
				
				
			try{
			
				card1 = hand1.remove();
				field.add(card1);
				
			}catch(NoSuchElementException e){
				
				return;
				
			}
			
			try{
				
				card2 = hand2.remove();
				field.add(card2);
				
			}catch(NoSuchElementException e){

				return;
				
			}
					
			System.out.format("%n __________                  __________  "
					+ "%n|          |                |          | "
					+ "%n|          |                |          | "
					+ "%n|    %2s    |       VS       |    %2s    |"
					+ "%n|          |                |          | "
					+ "%n|          |                |          | "
					+ "%n|__________|                |__________| ", card1, card2);
			
			if(card1==card2){
				
				System.out.format("%nAnother War!! Press enter to draw your next card!%n%n%n");
			
			}else if(Integer.parseInt(card1) > Integer.parseInt(card2)){
				
				System.out.format("%nYou won the war! Press enter to draw your next card.%n%n%n");
				
				for(int a = 0; a < field.size(); a++){
					
					hand1.add(field.get(a));
				
				}
							
			}else if(Integer.parseInt(card1) < Integer.parseInt(card2)){
				
				System.out.format("%nYou lost the war! Press enter to draw your next card.%n%n%n");
				
				for(int a = 0; a < field.size(); a++){
					
					hand2.add(field.get(a));
				
				}
				
			}
			
		}while(card1 == card2);
		
	}
	
}
