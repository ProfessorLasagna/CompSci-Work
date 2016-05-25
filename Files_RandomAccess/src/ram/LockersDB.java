package ram;

import java.awt.*; // contains GUI controls
import java.io.*; // contains data-file commands – for RandomAccessFile

public class LockersDB extends EasyApp {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new LockersDB();
	}

	Button bClear = addButton("Clear All", 50, 50, 100, 50, this);
	Button bAssign = addButton("Assign", 150, 50, 100, 50, this);
	Button bShowNames = addButton("Show Names", 250, 50, 100, 50, this);
	Button bGenNames = addButton("Generate Names", 50, 150, 100 ,50, this);

	public LockersDB() {
		setSize(500, 150);
		setTitle("Lockers Database");
	}

	public void actions(Object source, String command) {
		if (source == bClear) {
			
			clearList();
		
		} else if (source == bAssign) {
		
			String name = input("Type the name of the student");
			int locker = inputInt("Type the locker number:");
			String homeroom = inputString("Type the students homeroom teacher:");
			assignLocker(locker, name, homeroom);
		
		} else if (source == bShowNames) {
			int firstlocker = inputInt("Type the first locker in the range:");
			int lastlocker = inputInt("Type the last locker in the range:");
			String teacher = inputString("Type the homeroom teacher of the lockers you would like to view:"
					+ " \n (Use \"*\" to show all lockers.)");
			String firstletter = inputString("Type a letter to view all lockers assigned to students that have \n"
					+ "names starting with that letter: \n"
					+ "(Use \"*\" to show all lockers.)");
			showNames(firstlocker, lastlocker, teacher, firstletter);
		
		}else if(source == bGenNames){
			generateNames();
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
		
	}

	public void assignLocker(int locker, String name, String homeroom) // Put student name into
														// file
	{
		
		if (locker >= 3000) {
			return;
		}
		
		try {
		
			RandomAccessFile data = new RandomAccessFile("lockers.dat", "rw");

			if (name.length() > 30) {
				name = name.substring(0, 30);
			}

			data.seek(locker * 75);
			
			String namecheck = data.readUTF();
			
			if(namecheck.equals("")){
			
				data.seek(locker * 75);
				data.writeUTF(name);
				data.seek(locker * 75 + 32);
				data.writeUTF(homeroom);
			
			}else {
				
				output("Locker is already occupied.");
				
			}

			data.close();
		
		} catch (IOException e) {
			System.out.println("IOException occured in clearList()");
		}
	
	}

	public void showNames(int firstlocker, int lastlocker, String teacher, String firstletter) // Show non-blank names and lockers
	{
		
		try {
		
			RandomAccessFile data = new RandomAccessFile("lockers.dat", "rw");
			
			if(teacher.equals("*") && firstletter.equals("*")){
			
				for (int row = firstlocker; row <= lastlocker; row = row + 1) {
					data.seek(row * 75);
					String name = data.readUTF();
					data.seek(row * 75 + 32);
					String homeroom = data.readUTF();
					
					if (!name.equals("")) {
						System.out.println(row + "\t" + name + "\t" + homeroom);
					}
					
				}
				
			}
			
			for(int row = firstlocker; row <= lastlocker; row++){
				
				data.seek(row * 75 + 32);
				String homeroom = data.readUTF();
				
				if(teacher.equals(homeroom)){
					
					data.seek(row * 75);
					String name = data.readUTF();
							
					System.out.println(row + "\t" + name + "\t" + homeroom);
					
				}
				
			for(int row = firstlocker; row <= lastlocker; row++){
					
				data.seek(row * 75 + 32);
				String homeroom = data.readUTF();
					
				if(teacher.equals(homeroom)){
						
					data.seek(row * 75);
					String name = data.readUTF();
								
					System.out.println(row + "\t" + name + "\t" + homeroom);
						
				}
				
			}		
				
			data.close();
		
		} catch (IOException e) {
			System.out.println("IOException occured in clearList()");
		}
		
	}

	public void generateNames(){
		
		try {
			
			RandomAccessFile data = new RandomAccessFile("lockers.dat", "rw");

			char a = 65;
			
			for (int row = 0; row <= 25; row++) {
				
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
	
		
	}
	
}
