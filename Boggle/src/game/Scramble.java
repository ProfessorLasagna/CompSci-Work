package game;

import java.util.LinkedList;
import java.util.Queue;

public class Scramble {

	private static String[][] board = new String[5][5];
	private static Queue<String> letters = new LinkedList<String>();
	private static char[] letstore = new char[26];

	public Scramble(){

		char let = 65;

		for(int a = 0; a < 26; a++){

			letstore[a] = let;
			let++;

		}

	}

	public static void scrambler(){

		int a = 0;

		for(int b = 0; b < 26; b++){

			while(true){

				if(letstore[a] < 65 || letstore[a] > 90){

					a = (int)(26*Math.random());

				}else{

					letters.add(String.valueOf(letstore[a]));
					letstore[a] = 0;
					break;

				}

			}

		}

	}

	public static void setter(int rownum){

		for(int a = 0; a < 5; a++){

			board[rownum][a] = letters.remove();

		}

		if(rownum < 5){

			setter(rownum + 1);

		}

	}

}
