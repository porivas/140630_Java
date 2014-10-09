package org.zerock;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Ex1 {
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		
		Map<String, BinaryOperator<Double>> calcMap = new HashMap<>();
		
		calcMap.put("add", ( x, y) -> x + y);
		calcMap.put("minus", (x,y) -> x - y);
		calcMap.put("multi", (x,y) -> x * y);
		calcMap.put("div", (x,y) -> x / y);
		
		String oper = scanner.next();
		double param1 = scanner.nextInt();
		double param2 = scanner.nextInt();
		
		System.out.println(calcMap.get(oper).apply(param1, param2));
		
		
		
	}
}
