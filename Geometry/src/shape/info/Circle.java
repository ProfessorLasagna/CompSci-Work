package shape.info;

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

		System.out.println("The area of the circle is:"+(3.141 * radius * radius));

	}

	public void printCircumference(){

		System.out.println("The circumference of the circle is:"+(2 * radius * 3.141));

	}

	public void printVolume(){

		if(height == 0){

			System.out.println("Your object is a 2d entity and therefore has no volume.");

		}else{

			System.out.println("The volume of the cylinder is:"+ (3.141 * radius * radius * height));

		}

	}

}
