package datastructs;

public class DataAssignOne {

	public static void main(String[] args) {
		
		String[] heroes = new String[5]; //Creates the three arrays that hold the heroes, powers, and their gender
		String[] powers = new String[5];
		String[] gender = new String[5];
		
		heroes[0] = "Flash";
		heroes[1] = "Iron-Man";
		heroes[2] = "Hulk";
		heroes[3] = "Black-Widow";
		heroes[4] = "Cyclops";
		//Assigning each hero to their index
		
		powers[0] = "Speed";
		powers[1] = "Money";
		powers[2] = "Strength";
		powers[3] = "Spy";
		powers[4] = "Laser Vision";
		//Assigning each power to their index
		
		gender[0] = "Male";
		gender[1] = "Male";
		gender[2] = "Male";
		gender[3] = "Female";
		gender[4] = "Male";
		//Assigning each gender to their index
		
		System.out.format("%s, %s %n %n", heroes[0], heroes[4]);
		//Prints the first and last hero
		
		//array.length finds the length of the specified array
		
		for(int a = 0; a < 5; a++){
			//Prints all five heroes
			
			System.out.format("%n%s", heroes[a]);
			
		}
		
		System.out.format("%n %n %n %nName                Power             Gender");
		
		for(int b = 0; b < 5; b++){
			
			System.out.format("%n%-20s%-18s%s",heroes[b], powers[b], gender[b]);
			//Print each hero, power, and their gender in order
			
		}
		
	}
	
}
