package game;

import java.lang.ArrayIndexOutOfBoundsException;

public class AdjCheck {

	private static int row = -1;
	private static int column = -1;

	public static boolean adj(String[][] board, String input, int depth){
		
	//	System.out.format("%d , %d", row, column);

		if(depth > input.length())
			
			return(true);

		try{

			if(board[row+1][column-1].equals(input.substring(depth, depth+1))){

				
				row = row + 1;
				column = column - 1;

				if(adj(board, input, depth+1)){

					return(true);

				}else{

					return(false);

				}

			}

		}catch(ArrayIndexOutOfBoundsException ex){

		}

		try{

			if(board[row+1][column].equals(input.substring(depth, depth+1))){

				row = row+1;

				if(adj(board, input, depth+1)){

					return(true);

				}else{

					return(false);

				}

			}

		}catch(ArrayIndexOutOfBoundsException ex){

		}

		try{

			if(board[row+1][column+1].equals(input.substring(depth, depth+1))){

				row = row+1;
				column = column + 1;

				if(adj(board, input, depth+1)){

					return(true);

				}else{

					return(false);

				}

			}

		}catch(ArrayIndexOutOfBoundsException ex){

		}

		try{

			if(board[row][column-1].equals(input.substring(depth, depth+1))){

				column = column - 1;

				if(adj(board, input, depth+1)){

					return(true);

				}else{

					return(false);

				}

			}

		}catch(ArrayIndexOutOfBoundsException ex){

		}

		try{

			if(board[row][column+1].equals(input.substring(depth, depth+1))){

				column = column + 1;

				if(adj(board, input, depth+1)){

					return(true);

				}else{

					return(false);

				}

			}

		}catch(ArrayIndexOutOfBoundsException ex){

		}

		try{

			if(board[row-1][column-1].equals(input.substring(depth, depth+1))){

				row = row-1;
				column = column - 1;

				if(adj(board, input, depth+1)){

					return(true);

				}else{

					return(false);

				}

			}

		}catch(ArrayIndexOutOfBoundsException ex){

		}

		try{

			if(board[row-1][column].equals(input.substring(depth, depth+1))){

				row = row - 1;

				if(adj(board, input, depth+1)){

					return(true);

				}else{

					return(false);

				}

			}

		}catch(ArrayIndexOutOfBoundsException ex){

		}

		try{

			if(board[row-1][column+1].equals(input.substring(depth, depth+1))){

				row = row-1;
				column = column + 1;

				if(adj(board, input, depth+1)){

					return(true);

				}else{

					return(false);

				}

			}

		}catch(ArrayIndexOutOfBoundsException ex){

		}
		
		System.out.println("noooooooooooooo");

		return(false);

	}

	public static void findLetter(String[][] board, String input){

		char first;
		first = input.charAt(0);

		for(int a = 0; a < 5; a++){

			for(int b = 0; b < 5; b++){

				if(String.valueOf(first).equals(board[a][b])){

					row = a;
					column = b;
					return;

				}

			}

		}

		row = -1;
		column = -1;

	}

}
