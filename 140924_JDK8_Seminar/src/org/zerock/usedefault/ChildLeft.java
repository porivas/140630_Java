package org.zerock.usedefault;

public interface ChildLeft extends Parent {

	@Override
	public default void greet(String name) {
		print("Child Left :" + name);
	}
}
