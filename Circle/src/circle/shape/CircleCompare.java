package circle.shape;

public class CircleCompare{

	public static void main(String[] args) {

		Circle spot1 = new Circle(3);
		Circle spot2 = new Circle(4);
		
		Circle.displayAreaFormula();
		
		if(spot1.equals(spot2)){
			
			System.out.println("Objects are equal.");
			
		}else{
			
			System.out.println("Objects are not equal.");
			
		}
		
		System.out.println(spot1);
		System.out.println(spot2);
			

	}

}
