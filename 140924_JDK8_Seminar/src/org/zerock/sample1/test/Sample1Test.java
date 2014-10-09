package org.zerock.sample1.test;

import java.util.function.Consumer;

import org.junit.Test;
import org.zerock.sample1.NewSample1;


public class Sample1Test {

	@Test
	public void testSimple() {
		
		NewSample1 obj1 = new NewSample1((str) -> System.out.println(str));
		obj1.printName("ȫ�浿");
		
	}
	
	@Test
	public void testDecorate(){
				
		Consumer<String> consumer =	(str) -> {
			System.out.println("welcome -----------");
			System.out.println(str);
			System.out.println("bye...............");
		};
		
		NewSample1 obj1 = new NewSample1( consumer );
		obj1.printName("ȫ�浿");
		
	}

}
