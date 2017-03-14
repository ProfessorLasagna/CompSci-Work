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
		
		ArrayList<String> combined = new ArrayList<String>();
		
		System.out.println("African Countries:");
		
		for(int a = 0; a < africa.size(); a++){
						
			System.out.format("%s ", africa.get(a));
			
		}
		
		System.out.format("%n%n");
		System.out.println("European and Asian Countries:");
		
		for(int a = 0; a < other.size(); a++){
			
			System.out.format("%s ", other.get(a));
			
		}
		
		System.out.format("%n%n");
		System.out.println("All Countries:");
		
		for(int a = 0; a < africa.size(); a++){
			
			combined.add(africa.get(a));
			
		}
		
		for(int a = 0; a < other.size(); a++){
			
			combined.add(other.get(a));
			
		}

		for(int a = 0; a < combined.size(); a++){
			
			System.out.format("%s ", combined.get(a));
			
		}		
				
	}

}
