package game;

public class Interface {
	
	public static int[] bb = new int[5];
	public static int[] ca = new int[4];
	public static int[] dd = new int[3];
	public static int[] cl = new int[3];
	public static int[] ss = new int[2];

	public Interface(){
		
		for(int a = 0; a < 5; a++){
			
			bb[a] = -5;
			
		}
		
		for(int a = 0; a < 4; a++){
			
			ca[a] = -5;
			
		}
		
		for(int a = 0; a < 3; a++){
			
			dd[a] = -5;
			
		}
		
		for(int a = 0; a < 3; a++){
			
			cl[a] = -5;
			
		}
		
		for(int a = 0; a < 2; a++){
			
			ss[a] = -5;
			
		}
	
			printInterface(11, 0, 99, 3, 61, 0, 67, 1, 42, 2);
		
	}
	
	public void printInterface(int s1, int dir1, int s2, int dir2, int s3, int dir3,
			int s4, int dir4, int s5, int dir5){
		
		int rows = 10;
		int rownum = 1;
		
		findCoords(s1, dir1, 0);
		findCoords(s2, dir2, 1);
		findCoords(s3, dir3, 2);
		findCoords(s4, dir4, 3);
		findCoords(s5, dir5, 4);
		
		
		System.out.format("      1  2  3  4  5  6  7  8  9  10%n"
				+ "   ________________________________");
		
		for(int x = 0; x < 100; x++){
			
			if(rows > 9){
				
				System.out.format("%n%2d | ", rownum);
				rows = 0;
				rownum++;
				
			}
			
			if(bb[0] == x || bb[1] == x ||bb[2] == x ||bb[3] == x ||bb[4] == x || 
					ca[0] == x || ca[1] == x || ca[2] == x || ca[3] == x || 
					dd[0] == x || dd[1] == x || dd[2] == x ||
					cl[0] == x || cl[1] == x || cl[2] == x ||
					ss[0] == x || ss[1] == x){
				
				System.out.format(" B ");
				rows++;
				
			}else{
				
				System.out.format(" + ");
				rows++;
				
			}
			
		}
		
	}
	
	public static void findCoords(int s, int dir, int clas){
		
		if(clas == 0){
			
			bb[0] = s;
			
			if(dir == 0){
				
				bb[1] = s+1;
				bb[2] = s+2;
				bb[3] = s+3;
				bb[4] = s+4;
				
			}else if(dir == 1){
				
				bb[1] = s+10;
				bb[2] = s+20;
				bb[3] = s+30;
				bb[4] = s+40;
				
			}else if(dir == 2){
				
				bb[1] = s-1;
				bb[2] = s-2;
				bb[3] = s-3;
				bb[4] = s-4;
				
			}else if(dir == 3){
				
				bb[1] = s-10;
				bb[2] = s-20;
				bb[3] = s-30;
				bb[4] = s-40;
				
			}
			
		}else if(clas == 1){
			
			ca[0] = s;
			
			if(dir == 0){
				
				ca[1] = s+1;
				ca[2] = s+2;
				ca[3] = s+3;
				
			}else if(dir == 1){
				
				ca[1] = s+10;
				ca[2] = s+20;
				ca[3] = s+30;
				
			}else if(dir == 2){
				
				ca[1] = s-1;
				ca[2] = s-2;
				ca[3] = s-3;
				
			}else if(dir == 3){
				
				ca[1] = s-10;
				ca[2] = s-20;
				ca[3] = s-30;
				
			}
			
		}else if(clas == 2){
			
			dd[0] = s;
			
			if(dir == 0){
				
				dd[1] = s+1;
				dd[2] = s+2;
				
			}else if(dir == 1){
				
				dd[1] = s+10;
				dd[2] = s+20;
				
			}else if(dir == 2){
				
				dd[1] = s-1;
				dd[2] = s-2;
				
			}else if(dir == 3){
				
				dd[1] = s-10;
				dd[2] = s-20;
				
			}
			
		}else if(clas == 3){
			
			cl[0] = s;
			
			if(dir == 0){
				
				cl[1] = s+1;
				cl[2] = s+2;
				
			}else if(dir == 1){
				
				cl[1] = s+10;
				cl[2] = s+20;
				
			}else if(dir == 2){
				
				cl[1] = s-1;
				cl[2] = s-2;
				
			}else if(dir == 3){
				
				cl[1] = s-10;
				cl[2] = s-20;
				
			}
			
		}else if(clas == 4){
			
			ss[0] = s;
			
			if(dir == 0){
				
				ss[1] = s+1;
				
			}else if(dir == 1){
				
				ss[1] = s+10;
				
			}else if(dir == 2){
				
				ss[1] = s-1;
				
			}else if(dir == 3){
				
				ss[1] = s-10;
				
			}
		
		}
	
	}
	
}