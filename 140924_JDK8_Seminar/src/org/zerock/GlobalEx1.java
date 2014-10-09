package org.zerock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class GlobalEx1 {

	private static final Map<String, BinaryOperator<Double>> calcMap = new HashMap<>();

	static{
		calcMap.put("add", (x,y) -> x + y);
		calcMap.put("minus", (x,y) -> x - y);
		calcMap.put("multi", (x,y) -> x * y);
		calcMap.put("div", (x,y) -> x / y);
	}
	
	public static BinaryOperator<Double> getOper(String oper){
		
		return calcMap.get(oper);
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(GlobalEx1.getOper("add").apply(1002D, 233D));
		
	}
}


