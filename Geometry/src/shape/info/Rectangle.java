package shape.info;

import java.util.Scanner;

public class Rectangle {
	
	public double height = 0;
	public double width = 0;
	public double length = 0;

	public Rectangle(double l, double w) {
		
		width = w;
		length = l;
		
	}

	public Rectangle(double l, double w, double h) {
		
		width = w;
		length = l;
		height = h;
		
	}
	
	public void printArea(){

		System.out.format("%nThe area of the rectangle is: %.2f",(length*width));

	}
	
	public void printPerimeter(){
		
		System.out.format("%nThe perimeter of the rectangle is: %.2f",((2*length)+(2*width)));
		
	}
	
	public void printVolume(){

		if(height == 0){

			System.out.format("%nYour object is a 2d entity and therefore has no volume.");

		}else{

			System.out.format("%nThe volume of the rectangular prism is: %.2f cubic centimeters.", (length*width*height));

		}
		
	}
	
	public void drill(){
		
		Scanner in = new Scanner(System.in);
		
		System.out.format("Please enter the radius of your drillbit: ");
		
		double radii = in.nextDouble();
		
		double volume = radii*radii*3.141*height;
		
		if(volume > length*width*height){
			
			System.out.format("%nSorry the size you entered would result in a volume greater than that of the prism being removed%n");
			
		}else if(height > 0){
			
			System.out.format("%nYour drill bit will remove %.2f of material from your prism, leaving it at %.2f cubic centimeters.%n"
					+ "", volume, (length*width*height-volume));
			
			
		}else{
			
			System.out.format("%nSorry the the shape is 2d and as such cannot be drilled.");
			
		}
		
		
		in.close();
		
	}
	
}
