package shape.info;

import java.util.Scanner;

public class Circle {

	public double height = 0;
	public double radius = 0;

	public Circle(double rad){

		radius = rad;

	}

	public Circle(double rad, double hi){

		radius = rad;
		height = hi;

	}

	public void printArea(){

		System.out.format("%nThe area of the circle is: %.2f",(3.141 * radius * radius));

	}

	public void printCircumference(){

		System.out.format("%nThe circumference of the circle is: %.2f",(2 * radius * 3.141));

	}

	public void printVolume(){

		if(height == 0){

			System.out.format("%nYour object is a 2d entity and therefore has no volume.");

		}else{

			System.out.format("%nThe volume of the cylinder is: %.2f cubic centimeters.", (3.141 * radius * radius * height));

		}

	}
	
	public void drill(){
		
		Scanner in = new Scanner(System.in);
			
		System.out.format("5nPlease enter the radius of your drillbit: ");
		
		double radii = in.nextDouble();
		
		double volume = radii*radii*3.141*height;
		
		if(radii > radius){
			
			System.out.format("%nSorry the size you entered would result in a volume greater than that of the prism being removed%n");
			
		}else if(height > 0){
			
			System.out.format("%nYour drill bit will remove %d of material from your prism, leaving it at %d cubic centimeters.%n"
					+ "", volume, (radius*radius*3.141*height-volume));
			
			
		}else{
			
			System.out.format("%nSorry the the shape is 2d and as such cannot be drilled.");
			
		}
		
			
		in.close();
			
	}

}
