package game;

public class Play {
	
	public static void main(String args[]){
		
		Scramble meow = new Scramble();

		String[][] board = meow.scrambler();
		
		System.out.format(" %s %s %s %s %s%n %s %s %s %s %s%n %s %s %s %s %s%n %s %s %s %s %s%n %s %s %s %s %s%n"
				,board[0][0],board[0][1],board[0][2],board[0][3],board[0][4],board[1][0],board[1][1],board[1][2],
				board[1][3],board[1][4],board[2][0],board[2][1],board[2][2],board[2][3],board[2][4]
						,board[3][0],board[3][1],board[3][2],board[3][3],board[3][4],board[4][0],board[4][1]
								,board[4][2],board[4][3],board[4][4]);
		
	}

}