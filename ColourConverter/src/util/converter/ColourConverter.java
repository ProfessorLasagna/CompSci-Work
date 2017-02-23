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
		 
		 
		 
	 }
}

