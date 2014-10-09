package org.zerock.usedefault;

public interface Parent {

	void print(String name);
	
	public default void greet(String name){
		print(name);
	}
	
}
