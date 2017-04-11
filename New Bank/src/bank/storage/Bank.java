package bank.storage;

import java.util.Scanner;

public class Bank {
	
	public static Scanner in = new Scanner(System.in);

	public static void main(String args[]){
		
		int end = 1;

		System.out.println("You are creating a new bank account. Please enter your first name:");

		String fName = in.nextLine();

		System.out.println("Please enter your last name:");

		String sName = in.nextLine();
		
		System.out.format("%n%nHello %s %s! Please enter your province:%n", fName, sName);
		
		String prov = in.nextLine();
		
		System.out.println("Please enter your city of residence:");
		
		String city = in.nextLine();
		
		System.out.println("Please enter your adress:");
		
		String street = in.nextLine();
		
		System.out.println("Please enter your postal code:");
		
		String post = in.nextLine();
		
		System.out.println("And finally, please enter your initial deposit:");
		
		Double balance = in.nextDouble();
		
		Account act = new Account(balance, fName, sName, city, street, prov, post);
		
		System.out.format("%n%n%n%s", act);
		
		while(end == 1){
			
			System.out.format("%n%nWhat would you like to do?"
					+ "%n1.Make a deposit"
					+ "%n2.Make a withdrawl"
					+ "%n3.Change acount data"
					+ "%n4.Reprint account data"
					+ "%n5.Exit%n");
			
			int choice = in.nextInt();
			
			switch(choice){
				
			case 1: act.deposit(deposit());
					break;
			
			case 2: act.withdrawl(withdrawl());
					break;
			
			case 3: act.changeAddress(changeActstr(), changeActcity(), changeActpost(), changeActprov());
					break;
			
			case 4: System.out.format("%n%n%n%s", act);
					break;
					
			case 5: end = 0;
			        break;
				
			}
			
		}
		
		in.close();

	}
	
	public static double deposit(){
		
		System.out.format("%n%nPlease enter the amount you would like to deposit:");
		double input = in.nextDouble();
		return(input);
		
	}
	
	public static double withdrawl(){
		
		System.out.format("%n%nPlease enter the amount you would like to withdraw:");
		double input = in.nextDouble();
		return(input);
		
	}
	
	public static String changeActstr(){
		
		System.out.format("%n%nPlease enter your street address:");
		String input = in.nextLine();
		return(input);
		
	}
	
	public static String changeActcity(){
		
		System.out.format("%n%nPlease enter your city of residence:");
		String input = in.nextLine();
		return(input);
		
	}
	
	public static String changeActprov(){
		
		System.out.format("%n%nPlease enter your province:");
		String input = in.nextLine();
		return(input);
		
	}
	
	public static String changeActpost(){
		
		System.out.format("%n%nPlease enter your postal code:");
		String input = in.nextLine();
		return(input);
		
	}

}
