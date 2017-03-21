package algorithms.edu;

import java.util.ArrayList;

public class Merge {
	
	public static void main(String args[]){
		
		ArrayList<String> africa = new ArrayList<String>();
		africa.add("Algeria");
		africa.add("South Africa");
		africa.add("Egypt");
		africa.add("Nigeria");
		africa.add("Morocco");
		africa.add("Kenya");
		africa.add("Ethiopia");
		africa.add("Tunisia");
		africa.add("Libya");
		africa.add("Madagascar");
		africa.add("Zimbabwe");
		//Adds all of the African countries to a list
		
		ArrayList<String> other = new ArrayList<String>();
		other.add("Bulgaria");
		other.add("France");
		other.add("Turkey");
		other.add("Taiwan");
		other.add("SouthKorea");
		other.add("China");
		other.add("Russia");
		other.add("Serbia");
		other.add("Croatia");
		other.add("Japan");
		//Adds all of the other countries to another list
		
		ArrayList<String> combined = new ArrayList<String>();
		//The list that will hold both country sets
		
		System.out.println("African Countries:");
		
		for(int a = 0; a < africa.size(); a++){
						
			System.out.format("%s ", africa.get(a));
			//Prints the names of the countries in the Africa list
			
		}
		
		System.out.format("%n%n");
		System.out.println("European and Asian Countries:");
		
		for(int a = 0; a < other.size(); a++){
			
			System.out.format("%s ", other.get(a));
			//Prints the names of the countries in the other list
			
		}
		
		System.out.format("%n%n");
		System.out.println("All Countries:");
		
		for(int a = 0; a < africa.size(); a++){
			
			combined.add(africa.get(a));
			//Takes the first list and adds it to the combined list
			
		}
		
		for(int a = 0; a < other.size(); a++){
			
			combined.add(other.get(a));
			//Takes the second list and adds it to the combined list
			
		}

		for(int a = 0; a < combined.size(); a++){
			
			System.out.format("%s ", combined.get(a));
			//Prints out the combined list
			
		}		
				
	}

}
