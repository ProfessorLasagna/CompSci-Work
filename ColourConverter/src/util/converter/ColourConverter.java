package util.converter;

import java.awt.*;//
import util.converter.EasyApp;

public class ColourConverter extends EasyApp{//
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		new ColourConverter();	
	}

	TextField sCode = addTextField("", 30, 100, 150, 25, this);
	Label lCode = addLabel("Hex Colour Code:", 29, 60, 150, 60, this);
	Label lTitle = addLabel("Hexadecimal Colour Code converter", 20, 20, 500, 60, this);
	Button bCalc = addButton("Submit", 190, 99, 50, 25, this);
	Button bDisplay = addButton("List Codes", 500, 95, 75, 25, this);

	public ColourConverter(){
		
		lTitle.setFont(new Font("Arial",1,18));
		
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
		 return(text);
		 
	 }
	 
	 public void displayList(){
		 		 
		 String red = "Red: #FF0000", blue = "Blue: #0000FF", green = "Green: #008000", 
				yellow = "Yellow: #FFFF00";
		 
		 String colourList = red+"\n"+blue+"\n"+green+"\n"+yellow;
		 
		 output(colourList);
		 
	 }
	
	 public void convertCode(String hexcode){
		 
		 String r1, r2 , g1, g2, b1, b2;
		 int red = 0, green = 0, blue = 0;
		 
		 r1 = hexcode.substring(1, 2);
		 r2 = hexcode.substring(2, 3);
		 g1 = hexcode.substring(3, 4);
		 g2 = hexcode.substring(5, 6);
		 b1 = hexcode.substring(6, 7);
		 b2 = hexcode.substring(7);
		 
		red = hextodec(r1, r2);
		green = hextodec(g1, g2);
		blue = hextodec(b1, b2);
		
		
		
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
	 
}

