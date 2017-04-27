package game;

public class Builder {
	
	public static int[] bb = new int[5];
	public static int[] ca = new int[4];
	public static int[] dd = new int[3];
	public static int[] cl = new int[3];
	public static int[] ss = new int[2];
	public static int[] vb = new int[5];

	public Builder() {
		
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
		
	}
	
	public boolean checkOverlap(int loc, int dir, int boat){
		
		findCoords(loc, dir, boat);
		
		if(boat == 4){
			
			boat = 2;
			vb = ss;
			
		}else if(boat == 2){
			
			boat = 3;
			vb = dd;
			
		}else if(boat == 3){
			
			boat = 3;
			vb = cl;
			
		}else if(boat == 1){
			
			boat = 4;
			vb = ca;
			
		}else if(boat == 0){
			
			boat = 5;
			vb = bb;
			
		}
		
		if(loc < 100 && loc >= 0){
			
			for(int a = 0; a < boat; a++){
				
//				if(bb[0] == vb[a] || bb[1] == vb[a] ||bb[2] == vb[a] ||bb[3] == vb[a] ||bb[4] == vb[a] || 
//						ca[0] == vb[a] || ca[1] == vb[a] || ca[2] == vb[a] || ca[3] == vb[a] || 
//						dd[0] == vb[a] || dd[1] == vb[a] || dd[2] == vb[a] ||
//						cl[0] == vb[a] || cl[1] == vb[a] || cl[2] == vb[a] ||
//						ss[0] == vb[a] || ss[1] == vb[a]){
//					
//					return false;				
//				
//				}
			
			
	
		}
		
			for(int b = 0; b < vb.length; b++){
				
				
				int total =+ vb[b];
				
				if(vb[b] < 0 || vb[b] > 100){
					
					return false;
				
				}
				
				if(total % 10 >  9){
				
					return false;
				
				}
			
			}
			
			return true;
						
		}else
			return false;
		
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
