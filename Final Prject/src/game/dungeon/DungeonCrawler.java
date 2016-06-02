package game.dungeon;

import java.awt.*; // contains GUI controls
import java.io.*; // contains data-file commands – for RandomAccessFile
import javax.imageio.ImageIO;

public class DungeonCrawler extends EasyApp{

	private static final long serialVersionUID = 1L;
	Image backgroundimg;
	
	public static void main(String[] args) {
		new DungeonCrawler();
	}
	
	Menu mGame = addMenu("Game|New Game|Load Game|Save Game");
	
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
			
			for(int a = 0; a < 100; a++){
				
				saves.seek(a);
				
			}
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
