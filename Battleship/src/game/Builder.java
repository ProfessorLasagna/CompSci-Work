package game;

public class Builder {

	public static int[] bb = new int[5];
	public static int[] ca = new int[5];
	public static int[] dd = new int[5];
	public static int[] cl = new int[5];
	public static int[] ss = new int[5];
	public static int[] vb = new int[5];
	public static int[] va = new int[5];
	public static int[] vc = new int[5];
	public static int[] vd = new int[5];
	public static int[] ve = new int[5];

	public Builder() {

		for(int a = 0; a < 5; a++){

			bb[a] = -2057;

		}

		for(int a = 0; a < 5; a++){

			ca[a] = -2058;

		}

		for(int a = 0; a < 5; a++){

			dd[a] = -2059;

		}

		for(int a = 0; a < 5; a++){

			cl[a] = -2060;

		}

		for(int a = 0; a < 5; a++){

			ss[a] = -2061;

		}

	}

	public boolean checkOverlap(int loc, int dir, int boat){

		findCoords(loc, dir, boat);

		if(boat == 4){

			boat = 2;
			vb = ss;
			va = dd;
			vc = cl;
			vd = bb;
			ve = ca;

		}else if(boat == 2){

			boat = 3;
			vb = dd;
			va = ss;
			vc = cl;
			vd = bb;
			ve = ca;

		}else if(boat == 3){

			boat = 3;
			vb = cl;
			va = dd;
			vc = ss;
			vd = bb;
			ve = ca;

		}else if(boat == 1){

			boat = 4;
			vb = ca;
			va = dd;
			vc = cl;
			vd = bb;
			ve = ss;

		}else if(boat == 0){

			boat = 5;
			vb = bb;
			va = dd;
			vc = cl;
			vd = ss;
			ve = ca;

		}

		if(loc < 100 && loc >= 0){

			for(int a = 0; a < vb.length; a++){

				if(vb[a] == va[a] || vb[a] == vd[a] || vb[a] == vc[a] || vb[a] == ve[a]){

					
					return false;

				}

			}

			for(int b = 0; b < vb.length; b++){

				if(vb[b] == -2057 || vb[b] == -2061 || vb[b] == -2058 || vb[b] == -2059 || vb[b] == -2060){
					
					
					
				}else if(vb[b] < 0 || vb[b] > 100){

					return false;

				}

				if((dir == 0 || dir == 2) && vb[b] / 10 > loc / 10){

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
