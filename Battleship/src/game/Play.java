package game;

import java.util.Scanner;

public class Play {
	
	public static Interface board = new Interface();
	public static Builder build = new Builder();
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String args[]){
		
		int coord, dir;
		
		coord = in.nextInt();
		dir = in.nextInt();
		
		placeShip(coord, dir, 0);
		
		board.printInterface();
		
	}
	
	public static void placeShip(int coord, int dir, int val){
		
		if(build.checkOverlap(coord, dir, val)){
			
			board.findCoords(coord, dir, val);
			
		}
		
	}

}
