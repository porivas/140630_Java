package org.zerock.usedefault;

public class ParentImpl implements Parent {

	@Override
	public void print(String name) {
		
		System.out.println("Parent Impl print " + name);
	}

	@Override
	public void greet(String name) {
		// TODO Auto-generated method stub
		Parent.super.greet("ParentImpl greet :" + name);
	}
	
}
