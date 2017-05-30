package game;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.*;


public class Scramble {

	private static Queue<String> letters = new LinkedList<String>();
	private static char[] letstore = new char[26];

	public Scramble(){

	}

	public String[][] scrambler(){

		char let = 65;

		for(int a = 0; a < 26; a++){

			letstore[a] = let;
			let++;

		}

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

		return(setter(0));

	}

	public static String[][] setter(int rownum){

		String[][] board = new String[5][5];
		String[][] comb = new String[5][5];

		for(int a = 0; a < 5; a++){

			board[0][a] = letters.remove();

		}

		if(rownum < 4){

			comb = Stream.concat(Arrays.stream(board), Arrays.stream(setter(rownum+1)))
                    .toArray(String[][]::new);

		}

		return(comb);

	}

}
