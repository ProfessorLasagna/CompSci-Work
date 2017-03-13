package algorithms.edu;

import java.util.Scanner;

public class Sorting {

	 /*
	 For my sort method I chose to use selection sort. This decision was based off the fact that is easy to implement for this
	 very specific function and because I wrote the method myself so I have a much deeper understanding of how it works compared
	 to if I had just ripped it from a website.
	 */

	public static void main(String args[]){

		String myFriends[] = {"MacKay", "Schofield", "Smith", "Hughes", "Ronaghan", "Copping", "Telford", "Kasprick",
				"Jones", "Weimer", "Quinlan", "Chmillar", "Dickson", "Weigum", "Hill"};

		int input;

		Scanner in = new Scanner(System.in);

		System.out.format("Unsorted:%n");

		for(int k = 0; k < myFriends.length; k++){

			System.out.format("%s%n", myFriends[k]);

		}

		myFriends = selectionSort(myFriends);

		System.out.format("%nSorted:%n");

		for(int k = 0; k < myFriends.length; k++){

			System.out.format("%s%n", myFriends[k]);
//
		}

		System.out.format("%nPlease enter a last name:");
		input = binarySearch(myFriends, in.nextLine());

		if(input == -1)
			System.out.println("Sorry the name you entered was not found on the list.");
		else
			System.out.format("%nThe name %s was found at index %d", myFriends[input], input);


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

	public static String[] selectionSort(String a[]){

		int in = 0, cur = 0, max = a.length, test1 = 0, test2 = a.length;
		String two;
		String one;

		while(cur < max){

			test1 = cur + 1;

			while(test1 < test2){

				if(a[in].compareTo(a[test1]) > 0){

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

		return(a);

	}

}
