package algorithms.edu;

import java.util.Scanner;

public class BinarySearchTwo {
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		int list[] = {12, 13, 32, 35, 46, 68, 71, 73, 88, 94, 99, 100};
		int a = 0;
		
		System.out.println("Please enter a number:");
		int input = in.nextInt();
		
		a = binarySearch(list,input);
		
		if(a == -1)
			System.out.println("Sorry, this number is not in the list.");
		
		else{
			
			if((a-1) < 0){
				
				System.out.format("%nYour number %d was found located at the index %d. %nThere is no number before it"
						+ " and the number after it is %d.", input, a, list[a+1] );
				
			}else if((a+1) > list.length - 1){
				
				System.out.format("%nYour number %d was found located at the index %d. %nThe number before it is %d "
						+ "and there is no number after it.", input, a, list[a-1]);
				
			}else{
			
				System.out.format("%nYour number %d was found located at the index %d. %nThe number before it is %d "
						+ "and the number after it is %d.", input, a, list[a-1], list[a+1] );
		
			}
			
		}
			
		in.close();
		
	}

	private static int binarySearch(int a[], int srchVal){
		
		int lv = 0;
		int hv = a.length-1;
		
		while(hv >= lv){
			
			int mid = (lv + hv) / 2;
			
			if(srchVal == a[mid]){
				
				return(mid);
				
			} else if(srchVal > a[mid]){
				
				lv = mid+1;
				
			} else{
				
				hv = mid - 1;
				
			}
			
		}
		
		return(-1);
	
	}
	
}
