package org.zerock.sample0;

@FunctionalInterface
public interface CalcArea<T,R> {

	public R getArea(T t);
	
} 
