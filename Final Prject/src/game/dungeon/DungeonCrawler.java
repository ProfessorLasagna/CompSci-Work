package game.dungeon;

import java.awt.*; // contains GUI controls
import java.io.*; // contains data-file commands – for RandomAccessFile
import javax.imageio.ImageIO;

public class DungeonCrawler extends EasyApp{

	private static final long serialVersionUID = 1L;
	Image backgroundimg, monstergoblin, monsterskeleton, bossmummy, health0, health1, health2, health3, health4;
	public int currentsave = 0;
	public int location = 0;
	public int gold = 0;
	public int level = 1;
	public int monsterhealth = 4;
	public int monstergen = 0;
	public int playerhealth = 5;
	public int healthloop = 1, healthdisplay = 0;
	public Boolean monsterattack = false, bossattack = false;
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
	Button bRun = addButton("Run Away!", 365, 450, 125, 25, this);
	
	public DungeonCrawler(){
	
		setSize(750, 500);
		setResizable(false);
		setTitle("The Dungeon Game");
	
	}
	
	public void paint(Graphics g) {	
		
		
		try {
			
			backgroundimg = ImageIO.read(new File("background.jpg"));
			monstergoblin = ImageIO.read(new File("monstergoblinresize.png"));
			monsterskeleton = ImageIO.read(new File("skeeletonfullsize.png"));
			bossmummy = ImageIO.read(new File("mummy.gif"));
			health0 = ImageIO.read(new File("monsterhealthbar.png"));
			health1 = ImageIO.read(new File("monsterhealthbar-1.png"));
			health2 = ImageIO.read(new File("monsterhealthbar-2.png"));
			health3 = ImageIO.read(new File("monsterhealthbar-3.png"));
			health4 = ImageIO.read(new File("monsterhealthbar-4.png"));
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
        g.drawImage(backgroundimg, 0, 0, null);
        
        if(monstergen == 1){
        	g.drawImage(monstergoblin, 350, 200, null);
        }else if(monstergen == 2){
        	g.drawImage(monsterskeleton, 250, 100, null);
        }else if(monstergen == 3){
        	g.drawImage(bossmummy, 250, 100, null);
        }

        if(monstergen!= 0 && monsterhealth == 4){
        	g.drawImage(health0, 375, 400, null);
        }else if(monstergen!=0 && monsterhealth == 3){
        	g.drawImage(health1, 375, 400, null);
        }else if(monstergen!=0 && monsterhealth == 2){
        	g.drawImage(health2, 375, 400, null);
        }else if(monstergen!=0 && monsterhealth == 1){
        	g.drawImage(health3, 375, 400, null);
        }else if(monstergen!=0 && monsterhealth == 0){
        	g.drawImage(health4, 375, 400, null);
        }
        
        
      
        
    }
	
	
	public void actions(Object source, String command) {
		
		if(command.equals("Game|New Game")){
			
			String newgame = inputString("Please enter the name of your save:");
			
			createGame(newgame);
			
		}else if(command.equals("Game|Save Game")){
			
			saveGame();

		}else if(command.equals("Game|Load Game")){
			
			String name = inputString("Please enter the name of your save:");
			loadGame(name);
			
		}
		
		if(activegame){
		
			if(!monsterattack){
				
				revalidate();
				repaint();
			
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
							+ "\nYour highscore is tracked by how strong you get in the dungeon. The game ends when you die"
							+ "\nor defeat the big bad mummy in the biggest room at the end of the dungeon."
							+ "\nGet stronger by defeating monsters to get more health."
							+ "\n\"Run\" will allow you to flee from your attacker but you will not get any stronger."
							+ "\nGood Luck!");
					
				}
				
			}
			
			if(source == bAttack){
				
				if(monsterhealth == 4 || monsterhealth == 3 || monsterhealth == 2){
					
					monsterhealth--;
					System.out.println("You hit the monster!");
					
					if(((int) (2 * Math.random() + 1) == 1) && monsterattack){
						playerhealth--;
						System.out.println("The monster hit you!");
						System.out.println("Your Health: "+playerhealth +"/"+ (5+healthloop));
					
					}else if(((int) (2 * Math.random() + 1) == 1) && bossattack){
						
						playerhealth--;
						playerhealth--;
						playerhealth--;
						System.out.println("The mummy hit you for 3 damage!");
						System.out.println("Your Health: "+playerhealth +"/"+ (5+healthloop));
						
					}else{
					
						System.out.println("The monster missed you!");
					}
					
					if(playerhealth < 0){
						
						output("Game Over! You died.");
						activegame = false;
						
					}
					
					revalidate();
					repaint();
					
				}else if(monsterhealth == 1 && monsterattack){
					
					monsterhealth--;
					System.out.println("You hit the monster!");
					System.out.println("You defeated the monster!");
					System.out.println("Your were fully healed and your overall health increased by 1!");
					playerhealth = 5 + healthloop;
					healthloop++;
					healthdisplay++;
					monsterattack = false;
					monstergen = 0;
					
					revalidate();
					repaint();
																
					
				}else if(monsterhealth == 1 && bossattack){
					
					monsterhealth--;
					System.out.println("You hit the mummy!");
					System.out.println("You defeated the final boss!");
					System.out.println("Your were fully healed and your overall health increased by 1!");
					playerhealth = 5 + healthloop;
					healthloop++;
					healthdisplay++;
					monsterattack = false;
					monstergen = 0;
					
					revalidate();
					repaint();
					
					output("You did it! You beat the boss and won the game! \n Great Job!");
					activegame = false;
								
			
				}else{
					output("You are not in combat!");
				}
				
			}else if(source == bRun){
				
				monsterattack = false;
				monsterhealth = 0;
				monstergen = 0;
				revalidate();
				repaint();
				output("You flee from the monster.");
				
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
					playerhealth = 5;
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
			saves.writeInt(location);
			saves.seek(currentsave * 150 + 40);
			saves.writeInt(playerhealth);
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
				
					saves.seek(row * 150 + 36);
					location = saves.readInt();
					saves.seek(currentsave * 150 + 40);
					playerhealth = saves.readInt();
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
		
		attackMonster();
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
		
		attackMonster();		
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
		
		attackMonster();
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
		
		attackMonster();
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
	
	public void attackMonster(){
		
		if(location == 8){
			
			System.out.println("You've reached the final boss!");
			monstergen = 3;
			monsterhealth = 4;
			bossattack = true;
			
		}else{
		
			monstergen = (int) (2 * Math.random() + 1);
			monsterhealth = 4;
			monsterattack = true;
			System.out.println("You are under attack!");
			
		}
		
	}
	
}
