package org.thinker.fs.Data;

public class SingleEx {

	private static SingleEx instance = new SingleEx();
	
	public static SingleEx getInstance(){
		return instance;
	}
	
	private SingleEx(){
		//do nothing
	}
}
