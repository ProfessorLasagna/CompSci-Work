package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Play {

	public static Interface playerboard = new Interface();
	public static Interface aiboard = new Interface();
	public static Builder playerbuild = new Builder();
	public static Builder aibuild = new Builder();
	
	static ArrayList<Integer> used = new ArrayList<Integer>();

	public static int phit = 0;
	public static int ahit= 0;

	public static Scanner in = new Scanner(System.in);

	public static void main(String args[]){

		System.out.format("Hello! This is the game of Battleship. %nPlease press enter to begin your setup.%n");
		
		in.nextLine();
		
		playerboard.player = true;
		//aiboard.player = true;
		aiPlace();

		playerboard.printInterface();

		userPlace(0);
		userPlace(1);
		userPlace(2);
		userPlace(3);
		userPlace(4);

		do{

			System.out.format("%d : %d", ahit, phit);
			System.out.format("%n%n%nYou:%n%n");
			playerboard.printInterface();
			System.out.format("%n%n%nThe enemy:%n%n");
			aiboard.printInterface();
			pAttack();
			aiAttack();
			
		}while((ahit <= 16) && (phit <= 16));

		if(phit > 16){
			
			System.out.format("Congratulations you won!");
			
		}else{
			
			System.out.format("Oh no! He sunk all your ships!"
					+ "%nGame over!");
			
		}
		
		in.close();
		
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

			if(aibuild.checkOverlap(coord, dir, val)){

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
			phit++;

		}else{

			System.out.format("%nYou missed!%n%n");
			aiboard.missstat.add(coord);

		}

	}

	public static void aiAttack(){

		int coord = 0;

		do{
		
			coord = (int)(100*Math.random());

		}while(used.contains(coord));
		
		if(playerbuild.fireShell(coord)){

			System.out.format("%nYou've been hit!%n%n");
			playerboard.hitstat.add(coord);
			ahit++;
			used.add(coord);

		}else{

			System.out.format("%nThey missed!%n%n");
			playerboard.missstat.add(coord);
			used.add(coord);

		}

	}
	
}