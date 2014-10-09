
package org.zerock.dao.test;

import org.junit.Test;
import org.zerock.dao.MemberDAO;
import org.zerock.vo.MemberVO;

/**
 * use for junit test
 * 
 * 
 * 
 * @author Zerock
 *
 */
public class DAOExecutorTest {


	
	@Test
	public void testInsert() throws Exception {
		
		MemberVO vo = new MemberVO("user00","pw00","ȫ�浿","aaa@bbb.ccc");
		
		MemberDAO.create(vo);
		
	}
	
	@Test
	public void testRead() throws Exception {
		
		MemberVO vo = MemberDAO.read("aaa");
		
		System.out.println(vo);
	}	

}
