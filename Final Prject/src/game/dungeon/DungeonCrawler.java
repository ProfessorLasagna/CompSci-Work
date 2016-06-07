package game.dungeon;

import java.awt.*; // contains GUI controls
import java.awt.image.ImageObserver;
import java.io.*; // contains data-file commands – for RandomAccessFile
import javax.imageio.ImageIO;

public class DungeonCrawler extends EasyApp{

	private static final long serialVersionUID = 1L;
	Image backgroundimg, monstergoblin;
	public int currentsave = 0;
	public int location = 0;
	public int gold = 0;
	public int level = 1;
	public Boolean activegame = false;
	
	public static void main(String[] args) {
		new DungeonCrawler();
	}
	
	Menu mGame = addMenu("Game|New Game|Load Game|Save Game|Quit");
	Button bNorth = addButton("North", 125, 300, 75, 50, this);
	Button bWest = addButton("West", 50, 350, 75, 50, this);
	Button bSouth = addButton("South", 125, 400, 75, 50, this);
	Button bEast = addButton("East", 200, 350, 75, 50, this);
	Button bMap = addButton("Map", 675, 75, 50, 50, this);
	Button bHelp = addButton("?", 25, 75, 25, 25, this);
	Button bAttack = addButton("Attack", 125, 350, 75, 50, this);
	
	public DungeonCrawler(){
	
		setSize(750, 500);
		setTitle("Lockers Database");
	
	}
	
