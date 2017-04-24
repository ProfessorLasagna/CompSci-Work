package game;

public class Interface {

	public Interface(){
	
			printInterface(9, 2, 3, 4, 5);
		
	}
	
	public void printInterface(int s1, int s2, int s3, int s4, int s5){
		
		int rows = 10;
		int rownum = 1;
		
		System.out.format("      1  2  3  4  5  6  7  8  9  10%n"
				+ "   ________________________________");
		
		for(int x = 0; x < 100; x++){
			
			if(rows > 9){
				
				System.out.format("%n%2d | ", rownum);
				rows = 0;
				rownum++;
				
			}
			
			if(s1 == x || s2 == x || s3 == x || s4 == x || s5 == x){
				
				System.out.format(" I ");
				rows++;
				
			}else{
				
				System.out.format(" + ");
				rows++;
				
			}
			
		}
		
	}
	
}
