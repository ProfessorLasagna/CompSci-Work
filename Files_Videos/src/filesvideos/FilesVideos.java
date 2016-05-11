package filesvideos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class FilesVideos {

	private static Formatter z;	
	//Used to ad lines to the text file. 
	//Due the the function of the formatter the text file gets wiped every time the program runs
	
	private static Scanner x; //Used to read from the text file
	
	public static void main(String[] args){	
		
		Scanner in = new Scanner(System.in);
		
		String un, deux, trois; //Holds the user ID, first name, and last name inputs
		int choice = 0; //The selection the user makes between adding a record and quitting
		
		createfile(); //Creates the file if it does not already exist
		openfile(); //Opens the file for access
		
		System.out.format("%nHello, This program will let you add a record to be entered into the"
				+ "%ntext file located in your H drive. ");
		
		do{
			
			System.out.format("%nWhat would you like to do?"
					+ "%n1. Add a record"
					+ "%n2. Exit%n");
			
			choice = in.nextInt();
			
			if(choice == 2) //If the user chose to exit the program
				break;
			
			System.out.format("%nPlease enter your ID number: ");
			
			in.nextLine();
			un = in.nextLine();
			
			System.out.format("%nPlease enter you first name: ");
			
			deux = in.nextLine();
			
			System.out.format("%nPlease enter your last name: ");
			
			trois = in.nextLine();
			
			addrecords(un, deux, trois);
			//Sends the three inputed values to be stored in the text file
			
		}while(true);
			
		closefile(); //Runs the method that closes/saves the text file
				
		System.out.format("%n %nCurrent records: %n");
			
		reader(); //Runs the method that goes through the process of reading all of the values in the text file and printing them
		
		in.close();
		
	}//End main

	public static void createfile(){
		//The method that creates the text file stored on the H drive
		
		File x= new File("H:\\User_Records.txt");
		//Allows the file to be created in the specified location
		
		try{
			
			if (x.createNewFile()){
				//If the file was able to be created in the location specified
				
			    System.out.println("File is created!");
			    
			  }else{
				  //If a file with the same name already exists in that location
				  
			    System.out.println("File already exists.");
			    
			  }
			
		}catch (IOException e) {
			
			System.out.format("Unable to creat file.");
			
		}
		
	}//End createfile
	
	public static void openfile(){
		//The method that is used to attempt to open the file specified
		//Every time the file is opened the text file is wiped because of the way formatter works 
		//and as such can only store records for one run of the program
		
		try {
			
		 z = new Formatter("H:\\User_Records.txt");
		 //Allows for the use of z to add data to the text file
			
		} catch (FileNotFoundException e1) {
			
			System.out.format("File was not found.");
		
		}
	
		
	}//End openfile

	public static void addrecords(String un, String deux, String trois){
		//The method the adds the three specified values to the text file
		
		z.format("%s %s %s%n", un, deux, trois);
		
	}//End addrecords

	public static void closefile(){
		//The (very simple) method used to close and save the text file
		
		z.close();
		
	}//End closefile
	
	public static void reader(){
		//The method used to read the data stored on the text file
	
			try {
				
				x = new Scanner(new File("H:\\User_Records.txt"));
				//Creates a scanner that can read the file at the specified location
			
			} catch (FileNotFoundException e) {
			
			System.out.format("File not found.");
			
			}		
		
		while(x.hasNext()){
			//Print until every piece of data in the file has been printed
			
			String un = x.next(); //Each string holds the next string in the text file
			String deux = x.next();
			String trois = x.next();
			
			System.out.format("%-9s %-8s %s%n", un, deux, trois);
						
		}
		
		x.close();
		
	}//End reader
	
}