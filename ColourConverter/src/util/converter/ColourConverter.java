package util.converter;

import java.awt.*;//
import util.converter.EasyApp;

public class ColourConverter extends EasyApp{//
	
	private static final long serialVersionUID = 1L;
	
	public int red = 255, green = 255, blue = 255;
	public String rs = "255", gs = "255", bs = "255";
	public String rb = "11111111", gb = "11111111", bb = "11111111";

	public static void main(String[] args){
		new ColourConverter();	
	}

	TextField sCode = addTextField("", 30, 100, 150, 25, this);
	Label lCode = addLabel("Hex Colour Code:", 29, 60, 150, 60, this);
	Label lTitle = addLabel("Hexadecimal Colour Code converter", 20, 20, 500, 60, this);
	Label lDec = addLabel("Decimal:  Red: "+rs+"  Green:   "+gs+"  Blue:   "+bs, 28,128,500,50,this);
	Label lBin = addLabel("Binary:  Red: 1111 1111 "+"  Green: 1111 1111"+"  Blue: 1111 1111", 28,160,500,50,this);
	Button bCalc = addButton("Submit", 190, 99, 50, 25, this);
	Button bDisplay = addButton("List Codes", 500, 95, 75, 25, this);
	Frame fCol = new Frame();

	public ColourConverter(){
		
		lTitle.setFont(new Font("Arial",1,18));
		
	}
	
	public void paint(Graphics g) {
	    g.drawRect (275, 88, 150, 50);
	    g.setColor(new Color(red,green,blue));
	    g.fillRect(275, 88, 150, 50);
	  }
	
	
	 public void actions(Object source,String command){
		 
		 if(source == bCalc){
			 
			 convertCode(getHex());
		
		 }
		 
		 if(source == bDisplay){
			 
			 displayList();
			 
		 }
		 
	 }
	 
	 public String getHex(){
		 
		 String text = sCode.getText();
		 
		 if(text.length()> 7 || text.length() < 7){
			 
			 output("This is not a valid colour code.");
			 
		 }else{
		 
			 return(text);
		 
		 }
		 
		 return("#FFFFFF");
		 
	 }
	 
	 public void displayList(){
		 		 
		 String red = "Red: #FF0000", blue = "Blue: #0000FF", green = "Green: #00FF00", 
				yellow = "Yellow: #FFFF00";
		 
		 String colourList = red+"\n"+blue+"\n"+green+"\n"+yellow;
		 
		 output(colourList);
		 
	 }
	
	 public void convertCode(String hexcode){
		 
		 String r1, r2 , g1, g2, b1, b2;
		 
		 r1 = hexcode.substring(1, 2);
		 r2 = hexcode.substring(2, 3);
		 g1 = hexcode.substring(3, 4);
		 g2 = hexcode.substring(4, 5);
		 b1 = hexcode.substring(5, 6);
		 b2 = hexcode.substring(6, 7);
		 
		red = hextodec(r1, r2);
		green = hextodec(g1, g2);
		blue = hextodec(b1, b2);
		
		rs = Integer.toString(red);
		gs = Integer.toString(green);
		bs = Integer.toString(blue);
		
		rb = Integer.toString(dectobin(red));
		gb = Integer.toString(dectobin(green));
		bb = Integer.toString(dectobin(blue));
		
		lDec.setText("Decimal:  Red: "+rs+"  Green:   "+gs+"  Blue:   "+bs);
		lBin.setText("Binary:  Red: "+rb+"  Green: "+gb+"  Blue: "+bb);
		
		repaint();
		
	 }
		 
	 
	 
