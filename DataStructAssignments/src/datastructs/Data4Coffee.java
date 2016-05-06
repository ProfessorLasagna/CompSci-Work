package datastructs;

import java.util.Scanner;

public class Data4Coffee {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String[] drink = {"Iced Coffee (S)", "Iced Coffee (M)", "Iced Coffee (L)", "Cappuccino (S)", "Cappuccino (M)", "Cappuccino (L)", "Latte (S)", "Latte (M)", "Latte (L)"};
		int[] calories = {120, 160, 260, 60, 90, 120, 80, 110, 150};
		int[] caffeine = {60, 130, 160, 70, 90, 120, 35, 50, 70};
		int[] sugar = {8, 13, 21, 9, 13, 19, 11, 16, 22};
		//Creates the 4 arrays that will store the names and associated data of 9 different drinks offered at Tim Horton's
		
		int calorietotal = 0, caffeinetotal = 0, index, drinkcount = 0, age; 
		//Creates the the two variables that will store the calorie and caffeine totals of the user, index holds the value of the index at the drink specified by the user,
		//age holds the value of the user's age, and drink count stores how many drinks the user had
		
		String term; //Holds the name of the drink the user entered
		char gender; //Holds the char value of the gender the user entered
		
		System.out.format("Hello there! I can give you information on a select number of Tim Horton's coffee products:%n");
		
		do{
		
			for(int a = 0; a < 9; a++){
				//Prints out all of the drink names
				
				System.out.format("%n%s", drink[a]);
				
			}
			
			System.out.format("%n %nExit");
			
			System.out.format("%n %nWhat did you have to drink this week?%n");
			
			term = in.nextLine();
			
			index = search(drink, term);
			//Assigns the index value by calling the method and checking the user's input against the list of drinks
			
			if(term.equals("exit") || term.equals("Exit")){
				//If the user chose to stop entering drinks
				
				break;
				//Breaks out of the infinite while loop
				
			}	else if(index == -1){
				//If the user didn't enter a drink that was on the list
				
				System.out.format("%nSorry! That drink is not on the list.%nPlease try again.%n %n");
				
			}	else{
				
				System.out.format("%n %n%s %n%d Calories %n%dmg of caffeine %n%dg of Sugar", drink[index], calories[index], caffeine[index], sugar[index]);
				//Prints the sugar, calories, and caffeine of the drink the user specified
				
				calorietotal = calorietotal + calories[index];  //Increases the user's calorie total by adding the calories from the drink they had
				caffeinetotal = caffeinetotal +caffeine[index]; //Increases the user's caffeine total by adding the caffeine from the drink they had
			
				System.out.format("%n %nCurrent calorie total: %d %nCurrent caffeine total: %dmg %n %n", calorietotal, caffeinetotal);
				drinkcount++;
				//Prints the user's current calorie total and increases the amount of drinks they've had by one
				
			}
		
		}while(true);
		//Until the loop gets broken out of
		
		System.out.format("In total you had %d drinks. %nThis added up to %d calories and %dmg of caffeine. %n"
				+ "Please enter your gender (M/F): ", drinkcount, calorietotal, caffeinetotal);
		//Lists the user's final totals
		
		gender = in.next().toUpperCase().charAt(0);
		
		System.out.format("%nPlease enter your age: ");
		
		age = in.nextInt();
		
