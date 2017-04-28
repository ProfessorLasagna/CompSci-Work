package game;

import java.util.Scanner;

public class Play {

	public static Interface board = new Interface();
	public static Builder build = new Builder();

	public static Scanner in = new Scanner(System.in);

	public static void main(String args[]){

		int coord, dir, col, row;
		char direction;

		board.printInterface();

		do{

		System.out.format("%nPlease enter the column you would like to place your battleship in:");

		col = in.nextInt();

		System.out.format("%nPlease enter the row you would like to place your battleship in:");

		row = in.nextInt();

		System.out.format("%nPlease enter the diretion you want your battleship facing."
				+ "%n(U)p, (D)own, (L)eft, (R)ight%n");

		direction = in.next().toUpperCase().charAt(0);

		switch(direction){

		case 85: dir = 3;
				break;

		case 68: dir = 1;
				break;

		case 76: dir = 2;
				break;

		}

		dir = in.nextInt();

		coord = (row-1) * 10 + (col-1);

		}while(placeShip(coord, dir, 0));

		board.printInterface();

	}

	public static boolean placeShip(int coord, int dir, int val){

		if(build.checkOverlap(coord, dir, val)){

			board.findCoords(coord, dir, val);
			return false;

		}else{

			System.out.format("That is not a valid placement for your ship. %nPlease try again.");
			return true;

		}


	}

}
