package org.zerock.sample1;


public class NewSample2 {
	
	private Printer printer;

	public NewSample2(Printer printer) {

		this.printer = printer;
		System.out.println(printer);
	}
	
	public void printName(String userName){
		
		printer.print(userName);
		
	}
}
