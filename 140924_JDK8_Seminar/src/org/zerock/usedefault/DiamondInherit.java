package org.zerock.usedefault;

public class DiamondInherit implements ChildLeft, ChildRight  {

	@Override
	public void print(String name) {
		System.out.println("print " + name);
	}
	
	@Override
	public void greet(String name) {
		ChildLeft.super.greet(name);
	}
	
	public static void main(String[] args) {
		
		DiamondInherit obj = new DiamondInherit();
		
		obj.greet("Hello World");
	}
}
