package algorithms.edu;

public class InsertionSort {
	
	public static void main(String args[]){
		
		int a[] = {10,0,1,10000,100,1000};
		
		selectionSort(a);		
		
	}
	
	public static void selectionSort(int a[]){
		
		int in = 0, cur = 0, max = a.length, one, two, test1 = 0, test2 = a.length;
			
		while(cur < max){
							
			test1 = cur + 1;
				
			while(test1 < test2){
					
				if(a[in] > a[test1]){
						
				in = test1;	
																
				}
					
				test1++;
					
			}
				
			one = a[in];
			two = a[cur];
			a[cur] = one;
			a[in] = two;
			cur++;
			in = cur;
							
		}
		
		for(int k = 0; k < a.length; k++){
			
			System.out.format("%d ", a[k]);
			
		}
		
	}

	
	//Program takes the array of integers(can be changed) and sends it to the selection sort method
	//where it will find the lowest number in the data collection and place it in the first index. 
	//It will then move on to the second index where it will continue in order until all numbers
	//in the array are sorted from least to greatest.
	
}
