package game;

import java.util.Scanner;

public class Play {

	public static Interface playerboard = new Interface();
	public static Interface aiboard = new Interface();
	public static Builder playerbuild = new Builder();
	public static Builder aibuild = new Builder();
	
	
	public static Scanner in = new Scanner(System.in);

	public static void main(String args[]){

//		playerboard.printInterface();
//		
//		userPlace(0);
//		userPlace(1);
//		userPlace(2);
//		userPlace(3);
//		userPlace(4);
		aiPlace();
		aiboard.printInterface();
		pAttack();
		aiboard.printInterface();

	
	}

	public static boolean placeShip(int coord, int dir, int val){

		if(playerbuild.checkOverlap(coord, dir, val)){

			playerboard.findCoords(coord, dir, val);
			return false;

		}else{

			System.out.format("That is not a valid placement for your ship. %nPlease try again.");
			return true;

		}


	}
	
	public static void aiPlace(){
		
		int val = 0;
		int coord = 1, dir = 0;
		
		while(val < 5){
			
			coord =(int)(100*Math.random());
			dir = (int)(3*Math.random());
		
			if(playerbuild.checkOverlap(coord, dir, val)){

				aiboard.findCoords(coord, dir, val);
				val++;

			}
		
		}
		
	}

	public static void userPlace(int shiptype){
		
		int coord, dir = 0, col, row;
		char direction;
		String ship = null;
		
		if(shiptype == 0){
			
			ship = "Battleship (5)";
			
		}else if(shiptype == 1){
			
			ship = "Heavy Cruiser (4)";
			
		}else if(shiptype == 2){
			
			ship = "Destroyer (3)";
			
		}else if(shiptype == 3){
			
			ship = "Light Cruiser (3)";
			
		}else if(shiptype == 4){
			
			ship = "Submarine (2)";
			
		}
		
		do{

			System.out.format("%n%nPlease enter the column you would like to place your %s in:", ship);

			col = in.nextInt();

			System.out.format("%nPlease enter the row you would like to place your %s in:", ship);

			row = in.nextInt();

			System.out.format("%nPlease enter the diretion you want your %s facing."
					+ "%n(U)p, (D)own, (L)eft, (R)ight%n", ship);

			direction = in.next().toUpperCase().charAt(0);

			switch(direction){

			case 85: dir = 3;
					break;

			case 68: dir = 1;
					break;

			case 76: dir = 2;
					break;
					
			case 82: dir = 0;
					break;

			}

			coord = (row-1) * 10 + (col-1);

			}while(placeShip(coord, dir, shiptype));

			playerboard.printInterface();

		
	}
	
	public static void pAttack(){
		
		int coord, col = 0, row = 0;
		
		System.out.format("%nPlease enter the column you would like to attack:");
		col = in.nextInt();
		
		System.out.format("%nPlease enter the row you would like to attack:");
		row = in.nextInt();
		
		coord = (row-1) * 10 + (col-1);
		
		if(aibuild.fireShell(coord)){
			
			System.out.format("%nIt's a hit!%n%n");
			aiboard.hitstat.add(coord);
			
		}else{
			
			System.out.format("%nYou missed!%n%n");
			aiboard.missstat.add(coord);
			
		}

	}

}
