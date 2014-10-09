package org.zerock.sample0;

public class CalcTest {
	
	public static void main(String[] args) {
		
		 CalcArea<Triangle, Double> tCalc = (shape) -> (shape.getBottom() * shape.getBottom())/2;
		 
		 CalcArea<Rectangle, Integer> rCalc = (shape) -> shape.getXvalue() * shape.getYvalue();
		 
		 Triangle triangle = new Triangle(100,30);
		 
		 Rectangle rectangle = new Rectangle(50,50);
		 
		 double area = tCalc.getArea(triangle) - rCalc.getArea(rectangle);
		 
		 System.out.println(area);
	}

}
