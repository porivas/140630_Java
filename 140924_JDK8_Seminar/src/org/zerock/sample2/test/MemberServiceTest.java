package org.zerock.sample2.test;

import java.util.function.Predicate;

import org.junit.Test;
import org.zerock.sample2.MemberService;
import org.zerock.sample2.MemberService2;
import org.zerock.sample2.MemberVO;

public class MemberServiceTest {

	
	@Test
	public void testId() {
		
		//Aȸ���� ��� id�� 5�� �̻��������� üũ�Ѵ�. 
		MemberVO member = new MemberVO("user000","pw000","ȫ�浿",null);
		
		MemberService.addMember(member, 
				(vo) -> vo.getId().length() > 5,
				(vo) -> {
					System.out.println(vo.getName());
					System.out.println(vo.getId());
					return true;
				});
	}

	@Test
	public void testIdAndPwAndEmail() {
		
		//Bȸ���� ��� id, pw, email�� üũ�Ѵ�.  
		MemberVO member = new MemberVO("user000","pw000","ȫ�浿",null);
		
		Predicate<MemberVO> condition = (vo) -> vo.getId().length() > 5;
		//condition = condition.and((vo)-> vo.getPw() != null).and((vo) -> vo.getEmail() != null);
		
		MemberService.addMember(member,condition,
				(vo) -> {
					System.out.println(vo.getName());
					System.out.println(vo.getId());
					return true;
				});
	}

	@Test
	public void testIdAndPwAndEmail2() throws Exception {
		
		//Bȸ���� ��� id, pw, email�� üũ�Ѵ�.  
		MemberVO member = new MemberVO("user000","pw000","ȫ�浿","aaa@bbb.ccc");
		
		Predicate<MemberVO> condition = (vo) -> vo.getId().length() > 5;
		condition = condition.and((vo)-> vo.getPw() != null).and((vo) -> vo.getEmail() != null);
		
		MemberService2.addMember(member, (vo) -> System.out.println(vo), condition);
	}
}





