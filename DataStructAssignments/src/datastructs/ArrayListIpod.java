package datastructs;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListIpod {
	
	public static ArrayList<String> songs = new ArrayList<String>();
	public static ArrayList<String> artists = new ArrayList<String>();
	public static ArrayList<String> myplaylistsongs = new ArrayList<String>();
	public static ArrayList<String> myplaylistartists = new ArrayList<String>();
	//The four public arrays that will hold the songs, the artists of those songs, and the users playlist
	
	public static int y = 10; //Used to recognize how many songs the user has
	public static int z = 0;  //Used to recognize how many songs are in the users playlist
	
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
		//The ten songs and their artists
		
		Scanner in = new Scanner(System.in);
		
		int choice, removal, addition; //Used to store the user's choice, what songs they want to remove, and what songs they want to add to their playlist
		String songchoice, artistchoice;//Used to store what songs the user what like to add to the list
		
		System.out.format("Hello! This is your music center. Below the currently available songs for playback are listed.");
				
		PrintSongs();
		//Runs the method that prints all of the users songs
		
		do{
		
			System.out.format("%n %nWhat would you like to do?"
					+ "%n1. Add a new song"
					+ "%n2. Delete a song"
					+ "%n3. Add a song to your playlist"
					+ "%n4. Exit%n %n");
			
			choice = in.nextInt();
			
			if(choice == 1){
				//If the user chose to add a song
				
				System.out.format("%nPlease enter the name of the song you would like to add: ");
				
				in.nextLine();
				songchoice = in.nextLine();
				
				System.out.format("%nPlease enter the name of the artist of the song you just entered: ");
				
				artistchoice = in.nextLine();
				
				System.out.format("%nThe updated song list is available below:%n");
				
				songs.add(songchoice); artists.add(artistchoice);
				//adds the song and it's artist to the list of songs
				
				y++;
				//Increases the recognized amount of songs on the list
				
				PrintSongs();
				//Re-lists the songs on the list
				
			}else if(choice == 2){
				//If the user chose to remove a song from their list
				
				System.out.format("Please enter the number next to the song you would like to delete: ");
				
				removal = in.nextInt();
				
				songs.remove(removal-1); //Removes the selected song and decreases the recognized amount of songs on the list
				artists.remove(removal-1);
				y--;
				
				System.out.format("%nThe updated song list is available below:%n");
				
				PrintSongs();
				//Re-lists the songs on the list
				
			}else if(choice == 3){
				//If the user chose to add a song to their playlist
				
				System.out.format("Please enter the number next to the song you would like to add to your playlist: ");
				
				addition = in.nextInt();
				
				myplaylistsongs.add(songs.get(addition-1)); //Adds the song and it's artist to the playlist and increases the song count by one
				myplaylistartists.add(artists.get(addition-1));		
				z++;
				
				System.out.format("%nYour updated playlist list is available below:%n");
				
				PrintPlaylist();
				//Re-lists the songs on the list
				
			}else if(choice == 4) //If the user chose to exit
				break;
			
		}while(true);
		//Until the user exits
			
		System.out.format("Goodbye!");
		
		in.close();
		
	}//End main

	public static void PrintSongs(){
		//The method that is used to prints all of the songs the user has
		
		System.out.format("%nSong List:%n %n   Song       Artist%n---------------------");
		
		for(int x = 0; x < y; x++){
			//Uses y to determine how many songs to print
			
			System.out.format("%n%d. %-10s %s", (x+1), songs.get(x), artists.get(x));
			
		}
		
	}//End PrintSongs
	
	public static void PrintPlaylist(){
		//The method used to list all of the songs in the user's playlist
		
		System.out.format("%nSong List:%n %n   Song       Artist%n---------------------");
		
		for(int x = 0; x < z; x++){
			//Uses z to determine how many songs to prnt
			
			System.out.format("%n%d. %-10s %s", (x+1), myplaylistsongs.get(x), myplaylistartists.get(x));
			
		}
		
	}//End PrintPlayList
	
}