		if(gender == 77){
			//If the user is a boy
			
			if(age <= 18){
				//If the user is under eighteen
				
				System.out.format("%nAccording to your age and gender you should be limiting yourself to approximately 15400 calories a week%n"
						+ "and consume no more than 700mg of caffiene a week. ");
				
				if(calorietotal > 1540){
					//If the user consumed more than 10% of their weekly caloric intake
					
					System.out.format("%nIf you consumed the the %d drink(s) you listed in one week you would have used up to %.2f%% of your weekly calories on drinks alone!"
							+ "%nIt may be a good idea to decrease your intake of drinks by purchasing the smaller sizes which have a much lower amount of calories in them%n"
							+ "or straight up cutting back on the amount of drinks you have a week. "
							+ "%nIt may be a good idea to only have one drink a day. If you had one medium iced coffee a day you would only use 7%% of your weekly intake!", drinkcount, (((double)calorietotal)) / 15400 * 100);
					
				} else{
					
					System.out.format("%nIf you consumed the %d drink(s) you listed in one week you managed to stay under 10%% of your weekly calorie count! Good job!%n"
							+ "In one week you only used %.2f%% of your weekly calorie intake. Feel free to continue what you're doing.", drinkcount, (((double)calorietotal)) / 15400 * 100);
					
				}
				
			}else if(age > 18 && age <= 30){
				//If the user is between the ages of eighteen and thirty
				
				System.out.format("According to your age and gender you should be limiting yourself to approximately 16800 calories a week%n"
						+ "and consume no more than 2800mg of caffiene a week.");
				
				if(calorietotal > 1680){
					//If the user consumed more than 10% of their weekly caloric intake
					
					System.out.format("%nIf you consumed the the %d drink(s) you listed in one week you would have used up to %.2f%% of your weekly calories on drinks alone!"
							+ "%nIt may be a good idea to decrease your intake of drinks by purchasing the smaller sizes which have a much lower amount of calories in them%n"
							+ "or straight up cutting back on the amount of drinks you have a week."
							+ "%nIt may be a good idea to only have one drink a day. If you had one medium iced coffee a day you would only use 6%% of your weekly intake!", drinkcount, (((double)calorietotal)) / 16800 * 100);
					
				} else{
					
					System.out.format("%nIf you consumed the %d drink(s) you listed in one week you managed to stay under 10%% of your weekly calorie count! Good job!%n"
							+ "In one week you only used %.2f%% of your weekly calorie intake. Feel free to continue what you're doing.", drinkcount, (((double)calorietotal)) / 16800 * 100);
					
				}
				
				
			}else if(age > 30){
				//If the user is over the age of thirty
				
				System.out.format("%nAccording to your age and gender you should be limiting yourself to approximately 15400 calories a week%n"
						+ "and consume no more than 2800mg of caffiene a week.");
				
				if(calorietotal > 1540){
					//If the user consumed more than 10% of their weekly caloric intake
					
					System.out.format("%nIf you consumed the the %d drink(s) you listed in one week you would have used up to %.2f%% of your weekly calories on drinks alone!"
							+ "%nIt may be a good idea to decrease your intake of drinks by purchasing the smaller sizes which have a much lower amount of calories in them%n"
							+ "or straight up cutting back on the amount of drinks you have a week."
							+ "%nIt may be a good idea to only have one drink a day. If you had one medium iced coffee a day you would only use 7%% of your weekly intake!", drinkcount, (((double)calorietotal)) / 15400 * 100);
					
				} else{
					
					System.out.format("%nIf you consumed the %d drink(s) you listed in one week you managed to stay under 10%% of your weekly calorie count! Good job!%n"
							+ "In one week you only used %.2f%% of your weekly calorie intake. Feel free to continue what you're doing.", drinkcount, (((double)calorietotal)) / 15400 * 100);
					
				}
				
				
			}
			
		}else if(gender == 70){
			//If the user is a girl
			
			if(age <= 18){
				//If the user is eighteen or under
				
				System.out.format("%nAccording to your age and gender you should be limiting yourself to approximately 12600 calories a week%n"
						+ "and consume no more than 700mg of caffiene a week. ");
				
				if(calorietotal > 1260){
					//If the user consumed more than 10% of their weekly caloric intake
					
					System.out.format("%nIf you consumed the the %d drink(s) you listed in one week you would have used up to %.2f%% of your weekly calories on drinks alone!"
							+ "%nIt may be a good idea to decrease your intake of drinks by purchasing the smaller sizes which have a much lower amount of calories in them%n"
							+ "or straight up cutting back on the amount of drinks you have a week."
							+ "%nIt may be a good idea to only have one drink a day. If you had one medium iced coffee a day you would only use 9%% of your weekly intake!", drinkcount, (((double)calorietotal)) / 12600 * 100);
					
				} else{
					
					System.out.format("%nIf you consumed the %d drink(s) you listed in one week you managed to stay under 10%% of your weekly calorie count! Good job!%n"
							+ "In one week you only used %.2f%% of your weekly calorie intake. Feel free to continue what you're doing.", drinkcount, (((double)calorietotal)) / 12600 * 100);
					
				}
				
			}else if(age > 18 && age <= 30){
				//If the user is between the ages of eighteen and thirty
				
				System.out.format("%nAccording to your age and gender you should be limiting yourself to approximately 14000 calories a week%n"
						+ "and consume no more than 2800mg of caffiene a week.");
				
				if(calorietotal > 1400){
					//If the user consumed more than 10% of their weekly caloric intake
					
					System.out.format("%nIf you consumed the the %d drink(s) you listed in one week you would have used up to %.2f%% of your weekly calories on drinks alone!"
							+ "%nIt may be a good idea to decrease your intake of drinks by purchasing the smaller sizes which have a much lower amount of calories in them%n"
							+ "or straight up cutting back on the amount of drinks you have a week."
							+ "%nIt may be a good idea to only have one drink a day. If you had one medium iced coffee a day you would only use 8%% of your weekly intake!", drinkcount, (((double)calorietotal)) / 14000 * 100);
					
				} else{
					
					System.out.format("%nIf you consumed the %d drink(s) you listed in one week you managed to stay under 10%% of your weekly calorie count! Good job!%n"
							+ "In one week you only used %.2f%% of your weekly calorie intake. Feel free to continue what you're doing.", drinkcount, (((double)calorietotal)) / 14000 * 100);
					
				}
				
			}else if(age >= 30);
			//If the user is above the age of thirty
			
			System.out.format("%nAccording to your age and gender you should be limiting yourself to approximately 12600 calories a week%n"
					+ "and consume no more than 700mg of caffiene a week. ");
			
			if(calorietotal > 1260){
				//If the user consumed more than 10% of their weekly caloric intake
				
				System.out.format("%nIf you consumed the the %d drink(s) you listed in one week you would have used up to %.2f%% of your weekly calories on drinks alone!"
						+ "%nIt may be a good idea to decrease your intake of drinks by purchasing the smaller sizes which have a much lower amount of calories in them%n"
						+ "or straight up cutting back on the amount of drinks you have a week."
						+ "%nIt may be a good idea to only have one drink a day. If you had one medium iced coffee a day you would only use 9%% of your weekly intake!", drinkcount, (((double)calorietotal)) / 12600 * 100);
				
			} else{
				
				System.out.format("%nIf you consumed the %d drink(s) you listed in one week you managed to stay under 10%% of your weekly calorie count! Good job!%n"
						+ "In one week you only used %.2f%% of your weekly calorie intake. Feel free to continue what you're doing.", drinkcount, (((double)calorietotal)) / 12600 * 100);
				
			}
			
		}
		
		in.close();
		
	}//End main

	public static int search(String[] drink, String term){
		//The method that will compare the user's drink input against the predefined list of drinks
		
		int index = -1;
		//The default value for index in case the user entered a drink that did not exist
		
		for(int a = 0; a < 9; a++){
			//Goes through all nine drinks and compares them to the input
			
			if(drink[a].equals(term)){
				//If the current comparison is true
				
				index = a; //Assigns the index value to the current index so that the rest of that drinks data can be retrieved
				break;
				
			}
			
		}
		
		return index;
		//Returns the found index value or returns the default one in case of a lack of a matching drink
		
	}//End search
	
}