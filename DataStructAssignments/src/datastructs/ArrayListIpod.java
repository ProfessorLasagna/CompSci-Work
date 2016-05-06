package datastructs;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListIpod {
	
	public static ArrayList<String> songs = new ArrayList<String>();
	public static ArrayList<String> artists = new ArrayList<String>();
	public static ArrayList<String> myplaylistsongs = new ArrayList<String>();
	public static ArrayList<String> myplaylistartists = new ArrayList<String>();
	public static int y = 10;
	public static int z = 0;
	
	public static void main(String[] args) {
		
		songs.add("Meow");	artists.add("Meow");
		songs.add("dfg");	artists.add("ghghg");
		songs.add("gfgggg");	artists.add("ghghgh");
		songs.add("gggg");	artists.add("hghgh");
		songs.add("gggg");	artists.add("ssssss");
		songs.add("fdfg");	artists.add("hghgh");
		songs.add("dfhjjj");	artists.add("ghghk");
		songs.add("drt");	artists.add("kkkk");
		songs.add("dfg");	artists.add("uukf");
		songs.add("hgfhf");	artists.add("fghfgh");
		
		Scanner in = new Scanner(System.in);
		
		int choice, removal, addition;
		String songchoice, artistchoice;
		
		System.out.format("Hello! This is your music center. Below the currently available songs for playback are listed.");
				
		PrintSongs();
		
		do{
		
			System.out.format("%n %nWhat would you like to do?"
					+ "%n1. Add a new song"
					+ "%n2. Delete a song"
					+ "%n3. Add a song to your playlist"
					+ "%n4. Exit%n %n");
			
			choice = in.nextInt();
			
			if(choice == 1){
				
				System.out.format("%nPlease enter the name of the song you would like to add: ");
				
				in.nextLine();
				songchoice = in.nextLine();
				
				System.out.format("%nPlease enter the name of the artist of the song you just entered: ");
				
				artistchoice = in.nextLine();
				
				System.out.format("%nThe updated song list is available below:%n");
				
				songs.add(songchoice); artists.add(artistchoice);
				
				y++;
				
				PrintSongs();
				
			}else if(choice == 2){
				
				System.out.format("Please enter the number next to the song you would like to delete: ");
				
				removal = in.nextInt();
				
				songs.remove(removal-1);
				artists.remove(removal-1);
				y--;
				
				System.out.format("%nThe updated song list is available below:%n");
				
				PrintSongs();
				
			}else if(choice == 3){
				
				System.out.format("Please enter the number next to the song you would like to add to your playlist: ");
				
				addition = in.nextInt();
				
				myplaylistsongs.add(songs.get(addition-1));
				myplaylistartists.add(artists.get(addition-1));
				
				z++;
				
				System.out.format("%nYour updated playlist list is available below:%n");
				
				PrintPlaylist();
				
			}else if(choice == 4)
				break;
			
		}while(true);
			
		System.out.format("Goodbye!");
		
		in.close();
		
	}

	public static void PrintSongs(){
		
		System.out.format("%nSong List:%n %n   Song       Artist%n---------------------");
		
		for(int x = 0; x < y; x++){
			
			System.out.format("%n%d. %-10s %s", (x+1), songs.get(x), artists.get(x));
			
		}
		
	}
	
	public static void PrintPlaylist(){
		
		System.out.format("%nSong List:%n %n   Song       Artist%n---------------------");
		
		for(int x = 0; x < z; x++){
			
			System.out.format("%n%d. %-10s %s", (x+1), myplaylistsongs.get(x), myplaylistartists.get(x));
			
		}
		
	}
	
}
