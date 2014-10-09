package org.zerock.sample0;

public class Rectangle {

	private final int xvalue;
	private final int yvalue;
	
	public Rectangle(int xValue, int yValue) {
		super();
		this.xvalue = xValue;
		this.yvalue = yValue;
	}

	public int getXvalue() {
		return xvalue;
	}

	public int getYvalue() {
		return yvalue;
	}

	@Override
	public String toString() {
		return "Rectangle [xValue=" + xvalue + ", yValue=" + yvalue + "]";
	}
	
	
	
}
