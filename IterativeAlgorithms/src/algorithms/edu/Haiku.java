package algorithms.edu;

/*****************

This example sorts a text-file alphabetically, assuming each line 
in the file contains a single String (e.g. a word).
It uses the following algorithm:
(1) read all the Strings from the file into the list[] array
(2) sorts the array
(3) writes all the Strings from list[] back into the file

Notice that this only works if the file contains no more
than 1000 Strings.  Also, the original file is destroyed.

****************/

import java.io.*;
import java.util.*;

public class Haiku{
	
   public static void main(String[] args){
	   
	   Scanner in = new Scanner(System.in);
	   int input;

	   System.out.format("Please enter the number next to the list you would like to view and sort:"
	   		+ "%n1.Haikupoem.txt"
	   		+ "%n2.HaikuPoem2.txt"
	   		+ "%n3.haikuPoem3.txt%n");
	   
	   input = in.nextInt();
	   
	   System.out.format("%n");
	   
	   if(input == 1){
		   new Haiku("HaikuPoem.txt");    
	   }
	   
	   else if(input == 2){
		   new Haiku("HaikuPoem2.txt"); 
	   }
	   
	   else if(input == 3){
		   new Haiku("HaikuPoem3.txt"); 
	   }
	   
	   in.close();
	   
   }
   
   public Haiku(String fileName){
	   
      String[] list = new String[1000];
      int count = 0;
      
      try{
    	  
         // Read all the Strings from the file into list[]
         BufferedReader info = new BufferedReader(new FileReader(fileName));
         
         while (info.ready()){
        	 
            String item = info.readLine();
            list[count] = item;
            count = count + 1;
         
         }
         
         info.close(); 
         
         System.out.format("Unsorted:%n");
         
         for(int a = 0; a < list.length; a++){
        	 
        	 if(list[a] != null)
        	 System.out.format("%s%n", list[a]);
        	 
         }
         
         sort(list,count);
         
         // Write sorted Strings back into the file
         PrintWriter outfo = new PrintWriter(new FileWriter(fileName));
         
         for (int x = 0; x < count; x = x+1){
        	 
            outfo.println(list[x]);
         
         }
         
         outfo.close();
         
         System.out.format("%nSorted:%n");
         
         for(int a = 0; a < list.length; a++){
        	 
        	 if(list[a] != null)
             System.out.format("%s%n", list[a]);
        	 
         }
      
      }
     
      catch (IOException ex){
    	  
    	  System.out.println(ex.toString()); 
    	  
      }
   
   }
   
   public void sort(String[] list,int count){
   // A very simple, stupid Bubble Sort
   // list[] contains the Strings to be sorted
   // count tells how many Strings are in the array
   
      for (int pass = 0; pass < count; pass = pass+1){
      
         for (int p = 0; p < count-1; p = p + 1){
         
            if (list[p].compareTo(list[p+1])>0){
            
               String temp = list[p];
               list[p] = list[p+1];
               list[p+1] = temp;
            }
            
         }
         
      }
      
   }
   
}
