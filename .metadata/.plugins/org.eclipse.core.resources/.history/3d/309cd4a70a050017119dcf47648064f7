package algorithms.edu;

public class InsertionSort {
	
	public static void main(String args[]){
		
		int a[] = {9, 16, 19, 25, 99, 1, 2, 1205, 123, 5643, 9876, 129, 3};
		
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

}
