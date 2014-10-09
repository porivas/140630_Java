package org.zerock.sample2;

import java.util.function.Function;
import java.util.function.Predicate;

public class MemberService2<T,R> {

	@FunctionalInterface
	public static interface Executor<T>{
		
		void executeDetail( T param )throws Exception;
		
		
		default void execute(T param, Predicate<T> pre)throws Exception{
			
			if( pre.test(param) == false){
				throw new Exception("Predicate fail");
			}
			executeDetail(param);
		}
	}
	
	public static void addMember(MemberVO vo, Executor<MemberVO> executor, Predicate<MemberVO> pre)throws Exception{
		
		executor.execute(vo, pre);
		
	}

}
