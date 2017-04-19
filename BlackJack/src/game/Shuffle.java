package game;

import java.util.LinkedList;
import java.util.Queue;

public class Shuffle {

	public int[] deck = new int[52];
	public Queue<String> shuffledeck = new LinkedList<String>();

	public Shuffle(){

		int suitcount = 0;
		int index = (int) (52 * Math.random());
		int kingcount = 0;

		while(kingcount < 16){

			if(deck[index] == 0){

				deck[index] = 10;
				kingcount++;

			}else{

				index = (int) (52 * Math.random());

			}

		}

		for(int a = 1; a < 10; a++){

			suitcount = 0;
			
			while(suitcount < 4){

				if(deck[index] == 0){

					deck[index] = a;
					suitcount++;

				}else{

					index = (int) (52 * Math.random());

				}

			}

		}
		
		for(int c = 0; c < 52; c++){
			
			shuffledeck.offer(Integer.toString(deck[c]));
			
		}

	}
	
	public String toString(){
		
		String deckstring = "Cards:\n";
		
		for(int a = 0; a < 52; a++){
			
			deckstring += deck[a]+" ";
			
		}
		
		return(deckstring);
		
	}

}