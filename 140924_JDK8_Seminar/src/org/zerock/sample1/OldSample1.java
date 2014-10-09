package org.zerock.sample1;

public class OldSample1 {
	
	private Printer printer;
	
	public OldSample1(Printer printer) {
	
		this.printer = printer;
	}
	
	public void printName(String name){
		
		printer.print(name);
		
	}
}
