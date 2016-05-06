package datastructs;

import java.util.Scanner;

public class FriendFinder {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String[] aFriends = {"Bryan", "Carmen", "Michael",  "Julie", "Hank", "Susan", "Alex", "Kyle", "Austin", "Stephanie", "Joey"};
		String[] aLikes = {"Computers", "Reading", "Movies", "Singing", "Basketball", "Soccer", "Video Games", "Dogs", "Acting", "Comedy", "Hockey"};
		String[] bFriends = {"Ben", "Josh", "Johnny", "Joseph", "Jakob", "Jennifer", "Bill", "Ashley", "Carmen", null, null, null, null, null, null};
		String[] bLikes = {"Video Games", "Reading", "Comedy", "Programming", "Singing", "Hockey", "Math", "Writing", "Reading", null, null, null, null, null, null};
		
		String term;
		int index, loop = 0, bFriendcount = 9, loopcount = 0; 
		//The index is defined as the point to be covered by the Bryan array's, the loop is meant to  run until all friends that 
		//can be recommended have been recommended , and the friend count is used to count how many friends Bryan has
		
		char choice;
		//The value that will store whether or not the user wants to add a friend
		
		System.out.format("Hello! Welcome to the friend finder, you are currently browsing your friend Ashley's friends list."
				+ "%nAshley's current friends: %n ");
		
		for(int a = 0; a < 11; a++){
			//Prints out all of the friend names
			
			System.out.format("%n%d.%s",  (a+1), aFriends[a]);
			
		}
		
		do{
		
			System.out.format("%n %nPlease enter a friends name in order to see their interests: ");
			
			term = in.nextLine();
			
			index = search(aFriends, term);
			//Set's the index to the friends that the method finds
			
			if(index == -1){
				//If the method couldn't find that friend
				
				System.out.format("%nSorry! That friend is not on the list.");
				
			} else{
			
				System.out.format("%n%s likes %s.", aFriends[index], aLikes[index]);
			
			}
			
			loop++;
			//Used to let the user loop three times
			
		}while(loop <= 2);
			
		System.out.format("%n %n %nNow the friend finder will find you new friend option based on the likes of your friends and Ashley's friends."
				+ "%nEach new friend will be suggested in order and you will be given the oportunity to accept or deny them as a friend."
				+ "%nAfter every suggestion your current friends list will be printed. There is a maximum of 12 friends."
				+ "%n %nCurrent friends list: %n ");
		
		for(int a = 0; a < bFriendcount; a++){
			//Prints out all of the friend names
			
			System.out.format("%n%d.%s",  (a+1), bFriends[a]);
			
		}
		
		do{	
			
			for(int a = 3; a < 11; a++){
				//Goes through all of Ashley's friends
				
				if(bFriendcount == 12){
					//If the user has the maximum amount of friends
					
					System.out.format("%n %nMaximum friend limit reached. No more can be added. Final friends list: %n");
					
					for(int b = 0; b < bFriendcount; b++){
						//Prints out all of the friend names
						
						System.out.format("%n%d.%s",  (b+1), bFriends[b]);
						
					}
					
					loopcount = 10; //Ends the loop
					break;
					
				}
			
				if(bLikes[loopcount] == aLikes[a]){
					//If Bryan's friends have any likes in common with Ashley's friends
				
					System.out.format("%n %nIt would appear your friend %s likes %s and Ashley's friend %s also likes %s!"
							+ "%nWould you like to add %s as a friend? (Y/N/Exit)%n", bFriends[loopcount], bLikes[loopcount], aFriends[a], aLikes[a], aFriends[a]);
					
					choice = in.next().toUpperCase().charAt(0);
					
					if(choice == 89){
						//If the user chose to add that friend
						
						bFriends[(bFriendcount)] = aFriends[a]; //Adds the common friend to Bryan's friends list
						bLikes[(bFriendcount)] = aLikes[a]; //Adds the common likes to Bryan's friends likes
						bFriendcount++;
						
					}else if(choice == 69) //If the user chose to exit
						loopcount = 10; //Ends the loop
					
					System.out.format("%n %nCurrent friends list: %n");
					
					for(int b = 0; b < bFriendcount; b++){
						//Prints out all of the friend names
						
						System.out.format("%n%d.%s",  (b+1), bFriends[b]);
						
					}
					
				}		
					
			}
			
			loopcount++; 
			
		}while(loopcount < 9);
		//Until all the friends have been compared
			
		System.out.format("%n %nGoodbye!");
		
		in.close();
		
	}//End main

	public static int search(String[] aFriends, String term){
		//The method that will compare the user's input against the predefined list of friends
		
		int index = -1;
		//The default value for index in case the user entered a friend that did not exist
		
		for(int a = 0; a < 11; a++){
			//Goes through all ten friends and compares them to the input
			
			if(aFriends[a].equals(term)){
				//If the current comparison is true
				
				index = a; //Assigns the index value to the current index so that the rest of that friends data can be retrieved
				break;
				
			}
			
		}
		
		return index;
		//Returns the found index value or returns the default one in case of a lack of a matching friend
		
	}//End search
		
}

