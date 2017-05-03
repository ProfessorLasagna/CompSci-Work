package game;

import java.util.ArrayList;

public class Builder {

	static ArrayList<Integer> bb =new ArrayList<Integer>();
	static ArrayList<Integer> ca =new ArrayList<Integer>();
	static ArrayList<Integer> dd =new ArrayList<Integer>();
	static ArrayList<Integer> cl =new ArrayList<Integer>();
	static ArrayList<Integer> ss =new ArrayList<Integer>();
	ArrayList<Integer> vb =new ArrayList<Integer>();
	ArrayList<Integer> va =new ArrayList<Integer>();
	ArrayList<Integer> vc =new ArrayList<Integer>();
	ArrayList<Integer> vd =new ArrayList<Integer>();
	ArrayList<Integer> ve =new ArrayList<Integer>();

	public Builder() {


	}

	public boolean checkOverlap(int loc, int dir, int boat){

		vb.clear();
		va.clear();
		vc.clear();
		vd.clear();
		ve.clear();


		findCoords(loc, dir, boat);

		if(boat == 4){

			boat = 2;
			vb = ss;
			va = dd;
			vc = cl;
			vd = bb;
			ve = ca;

			vb.add(ss.get(1));
			vb.add(ss.get(1));
			vb.add(ss.get(1));

			va.add(-2);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);

		}else if(boat == 2){

			boat = 3;
			vb = dd;
			va = ss;
			vc = cl;
			vd = bb;
			ve = ca;

			vb.add(0);
			vb.add(0);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);

		}else if(boat == 3){

			boat = 3;
			vb = cl;
			va = dd;
			vc = ss;
			vd = bb;
			ve = ca;

			vb.add(0);
			vb.add(0);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);

		}else if(boat == 1){

			boat = 4;
			vb = ca;
			va = dd;
			vc = cl;
			vd = bb;
			ve = ss;

			vb.add(0);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);

		}else if(boat == 0){

			boat = 5;
			vb = bb;
			va = dd;
			vc = cl;
			vd = ss;
			ve = ca;

			va.add(-2);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			va.add(-2);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vc.add(-3);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			vd.add(-4);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);
			ve.add(-5);


		}

		if(loc < 100 && loc >= 0){

			for(int a = 0; a < vb.size(); a++){

				if(vb.get(a) == va.get(a) || vb.get(a) == vd.get(a) || vb.get(a) == vc.get(a) || vb.get(a) == ve.get(a)){



					return false;

				}

			}

			for(int b = 0; b < vb.size(); b++){

				if(vb.get(b) < 0 || vb.get(b) > 100){
System.out.println(b+" "+vb.get(b));
					return false;

				}

				if((dir == 0 || dir == 2) && ((vb.get(b) - (vb.get(b) % 10)) / 10) != (loc - (loc % 10)) / 10){

					return false;

				}

			}

			return true;

		}else
			return false;

	}



	public static void findCoords(int s, int dir, int clas){

		if(clas == 0){

			bb.add(s);

			if(dir == 0){

				bb.add(s+1);
				bb.add(s+2);
				bb.add(s+3);
				bb.add(s+4);

			}else if(dir == 1){

				bb.add(s+10);
				bb.add(s+20);
				bb.add(s+30);
				bb.add(s+40);

			}else if(dir == 2){

				bb.add(s-1);
				bb.add(s-2);
				bb.add(s-3);
				bb.add(s-4);

			}else if(dir == 3){

				bb.add(s-10);
				bb.add(s-20);
				bb.add(s-30);
				bb.add(s-40);

			}

		}else if(clas == 1){

			ca.add(s);

			if(dir == 0){

				ca.add(s+1);
				ca.add(s+2);
				ca.add(s+3);

			}else if(dir == 1){

				ca.add(s+10);
				ca.add(s+20);
				ca.add(s+30);

			}else if(dir == 2){

				ca.add(s-1);
				ca.add(s-2);
				ca.add(s-3);

			}else if(dir == 3){

				ca.add(s-10);
				ca.add(s-20);
				ca.add(s-30);

			}

		}else if(clas == 2){

			dd.add(s);

			if(dir == 0){

				dd.add(s+1);
				dd.add(s+2);

			}else if(dir == 1){

				dd.add(s+10);
				dd.add(s+20);

			}else if(dir == 2){

				dd.add(s-1);
				dd.add(s-1);

			}else if(dir == 3){

				dd.add(s-10);
				dd.add(s-20);

			}

		}else if(clas == 3){

			cl.add(s);

			if(dir == 0){

				cl.add(s+1);
				cl.add(s+2);

			}else if(dir == 1){

				cl.add(s+10);
				cl.add(s+20);

			}else if(dir == 2){

				cl.add(s-1);
				cl.add(s-2);

			}else if(dir == 3){

				cl.add(s-10);
				cl.add(s-20);

			}

		}else if(clas == 4){

			ss.add(s);

			if(dir == 0){

				ss.add(s+1);

			}else if(dir == 1){

				ss.add(s+10);

			}else if(dir == 2){

				ss.add(s-1);

			}else if(dir == 3){

				ss.add(s-10);

			}

		}

	}

}
