package methods;

import java.util.Scanner;

public class PiandRound {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		double diameter, area, circumference;
		//Creates the three values that will store the circumference, area, and diameter of a circle defined by the user
		
		System.out.println("Please enter the diameter of your circle:");
		
		diameter = in.nextDouble();
		
		area = Math.PI * (diameter/2) * (diameter/2);
		//Calculates the area of the circle
		
		circumference = Math.PI * diameter;
		//Calculates the circumference of the circle
		
		System.out.format("The area of your circle is ~%d with a circumference of ~%d.", (int)area, (int)circumference);
		//Rounds the two values and prints them
		
		in.close();
		
	}

}
