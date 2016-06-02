package ram;

import java.awt.*; // contains GUI controls
import java.io.*; // contains data-file commands – for RandomAccessFile

public class LockersDB extends EasyApp {
	
	private static final long serialVersionUID = 1L;
	private int output = 0; //Used to determine where the user wants their output

	public static void main(String[] args) {
		new LockersDB();
	}

	Button bClear = addButton("Clear All", 50, 50, 100, 50, this);
	Button bAssign = addButton("Assign", 150, 50, 100, 50, this);
	Button bShowNames = addButton("Show Names", 250, 50, 100, 50, this);
	Button bByLetter = addButton("Show By Letter", 75, 100, 125, 50, this);
	Button bByTeacher = addButton("Show By Teacher", 200, 100, 125, 50, this);
	Button bFindEmpty = addButton("Find Empty Lockers", 75, 150, 125, 50, this);
	Button bAssignTeacher = addButton("Assign Teacher", 200, 150, 125, 50, this);
	Button bGenNames = addButton("Generate Names", 50, 250, 100 ,50, this);
	Choice cPrint = addChoice("- Output -|Console|Text File",375,50,100,30,this);   
	//All of the on screen actions available to the user
	
	public LockersDB() {
		setSize(500, 250);
		setTitle("Lockers Database");
	}

	public void actions(Object source, String command) {
		
		if(command.equals("Console")){	//Retrieves the user's selection for output
			output = 0;
		}else if(command.equals("Text File")){
			output = 1;
		}
		
		if (source == bClear) {//If the user chose to clear all existing locker assignments
			
			clearList();
		
		} else if (source == bAssign) {//If the user chose to assign a student to a locker
		
			String name = input("Type the name of the student");
			int locker = inputInt("Type the locker number:");
			assignLocker(locker, name);
		
		} else if (source == bShowNames) {//If the user chose to output a selection of names from the database
			int firstlocker = inputInt("Type the first locker in the range:");
			int lastlocker = inputInt("Type the last locker in the range:");
			
			if(output == 0){
				showNames(firstlocker, lastlocker, "*", "*");
			}else if(output == 1){
				printNames(firstlocker, lastlocker, "*", "*");				
			}
				
				
		} else if(source == bGenNames){//A secret button used for debugging
			generateNames();
		
		} else if(source == bAssignTeacher){//Used to assign a homeroom to a selection of lockers
			int firstlocker = inputInt("Type the first locker in the range to be assigned:");
			int lastlocker = inputInt("Type the last locker in the range to be assigned:");
			String teacher = inputString("Type the homeroom teacher that will be assigned to these lockers:");
			assignHomeroom(firstlocker, lastlocker, teacher);
			
		} else if(source == bFindEmpty){//Used to find all empty lockers in the specified range
			int firstlocker = inputInt("Type the first locker in the range:");
			int lastlocker = inputInt("Type the last locker in the range:");
			findLockers(firstlocker, lastlocker);
		
		}else if(source == bByTeacher){//Output names based on homeroom teacher
			String teacher = inputString("Type the homeroom teacher of the lockers you would like to view:");
			
			if(output == 0){
				showNames(0, 2999, teacher, "*");
			}else if(output == 1){
				printNames(0, 2999, teacher, "*");
			}
				
				
		} else if(source == bByLetter){//Output names based on first letter 
			String firstletter = inputString("Type a letter to view all lockers assigned to students that have \n"
					+ "names starting with that letter: \n");
			
			if(output == 0){
				showNames(0, 2999, "*", firstletter);
			}else if(output == 1){
				printNames(0, 2999, "*", firstletter);
			}
		}
	
	}

