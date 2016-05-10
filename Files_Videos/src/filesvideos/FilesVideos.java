package filesvideos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class FilesVideos {

	private static Formatter z;
	
	public static void main(String[] args){	
		
		Scanner in = new Scanner(System.in);
		
		String un, deux, trois;
		int choice = 0;
		
		createfile();
		openfile();
		
		System.out.format("%nHello, This program will let you add a record to be entered into the"
				+ "%ntext file located in your H drive. ");
		
		do{
			
			System.out.format("What would you like to do?"
					+ "%n1. Add a record"
					+ "%n2. Exit%n");
			
			choice = in.nextInt();
			
			if(choice == 2)
				break;
			
			System.out.format("%nPlease enter your ID number: ");
			
			in.nextLine();
			un = in.nextLine();
			
			System.out.format("%nPlease enter you first name: ");
			
			deux = in.nextLine();
			
			System.out.format("%nPlease enter your last name: ");
			
			trois = in.nextLine();
			
			addrecords(un, deux, trois);
			
		}while(true);
			
		closefile();
				
		in.close();
		
	}

	public static void createfile(){
		
		File x= new File("H:\\User_Records.txt");
		
		try{
			
			if (x.createNewFile()){
				
			    System.out.println("File is created!");
			    
			  }else{
				  
			    System.out.println("File already exists.");
			    
			  }
			
		}catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void openfile(){		
		
		try {
			
		 z = new Formatter("H:\\User_Records.txt");
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		
		}
	
		
	}

	public static void addrecords(String un, String deux, String trois){
		
		z.format("%n%s %s %s", un, deux, trois);
		
	}

	public static void closefile(){
		
		z.close();
		
	}
	
}