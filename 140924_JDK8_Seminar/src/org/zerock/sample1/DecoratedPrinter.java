package org.zerock.sample1;

public class DecoratedPrinter implements Printer {

	@Override
	public void print(String name) {
		System.out.println("welcome-----");
		System.out.println(name);
		System.out.println("bye.........");
	}

}
