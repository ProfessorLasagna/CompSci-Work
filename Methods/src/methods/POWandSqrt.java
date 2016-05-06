package methods;

public class POWandSqrt {
	
	public static void main(String[] args) {
		
		int numLetters = 14;
		//Creates an int that holds the value of the number of characters in my full name
		
		System.out.format("%d to the power of is 3 is %.2f and the square root of %.2f is %.2f.", 
				numLetters, Math.pow(numLetters, 3), Math.pow(numLetters, 3), Math.sqrt(Math.pow(numLetters, 3)) );
		//Prints the numletters variable followed by that value to the power of three followed by the square root of that calculated value
		
	}

}
