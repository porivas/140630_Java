package org.zerock.sample1.test;

import org.junit.Test;
import org.zerock.sample1.NewSample1;
import org.zerock.sample1.NewSample2;
import org.zerock.sample1.Printer;

public class Sample2Test {

	@Test
	public void testSimple() {
		
		NewSample2 obj1 = new NewSample2((str) -> System.out.println(str));
		obj1.printName("ȫ�浿");
		
	}
	
	@Test
	public void testDecorate(){
				
		Printer printer =	(str) -> {
			System.out.println("welcome -----------");
			System.out.println(str);
			System.out.println("bye...............");
		};
		
		NewSample2 obj1 = new NewSample2(printer);
		obj1.printName("ȫ�浿");
		
	}	
}
