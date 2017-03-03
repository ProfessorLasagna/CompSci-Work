package algorithms.edu;

import java.util.Scanner;

public class SearchAndSort {
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		String a[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", 
				"p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		String input;
		
		System.out.format("Please enter a letter to evaluate:");
		input = in.nextLine(); 
		
		System.out.println(binarySearch(a, input) + 1);
		
		in.close();
		
	}

	private static int binarySearch(String a[], String srchVal){
		
		int lv = 0;
		int hv = a.length-1;
		
		while(hv >= lv){
			
			int mid = (lv + hv) / 2;
			
			if(srchVal.compareTo(a[mid]) == 0){
				
				return(mid);
				
			} else if(srchVal.compareTo(a[mid]) > 0){
				
				lv = mid+1;
				
			} else{
				
				hv = mid - 1;
				
			}
			
		}
		
		return(-1);
	
	}
	
}