	public void clearList() // Fills file with blanks
	{
	
		try {
		
			RandomAccessFile data = new RandomAccessFile("lockers.dat", "rw");
			
			for (int rec = 0; rec < 3000; rec = rec + 1) {
				data.seek(rec * 75); // clear the name field
				data.writeUTF("");

				data.seek(rec * 75 + 32); // clear the homeroom teacher field
				data.writeUTF("");

				data.seek(rec * 75 + 64); // clear the combination field
				data.writeUTF("");
			
			}
			
			data.close();
		
		} catch (IOException e) {
			System.out.println("IOException occured in clearList()");
		}
		
	}//end clearList

	public void assignLocker(int locker, String name) // Put student name into
														// file
	{
		
		if (locker >= 3000) { //If you try to assign a locker over the limit of 3000
			return;
		}
		
		try {
		
			RandomAccessFile data = new RandomAccessFile("lockers.dat", "rw");

			if (name.length() > 30) { //Truncates the name if necessary
				name = name.substring(0, 30);
			}

			data.seek(locker * 75);
			
			String namecheck = data.readUTF();
			
			if(namecheck.equals("")){ //If the locker is unoccupied assign the student to the locker
			
				data.seek(locker * 75);
				data.writeUTF(name);
			
			}else {
				
				output("Locker is already occupied.");
				
			}

			data.close();
		
		} catch (IOException e) {
			System.out.println("IOException occured in clearList()");
		}
	
	}//End assignLocker
	
	public void assignHomeroom(int firstlocker, int lastlocker, String teacher){
		//Used to assign homerooms to selections of lockers
		
		try {
			
			RandomAccessFile data = new RandomAccessFile("lockers.dat", "rw");

			if (teacher.length() > 30) { //Truncates the teachers name if necessary
				teacher = teacher.substring(0, 30);
			}

			for (int row = firstlocker; row <= lastlocker; row = row + 1) {
				//Assigns all specified lockers
				
				data.seek(row * 75 + 32);
				data.writeUTF(teacher);
				
			}

			data.close();
		
		} catch (IOException e) {
			System.out.println("IOException occured in clearList()");
		}
		
	}//end assignHomeroom
	
	public void findLockers(int firstlocker, int lastlocker){
		//Used to find which lockers do not have a student assigned to them
		
		try{
			
			RandomAccessFile data = new RandomAccessFile("lockers.dat", "r");
			
			System.out.println("The following lockers do not have a student assigned to them:");
			
			for(int row = firstlocker; row <= lastlocker; row++){
				//Goes through every locker in the database
				
				data.seek(row * 75);
				String name = data.readUTF();
							
				if(name.equals("")){
					//If the current locker is empty
					
					System.out.println(row);
					
				}
				
			}
		
			data.close();
			
		}catch (IOException e) {
			System.out.println("IOException occured in clearList()");
		}
		
	}//end findLockers

	public void showNames(int firstlocker, int lastlocker, String teacher, String firstletter) // Show non-blank names and lockers
	{
		
		try {
		
			RandomAccessFile data = new RandomAccessFile("lockers.dat", "rw");
			
			if(teacher.equals("*") && firstletter.equals("*")){
				//Used to print all students regardless of name or homeroom
			
				for (int row = firstlocker; row <= lastlocker; row = row + 1) {
					data.seek(row * 75);
					String name = data.readUTF();
					data.seek(row * 75 + 32);
					String homeroom = data.readUTF();
					
					if (!name.equals("")) {//If the locker isn't empty
						System.out.println(row + "\t" + name + "\t" + homeroom);
					}
					
				}
				
			}
			
			if(!teacher.equals("*") && firstletter.equals("*")){
				//If a specific teacher is designated
			
				for(int row = firstlocker; row <= lastlocker; row++){
					//Goes through all of the lockers
					
					data.seek(row * 75 + 32);
					String homeroom = data.readUTF();
					
					if(teacher.equals(homeroom)){
						//If the homeroom inputed and the assigned name match
						
						data.seek(row * 75);
						String name = data.readUTF();
								
						System.out.println(row + "\t" + name + "\t" + homeroom);
						
					}
					
				}
				
			}		
			
			if(teacher.equals("*") && !firstletter.equals("*")){
				//If a letter was specified to be used to finding students
				
				for(int row = firstlocker; row <= lastlocker; row++){
					//Goes through all of the lockers
					
					try {
			
						data.seek(row * 75 + 32);
						String homeroom = data.readUTF();
						data.seek(row * 75);
						String letter = data.readUTF();
						String str =letter.substring(0, 1);					
						
						
						if(str.equals(firstletter)){
							//If the current locker has a name starting with the same inputed character
							
							data.seek(row * 75);
							String name = data.readUTF();
	
							System.out.println(row + "\t" + name + "\t" + homeroom);
								
						}
						
					} catch (Exception StringIndexOutOfBoundsException) {
						
					}
					
				}
					
			}	
				
			data.close();
		
		} catch (IOException e) {
			System.out.println("IOException occured in clearList()");
		}
		
	}//End showNames
	
