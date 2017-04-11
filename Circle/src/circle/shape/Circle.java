package circle.shape;

public class Circle {
	
	private static final double PI = 3.14;
	private double radius;
	
	public Circle(){
		
		radius = 1;
		
	}
	
	public Circle(double r){
		
		radius = r;
		
	}
	
	public void setRadius(double newRadius){
		
		radius = newRadius;
		
	}
	
	public double area(){
		
		double circleArea;
		
		circleArea = PI * radius * radius;
		return(circleArea);
		
	}
	
	public double getRadius(){
		
		return(radius);
		
	}
	
	public double circumference(){
		
		double circumference;
		
		circumference = 2 * PI * radius;
		
		return(circumference);
		
	}
	
	public static void displayAreaFormula(){
		
		System.out.format("The formula for the area of a cirlce is: a = PI * r^2%n%n");
		
	}
	
	public boolean equals(Object c){
		
		Circle testObj = (Circle)c;
		
		if(testObj.getRadius() == radius)
			return(true);
		
		else
			return(false);
		
	}
	
	public String toString(){
		
		String circleString = "Circle has radius:"+radius;
		
		return(circleString);
		
	}

}