	 public int hextodec(String one, String two){
		
		 int sixteens = 0, ones = 0, total;
		 
		 if(one.startsWith("1")){
			 
			 sixteens = 1 * 16;
			 
		 }
		 
		 else if(one.startsWith("2")){
			 
			 sixteens = 2 * 16;
			 
		 }
		 
		 else if(one.startsWith("3")){
			 
			 sixteens = 3 * 16;
			 
		 }
		 
		 else if(one.startsWith("4")){
			 
			 sixteens = 4 * 16;
			 
		 }
		 
		 else if(one.startsWith("5")){
			 
			 sixteens = 5 * 16;
			 
		 }
		 
		 else if(one.startsWith("6")){
			 
			 sixteens = 6 * 16;
			 
		 }
		 
		 else if(one.startsWith("7")){
			 
			 sixteens = 7 * 16;
			 
		 }
		 
		 else if(one.startsWith("8")){
			 
			 sixteens = 8 * 16;
			 
		 }
		 
		 else if(one.startsWith("9")){
			 
			 sixteens = 9 * 16;
			 
		 }
		 
		 else if(one.startsWith("A")){
			 
			 sixteens = 10 * 16;
			 
		 }
		 
		 else if(one.startsWith("B")){
			 
			 sixteens = 11 * 16;
			 
		 }
		 
		 else if(one.startsWith("C")){
			 
			 sixteens = 12 * 16;
			 
		 }
		 
		 else if(one.startsWith("D")){
			 
			 sixteens = 13 * 16; 
			 
		 }
		 
		 else if(one.startsWith("E")){
			 
			 sixteens = 14 * 16;
			 
		 }
		 
		 else if(one.startsWith("F")){
			 
			 sixteens = 15 * 16;
			 
		 }
		 
		 if(two.startsWith("0")){
			 
			 ones = 0;
			 
		 }
		 
		 else if(two.startsWith("1")){
			 
			 ones = 1;
			 
		 }
		 
		 else if(two.startsWith("2")){
			 
			 ones = 2;
			 
		 }
		 
		 else if(two.startsWith("3")){
			 
			 ones = 3;
			 
		 }
		 
		 else if(two.startsWith("4")){
			 
			 ones = 4;
			 
		 }
		 
		 else if(two.startsWith("5")){
			 
			 ones = 5;
			 
		 }
		 
		 else if(two.startsWith("6")){
			 
			 ones = 6;
			 
		 }
		 
		 else if(two.startsWith("7")){
			 
			 ones = 7;
			 
		 }
		 
		 else if(two.startsWith("8")){
			 
			 ones = 8;
			 
		 }
		 
		 else if(two.startsWith("9")){
			 
			 ones = 9;
			 
		 }
		 
		 else if(two.startsWith("A")){
			 
			 ones = 10;
			 
		 }
		 
		 else if(two.startsWith("B")){
			 
			 ones = 11;
			 
		 }
		 
		 else if(two.startsWith("C")){
			 
			 ones = 12;
			 
		 }
		 
		 else if(two.startsWith("D")){
			 
			 ones = 13; 
			 
		 }
		 
		 else if(two.startsWith("E")){
			 
			 ones = 14;
			 
		 }
		 
		 else if(two.startsWith("F")){
			 
			 ones = 15;
			 
		 }
		 
		 total = ones + sixteens;
		 
		 return(total);
		
	 }
	 
	 public int dectobin(int deccode){
			 
		int ones = 0, twos = 0, fours = 0, eights = 0, sixteens = 0, thirtytwos = 0, 
			sixtyfours = 0, onetwentyeights = 0;
		
		if(deccode - 128 >= 0){
			
			onetwentyeights = 1;
			deccode = deccode - 128;
			
		}
		
		if(deccode - 64 >= 0){
			
			sixtyfours = 1;
			deccode = deccode - 64;
			
		}
		
		if(deccode - 32 >= 0){
			
			thirtytwos = 1;
			deccode = deccode - 32;
			
		}
		
		if(deccode - 16 >= 0){
			
			sixteens = 1;
			deccode = deccode - 16;
			
		}
		
		if(deccode - 8 >= 0){
			
			eights = 1;
			deccode = deccode - 8;
			
		}
		
		if(deccode - 4 >= 0){
			
			fours = 1;
			deccode = deccode - 4;
			
		}
		
		if(deccode - 2 >= 0){
			
			twos = 1;
			deccode = deccode - 2;
			
		}
		
		if(deccode - 1 >= 0){
			
			ones = 1;
			deccode = deccode - 1;
			
		}
		
		int num = (ones + (twos * 10) + (fours * 100) + (eights * 1000) + (sixteens * 10000) + (thirtytwos * 100000) + (sixtyfours * 1000000) + (onetwentyeights * 10000000));
		 		
		return(num);
		
	 }
	 
}