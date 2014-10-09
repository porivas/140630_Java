package org.zerock.sample2;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MemberService {
	
	public static boolean addMember(MemberVO member,
			Predicate<MemberVO> condition, 
			Function<MemberVO, Boolean> fn){
		
		if(condition.test(member)){
			return fn.apply(member);
		}
		return false;
	}
}