	public void paint(Graphics g) {	
		try {
			
			backgroundimg = ImageIO.read(new File("background.jpg"));
			monstergoblin = ImageIO.read(new File("monstergoblinresize.png"));
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
        g.drawImage(backgroundimg, 0, 0, null);


    }
	
	public void update(){
		
		try {
			
			monstergoblin = ImageIO.read(new File("monstergoblinresize.png"));
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
        Graphics.drawImage(monstergoblin, 0, 0, null);


    }
	
	}
	
	public void actions(Object source, String command) {
		
		if(command.equals("Game|New Game")){
			
			String newgame = inputString("Please enter the name of your save:");
			update(null);
			createGame(newgame);
			
		}else if(command.equals("Game|Save Game")){
			
			saveGame();
			
		}else if(command.equals("Game|Load Game")){
			
			String name = inputString("Please enter the name of your save:");
			loadGame(name);
			
		}
		
		if(activegame){
		
			if(source == bNorth){
				
				if(location == 0 || location == 1 || location == 4 || location == 5 || location == 6)
				goNorth();
				
				else
				output("You cannot go anymore north!");
					
			}else if(source == bSouth){
				
				if(location == 1 || location == 6 || location == 3 || location == 7 || location == 8)
				goSouth();
				
				else
				output("You cannot go anymore south!");
				
			}else if(source == bWest){
				
				if(location == 2 || location == 3 || location == 5 || location == 6)
				goWest();
				
				else
				output("You cannot go anymore west!");
				
			}else if(source == bEast){
				
				if(location == 1 || location == 2 || location == 3 || location == 7)
				goEast();
				
				else
				output("You cannot go anymore east!");
				
			}else if(source == bMap){
				viewMap();
			
			}else if(source == bHelp){
				
				output("Welcome to the dungeon! Clicking \"Map\" will show your current location in the dungeon."
						+ "\nNavigate the dungeon using the directional buttons on the bottom right of your screen."
						+ "\nYour highscore is tracked by how much gold you find in the dungeon. The game ends when you die"
						+ "\nor defeat the big bad goblin in the biggest room at the end of the dungeon."
						+ "\nLevel up by defeating monsters to do more damage."
						+ "\n\"Run\" will allow you to flee from your attacker but you will not gain any experience."
						+ "\nGood Luck!");
				
			}
			
		}else
		output("Please begin a game first.");
						
	}
	
	public void createGame(String name){
		
		try {
			
			RandomAccessFile saves = new RandomAccessFile("saves.dat", "rw");
			
			saves.seek(101*150);
			saves.writeUTF("");
			
			if (name.length() > 30) { //Truncates the name if necessary
				name = name.substring(0, 30);
			}
			
			for(int row = 0; row < 100; row++){
				
				saves.seek(row * 150);
				String namecheck = saves.readUTF();
				
				if(namecheck.equals("")){
				
					saves.seek(row * 150);
					saves.writeUTF(name);
					output("Game Created!");
					location = 0;
					gold = 0;
					level = 1;
					currentsave = row;
					activegame = true;
					break;
				
				}
				
			}	
			
			saves.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}	
		
	}

	public void saveGame(){
		
		try {
			
			RandomAccessFile saves = new RandomAccessFile("saves.dat", "rw");
			
			saves.seek(currentsave * 150 + 32);
			saves.writeInt(gold);
			saves.seek(currentsave * 150 + 36);
			saves.writeInt(location);
			saves.seek(currentsave * 150 + 40);
			saves.writeInt(level);
			output("Game Saved!");
			
			saves.close();
			
		}catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void loadGame(String name){
		
		try{
			
			RandomAccessFile saves = new RandomAccessFile("saves.dat", "rw");
			
			saves.seek(101*150);
			saves.writeUTF("");
			
			if (name.length() > 30) { //Truncates the name if necessary
				name = name.substring(0, 30);
			}
			
			for(int row = 0; row < 100; row++){
				
				saves.seek(row * 150);
				String namecheck = saves.readUTF();
				
				if(namecheck.equals(name)){
				
					saves.seek(row * 150 + 32);
					gold = saves.readInt();
					saves.seek(row * 150 + 36);
					location = saves.readInt();
					saves.seek(currentsave * 150 + 40);
					level = saves.readInt();
					currentsave = row;
					activegame = true;
					output("Game Loaded!");
					break;
				
				}

			}
			
			saves.close();
			
		}catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void goNorth(){
	
	if(location == 0)
		location = 1;
	
	else if (location == 1)
		location = 7;
	
	else if(location == 4)
		location = 3;
	
	else if(location == 5)
		location = 6;
	
	else if(location == 6)
		location = 8;
		
	}
	
	public void goSouth(){
		
		if(location == 1)
			location = 0;
		
		else if(location == 7)
			location = 1;
		
		else if(location == 3)
			location = 4;
		
		else if(location == 6)
			location = 5;
		
		else if(location == 8)
			location = 6;
		
	}
	
	public void goEast(){
		
		if(location == 1)
			location = 2;
		
		else if(location == 2)
			location = 3;
		
		else if(location == 3)
			location = 5;
		
		else if(location == 7)
			location = 6;
		
	}

	public void goWest(){
		
		if(location == 2)
			location = 1;
		
		else if(location == 3)
			location = 2;
		
		else if(location == 5)
			location = 3;
		
		else if(location == 6)
			location = 7;
		
	}
	
	public void viewMap(){
		
		if(location == 0)
			runProgram("Notepad.exe \"maps\\map1.txt\"");
		
		else if(location == 1)
			runProgram("Notepad.exe \"maps\\map2.txt\"");
		
		else if(location == 2)
			runProgram("Notepad.exe \"maps\\map3.txt\"");
		
		else if(location == 3)
			runProgram("Notepad.exe \"maps\\map4.txt\"");
		
		else if(location == 4)
			runProgram("Notepad.exe \"maps\\map5.txt\"");
		
		else if(location == 5)
			runProgram("Notepad.exe \"maps\\map6.txt\"");
		
		else if(location == 6)
			runProgram("Notepad.exe \"maps\\map7.txt\"");
		
		else if(location == 7)
			runProgram("Notepad.exe \"maps\\map8.txt\"");
		
		else if(location == 8)
			runProgram("Notepad.exe \"maps\\map9.txt\"");
		
	}
	
}
