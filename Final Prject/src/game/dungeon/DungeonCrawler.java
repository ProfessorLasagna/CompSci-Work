package game.dungeon;

import java.awt.*; // contains GUI controls
import java.io.*; // contains data-file commands – for RandomAccessFile
import javax.imageio.ImageIO;

public class DungeonCrawler extends EasyApp{

	private static final long serialVersionUID = 1L;
	Image backgroundimg;
	public int currentsave = 0;
	public int location = 0;
	public int gold = 0;
	public Boolean activegame = false;
	
	public static void main(String[] args) {
		new DungeonCrawler();
	}
	
	Menu mGame = addMenu("Game|New Game|Load Game|Save Game|Quit");
	Button bNorth = addButton("North", 125, 300, 100, 50, this);
	Button bWest = addButton("West", 25, 350, 100, 50, this);
	Button bSouth = addButton("South", 125, 400, 100, 50, this);
	
	public DungeonCrawler(){
	
		setSize(750, 500);
		setTitle("Lockers Database");
	
	}
	
	public void paint(Graphics g)
    {	
		try {
			
			backgroundimg = ImageIO.read(new File("background.jpg"));
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
        g.drawImage(backgroundimg, 0, 0, null);

    }
	
	public void actions(Object source, String command) {
		
		if(command.equals("Game|New Game")){
			
			String newgame = inputString("Please enter the name of your save:");
			createGame(newgame);
			
		}
		
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
			output("Game Saved!");
			
			saves.close();
			
		}catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	
}