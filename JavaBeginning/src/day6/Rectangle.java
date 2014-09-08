package day6;


public class Rectangle {
	//	double width, legnth;

	private double width, length;
	public Rectangle(){
		this(10.0, 10.0);
	}

	public Rectangle(double width, double length){
		this.width = width;
		this.length = length;
	}
	public void setWidth(double width){
		this.width = width;
	}
	public void setLength(double length){
		this.length = length;
	}
	public double getWidth(){
		return width;
	}
	public double getlength(){
		return length;
	}
	public double calcArea(){
		return width*length;
	}
	public String toString(){
		return "����=" +width +", ����="+length+", ����="+calcArea();
	}

	public static void main(String[] args){
		Rectangle r1 = new Rectangle();
		System.out.println("����="+r1.getWidth());
		System.out.println("����="+r1.getlength());
		System.out.println("����="+r1.calcArea());
		Rectangle r2 = new Rectangle(5.5, 10.0);
		System.out.println(r2);
		r2.setWidth(20.0);
		System.out.println(r2.toString());
	}

}
