package game.war;

import java.util.LinkedList;
import java.util.Queue;

public class Card {
	
	public static Queue<String> hand1 = new LinkedList<String>();
	public static Queue<String> hand2 = new LinkedList<String>();
	
	public static void main(String args[]){
	
		int deck[] = new int[52];
		
		deck = shuffle(deck);
		
	}
	
	public static int[] shuffle(int deck[]){
		
		int suitcount = 0;
		int index = 0;
			
		for(int a = 2; a < 15; a++){
			
			suitcount = 0;
				
			while(suitcount < 4){
					
				if(deck[index] == 0){
					
					deck[index] = a;
					suitcount++;
					
				}else
					index = (int) (52 * Math.random());
				
			}
				
		}			
		
		return deck;
			
	}
	

}
