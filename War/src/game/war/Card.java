package game.war;

import java.util.LinkedList;
import java.util.Queue;

public class Card {
	
	public static Queue<String> hand1 = new LinkedList<String>();
	public static Queue<String> hand2 = new LinkedList<String>();
	
	public void deck(){
	
		int[] deck = new int[52];
		
		deck = shuffle(deck);
		
		for(int a = 0; a < 26; a++){
			
			hand1.offer(Integer.toString(deck[a]));
			
		}
		
		for(int a = 26; a < 52; a++){
			
			hand2.offer(Integer.toString(deck[a]));
			
		}		
		
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
