package game;

import java.util.ArrayList;
import java.util.Collections;

public class Builder {

	ArrayList<Integer> bb =new ArrayList<Integer>();
	ArrayList<Integer> ca =new ArrayList<Integer>();
	ArrayList<Integer> dd =new ArrayList<Integer>();
	ArrayList<Integer> cl =new ArrayList<Integer>();
	ArrayList<Integer> ss =new ArrayList<Integer>();
	ArrayList<Integer> vb =new ArrayList<Integer>();
	ArrayList<Integer> va =new ArrayList<Integer>();
	ArrayList<Integer> vc =new ArrayList<Integer>();
	ArrayList<Integer> vd =new ArrayList<Integer>();
	ArrayList<Integer> ve =new ArrayList<Integer>();

	public Builder() {

		bb.clear();
		ca.clear();
		dd.clear();
		cl.clear();
		ss.clear();
		vb.clear();
		va.clear();
		vc.clear();
		vd.clear();
		ve.clear();

	}

	boolean checkOverlap(int loc, int dir, int boat){

		boolean dest = false;
		vb.clear();
		va.clear();
		vc.clear();
		vd.clear();
		ve.clear();


		findCoords(loc, dir, boat);

		if(boat == 4){

			boat = 2;
			vb.addAll(ss);
			va.addAll(dd);
			vc.addAll(cl);
			vd.addAll(bb);
			ve.addAll(ca);

		}else if(boat == 2){

			boat = 3;
			vb.addAll(dd);
			va.addAll(ss);
			vc.addAll(cl);
			vd.addAll(bb);
			ve.addAll(ca);
			dest = true;

		}else if(boat == 3){

			boat = 3;
			vb.addAll(cl);
			va.addAll(dd);
			vc.addAll(ss);
			vd.addAll(bb);
			ve.addAll(ca);

		}else if(boat == 1){

			boat = 4;
			vb.addAll(ca);
			va.addAll(dd);
			vc.addAll(cl);
			vd.addAll(bb);
			ve.addAll(ss);

		}else if(boat == 0){

			boat = 5;
			vb.addAll(bb);
			va.addAll(dd);
			vc.addAll(cl);
			vd.addAll(ss);
			ve.addAll(ca);

		}

		if(loc < 100 && loc >= 0){

			
			if(!Collections.disjoint(vb, va) || !Collections.disjoint(vb, vc) || !Collections.disjoint(vb, vd) || !Collections.disjoint(vb, ve)){
				
				if(boat == 2){

					ss.clear();

				}else if(boat == 3 && dest){

					dd.clear();

				}else if(boat == 3){

					cl.clear();

				}else if(boat == 4){

					ca.clear();

				}else if(boat == 5){

					bb.clear();

				}
				
				return false;

			}

			for(int b = 0; b < vb.size(); b++){

				if(vb.get(b) < 0 || vb.get(b) > 100){
					
					if(boat == 2){

						ss.clear();

					}else if(boat == 3 && dest){

						dd.clear();

					}else if(boat == 3){

						cl.clear();

					}else if(boat == 4){

						ca.clear();

					}else if(boat == 5){

						bb.clear();

					}

					return false;

				}

				if((dir == 0 || dir == 2) && ((vb.get(b) - (vb.get(b) % 10)) / 10) != (loc - (loc % 10)) / 10){

					if(boat == 2){

						ss.clear();

					}else if(boat == 3 && dest){

						dd.clear();

					}else if(boat == 3){

						cl.clear();

					}else if(boat == 4){

						ca.clear();

					}else if(boat == 5){

						bb.clear();

					}
					
					return false;

				}

			}

			return true;

		}else{
			
			if(boat == 2){

				ss.clear();

			}else if(boat == 3 && dest){

				dd.clear();

			}else if(boat == 3){

				cl.clear();

			}else if(boat == 4){

				ca.clear();

			}else if(boat == 5){

				bb.clear();

			}
			
			return false;

		}
			
	}

	public void findCoords(int s, int dir, int clas){

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
				dd.add(s-2);

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

	public boolean fireShell(int coord){
		
		if(bb.contains(coord) || ca.contains(coord) || cl.contains(coord) || dd.contains(coord) || ss.contains(coord)){
			
			if(bb.contains(coord)){
				
				bb.remove(bb.indexOf(coord));
				
			}else if(ca.contains(coord)){
				
				ca.remove(ca.indexOf(coord));
				
			}else if(cl.contains(coord)){
				
				cl.remove(cl.indexOf(coord));
				
			}else if(dd.contains(coord)){
				
				dd.remove(dd.indexOf(coord));
				
			}else if(ss.contains(coord)){
				
				ss.remove(ss.indexOf(coord));
				
			}
			
			return true;
			
			
		}else
			return false;
		
	}

}
