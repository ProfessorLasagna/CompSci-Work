package shape.info;

public class Main {

	public static void main(String[] args) {
		
		Circle ManHole = new Circle(50);
		Circle TowerofPisa = new Circle(200, 800);
		Rectangle Paper = new Rectangle(21.6, 28);
		Rectangle Printer = new Rectangle(36,32,24);
		
		System.out.format("%nThe properties of the man hole are: %n");
		ManHole.printArea();
		ManHole.printCircumference();
		
		System.out.format("%n%nThe properties of the Leaning Tower of Pisa are: %n");
		TowerofPisa.printArea();
		TowerofPisa.printCircumference();
		TowerofPisa.printVolume();
		
		System.out.format("%n%nThe properties of the paper are: %n");
		Paper.printArea();
		Paper.printPerimeter();
		
		System.out.format("%n%nThe properties of the printer are: %n");
		Printer.printArea();
		Printer.printPerimeter();
		Printer.printVolume();
		
	}

}