	public void printNames(int firstlocker, int lastlocker, String teacher, String firstletter){
		//Does the exact same thing as show names except it prints the output to a text file
		//See the previous method comments for details
		
		try{
		
			PrintWriter file = new PrintWriter(new FileWriter("H:\\LockerDB.txt"));
		
			try {
				
				RandomAccessFile data = new RandomAccessFile("lockers.dat", "rw");
				
				if(teacher.equals("*") && firstletter.equals("*")){
				
					for (int row = firstlocker; row <= lastlocker; row = row + 1) {
						data.seek(row * 75);
						String name = data.readUTF();
						data.seek(row * 75 + 32);
						String homeroom = data.readUTF();
						
						if (!name.equals("")) {
							file.println(row + "\t" + name + "\t" + homeroom);
						}
						
					}
					
				}
				
				if(!teacher.equals("*") && firstletter.equals("*")){
				
					for(int row = firstlocker; row <= lastlocker; row++){
						
						data.seek(row * 75 + 32);
						String homeroom = data.readUTF();
						
						if(teacher.equals(homeroom)){
							
							data.seek(row * 75);
							String name = data.readUTF();
									
							file.println(row + "\t" + name + "\t" + homeroom);
							
						}
						
					}
					
				}		
				
				if(teacher.equals("*") && !firstletter.equals("*")){
					
					for(int row = firstlocker; row <= lastlocker; row++){
						
						
						try {
				
							data.seek(row * 75 + 32);
							String homeroom = data.readUTF();
							data.seek(row * 75);
							String letter = data.readUTF();
							String str =letter.substring(0, 1);					
							
							
							if(str.equals(firstletter)){
								
								data.seek(row * 75);
								String name = data.readUTF();
		
								file.println(row + "\t" + name + "\t" + homeroom);
									
							}
							
						} catch (Exception StringIndexOutOfBoundsException) {
							
						}
						
					}
						
				}
					
				data.close();
				
			} catch (IOException e) {
				System.out.println("IOException occured in clearList()");
			}
		
			file.close();
				
			runProgram("Notepad.exe \"H:\\LockerDB.txt\""); //Runs notepad and displays the output file
	
		}catch(IOException e1){
			
		}
		
		
		
	}//end printNames

	public void generateNames(){
		//Used for debugging purposes
		
		try {
			
			RandomAccessFile data = new RandomAccessFile("lockers.dat", "rw");

			char a = 65;
			
			for (int row = 0; row <= 25; row++) {
				//Prints every letter of the alphabet in order to a locker
				//and gives them the homeroom or Mr. Meow
				
				String name = Character.toString(a);
				
				data.seek(row * 75);
				data.writeUTF(name);
				data.seek(row * 75 + 32);
				data.writeUTF("Mr. Meow");

				a++;
				
			}
			
			data.close();
		
		} catch (IOException e) {
			System.out.println("IOException occured in clearList()");
		}
	
	}//end generateNames
	
}
