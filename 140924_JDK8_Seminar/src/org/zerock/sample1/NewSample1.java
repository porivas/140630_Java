package org.zerock.sample1;
import java.util.function.Consumer;


public class NewSample1 {

	private Consumer<String> printer;

	public NewSample1(Consumer<String> printer) {

		this.printer = printer;
	}
	
	public void printName(String userName){
		
		printer.accept(userName);
		
	}
	
	
}
