package org.zerock.sample0;

public class Triangle {

	private final double bottom;
	private final double height;
	
	public Triangle(double bottom, double height) {
		super();
		this.bottom = bottom;
		this.height = height;
	}

	public double getBottom() {
		return bottom;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Triagnle [bottom=" + bottom + ", height=" + height + "]";
	}
	
	
}
