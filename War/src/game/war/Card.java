package game.war;

import java.util.LinkedList;
import java.util.Queue;

public class Card {

	public static Queue<String> hand1 = new LinkedList<String>();
	public static Queue<String> hand2 = new LinkedList<String>();
	//Creates the two players hands that can be accessed by the wargame class

	public void deck(){

		int[] deck = new int[52];
		//Creates an empty deck that will hold fifty two cards

		deck = shuffle(deck);

		for(int a = 0; a < 26; a++){

			hand1.offer(Integer.toString(deck[a]));
			//Deals 26 cards to the first player

		}

		for(int a = 26; a < 52; a++){

			hand2.offer(Integer.toString(deck[a]));
			//Deals 26 cards to the other players account

		}

	}

	public static int[] shuffle(int deck[]){

		int suitcount = 0;
		int index = 0;

		for(int a = 2; a < 15; a++){
			//This process randomly adds 52 cards to the deck

			suitcount = 0;

			while(suitcount < 4){
				//Adds the same card four times for each of the suits

				if(deck[index] == 0){

					deck[index] = a;
					suitcount++;
					//Only adds the card if there is not already one in that location of the deck

				}else
					index = (int) (52 * Math.random());

			}

		}

		return deck;

	}


}
